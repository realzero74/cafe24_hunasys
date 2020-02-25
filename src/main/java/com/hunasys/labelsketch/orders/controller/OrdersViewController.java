package com.hunasys.labelsketch.orders.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.View;

import com.hunasys.labelsketch.common.util.ExcelView;
import com.hunasys.labelsketch.orders.service.OrdersService;
import com.hunasys.labelsketch.orders.vo.OrdersVo;
import com.hunasys.labelsketch.users.vo.UsersVo;

@Controller
public class OrdersViewController {

	private static final Logger logger = LoggerFactory.getLogger(OrdersViewController.class);

    @Autowired
    OrdersService service; 
	
	@RequestMapping(value = "/orders", method = RequestMethod.GET)
	public String orderlist(Locale locale, Model model, HttpServletRequest request) {
		logger.info("Welcome home! /orders");

		HttpSession session = request.getSession();
		UsersVo uservo = (UsersVo)session.getAttribute("login");
		
		model.addAttribute("userId", uservo.getUserId());
		model.addAttribute("userCls", uservo.getUserCls());
		
		return "orders";
	}
	
	
	/**
	 * @default used by ÇÁ¸°ÅÍ
	 * @param
	 * @throws UnsupportedEncodingException
	 */
    @RequestMapping(value = "/order/print/{orderId}", method = RequestMethod.GET)
    public String getItem( Model model, @PathVariable long orderId) {
        logger.info("request /order/print");
        logger.info("orderId : " + orderId);
        
        OrdersVo vo = service.getItem(orderId);
        model.addAttribute("order", vo);
        
        return "print";
    }
	
	
	/**
	 * @default used by ¿¢¼¿ ´Ù¿î·Îµå
	 * @param
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value = "/orders/exportExcel", produces = "html/text;charset=UTF-8", method = RequestMethod.GET)    
	public View exportExcel(Model model, HttpServletRequest request, @RequestParam Map<String, Object> param)
            throws UnsupportedEncodingException {
        
        logger.info("request /order/exportExcel");
        logger.info(param.toString());
        
        model.addAttribute("datalist", service.getList(param));
        return new ExcelView();
    }
}
