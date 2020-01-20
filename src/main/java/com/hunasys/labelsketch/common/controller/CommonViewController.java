package com.hunasys.labelsketch.common.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.View;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hunasys.labelsketch.common.util.ExcelView;

@Controller
public class CommonViewController {

	private static final Logger logger = LoggerFactory.getLogger(CommonViewController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome hunaorder login!");
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Locale locale, Model model) {
		logger.info("Welcome hunaorder login!");
		return "login";
	}

	/**
	 * @default used by ¿¢¼¿ ´Ù¿î·Îµå
	 * @param
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value = "/com/exportExcel", produces = "html/text;charset=UTF-8", method = RequestMethod.POST)
	public View exportExcel(Model model, HttpServletRequest request) throws UnsupportedEncodingException {
		logger.debug("Welcome rest apo, jqxGrid Export Controller - Excel");

		String decode_info = new String(request.getParameter("jqxGridInfo").getBytes("8859_1"), "UTF-8");
		logger.debug(decode_info);

		try {
			ObjectMapper mapper = new ObjectMapper();
			Map<String, Object> map = new HashMap<String, Object>();
			map = mapper.readValue(decode_info, new TypeReference<Map<String, Object>>() {
			});

			String title = (String) map.get("title");
			model.addAttribute("title", map.get("title"));

			Map<String, Object> columns = (Map) map.get("columninfo");
			model.addAttribute("columns", columns);

			List<Map<String, Object>> datalist = (ArrayList) map.get("datalist");
			model.addAttribute("datalist", datalist);

		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ExcelView();
	}
}
