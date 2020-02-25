package com.hunasys.labelsketch.common.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hunasys.labelsketch.common.service.CommonService;
import com.hunasys.labelsketch.common.vo.FileVo;

@Controller
public class FileUploadController {

	private static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);

	// file.properties 에서 filepath를 가져와 사용
	// root-context.xml에 설정파일 정의
	@Value("#{file['save.filepath']}")
	private String filePath;

	@Autowired
	private CommonService commonService;

	@RequestMapping(value = "/fileUpload", produces = "multipart/form-data;charset=UTF-8", method = RequestMethod.POST)
	@ResponseBody
	public String fileUpload(HttpServletRequest request, HttpServletResponse response) {
		
		logger.info("/fileUpload controller ==========================================");
		
		String json = "";

		// 파일이 저장될 path 설정
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

		Calendar calendar = Calendar.getInstance();
		String strToday = sdf.format(calendar.getTime());

		String savedFilePath = request.getSession().getServletContext().getRealPath("/") + filePath + File.separator + strToday;

		logger.info(request.getSession().getServletContext().getRealPath("/"));
		logger.info(savedFilePath);

		List<Map<String, Object>> returnObject = new ArrayList<Map<String, Object>>();
		try {
			// request에서 MultipartHttpServletRequest 생성
			MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;

			// 파일이름 목록
			Iterator<String> iter = multipartHttpServletRequest.getFileNames();
			MultipartFile multipartFile = null;
			String itemFileName = "";

			// 디레토리가 없다면 생성
			File directory = new File(savedFilePath);
			if (!directory.isDirectory()) {
				directory.mkdirs();
			}

			// request의 Iterator를 돌면서 처리
			while (iter.hasNext()) {

				itemFileName = iter.next();
				// 내용을 가져와서
				multipartFile = multipartHttpServletRequest.getFile(itemFileName);
				String originalFileName = new String(multipartFile.getOriginalFilename().getBytes("8859_1"), "UTF-8"); // 한글꺠짐
																														// 방지

				// 파일명이 없다면 다음처리로
				if ("".equals(originalFileName)) {
					continue;
				}

				// 저장할 파일명 (파일 명명 규칙에 맞게 변경)
				String savedFileName = getUUID();

				// 설정한 path를 사용한 file 객체 생성
				File savedFile = new File(savedFilePath + File.separator + savedFileName);
				
				// multipart로 수신한 파일을 savedFile 객체에 복사
				multipartFile.transferTo(savedFile);

				// 파일객체를 통해서 DB저장
				FileVo vo = new FileVo();
				vo.setOriginalFileName(originalFileName);
				vo.setSavedFileName(savedFileName);
				vo.setSavedFilePath(savedFilePath);
				
				Long fileId = commonService.regFileItem(vo);
				vo.setFileId(fileId);
				
				json = new ObjectMapper().writeValueAsString(vo);
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return json;
	}

	String getUUID() {
		
		char[] arr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
		                 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
		                 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 
		                 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 
		                 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 
		                 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 
		                 'Y', 'Z'};
		
		StringBuilder builder = new StringBuilder();
		
		Calendar now = Calendar.getInstance();

		builder.append(arr[now.get(Calendar.YEAR) / 60]  +""+  arr[now.get(Calendar.YEAR) % 60]);
		builder.append(arr[now.get(Calendar.MONTH) + 1]);
		builder.append(arr[now.get(Calendar.DATE)]);
		builder.append(arr[now.get(Calendar.HOUR)]);
		builder.append(arr[now.get(Calendar.MINUTE)]);
		builder.append(arr[now.get(Calendar.SECOND)]);
		builder.append(arr[now.get(Calendar.MILLISECOND) / 60]  +""+  arr[now.get(Calendar.MILLISECOND) % 60]);
		
		logger.info("YEAR        : "+ now.get(Calendar.YEAR)   +"  => "+arr[(int) Math.floor(now.get(Calendar.YEAR) / 60)] +""+ arr[now.get(Calendar.YEAR) % 60]);
		logger.info("MONTH       : "+ now.get(Calendar.MONTH)  +"  => "+arr[now.get(Calendar.MONTH) + 1]);
		logger.info("DATE        : "+ now.get(Calendar.DATE)   +"  => "+arr[now.get(Calendar.DATE)]);
		logger.info("HOUR        : "+ now.get(Calendar.HOUR)   +"  => "+arr[now.get(Calendar.HOUR)]);
		logger.info("MINUTE      : "+ now.get(Calendar.MINUTE) +"  => "+arr[now.get(Calendar.MINUTE)]);
		logger.info("SECOND      : "+ now.get(Calendar.SECOND) +"  => "+arr[now.get(Calendar.SECOND)]);
		logger.info("MILLISECOND : "+ now.get(Calendar.MILLISECOND)  +"  => "+arr[(int)Math.floor(now.get(Calendar.MILLISECOND) / 60)]  +""+  arr[now.get(Calendar.MILLISECOND) % 60]);

//		  javascript 버전		
//        var nowdatetime = new Date();
//        var system60 = function (num) {
//            var arr = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
//                       'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
//                       'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 
//                       'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 
//                       'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 
//                       'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 
//                       'Y', 'Z']
//            if (num < 60) {
//                return arr[num % 60];
//            }
//            else if (num < 3600) {
//                return arr[Math.floor(num / 60)] + arr[num % 60];
//            }
//        }
//
//        return system60(nowdatetime.getFullYear())
//            + system60(nowdatetime.getMonth())
//            + system60(nowdatetime.getDate())
//            + system60(nowdatetime.getHours())
//            + system60(nowdatetime.getMinutes())
//            + system60(nowdatetime.getSeconds())
//            + system60(nowdatetime.getMilliseconds())
//            + system60(Math.floor(Math.random() * 1000 + 60));
		
		return builder.toString();
	}
}
