package com.hunasys.labelsketch.users.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hunasys.labelsketch.orders.vo.OrdersVo;
import com.hunasys.labelsketch.users.vo.UsersVo;

@RestController
public class UsersRestApiController {

    private static final Logger logger = LoggerFactory.getLogger(UsersRestApiController.class);

    @RequestMapping(value = "/users/getList", method = RequestMethod.GET)
    public List<UsersVo> getFileList(Locale locale, Model model) {
        logger.info("request /users/getList");
        return new ArrayList<UsersVo>();
    }

    @RequestMapping(value = "/users/getItem", method = RequestMethod.GET)
    public OrdersVo getFileItem(Locale locale, Model model) {
        logger.info("request /users/getItem");
        return new OrdersVo();
    }

    @RequestMapping(value = "/users/newItem", method = RequestMethod.GET)
    public String newFileItem(Locale locale, Model model) {
        logger.info("request /users/newItem");
        return "";
    }

    @RequestMapping(value = "/users/modItem", method = RequestMethod.GET)
    public String modFileItem(Locale locale, Model model) {
        logger.info("request /users/modItem");
        return "";
    }

    @RequestMapping(value = "/users/delItem", method = RequestMethod.GET)
    public String delFileItem(Locale locale, Model model) {
        logger.info("request /users/delItem");
        return "";
    }
}
