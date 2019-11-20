package com.hunasys.labelsketch.common.controller;

import java.io.File;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FileDownloadController {
   
   private static final Logger logger = LoggerFactory.getLogger(FileDownloadController.class);
   
   // file.properties ���� filepath�� ������ ���
   // root-context.xml�� �������� ����
   @Value("#{file['save.filepath']}")
   private String filePath;

//   @Autowired
//   private CommonService commonService;

   @RequestMapping("/fileDownload")
   public ModelAndView download(@RequestParam Map<String, String> paramMap, HttpServletRequest request)
           throws Exception {

       logger.debug("fileDownload request");
       logger.debug("fileDownload request : ", filePath);
       logger.debug("fileDownload request : ", request.getParameter("fileId"));

       String fullPath = "C:/Temp/20180612/20180530_1122.zip";
       String originalFileName = "20180530_1122.zip";

       String vFileType = request.getParameter("vFileType");
       String param1 = request.getParameter("param1"); //emplno
       String param2 = request.getParameter("param2"); //nSeq
       String param3 = request.getParameter("param3"); //fileSeq

       logger.debug("vFileType : " + vFileType);

       if (vFileType.equals("hba")) {
           // param - PK Ȱ��
           /*logger.debug("param 1 : " + param1);   //�ͼӳ��
           logger.debug("param 2 : " + param2);   //
           logger.debug("param 3 : " + param3);   //
           
           Map<String, String> aweparam = new HashMap<String, String>();
           aweparam.put("yymm", param1);
           
           Map<String, String> aweFileMap = aweService.getDownLoadFile(aweparam);
           
           fullPath = aweFileMap.get("vFilePath");
           fullPath += "/";
           fullPath += aweFileMap.get("vTempFileName");
           
           originalFileName = aweFileMap.get("vFileName");
           
           logger.debug(fullPath);*/

       } else if (vFileType.equals("hba") || vFileType.equals("hbb") || vFileType.equals("hbc")
           || vFileType.equals("hbd") || vFileType.equals("hbe") || vFileType.equals("hbf") || vFileType.equals("hbg")
           || vFileType.equals("hbh")) {
           logger.debug("param 1 : " + param1); //���
           logger.debug("param 2 : " + param2); //�Ϸù�ȣ
           logger.debug("param 3 : " + param3); //�����Ϸù�ȣ

           /*FileVo filevo = new FileVo();

           filevo.setvEmplNo(param1);
           filevo.setvFileType(vFileType);
           filevo.setnSeq(Integer.parseInt(param2));
           filevo.setnFileSeq(Integer.parseInt(param3));

           List<FileVo> fileVoInfo = hbbService.getHrFileList(filevo);

           fullPath = fileVoInfo.get(0).getvFilePath();
           fullPath += "/";
           fullPath += fileVoInfo.get(0).getvTempFileName();

           originalFileName = fileVoInfo.get(0).getvFileName();*/

           logger.debug(fullPath);
       } else if (vFileType.equals("spm")) {
           //          //Map Ȱ����
           //          
           //          logger.debug("param 1 : " + param1);   //�����ڵ�
           //          logger.debug("param 2 : " + param2);   //�Ϸù�ȣ
           //          logger.debug("param 3 : " + param3);   //�����Ϸù�ȣ
           //          
           //          Map<String, Object> param = new HashMap<String, Object>();
           //          param.put("vProjectCode", param1);
           //          param.put("nSeqNo", Integer.parseInt(param2));
           //          param.put("nFileSeqNo", Integer.parseInt(param3));
           //          
           //          SpmReportFileVo spmReportFileVo = spmService.selectReportFileInfo(param);
           //
           //
           //          fullPath = spmReportFileVo.getvFilePath();
           //          fullPath += "/";
           //          fullPath += spmReportFileVo.getvTempFileName();
           //          
           //          originalFileName = spmReportFileVo.getvFileName();
           //       
           //          logger.debug(fullPath);
       } else if (vFileType.equals("")) {
           // ���� �ٿ�ε� ���� ��ȸ
           // �߰��ؼ� ����ϼ���~
           // �̺κ��� ����/�������� ������(�˻��뵵)
       }

       File renameFile; // �ٿ�ε带 �ޱ����� ���� ��ü
       try {
           renameFile = new File(fullPath);
           logger.warn(fullPath.toString());
       } catch (Exception e) {
           e.printStackTrace();
           logger.warn("���� �̸� ���� ����!!");
           throw e;
       }

       ModelAndView mav = new ModelAndView("downloadView");
       mav.addObject("downloadFile", renameFile); //������ ����� ���� ���
       mav.addObject("originalFileName", originalFileName); //����ڰ� ������ ���� ���ϸ�

       return mav; //����Ʈ�� �����ش�
   }
}

