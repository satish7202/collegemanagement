package com.collegemanagement.collegemanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Component
public class CrudAttendence {
	@Autowired
	SqlConnection connection;
	Connection con;
	PreparedStatement ps;
	int count=0;
	public int insertAttendence(int sid,String sName,String department,String loginTime,String logoutTime,float attendencePercentage)
	{
		try {

			con = connection.getConnection();
			//Statement stmt = con.createStatement();
			ps = con.prepareStatement(AttendenceQuery.insert);
			//Database Name Pass in dbName present in constant class
			//ps.setString(1,constant.dbName);
			ps.setInt(1,sid);
			ps.setString(2,sName);
			ps.setString(3,department);
			ps.setString(4,loginTime);
			ps.setString(5,logoutTime);
			ps.setFloat(6,attendencePercentage);
			count = ps.executeUpdate ();
			System.out.println("Inserted Rows "+count);

			con.close();
		}
		catch (Exception e)
		{
			System.out.println("Errorr...in Crud Attendence..."+e);
		}
		return count;
	}
	public List selectAttendence()
	{
		AttendenceModel[] model=new AttendenceModel[100];
		List<AttendenceModel> listModel = new ArrayList<>();
		int length=0;
		try {

			con= connection.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(AttendenceQuery.select);

			while (rs.next()) {
//				System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3)
//						+ "  " + rs.getString(4) + "  " + rs.getString(5)+"  "+rs.getInt(6));
				model[length] = new AttendenceModel(rs.getInt(1),rs.getInt(2),
						rs.getString(3),rs.getString(4),rs.getString(5),
						rs.getString(6),rs.getInt(7));
				listModel.add(model[length]);
				length++;
//                productmap.put("Product_Id",rs.getString(1));
//                productmap.put("Product_Name",rs.getString(2));
//                productmap.put("Product_Rate",Integer.toString(rs.getInt(3)));
//                productmap.put("Product_Description",rs.getString(4));
//                productmap.put("Supplier_Id",rs.getString(5));


			}

			con.close();
		}
		catch (Exception e)
		{
			System.out.println("Error..."+e);
		}
		return listModel;
	}
	public int Delete(int srNo)
	{
		int deleted_row=0;
		try {
			con= connection.getConnection();
			//Statement stmt = con.createStatement();
			ps = con.prepareStatement(AttendenceQuery.delete);
			ps.setInt(1,srNo);
			deleted_row = ps.executeUpdate();

		}
		catch (Exception e)
		{
			System.out.println("Errorr."+e);
		}
		return deleted_row;
	}
	public int attendenceUpdate(int srNo,String sName,String department,String loginTime,String logoutTime,int attdencePercentage)
	{
		int updated_row=0;
		try {
			con= connection.getConnection();
			Statement stmt = con.createStatement();
			ps = con.prepareStatement(AttendenceQuery.update);
			ps.setString(1,sName);
			ps.setString(2,department);
			ps.setString(3,loginTime);
			ps.setString(4,logoutTime);
			ps.setInt(5,attdencePercentage);
			ps.setInt(6,srNo);
			updated_row = ps.executeUpdate();

		}
		catch (Exception e)
		{
			System.out.println("Errorr."+e);
		}
		return updated_row;
	}
	public float attendencePercentage(int sId)
	{
		//attendenceModel[] model=new attendenceModel[100];
		//List<attendenceModel> listModel = new ArrayList<>();
		float length=0,noDays=31;
		float attendencePercentage=0;
		try {

			con= connection.getConnection();
			Statement stmt = con.createStatement();
			ps = con.prepareStatement(AttendenceQuery.percentageCalculationQuery);
			ps.setInt(1,sId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				length++;
//                productmap.put("Product_Id",rs.getString(1));
//                productmap.put("Product_Name",rs.getString(2));
//                productmap.put("Product_Rate",Integer.toString(rs.getInt(3)));
//                productmap.put("Product_Description",rs.getString(4));
//                productmap.put("Supplier_Id",rs.getString(5));


			}
			attendencePercentage=length/noDays*100;
			con.close();
		}
		catch (Exception e)
		{
			System.out.println("Error..."+e);
		}
		return attendencePercentage;
	}
}
