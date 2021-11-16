package com.collegemanagement.collegemanagement;
public class attendenceModel {
	int studentId,srNo;
	String studentName;
	String departmentName;
	String loginTime;
	String logoutTime;
	int attendencePercentage;

	public attendenceModel(int srNo,int sid, String sName, String department, String loginTime, String logoutTime, int attendencePercentage) {
		this.srNo=srNo;
		this.studentId = sid;
		this.studentName = sName;
		this.departmentName = department;
		this.loginTime = loginTime;
		this.logoutTime = logoutTime;
		this.attendencePercentage = attendencePercentage;
	}


}
