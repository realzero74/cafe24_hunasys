package com.hunasys.labelsketch.common.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class FileUploadController {
   
   private static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);
   
   // file.properties ���� filepath�� ������ ���
   // root-context.xml�� �������� ����
   @Value("#{file['save.filepath']}")
   private String filePath;

//   @Autowired
//   private CommonService commonService;

   @RequestMapping(value = "/fileUpload/{ordersIdx}/{fileSeq}", produces = "application/json;charset=UTF-8", method = RequestMethod.POST)
   @ResponseBody
  public String fileUpload(
          @PathVariable long ordersIdx,
          @PathVariable long fileseq, 
          HttpServletRequest request, HttpServletResponse response) {
     String json="";
      
     //������ ����� path ����
     SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
     Calendar calendar = Calendar.getInstance();
     String strToday = sdf.format(calendar.getTime());

     String savePath = filePath + "/" + ordersIdx + "/" + fileseq;

     logger.debug(savePath);

     List<Map<String, Object>> returnObject = new ArrayList<Map<String,Object>>();
     try {
        // request���� MultipartHttpServletRequest ���� 
        MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest)request;

        //�����̸� ���
        Iterator<String> iter = multipartHttpServletRequest.getFileNames();
        MultipartFile multipartFile = null;
        String itemFileName = "";

        // ���丮�� ���ٸ� ���� 
        File directory = new File(savePath);
        if (!directory.isDirectory()) {
           directory.mkdirs();
        }

        // request�� Iterator�� ���鼭 ó��
        while (iter.hasNext()) {

           itemFileName = iter.next();
           // ������ �����ͼ� 
           multipartFile = multipartHttpServletRequest.getFile(itemFileName);
           String originalFileName = new String(multipartFile.getOriginalFilename().getBytes("8859_1"), "UTF-8"); //�ѱۃ��� ���� 

           // ���ϸ��� ���ٸ� ����ó����
           if ("".equals(originalFileName)) {
              continue;
           }
           // ���� Ȯ���� 
           String oridianlFileExt = originalFileName.substring(originalFileName.lastIndexOf('.'));
           
           // ������ ���ϸ� (���� ��� ��Ģ�� �°� ����) 
           String savedFileName =  ordersIdx+"_"+ fileseq +"_"+ strToday;
           
           // ������ path�� ����� file ��ü ����
           File savedFile = new File(savePath + File.separator + savedFileName);
           // multipart�� ������ ������ savedFile ��ü�� ����
           multipartFile.transferTo(savedFile);

           //DB���� ����ϴ� �÷����� ����ؼ� return �� ����
           Map<String, Object> fileHandleResult = new HashMap<String, Object>();
           fileHandleResult.put("nFileSeqNo", fileseq);
           fileHandleResult.put("vFileName", originalFileName);
           fileHandleResult.put("vFileExtension", oridianlFileExt);
           fileHandleResult.put("vTempFileName", savedFileName);
           fileHandleResult.put("vFilePath", savePath);
           returnObject.add(fileHandleResult);
        }
        json = new ObjectMapper().writeValueAsString(returnObject);
     } catch (UnsupportedEncodingException e) {
        e.printStackTrace();
     } catch (IllegalStateException e) {
        e.printStackTrace();
     } catch (IOException e) {
        e.printStackTrace();
     }
     return json;
  }
}
