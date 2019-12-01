package com.hunasys.labelsketch.users.service;

import java.util.List;

import com.hunasys.labelsketch.users.vo.UsersVo;

public interface UsersService {
    public List<UsersVo> getList(int page);

    public UsersVo getItem(long idx);

    public String newItem(UsersVo vo);

    public String modItem(UsersVo vo);

    public String delItem(long idx);
}
