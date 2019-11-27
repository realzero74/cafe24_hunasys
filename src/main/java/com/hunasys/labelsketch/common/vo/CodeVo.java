package com.hunasys.labelsketch.common.vo;

public class CodeVo {

	private String groupCd; /*  */
	private String groupNm; /*  */
	private String itemCd; /*  */
	private String itemNm; /*  */
	private Integer ordered; /*  */

	public String getGroupCd() {
		return groupCd;
	}

	public void setGroupCd(String groupCd) {
		this.groupCd = groupCd;
	}

	public String getGroupNm() {
		return groupNm;
	}

	public void setGroupNm(String groupNm) {
		this.groupNm = groupNm;
	}

	public String getItemCd() {
		return itemCd;
	}

	public void setItemCd(String itemCd) {
		this.itemCd = itemCd;
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
		builder.append("CodeVo [groupCd=");
		builder.append(groupCd);
		builder.append(", groupNm=");
		builder.append(groupNm);
		builder.append(", itemCd=");
		builder.append(itemCd);
		builder.append(", itemNm=");
		builder.append(itemNm);
		builder.append(", ordered=");
		builder.append(ordered);
		builder.append("]");
		return builder.toString();
	}
}
