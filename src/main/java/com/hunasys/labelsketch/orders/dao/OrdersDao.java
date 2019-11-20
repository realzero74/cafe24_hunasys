package com.hunasys.labelsketch.orders.dao;

import java.util.List;
import java.util.Map;

import com.hunasys.labelsketch.orders.vo.OrdersVo;

public interface OrdersDao {
    
    public List<OrdersVo> selectList(Map<String, Integer> page);
    
    public OrdersVo selectItem(long idx);
    
    public String insertItem(OrdersVo vo);
    
    public String updateItem(OrdersVo vo);
    
    public String deleteItem(long idx);

}
