package com.yc.po;

/**
 * 监考人员
 * @author 38929
 *
 */
public class UserPO {

	private	Integer uid;//编号
	private String uname;//账号
	private String upwd;//密码
	private String utype;//类型
	private String utel;//手机号码
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpwd() {
		return upwd;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	public String getUtype() {
		return utype;
	}
	public void setUtype(String utype) {
		this.utype = utype;
	}
	public String getUtel() {
		return utel;
	}
	public void setUtel(String utel) {
		this.utel = utel;
	}
	@Override
	public String toString() {
		return "userPO [uid=" + uid + ", uname=" + uname + ", upwd=" + upwd + ", utype=" + utype + ", utel=" + utel + "]";
	}
	
	public UserPO() {
		super();
	}
	public UserPO(String uname, String upwd, String utype, String utel) {
		super();
		this.uname = uname;
		this.upwd = upwd;
		this.utype = utype;
		this.utel = utel;
	}
	
}
