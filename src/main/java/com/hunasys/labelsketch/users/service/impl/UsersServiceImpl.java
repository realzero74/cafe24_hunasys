package com.hunasys.labelsketch.users.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hunasys.labelsketch.users.dao.UsersDao;
import com.hunasys.labelsketch.users.service.UsersService;
import com.hunasys.labelsketch.users.vo.UsersVo;

@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	UsersDao usersdao; 
	
    @Override
    public List<UsersVo> getList(Map<String, String> param) {
    	return usersdao.selectUsers(param);
    }

    @Override
    public UsersVo getItem(Map<String, String> param) {
        return usersdao.selectUser(param);
    }

    @Override
    public String newItem(UsersVo vo) {
        return usersdao.insertUser(vo);
    }

    @Override
    public String modItem(UsersVo vo) {
        return usersdao.updateUser(vo);
    }

    @Override
    public String delItem(String idx) {
        return usersdao.deleteUser(idx);
    }

}
