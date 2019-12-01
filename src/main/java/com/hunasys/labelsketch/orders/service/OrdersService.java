package com.hunasys.labelsketch.orders.service;

import java.util.List;
import java.util.Map;

import com.hunasys.labelsketch.orders.vo.OrdersVo;

public interface OrdersService {

    public List<OrdersVo> getList(Map<String, String> param);
    
    public OrdersVo getItem(long idx);
    
    public String newItem(OrdersVo vo);
    
    public String modItem(OrdersVo vo);
    
    public String delItem(long idx);
    
}
