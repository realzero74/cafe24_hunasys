package com.hunasys.labelsketch.orders.vo;

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
	private String due_dt; 
	private String delivery; 
	private String description; 
	private long   file1; 
	private long   file2; 
	private String new_dt; 
	private String mod_dt;
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
	public String getDue_dt() {
		return due_dt;
	}
	public void setDue_dt(String due_dt) {
		this.due_dt = due_dt;
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
		builder.append("OrdersVo [order_id=");
		builder.append(order_id);
		builder.append(", item_cls=");
		builder.append(item_cls);
		builder.append(", company=");
		builder.append(company);
		builder.append(", item_nm=");
		builder.append(item_nm);
		builder.append(", item_spec=");
		builder.append(item_spec);
		builder.append(", total_qty=");
		builder.append(total_qty);
		builder.append(", paper1=");
		builder.append(paper1);
		builder.append(", paper2=");
		builder.append(paper2);
		builder.append(", paper3=");
		builder.append(paper3);
		builder.append(", paper4=");
		builder.append(paper4);
		builder.append(", parer_roll=");
		builder.append(parer_roll);
		builder.append(", roll_qty=");
		builder.append(roll_qty);
		builder.append(", due_dt=");
		builder.append(due_dt);
		builder.append(", delivery=");
		builder.append(delivery);
		builder.append(", description=");
		builder.append(description);
		builder.append(", file1=");
		builder.append(file1);
		builder.append(", file2=");
		builder.append(file2);
		builder.append(", new_dt=");
		builder.append(new_dt);
		builder.append(", mod_dt=");
		builder.append(mod_dt);
		builder.append("]");
		return builder.toString();
	}
}