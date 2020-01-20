package com.hunasys.labelsketch.orders.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hunasys.labelsketch.orders.dao.OrdersDao;
import com.hunasys.labelsketch.orders.service.OrdersService;
import com.hunasys.labelsketch.orders.vo.OrdersVo;

@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersDao ordersdao;
    
    @Override
    public int getListCnt(Map<String, Object> param) {
    	return ordersdao.selectOrdersCount(param);
    }

    @Override
    public List<OrdersVo> getList(Map<String, Object> param) {
    	return ordersdao.selectOrders(param);
    }

    @Override
    public OrdersVo getItem(long idx) {
    	return ordersdao.selectOrder(idx);
    }

    @Override
    public String newItem(OrdersVo vo) {
    	return ordersdao.insertOrder(vo);
    }

    @Override
    public String modItem(OrdersVo vo) {
    	return ordersdao.updateOrder(vo);
    }

    @Override
    public String delItem(long idx) {
    	return ordersdao.deleteOrder(idx);
    }


}
