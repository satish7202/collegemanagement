package com.collegemanagement.collegemanagement;

import org.springframework.stereotype.Component;


public class attendenceQuery {
	public static String insert="INSERT INTO "+"`"+constant.dbName+"`"+".`attendence`(`studentId`,`studentName`, `departmentName`,`loginTime`,`logoutTime`,`attendancePercentage`)VALUES((?),(?),(?),(?),(?),(?));";
	public static String select="SELECT * FROM "+"`"+constant.dbName+"`"+".attendence;";
	public static String delete="DELETE FROM "+"`"+constant.dbName+"`"+".`attendence`WHERE studentId=(?);";
	public static String update="UPDATE "+"`"+constant.dbName+"`"+".`attendence`SET`studentName` = (?) ,`departmentName` = (?),`loginTime` = (?),`logoutTime` = (?),`attendancePercentage` = (?) WHERE `studentId`= (?);";
}
