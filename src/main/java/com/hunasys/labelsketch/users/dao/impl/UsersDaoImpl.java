package com.hunasys.labelsketch.users.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hunasys.labelsketch.users.dao.UsersDao;
import com.hunasys.labelsketch.users.vo.UsersVo;

@Repository
public class UsersDaoImpl implements UsersDao {


    @Autowired
    @Resource(name = "sqlSession")
    private SqlSessionTemplate sqlsession;
    

    @Override
    public List<UsersVo> selectUsers(Map<String, String> param) {
        return sqlsession.selectList("sqlmaps.UsersSql.selectUsers", param);
    }

    @Override
    public UsersVo selectUser(Map<String, String> param) {
        return sqlsession.selectOne("sqlmaps.UsersSql.selectUser", param);
    }

    @Override
    public String insertUser(UsersVo vo) {
		int count = sqlsession.insert("sqlmaps.UsersSql.insertUser", vo);
		if (count > 0) {
			return "success";
		} else {
			return "fail";
		}
    }

    @Override
    public String updateUser(UsersVo vo) {
    	int count = sqlsession.update("sqlmaps.UsersSql.updateUser", vo);
		if (count > 0) {
			return "success";
		} else {
			return "fail";
		}    	
    }

    @Override
    public String deleteUser(String idx) {
        int count = sqlsession.delete("sqlmaps.UsersSql.deleteUser", idx);
		if (count > 0) {
			return "success";
		} else {
			return "fail";
		}    	
    }
}
