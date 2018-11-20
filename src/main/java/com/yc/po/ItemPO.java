package com.yc.po;

/**
 * 考试安排表
 * @author 38929
 *
 */
public class ItemPO {

	private String iid;//考试阶段编号
	private String iname;//考试阶段名称
	public String getIid() {
		return iid;
	}
	public void setIid(String iid) {
		this.iid = iid;
	}
	public String getIname() {
		return iname;
	}
	public void setIname(String iname) {
		this.iname = iname;
	}
	@Override
	public String toString() {
		return "itemsPO [iid=" + iid + ", iname=" + iname + "]";
	}	
}
