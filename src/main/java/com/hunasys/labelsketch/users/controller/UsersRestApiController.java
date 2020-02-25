package com.hunasys.labelsketch.users.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hunasys.labelsketch.users.service.UsersService;
import com.hunasys.labelsketch.users.vo.UsersVo;

@RestController
public class UsersRestApiController {

    private static final Logger logger = LoggerFactory.getLogger(UsersRestApiController.class);

    @Autowired
    UsersService service;
    
    @RequestMapping(value = "/user/getList", method = RequestMethod.GET)
    public Map<String, Object> getUserList(@RequestParam Map<String, Object> param) {
        logger.info("request /users/getList");
        
        Map<String, Object> map = new HashMap<String, Object>();
        
        int curpage = 1;
        
        if(param.get("currentPage")==null) {
        	curpage = 1;
        	param.put("offset", 0);
        }
        else {
        	curpage = Integer.parseInt((String)param.get("currentPage"));
        	param.put("offset", (curpage-1) *10);
        }
        
        map.put("currentPage", curpage);
        map.put("totalCnt", service.getListCnt(param));
        map.put("datalist", service.getList(param));
        
        return map;
    }

    @RequestMapping(value = "/user/getItem", method = RequestMethod.GET)
    public UsersVo getUserItem(@RequestParam Map<String, Object> param) {
        logger.info("request /users/getItem");
        return service.getItem(param);
    }

    @RequestMapping(value = "/user/newItem", method = RequestMethod.POST)
    public String newUserItem(@RequestBody UsersVo vo) {
        logger.info("request /users/newItem");
        vo.setUserCls("user");
        return service.newItem(vo);
    }

    @RequestMapping(value = "/user/modItem", method = RequestMethod.POST)
    public String modUserItem(@RequestBody UsersVo vo) {
        logger.info("request /users/modItem");
        return service.modItem(vo);
    }

    @RequestMapping(value = "/user/delItem", method = RequestMethod.POST)
    public String delUserItem(@RequestParam String userId) {
        logger.info("request /users/delItem");
        return service.delItem(userId);
    }
}

