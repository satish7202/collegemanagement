package com.collegemanagement.collegemanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Controller
public class attendenceController {
	@Autowired
	crudAttendence attendence;
	@RequestMapping(path = "/attendence/insert",method = RequestMethod.GET)
	@ResponseBody
	public int AttendenceInsert() throws IOException {
		//Declaration
		int sid;
		String sName;
		String department;
		String loginTime;
		String logoutTime;
		int attendencePercentage;
		//Constant Intiallization
		sid = 3;
		sName = "Satish";
		department = "IT";
		loginTime = "1970-01-01 00:00:01";
		logoutTime = "1970-01-01 00:00:01";
		attendencePercentage = 20;
		int count = attendence.insertAttendence(sid,sName,department,loginTime,logoutTime,attendencePercentage);
		return count;
	}
	//Select Statement
	@RequestMapping(path = "/attendence",method = RequestMethod.GET)
	@ResponseBody
	public List attendenceHome() throws IOException {
		//Declaration

		List<attendenceModel> listModel = new ArrayList<>();
		listModel = attendence.selectAttendence();
		return listModel;
	}
	@RequestMapping(path = "/attendence/delete",method = RequestMethod.GET)
	@ResponseBody
	public int attendenceDelete() throws IOException {
		int sId=1;
		int deletedRow=0;
		deletedRow=attendence.Delete(sId);
		return deletedRow;


	}
	@RequestMapping(path = "/attendence/update",method = RequestMethod.GET)
	@ResponseBody
	public int attendenceUpdate() throws IOException {
		int sid;
		String sName;
		String department;
		String loginTime;
		String logoutTime;
		int attendencePercentage;
		//Constant Intiallization
		sid = 3;
		sName = "Dhiraj";
		department = "IT";
		loginTime = "1970-01-01 00:00:01";
		logoutTime = "1970-01-01 00:00:05";
		attendencePercentage = 30;
		int updatedRow=0;
		updatedRow=attendence.attendenceUpdate(sid,sName,department,loginTime,logoutTime,attendencePercentage);
		return updatedRow;


	}
}
