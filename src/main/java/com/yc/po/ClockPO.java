package com.yc.po;

/**
 * 签到
 * @author 38929
 *
 */
public class ClockPO {

	private Integer cid;//编号
	private String utel;//监考员编号
	private String date;//签到时间
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getUtel() {
		return utel;
	}
	public void setUtel(String utel) {
		this.utel = utel;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "ClockPO [cid=" + cid + ", utel=" + utel + ", date=" + date + "]";
	}
	
	
}
