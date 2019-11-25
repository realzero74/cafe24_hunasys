package com.hunasys.labelsketch.common.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.hunasys.labelsketch.common.vo.CodeVo;
import com.hunasys.labelsketch.orders.vo.OrdersVo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommonRestApiController {

    private static final Logger logger = LoggerFactory.getLogger(CommonRestApiController.class);

    @RequestMapping(value = "/code/getList", method = RequestMethod.GET)
    public List<CodeVo> getList(Locale locale, Model model) {
        logger.info("request /code/getList");
        return new ArrayList<CodeVo>();
    }

    @RequestMapping(value = "/code/getItem", method = RequestMethod.GET)
    public OrdersVo getItem(Locale locale, Model model) {
        logger.info("request code/getItem");
        return new OrdersVo();
    }

    @RequestMapping(value = "/code/newItem", method = RequestMethod.GET)
    public String newItem(Locale locale, Model model) {
        logger.info("request code/newItem");
        return "";
    }

    @RequestMapping(value = "/code/modItem", method = RequestMethod.GET)
    public String modItem(Locale locale, Model model) {
        logger.info("request code/modItem");
        return "";
    }

    @RequestMapping(value = "/code/delItem", method = RequestMethod.GET)
    public String delItem(Locale locale, Model model) {
        logger.info("request code/delItem");
        return "";
    }

    @RequestMapping(value = "/file/getList", method = RequestMethod.GET)
    public List<CodeVo> getFileList(Locale locale, Model model) {
        logger.info("request /file/getList");
        return new ArrayList<CodeVo>();
    }

    @RequestMapping(value = "/file/getItem", method = RequestMethod.GET)
    public OrdersVo getFileItem(Locale locale, Model model) {
        logger.info("request file/getItem");
        return new OrdersVo();
    }

    @RequestMapping(value = "/file/newItem", method = RequestMethod.GET)
    public String newFileItem(Locale locale, Model model) {
        logger.info("request file/newItem");
        return "";
    }

    @RequestMapping(value = "/file/modItem", method = RequestMethod.GET)
    public String modFileItem(Locale locale, Model model) {
        logger.info("request file/modItem");
        return "";
    }

    @RequestMapping(value = "/file/delItem", method = RequestMethod.GET)
    public String delFileItem(Locale locale, Model model) {
        logger.info("request file/delItem");
        return "";
    }

}
