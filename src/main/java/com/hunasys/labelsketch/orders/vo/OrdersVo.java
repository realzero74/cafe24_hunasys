package com.hunasys.labelsketch.orders.vo;

public class OrdersVo {

    private long   idx;
    private String itemNm;
    private String itemCls;
    private String company;
    private String spec;
    private int    totalQty;
    private String paper1;
    private String paper2;
    private String parerRoll;
    private int    rollQty;
    private String dueDt;
    private String delivery;
    private String desc;
    private long   file1;
    private long   file2;
    private String createDt;
    
	public long getIdx() {
		return idx;
	}
	public void setIdx(long idx) {
		this.idx = idx;
	}
	public String getItemNm() {
		return itemNm;
	}
	public void setItemNm(String itemNm) {
		this.itemNm = itemNm;
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
	public String getSpec() {
		return spec;
	}
	public void setSpec(String spec) {
		this.spec = spec;
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
	public String getDueDt() {
		return dueDt;
	}
	public void setDueDt(String dueDt) {
		this.dueDt = dueDt;
	}
	public String getDelivery() {
		return delivery;
	}
	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
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
	public String getCreateDt() {
		return createDt;
	}
	public void setCreateDt(String createDt) {
		this.createDt = createDt;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OrdersVo [idx=");
		builder.append(idx);
		builder.append(", itemNm=");
		builder.append(itemNm);
		builder.append(", itemCls=");
		builder.append(itemCls);
		builder.append(", company=");
		builder.append(company);
		builder.append(", spec=");
		builder.append(spec);
		builder.append(", totalQty=");
		builder.append(totalQty);
		builder.append(", paper1=");
		builder.append(paper1);
		builder.append(", paper2=");
		builder.append(paper2);
		builder.append(", parerRoll=");
		builder.append(parerRoll);
		builder.append(", rollQty=");
		builder.append(rollQty);
		builder.append(", dueDt=");
		builder.append(dueDt);
		builder.append(", delivery=");
		builder.append(delivery);
		builder.append(", desc=");
		builder.append(desc);
		builder.append(", file1=");
		builder.append(file1);
		builder.append(", file2=");
		builder.append(file2);
		builder.append(", createDt=");
		builder.append(createDt);
		builder.append("]");
		return builder.toString();
	}
    
    
}
