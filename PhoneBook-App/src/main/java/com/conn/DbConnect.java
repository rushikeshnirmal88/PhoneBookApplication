package com.conn;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnect {

	private static Connection conn;
	
	public static Connection getConn()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Loaded");
			String url="jdbc:mysql://database-1.cfm8akmgu833.us-east-1.rds.amazonaws.com:3306/mydb";
			
			 conn=DriverManager.getConnection(url,"admin","rushi801");
			 System.out.println(conn);
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
}
