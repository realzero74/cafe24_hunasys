package com.hunasys.labelsketch.orders.vo;

public class OrdersVo {

    private long idx;
    private String item_nm;
    private String item_cls;
    private String company;
    private String spec;
    private int total_qty;
    private String paper1;
    private String paper2;
    private String parer_roll;
    private int roll_qty;
    private String due_dt;
    private String delivery;
    private String desc;
    private long file1;
    private long file2;
    private String create_dt;

    public long getIdx() {
        return idx;
    }

    public void setIdx(long idx) {
        this.idx = idx;
    }

    public String getItem_nm() {
        return item_nm;
    }

    public void setItem_nm(String item_nm) {
        this.item_nm = item_nm;
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

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
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

    public String getCreate_dt() {
        return create_dt;
    }

    public void setCreate_dt(String create_dt) {
        this.create_dt = create_dt;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("OrdersVo [idx=");
        builder.append(idx);
        builder.append(", item_nm=");
        builder.append(item_nm);
        builder.append(", item_cls=");
        builder.append(item_cls);
        builder.append(", company=");
        builder.append(company);
        builder.append(", spec=");
        builder.append(spec);
        builder.append(", total_qty=");
        builder.append(total_qty);
        builder.append(", paper1=");
        builder.append(paper1);
        builder.append(", paper2=");
        builder.append(paper2);
        builder.append(", parer_roll=");
        builder.append(parer_roll);
        builder.append(", roll_qty=");
        builder.append(roll_qty);
        builder.append(", due_dt=");
        builder.append(due_dt);
        builder.append(", delivery=");
        builder.append(delivery);
        builder.append(", desc=");
        builder.append(desc);
        builder.append(", file1=");
        builder.append(file1);
        builder.append(", file2=");
        builder.append(file2);
        builder.append(", create_dt=");
        builder.append(create_dt);
        builder.append("]");
        return builder.toString();
    }

}
