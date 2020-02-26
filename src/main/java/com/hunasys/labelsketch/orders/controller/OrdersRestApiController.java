package com.hunasys.labelsketch.orders.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import com.hunasys.labelsketch.users.vo.UsersVo;

@RestController
public class OrdersRestApiController {

    private static final Logger logger = LoggerFactory.getLogger(OrdersRestApiController.class);
    
    @Autowired
    OrdersService service; 

    @RequestMapping(value = "/order/getList", method = RequestMethod.GET)
    public Map<String, Object> getList(@RequestParam Map<String, Object> param, HttpServletRequest request) {
        logger.info("request /order/getList");
        logger.info(param.toString());
        
        
        int curpage = 1;
        
        if(param.get("currentPage")==null) {
        	curpage = 1;
        	param.put("offset", 0);
        }
        else {
        	curpage = Integer.parseInt((String)param.get("currentPage"));
        	param.put("offset", (curpage-1) *10);
        }
        HttpSession session = request.getSession();
        UsersVo uservo = (UsersVo)session.getAttribute("login");
        
        param.put("userId", uservo.getUserId());
        param.put("userCls", uservo.getUserCls());
        
        //결과 세팅
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("currentPage", curpage);
        map.put("totalCnt", service.getListCnt(param));
        map.put("datalist", service.getList(param));
        
        return map;
    }

    @RequestMapping(value = "/order/getItem", method = RequestMethod.GET)
    public OrdersVo getItem(@RequestParam long orderId) {
        logger.info("request /order/getItem");
        logger.info("orderId : " + orderId);
        return service.getItem(orderId);
    }

    @RequestMapping(value = "/order/regItem", method = RequestMethod.POST)
    public String newItem(@RequestBody OrdersVo vo) {
        logger.info("request /order/regItem");
        logger.info(vo.toString());
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
