package com.hunasys.labelsketch.common.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hunasys.labelsketch.common.dao.CommonDao;
import com.hunasys.labelsketch.common.service.CommonService;
import com.hunasys.labelsketch.common.vo.CodeVo;
import com.hunasys.labelsketch.common.vo.FileVo;

@Service
public class CommonServiceImpl implements CommonService {

	@Autowired
	CommonDao commondao;
	
	@Override
	public List<CodeVo> getCodeList(String code) {
		return commondao.selectCodeList(code);
	}

	@Override
	public List<FileVo> getFileList(Map<String, String> param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FileVo getFileItem(long idx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String newFileItem(FileVo vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String modFileItem(FileVo vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delFileItem(long idx) {
		// TODO Auto-generated method stub
		return null;
	}
}