package com.hunasys.labelsketch.orders.controller;

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

@RestController
public class OrdersRestApiController {

    private static final Logger logger = LoggerFactory.getLogger(OrdersRestApiController.class);

    @RequestMapping(value = "/order/getList", method = RequestMethod.GET)
    public List<OrdersVo> getList(Locale locale, Model model) {
        logger.info("request /order/list");
        return new ArrayList<OrdersVo>();
    }
    
    @RequestMapping(value = "/order/getItem", method = RequestMethod.GET)
    public OrdersVo getItem(Locale locale, Model model) {
        logger.info("request /order/getItem");
        return new OrdersVo();
    }
    
    @RequestMapping(value = "/order/newItem", method = RequestMethod.GET)
    public String newItem(Locale locale, Model model) {
        logger.info("request /order/newItem");
        return "";
    }
    
    @RequestMapping(value = "/order/modItem", method = RequestMethod.GET)
    public String modItem(Locale locale, Model model) {
        logger.info("request /order/modItem");
        return "";
    }
    
    @RequestMapping(value = "/order/delItem", method = RequestMethod.GET)
    public String delItem(Locale locale, Model model) {
        logger.info("request /order/delItem");
        return "";
    }

}
