package com.hunasys.labelsketch.orders.dao;

import java.util.List;
import java.util.Map;

import com.hunasys.labelsketch.orders.vo.OrdersVo;

public interface OrdersDao {
    
    public List<OrdersVo> selectOrders(Map<String, String> param);
    
    public OrdersVo selectOrder(long idx);
    
    public String insertOrder(OrdersVo vo);
    
    public String updateOrder(OrdersVo vo);
    
    public String deleteOrder(long idx);

}
