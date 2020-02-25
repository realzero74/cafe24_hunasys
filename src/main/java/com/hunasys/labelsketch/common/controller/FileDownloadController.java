package com.hunasys.labelsketch.common.controller;

import java.io.File;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hunasys.labelsketch.common.service.CommonService;
import com.hunasys.labelsketch.common.vo.FileVo;

@Controller
public class FileDownloadController {

    private static final Logger logger = LoggerFactory.getLogger(FileDownloadController.class);

    // file.properties 에서 filepath를 가져와 사용
    // root-context.xml에 설정파일 정의
    @Value("#{file['save.filepath']}")
    private String filePath;

    @Autowired
    private CommonService commonService;

    @RequestMapping("/fileDownload/{fileId}")
    public ModelAndView download(
    		@PathVariable Long fileId,
    		HttpServletRequest request) throws Exception {

        logger.debug("fileDownload request");
        logger.debug("fileDownload request : ", filePath);
        logger.debug("fileDownload request : ", fileId);

        FileVo vo = commonService.getFileItem(fileId);
        String fullPath = vo.getSavedFilePath() + File.pathSeparator + vo.getSavedFileName();
        String originalFileName = vo.getOriginalFileName();
        
        
        File downloadFile; // 다운로드를 받기위한 파일 객체
        try {
        	downloadFile = new File(fullPath);
            logger.warn(fullPath.toString());
        } catch (Exception e) {
            e.printStackTrace();
            logger.warn("다운로드 파일 설정 실패!!");
            throw e;
        }

        ModelAndView mav = new ModelAndView("downloadView");
        mav.addObject("downloadFile", downloadFile); // 서버에 저장된 파일 경로
        mav.addObject("originalFileName", originalFileName); // 사용자가 저장한 원본 파일명

        return mav; // 바이트로 보내준다
    }
}
