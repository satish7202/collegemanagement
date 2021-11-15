package com.collegemanagement.collegemanagement;
public class attendenceModel {
	int sid;
	String sName;
	String department;
	String loginTime;
	String logoutTime;
	int attendencePercentage;

	public attendenceModel(int sid, String sName, String department, String loginTime, String logoutTime, int attendencePercentage) {
		this.sid = sid;
		this.sName = sName;
		this.department = department;
		this.loginTime = loginTime;
		this.logoutTime = logoutTime;
		this.attendencePercentage = attendencePercentage;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}

	public String getLogoutTime() {
		return logoutTime;
	}

	public void setLogoutTime(String logoutTime) {
		this.logoutTime = logoutTime;
	}

	public int getAttendencePercentage() {
		return attendencePercentage;
	}

	public void setAttendencePercentage(int attendencePercentage) {
		this.attendencePercentage = attendencePercentage;
	}
}
