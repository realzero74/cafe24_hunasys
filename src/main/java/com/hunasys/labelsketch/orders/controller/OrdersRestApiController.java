package com.hunasys.labelsketch.orders.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hunasys.labelsketch.orders.service.OrdersService;
import com.hunasys.labelsketch.orders.vo.OrdersVo;

@RestController
public class OrdersRestApiController {

    private static final Logger logger = LoggerFactory.getLogger(OrdersRestApiController.class);
    
    @Autowired
    OrdersService service; 

    @RequestMapping(value = "/order/getList", method = RequestMethod.GET)
    public List<OrdersVo> getList(@RequestParam Map<String, String> param) {
        logger.info("request /order/getList");
        logger.info(param.toString());
        return service.getList(param);
    }

    @RequestMapping(value = "/order/getItem", method = RequestMethod.GET)
    public OrdersVo getItem(@RequestParam long orderId) {
        logger.info("request /order/getItem");
        logger.info("orderId : " + orderId);
        return service.getItem(orderId);
    }

    @RequestMapping(value = "/order/regItem", method = RequestMethod.POST)
    public String newItem(@RequestBody OrdersVo vo) {
        logger.info("request /order/newItem");
        logger.info(vo.toString());
//        return "";
        return service.newItem(vo);
    }

    @RequestMapping(value = "/order/modItem", method = RequestMethod.POST)
    public String modItem(@RequestBody OrdersVo vo) {
        logger.info("request /order/modItem");
        logger.info(vo.toString());
        return service.modItem(vo);
    }

    @RequestMapping(value = "/order/delItem", method = RequestMethod.POST)
    public String delItem(@RequestParam long orderId) {
        logger.info("request /order/delItem");
        logger.info("orderId : " + orderId);
        return service.delItem(orderId);
    }

}
