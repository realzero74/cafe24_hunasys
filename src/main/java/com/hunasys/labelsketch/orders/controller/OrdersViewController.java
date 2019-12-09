package com.hunasys.labelsketch.orders.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hunasys.labelsketch.users.vo.UsersVo;

@Controller
public class OrdersViewController {

	private static final Logger logger = LoggerFactory.getLogger(OrdersViewController.class);

	@RequestMapping(value = "/orders/list", method = RequestMethod.GET)
	public String orderlist(Locale locale, Model model, HttpServletRequest request) {
		logger.info("Welcome home! /orders/list");

		HttpSession session = request.getSession();
		UsersVo uservo = (UsersVo)session.getAttribute("login");
		
		model.addAttribute("userId", uservo.getUserId());
		model.addAttribute("userCls", uservo.getUserCls());
		
		return "orderList";
	}

	@RequestMapping(value = "/orders/form", method = RequestMethod.GET)
	public String orderform(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "orderform";
	}
}
