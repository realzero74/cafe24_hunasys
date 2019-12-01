package com.hunasys.labelsketch.common.dao;

import java.util.List;
import java.util.Map;

import com.hunasys.labelsketch.common.vo.CodeVo;
import com.hunasys.labelsketch.common.vo.FileVo;

public interface CommonDao {
	public List<CodeVo> selectCodeList(String code);
	
    public List<FileVo> selectFiles(Map<String, String> param);
    
    public FileVo selectFile(long idx);
    
    public String insertFile(FileVo vo);
    
    public String updateFile(FileVo vo);
    
    public String deleteFile(long idx);
	
}
