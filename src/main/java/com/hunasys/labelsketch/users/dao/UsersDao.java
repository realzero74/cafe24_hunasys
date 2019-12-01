package com.hunasys.labelsketch.users.dao;

import java.util.List;
import java.util.Map;

import com.hunasys.labelsketch.users.vo.UsersVo;

public interface UsersDao {
	
    public List<UsersVo> selectUsers(Map<String, String> param);
    
    public UsersVo selectUser(long idx);
    
    public String insertUser(UsersVo vo);
    
    public String updateUser(UsersVo vo);
    
    public String deleteUser(long idx);
}
