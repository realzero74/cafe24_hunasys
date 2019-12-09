package com.hunasys.labelsketch.orders.vo;

import com.fasterxml.jackson.databind.ObjectMapper;

public class OrdersVo {

	private long   order_id; 
	private String item_cls; 
	private String company; 
	private String item_nm; 
	private String item_spec; 
	private int    total_qty; 
	private String paper1; 
	private String paper2; 
	private String paper3; 
	private String paper4; 
	private String parer_roll; 
	private int    roll_qty; 
	private String due_date; 
	private String delivery; 
	private String description; 
	private long   file1; 
	private long   file2;
	
	private String user_id;
	
	private String new_date;
	private String new_time;
	private String end_date;
	private String end_time;
	private String mod_date;
	private String mod_time;
	
	
	public long getOrder_id() {
		return order_id;
	}
	public void setOrder_id(long order_id) {
		this.order_id = order_id;
	}
	public String getItem_cls() {
		return item_cls;
	}
	public void setItem_cls(String item_cls) {
		this.item_cls = item_cls;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getItem_nm() {
		return item_nm;
	}
	public void setItem_nm(String item_nm) {
		this.item_nm = item_nm;
	}
	public String getItem_spec() {
		return item_spec;
	}
	public void setItem_spec(String item_spec) {
		this.item_spec = item_spec;
	}
	public int getTotal_qty() {
		return total_qty;
	}
	public void setTotal_qty(int total_qty) {
		this.total_qty = total_qty;
	}
	public String getPaper1() {
		return paper1;
	}
	public void setPaper1(String paper1) {
		this.paper1 = paper1;
	}
	public String getPaper2() {
		return paper2;
	}
	public void setPaper2(String paper2) {
		this.paper2 = paper2;
	}
	public String getPaper3() {
		return paper3;
	}
	public void setPaper3(String paper3) {
		this.paper3 = paper3;
	}
	public String getPaper4() {
		return paper4;
	}
	public void setPaper4(String paper4) {
		this.paper4 = paper4;
	}
	public String getParer_roll() {
		return parer_roll;
	}
	public void setParer_roll(String parer_roll) {
		this.parer_roll = parer_roll;
	}
	public int getRoll_qty() {
		return roll_qty;
	}
	public void setRoll_qty(int roll_qty) {
		this.roll_qty = roll_qty;
	}
	public String getDue_date() {
		return due_date;
	}
	public void setDue_date(String due_date) {
		this.due_date = due_date;
	}
	public String getDelivery() {
		return delivery;
	}
	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public long getFile1() {
		return file1;
	}
	public void setFile1(long file1) {
		this.file1 = file1;
	}
	public long getFile2() {
		return file2;
	}
	public void setFile2(long file2) {
		this.file2 = file2;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getNew_date() {
		return new_date;
	}
	public void setNew_date(String new_date) {
		this.new_date = new_date;
	}
	public String getNew_time() {
		return new_time;
	}
	public void setNew_time(String new_time) {
		this.new_time = new_time;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	public String getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	public String getMod_date() {
		return mod_date;
	}
	public void setMod_date(String mod_date) {
		this.mod_date = mod_date;
	}
	public String getMod_time() {
		return mod_time;
	}
	public void setMod_time(String mod_time) {
		this.mod_time = mod_time;
	}
	
	@Override
	public String toString() {
		String str = "";
		try {
			str =  new ObjectMapper().writeValueAsString(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}
}