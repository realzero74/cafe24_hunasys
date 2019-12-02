package com.hunasys.labelsketch.users.vo;

public class UsersVo {
	
	private String userId; 
	private String userPw; 
	private String userComp; 
	private String userCls; 
	private String newDt; 
	private String modDt;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserComp() {
		return userComp;
	}
	public void setUserComp(String userComp) {
		this.userComp = userComp;
	}
	public String getUserCls() {
		return userCls;
	}
	public void setUserCls(String userCls) {
		this.userCls = userCls;
	}
	public String getNewDt() {
		return newDt;
	}
	public void setNewDt(String newDt) {
		this.newDt = newDt;
	}
	public String getModDt() {
		return modDt;
	}
	public void setModDt(String modDt) {
		this.modDt = modDt;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UsersVo [userId=");
		builder.append(userId);
		builder.append(", userPw=");
		builder.append(userPw);
		builder.append(", userComp=");
		builder.append(userComp);
		builder.append(", userCls=");
		builder.append(userCls);
		builder.append(", newDt=");
		builder.append(newDt);
		builder.append(", modDt=");
		builder.append(modDt);
		builder.append("]");
		return builder.toString();
	}
}