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
	public List<FileVo> selectFiles(Map<String, String> param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FileVo selectFile(long idx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String insertFile(FileVo vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateFile(FileVo vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteFile(long idx) {
		// TODO Auto-generated method stub
		return null;
	}
}
