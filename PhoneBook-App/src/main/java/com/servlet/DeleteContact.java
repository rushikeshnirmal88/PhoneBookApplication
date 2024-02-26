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

@WebServlet("/delete")
public class DeleteContact extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		int cid=Integer.parseInt(req.getParameter("cid"));
		
		ContactDao dao=new ContactDao(DbConnect.getConn());
		
		boolean f=dao.deleteContactById(cid);
		
		HttpSession session=req.getSession();
		
		if(f)
		{
			session.setAttribute("successmsg", "Contact Delete Successfully...!!!");
			resp.sendRedirect("viewContact.jsp");
		}
		else
		{
			session.setAttribute("Errorsmsg", "Failed to Delete Contact...!!!");
			resp.sendRedirect("viewContact.jsp");
		}
	}
}
