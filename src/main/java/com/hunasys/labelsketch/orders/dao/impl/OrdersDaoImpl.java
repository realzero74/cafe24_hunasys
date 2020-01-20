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
	public int selectOrdersCount(Map<String, Object> param) {
		return sqlsession.selectOne("sqlmaps.OrdersSql.selectOrdersCount", param);
	}
	
    @Override
    public List<OrdersVo> selectOrders(Map<String, Object> param) {
        return sqlsession.selectList("sqlmaps.OrdersSql.selectOrders", param);
    }

    @Override
    public OrdersVo selectOrder(long idx) {
        return sqlsession.selectOne("sqlmaps.OrdersSql.selectOrder", idx);
    }

    @Override
    public String insertOrder(OrdersVo vo) {
		int count = sqlsession.insert("sqlmaps.OrdersSql.insertOrder", vo);
		if (count > 0) {
			return "success";
		} else {
			return "fail";
		}
    }

    @Override
    public String updateOrder(OrdersVo vo) {
    	int count = sqlsession.update("sqlmaps.OrdersSql.updateOrder", vo);
		if (count > 0) {
			return "success";
		} else {
			return "fail";
		}    	
    }

    @Override
    public String deleteOrder(long idx) {
        int count = sqlsession.delete("sqlmaps.OrdersSql.deleteOrder", idx);
		if (count > 0) {
			return "success";
		} else {
			return "fail";
		}    	
    }

}
