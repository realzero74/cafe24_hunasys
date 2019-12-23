package com.hunasys.labelsketch.orders.vo;

import com.fasterxml.jackson.databind.ObjectMapper;

public class OrdersVo {

	private long   orderId;
	private String itemCls;
	private String company;
	private String itemNm;
	private String itemSpec;
	private int    totalQty;
	private String paper1;
	private String paper2;
	private String paper3;
	private String paper4;
	private String parerRoll;
	private int    rollQty;
	private String dueDate;
	private String delivery;
	private String description;
	private long   file1;
	private String file1Name;
	private long   file2;
	private String file2Name;
	
	private String setEnd;
	private String endDate;
	private String endTime;

	private String userId;
	private String newDate;
	private String newTime;
	private String modDate;
	private String modTime;

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public String getItemCls() {
		return itemCls;
	}

	public void setItemCls(String itemCls) {
		this.itemCls = itemCls;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getItemNm() {
		return itemNm;
	}

	public void setItemNm(String itemNm) {
		this.itemNm = itemNm;
	}

	public String getItemSpec() {
		return itemSpec;
	}

	public void setItemSpec(String itemSpec) {
		this.itemSpec = itemSpec;
	}

	public int getTotalQty() {
		return totalQty;
	}

	public void setTotalQty(int totalQty) {
		this.totalQty = totalQty;
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

	public String getParerRoll() {
		return parerRoll;
	}

	public void setParerRoll(String parerRoll) {
		this.parerRoll = parerRoll;
	}

	public int getRollQty() {
		return rollQty;
	}

	public void setRollQty(int rollQty) {
		this.rollQty = rollQty;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
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

	public String getSetEnd() {
		return setEnd;
	}

	public void setSetEnd(String setEnd) {
		this.setEnd = setEnd;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getNewDate() {
		return newDate;
	}

	public void setNewDate(String newDate) {
		this.newDate = newDate;
	}

	public String getNewTime() {
		return newTime;
	}

	public void setNewTime(String newTime) {
		this.newTime = newTime;
	}

	public String getModDate() {
		return modDate;
	}

	public void setModDate(String modDate) {
		this.modDate = modDate;
	}

	public String getModTime() {
		return modTime;
	}

	public void setModTime(String modTime) {
		this.modTime = modTime;
	}

	public String getFile1Name() {
		return file1Name;
	}

	public void setFile1Name(String file1Name) {
		this.file1Name = file1Name;
	}

	public String getFile2Name() {
		return file2Name;
	}

	public void setFile2Name(String file2Name) {
		this.file2Name = file2Name;
	}

	
	@Override
	public String toString() {
		String str = "";
		try {
			str = new ObjectMapper().writeValueAsString(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}
}