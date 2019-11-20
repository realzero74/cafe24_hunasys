package com.hunasys.labelsketch.orders.service;

import java.util.List;

import com.hunasys.labelsketch.orders.vo.OrdersVo;

public interface OrdersService {

    public List<OrdersVo> getList(int page);
    
    public OrdersVo getItem(long idx);
    
    public String newItem(OrdersVo vo);
    
    public String modItem(OrdersVo vo);
    
    public String delItem(long idx);
    
}
