package com.hunasys.labelsketch.common.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hunasys.labelsketch.common.service.CommonService;
import com.hunasys.labelsketch.common.vo.CodeVo;
import com.hunasys.labelsketch.common.vo.FileVo;

@RestController
public class CommonRestApiController {
    private static final Logger logger = LoggerFactory.getLogger(CommonRestApiController.class);
    
    @Autowired
    CommonService service; 

    @RequestMapping(value = "/code/getList", method = RequestMethod.GET)
    public List<CodeVo> getList(@RequestParam(value = "code", required = true) String code) {
        logger.info("request /code/getList");
        return service.getCodeList(code);
    }

    @RequestMapping(value = "/file/getList", method = RequestMethod.GET)
    public List<FileVo> getFileList(@RequestParam Map<String, String> param) {
        logger.info("request /file/list");
        return service.getFileList(param);
    }

    @RequestMapping(value = "/file/getItem", method = RequestMethod.GET)
    public FileVo getFileItem(@RequestParam long idx) {
        logger.info("request /file/getItem");
        return service.getFileItem(idx);
    }

    @RequestMapping(value = "/file/newItem", method = RequestMethod.GET)
    public String newFileItem(@RequestParam FileVo vo) {
        logger.info("request /file/newItem");
        return service.newFileItem(vo);
    }

    @RequestMapping(value = "/file/modItem", method = RequestMethod.GET)
    public String modFileItem(@RequestParam FileVo vo) {
        logger.info("request /file/modItem");
        return service.modFileItem(vo);
    }

    @RequestMapping(value = "/file/delItem", method = RequestMethod.GET)
    public String delFileItem(@RequestParam long idx) {
        logger.info("request /file/delItem");
        return service.delFileItem(idx);
    }    
    
}
