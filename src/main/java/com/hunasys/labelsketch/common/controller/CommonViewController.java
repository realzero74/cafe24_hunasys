package com.hunasys.labelsketch.common.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hunasys.labelsketch.users.service.UsersService;

@Controller
public class CommonViewController {

	private static final Logger logger = LoggerFactory.getLogger(CommonViewController.class);

	@Autowired
	UsersService usersservice;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home!");
		return "login";
	}

}
