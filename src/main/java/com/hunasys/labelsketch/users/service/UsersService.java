package com.hunasys.labelsketch.users.service;

import java.util.List;

import com.hunasys.labelsketch.users.vo.UsersVo;

public interface UsersService {
    public List<UsersVo> getUserList(int page);

    public UsersVo getUserItem(long idx);

    public String newUserItem(UsersVo vo);

    public String modUserItem(UsersVo vo);

    public String delUserItem(long idx);
}
