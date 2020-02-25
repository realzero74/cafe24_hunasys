package com.hunasys.labelsketch.common.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hunasys.labelsketch.common.dao.CommonDao;
import com.hunasys.labelsketch.common.vo.CodeVo;
import com.hunasys.labelsketch.common.vo.FileVo;

@Repository
public class CommonDaoImpl implements CommonDao {
    
	@Autowired
    @Resource(name = "sqlSession")
    private SqlSessionTemplate sqlsession;
    
    @Override
    public List<CodeVo> selectCodeList(String code) {
        return sqlsession.selectList("sqlmaps.CodesSql.selectCodeList", code);
    }

	@Override
	public FileVo selectFile(long idx) {
		return sqlsession.selectOne("sqlmaps.FilesSql.selectFile", idx);
	}

	@Override
	public Long insertFile(FileVo vo) {
		
		System.out.println(vo.toString());
		
		int count = sqlsession.insert("sqlmaps.FilesSql.insertFile", vo);
		
		System.out.println(vo.toString());
		
		if (count > 0) {
			return vo.getFileId();
		} else {
			return (long) 0;
		}
	}

}
