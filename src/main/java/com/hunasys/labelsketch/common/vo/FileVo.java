package com.hunasys.labelsketch.common.vo;

public class FileVo {

	private Long   fileId;
	private String originalFileName;
	private String savedFileName;
	private String savedFilePath;

	public Long getFileId() {
		return fileId;
	}

	public void setFileId(Long fileId) {
		this.fileId = fileId;
	}

	public String getOriginalFileName() {
		return originalFileName;
	}

	public void setOriginalFileName(String originalFileName) {
		this.originalFileName = originalFileName;
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
		builder.append("FileVo [fileId=");
		builder.append(fileId);
		builder.append(", originalFileName=");
		builder.append(originalFileName);
		builder.append(", savedFileName=");
		builder.append(savedFileName);
		builder.append(", savedFilePath=");
		builder.append(savedFilePath);
		builder.append("]");
		return builder.toString();
	}

}
