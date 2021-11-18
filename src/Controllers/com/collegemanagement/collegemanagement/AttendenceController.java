package com.collegemanagement.collegemanagement;


import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import java.io.IOException;


@RestController
public class AttendenceController {
	@Autowired
	CrudAttendence attendence;
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/attendence/insert",method=RequestMethod.POST)
	public String AttendenceInsert(@RequestBody String attendModel) throws IOException {
		System.out.println(attendModel);
		//Declaration
		Gson gson=new Gson();
		AttendenceInsertModel attendenceinsertmodel=gson.fromJson(attendModel, AttendenceInsertModel.class);
		int sid = attendenceinsertmodel.getStudentId();
		String sName = attendenceinsertmodel.getStudentName();
		String department = attendenceinsertmodel.getDepartment();
		String loginTime = attendenceinsertmodel.getLoginTime();
		String logoutTime = attendenceinsertmodel.getLogoutTime();
		//System.out.println();
		int attendencePercentage=(int)attendence.attendencePercentage(sid);
		//Constant Intiallization
		String count =String.valueOf(attendence.insertAttendence(sid,sName,department,loginTime,logoutTime,attendencePercentage));
		return "Row Successfully Inserted..No of Inserted Row="+count;
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
	public String attendenceDelete(@RequestParam("srNo") int srNo) throws IOException {
		int deletedRow=0;
		deletedRow=attendence.Delete(srNo);
		return "Successfully Deleted..No of Rows="+deletedRow;


	}
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(path = "/attendence/update",method = RequestMethod.PUT)
	@ResponseBody
	public String attendenceUpdate(@RequestBody String updateData) throws IOException {

		//Constant Intiallization
		int updatedRow=0;
		Gson gson=new Gson();
		AttendenceUpdateModel attendenceupdatemodel=gson.fromJson(updateData,AttendenceUpdateModel.class);
		 int sId=attendenceupdatemodel.getStudentId();
		int attendencePercentage= (int)attendence.attendencePercentage(sId);
		int srNo=attendenceupdatemodel.getSrNo();
		String studentName=attendenceupdatemodel.getStudentName();
		String department = attendenceupdatemodel.getDepartment();
		String loginTime=attendenceupdatemodel.getLoginTime();
		String logoutTime=attendenceupdatemodel.getLogoutTime();
		updatedRow=attendence.attendenceUpdate(srNo,studentName,department,loginTime,logoutTime,attendencePercentage);
		return "Successfully..Updated Rows="+String.valueOf(updatedRow);


	}
}
