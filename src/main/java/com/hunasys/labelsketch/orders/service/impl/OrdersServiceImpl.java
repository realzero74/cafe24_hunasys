package com.hunasys.labelsketch.orders.service.impl;

import java.util.List;

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
    public List<OrdersVo> getList(int page) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public OrdersVo getItem(long idx) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String newItem(OrdersVo vo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String modItem(OrdersVo vo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String delItem(long idx) {
        // TODO Auto-generated method stub
        return null;
    }

}
