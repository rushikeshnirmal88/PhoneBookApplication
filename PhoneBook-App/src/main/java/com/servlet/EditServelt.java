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

@WebServlet("/editContact")
public class EditServelt extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int cid=Integer.parseInt(req.getParameter("cid"));
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String phonenumber=req.getParameter("phonenumber");
		String about=req.getParameter("about");
				
		Contact c= new Contact();
		c.setId(cid);
		c.setName(name);
		c.setEmail(email);
		c.setPhonenumber(phonenumber);
		c.setAbout(about);
		
		ContactDao dao=new ContactDao(DbConnect.getConn());
		
		HttpSession session=req.getSession();
		boolean f=dao.updateContact(c);
		
		if(f)
		{
			session.setAttribute("successmsg","Conatct Updated Successfully....!!!");
			resp.sendRedirect("viewContact.jsp");
		}
		else
		{
			session.setAttribute("Errorsmsg","Failed to Update contact....!!!");
			resp.sendRedirect("editContact.jsp?cid="+cid);
		}
	}
}
