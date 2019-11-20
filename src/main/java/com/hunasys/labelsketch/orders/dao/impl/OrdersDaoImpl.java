package com.hunasys.labelsketch.orders.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hunasys.labelsketch.orders.dao.OrdersDao;
import com.hunasys.labelsketch.orders.vo.OrdersVo;

@Repository
public class OrdersDaoImpl implements OrdersDao {

    @Autowired
    @Resource(name = "sqlSession")
    private SqlSessionTemplate sqlsession;
    

    @Override
    public List<OrdersVo> selectList(Map<String, Integer> page) {
        return sqlsession.selectList("sqlmaps.OrdersSql.selectList", page);
    }

    @Override
    public OrdersVo selectItem(long idx) {
        return sqlsession.selectOne("sqlmaps.OrdersSql.selectItem", idx);
    }

    @Override
    public String insertItem(OrdersVo vo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String updateItem(OrdersVo vo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String deleteItem(long idx) {
        // TODO Auto-generated method stub
        return null;
    }


}
