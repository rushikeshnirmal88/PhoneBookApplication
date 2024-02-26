package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.entity.User;

public class UserDao {

	private Connection conn;

	public UserDao(Connection conn) {
		super();
		this.conn = conn;
	}
	public UserDao() {
		
	}
	
	public boolean userRegistration(User user)
	{
		boolean f=false;
		try
		{
			String sql="insert into user(name,email,password) values (?,?,?)";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1,user.getName());
			pst.setString(2,user.getEmail());
			pst.setString(3,user.getPassword());
			
			int i=pst.executeUpdate();
			if(i==1)
			{
				f=true;
			}
			
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return f;
	}
	
	public User loginUser(String email,String password)
	{
		User user=null;
		
		try 
		{
			String sql="Select * from user where email=? and password=?  ";
			
			PreparedStatement pst=conn.prepareStatement(sql);
			
			pst.setString(1,email);
			pst.setString(2,password);
			
			ResultSet rs=pst.executeQuery();
			
			while(rs.next())
			{
				user=new User();
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setPassword(rs.getString(4));
			}
			
		} catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		return user;
		
	}
}

