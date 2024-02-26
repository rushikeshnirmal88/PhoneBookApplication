<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="component/allCssjsp.jsp"%>
</head>
<body style="background-color: #f7faf8">
	<%@include file="component/navbar.jsp"%>
	
	<%-- <%session.getAttribute("user"); %> --%>
	
	<% if(user==null)
	{
		session.setAttribute("Errorsmsg", "Login Please....!!!");
		response.sendRedirect("login.jsp");
	}%>

	
	<div class="container-fluid" style="margin-top: 90px">
		<div class="row p=7">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-body">
						<h4 class="text-center text-success">Add Your Contact Here !!!</h4>
						
					<%String successmsg=(String)session.getAttribute("successmsg");
						String Errorsmsg=(String)session.getAttribute("Errorsmsg");
						
						if(successmsg!=null)
						{%>
							
							<p class="text-success text-center"><%=successmsg%></p>
						<%
						session.removeAttribute("successmsg");
						}
						
						if(Errorsmsg!=null)
						{%>
							
							<p class="text-danger text-center"><%=Errorsmsg%></p>
						<%
						session.removeAttribute("Errorsmsg");
						}
						%>
						
						
						<form action="addContact" method="post">
						<%
						if(user!=null)
						{%>
							<input type="hidden" value="<%=user.getId()%>" name="userid">
						<%}
						%>
							<div class="form-group">
								<label for="exampleInputEmail1">Enter Name</label> <input
									name="name" type="text" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" placeholder="Enter Name" required="required">

							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Email address</label> <input
									name="email" type="email" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" placeholder="Enter email" required="required">

							</div>
							<div class="form-group">
								<label for="exampleInputPhoneNumber">Enter Phone Number</label> <input
									name="phonenumber" type="text" class="form-control" id="exampleInputPhoneNumber"
									placeholder="Phone Number" required="required">
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">About Person</label> <input
								 name="about"	type="text" class="form-control" id="exampleInputPhoneNumber"
									placeholder="About Person" required="required">
							</div>
							<div class="text-center mt-9">
								<button type="submit" class="btn btn-primary">Save Contact</button>
							</div>


						</form>

					</div>
				</div>
			</div>
		</div>
	</div>
	<div style="margin-top: 171px"><%@ include
			file="component/footer.jsp"%></div>
</body>
</html>