package com.hunasys.labelsketch.common.vo;

public class CodeVo {

	private String  code;
	private String  itemCd;
	private String  codeNm;
	private String  itemNm;
	private Integer ordered;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getItemCd() {
		return itemCd;
	}
	public void setItemCd(String itemCd) {
		this.itemCd = itemCd;
	}
	public String getCodeNm() {
		return codeNm;
	}
	public void setCodeNm(String codeNm) {
		this.codeNm = codeNm;
	}
	public String getItemNm() {
		return itemNm;
	}
	public void setItemNm(String itemNm) {
		this.itemNm = itemNm;
	}
	public Integer getOrdered() {
		return ordered;
	}
	public void setOrdered(Integer ordered) {
		this.ordered = ordered;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CodeVo [code=");
		builder.append(code);
		builder.append(", itemCd=");
		builder.append(itemCd);
		builder.append(", codeNm=");
		builder.append(codeNm);
		builder.append(", itemNm=");
		builder.append(itemNm);
		builder.append(", ordered=");
		builder.append(ordered);
		builder.append("]");
		return builder.toString();
	}
}
