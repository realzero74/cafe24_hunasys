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
	public FileVo getFileItem(long idx) {
		return commondao.selectFile(idx);
	}

	@Override
	public Long regFileItem(FileVo vo) {
		return commondao.insertFile(vo);
	}

}