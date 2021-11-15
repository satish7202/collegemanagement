package com.collegemanagement.collegemanagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


@Component
public class sqlConnection {
	Connection  con;
	public Connection getConnection()  {
		try{
			Class.forName(constant.sqldriver);
			con = DriverManager.getConnection(
					constant.url,constant.user,constant.password);

		}catch(Exception e)
		{
			System.out.println(e);

		}
		return con;
	}

}
