package com.hunasys.labelsketch.common.controller;

import java.text.DateFormat;
import java.util.Date;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hunasys.labelsketch.users.service.UsersService;
import com.hunasys.labelsketch.users.vo.UsersVo;

@Controller
public class CommonViewController {

	private static final Logger logger = LoggerFactory.getLogger(CommonViewController.class);

	@Autowired
	UsersService usersservice;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home!");
		return "login";
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/login_check", method = RequestMethod.POST)
	public String logincheck(
			@RequestParam(value = "user_id", required = true) String userid,
			@RequestParam(value = "user_pw", required = true) String userpw,
			HttpServletRequest request) {
		logger.info("Welcome home! 로그인 체크");
		
		Map<String, String> param = new HashMap<String, String>();
		param.put("userId", userid);
		param.put("userPw", userpw);
		
        UsersVo usersvo = usersservice.getItem(param);
        if(usersvo != null && userid.equals(usersvo.getUserId()) && userpw.equals(usersvo.getUserPw())) {
        	
        	logger.info("Welcome home! 로그인 성공");
        	
        	HttpSession session = request.getSession();
        	session.setAttribute("login", usersvo);

        	return "redirect:/orders/list";
        }
        else {
        	logger.info("Welcome home! 로그인 실패");
        	return "login";
        }
        
	}
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public String logout(Locale locale, Model model) {
		logger.info("Welcome home! logout()");

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "login";
	}
}
