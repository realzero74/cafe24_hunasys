package com.hunasys.labelsketch.users.vo;

public class UsersVo {

	
	private String user_id; 
	private String user_pw; 
	private String user_comp; 
	private String user_cls; 
	private String new_dt; 
	private String mod_dt;
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_pw() {
		return user_pw;
	}
	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}
	public String getUser_comp() {
		return user_comp;
	}
	public void setUser_comp(String user_comp) {
		this.user_comp = user_comp;
	}
	public String getUser_cls() {
		return user_cls;
	}
	public void setUser_cls(String user_cls) {
		this.user_cls = user_cls;
	}
	public String getNew_dt() {
		return new_dt;
	}
	public void setNew_dt(String new_dt) {
		this.new_dt = new_dt;
	}
	public String getMod_dt() {
		return mod_dt;
	}
	public void setMod_dt(String mod_dt) {
		this.mod_dt = mod_dt;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UsersVo [user_id=");
		builder.append(user_id);
		builder.append(", user_pw=");
		builder.append(user_pw);
		builder.append(", user_comp=");
		builder.append(user_comp);
		builder.append(", user_cls=");
		builder.append(user_cls);
		builder.append(", new_dt=");
		builder.append(new_dt);
		builder.append(", mod_dt=");
		builder.append(mod_dt);
		builder.append("]");
		return builder.toString();
	}
}