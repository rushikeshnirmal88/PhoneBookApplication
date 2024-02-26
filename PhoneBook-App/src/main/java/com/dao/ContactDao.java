package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Contact;

public class ContactDao {

	private Connection conn;

	public ContactDao(Connection conn) {
		super();
		this.conn = conn;
	}
	
	public boolean saveContact(Contact c)
	{
		boolean f=false;
		try
		{
			String sql="insert into contact(name,email,phonenumber,about,userId) values (?,?,?,?,?)";
			
			PreparedStatement pst=conn.prepareStatement(sql);
			
			pst.setString(1,c.getName());
			pst.setString(2,c.getEmail());
			pst.setString(3,c.getPhonenumber());
			pst.setString(4,c.getAbout());
			pst.setInt(5,c.getUserId());
			
			int i=pst.executeUpdate();
			if(i==1)
			{
				f=true;
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return f;
	}
	
	public List<Contact> getAllContact(int uID)
	{
		List<Contact> list= new ArrayList<>();
		Contact c=null;
		try 
		{
			String sql="select * from Contact where userId=?";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, uID);
			
			ResultSet  rs=pst.executeQuery();
		
			while(rs.next())
			{
				c=new Contact();
				c.setId(rs.getInt(1));
				c.setName(rs.getString(2));
				c.setEmail(rs.getString(3));
				c.setPhonenumber(rs.getString(4));
				c.setAbout(rs.getString(5));
				list.add(c);
			}
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	
	public Contact getContactById(int cid)
	{
		Contact c=new Contact();
		
		try 
		{
			String sql="select * from contact where id=?";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, cid);
			
			ResultSet rs=pst.executeQuery();
			
			while(rs.next())
			{
				c.setId(rs.getInt(1));
				c.setName(rs.getString(2));
				c.setEmail(rs.getString(3));
				c.setPhonenumber(rs.getString(4));
				c.setAbout(rs.getString(5));
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return c;	
	}
	
	public boolean updateContact(Contact c)
	{
		boolean f=false;
		try
		{
			String sql="update contact set name=?,email=?,phonenumber=?,about=? where id=?";
			
			PreparedStatement pst=conn.prepareStatement(sql);
			
			pst.setString(1,c.getName());
			pst.setString(2,c.getEmail());
			pst.setString(3,c.getPhonenumber());
			pst.setString(4,c.getAbout());
			pst.setInt(5,c.getId());
			
			int i=pst.executeUpdate();
			if(i==1)
			{
				f=true;
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return f;
	}
	
	public boolean deleteContactById(int id)
	{
		boolean f=false;
		try 
		{
			String sql="delete from contact where id=?";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, id);
			
			int i=pst.executeUpdate();
			
			if(i==1)
			{
				f=true;
			}
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		return f;
		
	}

}
