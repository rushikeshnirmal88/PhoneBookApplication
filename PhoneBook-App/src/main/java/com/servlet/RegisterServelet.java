package com.servlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.conn.DbConnect;
import com.dao.UserDao;
import com.entity.User;

@WebServlet("/register")
public class RegisterServelet extends HttpServlet{

	public void doPost(HttpServletRequest request,HttpServletResponse reponse) throws IOException
	{
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		User u=new User(name,email,password);
		
		UserDao udao=new UserDao(DbConnect.getConn());
		
		boolean f=udao.userRegistration(u);
		
		HttpSession session=request.getSession();
		
		if(f)
		{
			session.setAttribute("successmsg","User Registration Successfull....!!!");
			reponse.sendRedirect("register.jsp");
		}
		else
		{
			session.setAttribute("Errorsmsg","User Registration Falied...!!!!");
			reponse.sendRedirect("register.jsp");
		}
	}
}
