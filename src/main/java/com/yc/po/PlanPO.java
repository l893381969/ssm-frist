package com.yc.po;

/**
 * 考试计划详情
 * @author 38929
 *
 */
public class PlanPO {

	private Integer pid;//详情编号
	private String direction;//课程名称
	private String college;//开课院系
	private String department;//上课院系
	private String classname;//考试班级
	private Integer num;//参考人数
	private String classroom;//考试地点
	private String building;//考试楼栋
	private String date;//监考日期
	private String time;//监考时间
	private String uname;//监考人员
	private String utel;//手机号码
	private String iid;//考试阶段编号
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public String getClassroom() {
		return classroom;
	}
	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}
	public String getBuilding() {
		return building;
	}
	public void setBuilding(String building) {
		this.building = building;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUtel() {
		return utel;
	}
	public void setUtel(String utel) {
		this.utel = utel;
	}
	public String getIid() {
		return iid;
	}
	public void setIid(String iid) {
		this.iid = iid;
	}
	@Override
	public String toString() {
		return "PlanPO [pid=" + pid + ", direction=" + direction + ", college=" + college + ", department=" + department
				+ ", classname=" + classname + ", num=" + num + ", classroom=" + classroom + ", building=" + building
				+ ", date=" + date + ", time=" + time + ", uname=" + uname + ", utel=" + utel + ", iid=" + iid + "]";
	}
	
}
