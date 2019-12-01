package com.hunasys.labelsketch.common.vo;

public class FileVo {

	private Long   idx;
	private String originalFileName;
	private String originalFileExt;
	private String savedFileName;
	private String savedFilePath;

	public Long getIdx() {
		return idx;
	}

	public void setIdx(Long idx) {
		this.idx = idx;
	}

	public String getOriginalFileName() {
		return originalFileName;
	}

	public void setOriginalFileName(String originalFileName) {
		this.originalFileName = originalFileName;
	}

	public String getOriginalFileExt() {
		return originalFileExt;
	}

	public void setOriginalFileExt(String originalFileExt) {
		this.originalFileExt = originalFileExt;
	}

	public String getSavedFileName() {
		return savedFileName;
	}

	public void setSavedFileName(String savedFileName) {
		this.savedFileName = savedFileName;
	}

	public String getSavedFilePath() {
		return savedFilePath;
	}

	public void setSavedFilePath(String savedFilePath) {
		this.savedFilePath = savedFilePath;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FileVo [idx=");
		builder.append(idx);
		builder.append(", originalFileName=");
		builder.append(originalFileName);
		builder.append(", originalFileExt=");
		builder.append(originalFileExt);
		builder.append(", savedFileName=");
		builder.append(savedFileName);
		builder.append(", savedFilePath=");
		builder.append(savedFilePath);
		builder.append("]");
		return builder.toString();
	}

}
