package com.hunasys.labelsketch.users.dao;

import java.util.List;
import java.util.Map;

import com.hunasys.labelsketch.users.vo.UsersVo;

public interface UsersDao {
	
	public int selectUsersCount(Map<String, Object> param);
	
	public List<UsersVo> selectUsers(Map<String, Object> param);
    
    public UsersVo selectUser(Map<String, Object> param);
    
    public String insertUser(UsersVo vo);
    
    public String updateUser(UsersVo vo);
    
    public String deleteUser(String idx);
}
