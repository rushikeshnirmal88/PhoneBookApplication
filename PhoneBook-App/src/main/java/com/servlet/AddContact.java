package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.conn.DbConnect;
import com.dao.ContactDao;
import com.entity.Contact;

@WebServlet("/addContact")
public class AddContact extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int userId=Integer.parseInt(req.getParameter("userid"));
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String phonenumber=req.getParameter("phonenumber");
		String about=req.getParameter("about");
				
		Contact c= new Contact(name,email,phonenumber,about,userId);
		
		ContactDao dao=new ContactDao(DbConnect.getConn());
	
		HttpSession session=req.getSession();
		boolean f=dao.saveContact(c);
		
		if(f)
		{
			session.setAttribute("successmsg","Conatct Saved Successfully....!!!");
			resp.sendRedirect("addContact.jsp");
		}
		else
		{
			session.setAttribute("Errorsmsg","Failed to save contact....!!!");
			resp.sendRedirect("addContact.jsp");
		}
	}
}
