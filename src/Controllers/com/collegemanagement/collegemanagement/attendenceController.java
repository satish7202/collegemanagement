package com.collegemanagement.collegemanagement;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
	@RequestMapping(path = "/attendence/insert",method = RequestMethod.POST)
	@ResponseBody
	public String AttendenceInsert(@RequestParam("studentId") int sid,@RequestParam("studentName") String sName,
	                               @RequestParam("department")String department,@RequestParam("loginTime")
	                               String loginTime,@RequestParam("logoutTime") String logoutTime) throws IOException {
		//Declaration
		float attendencePercentage=attendence.attendencePercentage(sid);
		//Constant Intiallization
		int count = attendence.insertAttendence(sid,sName,department,loginTime,logoutTime,attendencePercentage);
		return attendenceHome();
	}
	//Select Statement
	@RequestMapping(path = "/attendence",method = RequestMethod.GET)
	@ResponseBody
	public String attendenceHome() throws IOException {
		//Declaration
		Gson gson=new Gson();
		String listModel = gson.toJson(attendence.selectAttendence());
		return listModel;
	}
	@RequestMapping(path = "/attendence/delete",method = RequestMethod.DELETE)
	@ResponseBody
	public int attendenceDelete(@RequestParam("studentId") int sId) throws IOException {
		int deletedRow=0;
		deletedRow=attendence.Delete(sId);
		return deletedRow;


	}
	@RequestMapping(path = "/attendence/update",method = RequestMethod.PUT)
	@ResponseBody
	public String attendenceUpdate(@RequestParam("srNo") int srNo,@RequestParam("studentName") String sName,
	                            @RequestParam("department")String department,@RequestParam("loginTime")
			                                String loginTime,@RequestParam("logoutTime") String logoutTime) throws IOException {
		//float attendencePercentage=attendence.attendencePercentage(sid);
		//Constant Intiallization
		int updatedRow=0;
		updatedRow=attendence.attendenceUpdate(srNo,sName,department,loginTime,logoutTime);
		return "Updated Rows="+String.valueOf(updatedRow);


	}
}
