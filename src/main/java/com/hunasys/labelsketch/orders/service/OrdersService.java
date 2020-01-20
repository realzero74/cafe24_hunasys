package com.hunasys.labelsketch.orders.service;

import java.util.List;
import java.util.Map;

import com.hunasys.labelsketch.orders.vo.OrdersVo;

public interface OrdersService {

	public int getListCnt(Map<String, Object> param);
	
    public List<OrdersVo> getList(Map<String, Object> param);
    
    public OrdersVo getItem(long idx);
    
    public String newItem(OrdersVo vo);
    
    public String modItem(OrdersVo vo);
    
    public String delItem(long idx);
    
}
