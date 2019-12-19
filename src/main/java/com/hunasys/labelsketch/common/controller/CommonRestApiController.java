package com.hunasys.labelsketch.common.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hunasys.labelsketch.common.service.CommonService;
import com.hunasys.labelsketch.common.vo.CodeVo;
import com.hunasys.labelsketch.common.vo.FileVo;
import com.hunasys.labelsketch.users.service.UsersService;
import com.hunasys.labelsketch.users.vo.UsersVo;

@RestController
public class CommonRestApiController {
    private static final Logger logger = LoggerFactory.getLogger(CommonRestApiController.class);
    
    @Autowired
    CommonService service; 

    @Autowired
    UsersService usersService;

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
		
        UsersVo usersvo = usersService.getItem(param);
        if(usersvo != null && userid.equals(usersvo.getUserId()) && userpw.equals(usersvo.getUserPw())) {
        	
        	logger.info("Welcome home! 로그인 성공");
        	
        	HttpSession session = request.getSession();
        	session.setAttribute("login", usersvo);

        	return "success";
        }
        else {
        	logger.info("Welcome home! 로그인 실패");
        	return "fail";
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
    
    
    @RequestMapping(value = "/code/getList", method = RequestMethod.GET)
    public List<CodeVo> getList(@RequestParam(value = "code", required = true) String code) {
        logger.info("request /code/getList");
        return service.getCodeList(code);
    }

    @RequestMapping(value = "/file/getList", method = RequestMethod.GET)
    public List<FileVo> getFileList(@RequestParam Map<String, String> param) {
        logger.info("request /file/list");
        return service.getFileList(param);
    }

    @RequestMapping(value = "/file/getItem", method = RequestMethod.GET)
    public FileVo getFileItem(@RequestParam long idx) {
        logger.info("request /file/getItem");
        return service.getFileItem(idx);
    }

    @RequestMapping(value = "/file/newItem", method = RequestMethod.GET)
    public String newFileItem(@RequestParam FileVo vo) {
        logger.info("request /file/newItem");
        return service.newFileItem(vo);
    }

    @RequestMapping(value = "/file/modItem", method = RequestMethod.GET)
    public String modFileItem(@RequestParam FileVo vo) {
        logger.info("request /file/modItem");
        return service.modFileItem(vo);
    }

    @RequestMapping(value = "/file/delItem", method = RequestMethod.GET)
    public String delFileItem(@RequestParam long idx) {
        logger.info("request /file/delItem");
        return service.delFileItem(idx);
    }    
    
}
