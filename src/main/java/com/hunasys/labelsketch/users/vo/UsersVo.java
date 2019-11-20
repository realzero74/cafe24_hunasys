package com.hunasys.labelsketch.users.vo;

public class UsersVo {
	
	private Long   idx;
	private String userId;
	private String userNm;
	private String userPw;
	
	public Long getIdx() {
		return idx;
	}
	public void setIdx(Long idx) {
		this.idx = idx;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserNm() {
		return userNm;
	}
	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UsersVo [idx=");
		builder.append(idx);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", userNm=");
		builder.append(userNm);
		builder.append(", userPw=");
		builder.append(userPw);
		builder.append("]");
		return builder.toString();
	}
}
