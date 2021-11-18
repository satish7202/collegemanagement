package com.collegemanagement.collegemanagement;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;


@Component
public class SqlConnection {
	Connection  con;
	public Connection getConnection()  {
		try{
			Class.forName(Constant.sqldriver);
			con = DriverManager.getConnection(
					Constant.url, Constant.user, Constant.password);

		}catch(Exception e)
		{
			System.out.println(e);

		}
		return con;
	}

}
