package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.conn.DbConnect;
import com.dao.UserDao;
import com.entity.User;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		UserDao udao=new UserDao(DbConnect.getConn());
		
		User u=udao.loginUser(email, password);
		
		HttpSession session=req.getSession();
		if(u!=null)
		{
			session.setAttribute("user",u);
			resp.sendRedirect("index.jsp");
			//System.out.println("Login Successfull....!!!");
		}
		else
		{
			session.setAttribute("Errorsmsg", "Login Failed....!!! Invalid Email Or Password");
			resp.sendRedirect("login.jsp");
			//System.out.println("Login Failed....!!!");
		}
		
	}
}
