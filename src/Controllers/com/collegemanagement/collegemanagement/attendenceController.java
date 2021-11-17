package com.collegemanagement.collegemanagement;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import springfox.documentation.spring.web.json.Json;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

@Controller
public class attendenceController {
	@Autowired
	crudAttendence attendence;
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/attendence/insert",method=RequestMethod.POST)
	public String AttendenceInsert(@RequestBody String attendModel) throws IOException {
		System.out.println(attendModel);
		//Declaration
		Gson gson=new Gson();
		attendenceInsertModel attendenceinsertmodel=gson.fromJson(attendModel,attendenceInsertModel.class);
		int sid = (int)attendenceinsertmodel.getStudentId();
		String sName = attendenceinsertmodel.getStudentName();
		String department = attendenceinsertmodel.getDepartment();
		String loginTime = attendenceinsertmodel.getLoginTime();
		String logoutTime = attendenceinsertmodel.getLogoutTime();
		//System.out.println();
		float attendencePercentage=attendence.attendencePercentage(sid);
		//Constant Intiallization
		int count = attendence.insertAttendence(sid,sName,department,loginTime,logoutTime,attendencePercentage);
		return "Successfully Insert..";
	}
	//Select Statement
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(path = "/attendence",method = RequestMethod.GET)
	@ResponseBody
	public String attendenceHome() throws IOException {
		//Declaration
		Gson gson=new Gson();
		String listModel = gson.toJson(attendence.selectAttendence());
		return listModel;
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(path = "/attendence/delete",method = RequestMethod.DELETE)
	@ResponseBody
	public int attendenceDelete(@RequestParam("studentId") int sId) throws IOException {
		int deletedRow=0;
		deletedRow=attendence.Delete(sId);
		return deletedRow;


	}
	@CrossOrigin(origins = "http://localhost:4200")
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
