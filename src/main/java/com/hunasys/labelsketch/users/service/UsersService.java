package com.hunasys.labelsketch.users.service;

import java.util.List;
import java.util.Map;

import com.hunasys.labelsketch.users.vo.UsersVo;

public interface UsersService {
    public List<UsersVo> getList(Map<String, String> param);

    public UsersVo getItem(Map<String, String> param);

    public String newItem(UsersVo vo);

    public String modItem(UsersVo vo);

    public String delItem(String idx);
}
