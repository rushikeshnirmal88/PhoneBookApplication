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
	<div class="container-fluid" style="margin-top: 90px">
		<div class="row p=7">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-body">
						<h4 class="text-center text-success">Register Here !!!</h4>
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
						<form action="register" method="post">
							<div class="form-group">
								<label for="exampleInputEmail1">Enter Name</label> <input
								name="name"
									type="text" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" placeholder="Enter Name">

							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Email address</label> <input
								name="email"
									type="email" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" placeholder="Enter email">

							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Password</label> <input
								name="password"
									type="password" class="form-control" id="exampleInputPassword1"
									placeholder="Password">
							</div>
							<div class="text-center mt-9">
								<button type="submit" class="btn btn-primary">Register</button>
							</div>


						</form>

					</div>
				</div>
			</div>
		</div>
	</div>
	<div style="margin-top: 257px"><%@ include
			file="component/footer.jsp"%></div>

</body>
</html>