package com.hunasys.labelsketch.common.service;

import java.util.List;
import java.util.Map;

import com.hunasys.labelsketch.common.vo.CodeVo;
import com.hunasys.labelsketch.common.vo.FileVo;

public interface CommonService {

	public List<CodeVo> getCodeList(String code);

	
    public List<FileVo> getFileList(Map<String, String> param);
    
    public FileVo getFileItem(long idx);
    
    public String newFileItem(FileVo vo);
    
    public String modFileItem(FileVo vo);
    
    public String delFileItem(long idx);
	
}
