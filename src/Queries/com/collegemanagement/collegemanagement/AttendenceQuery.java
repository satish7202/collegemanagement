package com.collegemanagement.collegemanagement;


public class AttendenceQuery {
	public static String insert="INSERT INTO "+"`"+ Constant.dbName+"`"+".`attendence`(`studentId`,`studentName`, `department`,`loginTime`,`logoutTime`,`attendancePercentage`)VALUES((?),(?),(?),(?),(?),(?));";
	public static String select="SELECT * FROM "+"`"+ Constant.dbName+"`"+".attendence;";
	public static String delete="DELETE FROM "+"`"+ Constant.dbName+"`"+".`attendence`WHERE srNo=(?);";
	public static String update="UPDATE "+"`"+ Constant.dbName+"`"+".`attendence`SET`studentName` = (?) ,`department` = (?),`loginTime` = (?),`logoutTime` = (?),`attendancePercentage`=(?) WHERE `srNo`= (?);";
	public static String percentageCalculationQuery="SELECT studentName FROM "+"`"+ Constant.dbName+"`"+".`attendence`WHERE studentId= ?;";
}
