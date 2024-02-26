<%@page import="com.entity.Contact"%>
<%@page import="java.util.List"%>
<%@page import="com.conn.DbConnect"%>
<%@page import="com.dao.ContactDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="component/allCssjsp.jsp"%>
<style type="text/css">
.crd-ho:hover {
	background-color: #f7f7f7;
}
</style>
</head>
<body style="background-color: #f7faf8">
	<%@include file="component/navbar.jsp"%>

	<%
	if (user == null) {
		session.setAttribute("Errorsmsg", "Login Please....!!!");
		response.sendRedirect("login.jsp");
	}
	%>

	<%
	String successmsg = (String) session.getAttribute("successmsg");
	String Errorsmsg = (String) session.getAttribute("Errorsmsg");

	if (successmsg != null) {
	%>

	<div class="alert alert-success" role="alert"><%=successmsg%></div>

	<%
	session.removeAttribute("successmsg");
	}

	if (Errorsmsg != null) {
	%>

	<p class="text-danger text-center"><%=Errorsmsg%></p>
	<%
	session.removeAttribute("Errorsmsg");
	}
	%>


	<div class="container">
		<div class="row p-5">

			<%
			if (user != null) {
				ContactDao dao = new ContactDao(DbConnect.getConn());

				List<Contact> contact = dao.getAllContact(user.getId());

				for (Contact c : contact) {
			%>
			<div class="col-md-4">

				<div class="card crd-ho">
					<div class="card-body">
						<h5>
							Name :<%=c.getName()%></h5>
						<p>
							Email :<%=c.getEmail()%></p>
						<p>
							Phone No :<%=c.getPhonenumber()%></p>
						<p>
							About :<%=c.getAbout()%></p>
						<div class="text-center">
							<a href="editContact.jsp?cid=<%=c.getId()%>"
								class="btn btn-success btn-sm text-white">Edit</a> <a
								href="delete?cid=<%=c.getId()%>"
								class="btn-danger btn-sm text-white">Delete</a>
						</div>
					</div>
				</div>
			</div>

			<%
			}
			}
			%>


		</div>
	</div>


	<div style="margin-top: 342px"><%@ include
			file="component/footer.jsp"%></div>
</body>
</html>