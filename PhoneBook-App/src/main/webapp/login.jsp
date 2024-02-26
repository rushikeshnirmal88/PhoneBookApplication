<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Here</title>
<%@include file="component/allCssjsp.jsp"%>
</head>
<body style="background-color:#f7faf8">
	<%@include file="component/navbar.jsp"%>
	<div class="container-fluid"  style="margin-top: 90px">
		<div class="row p=7">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-body">
					<h4 class="text-center text-success" >Login Here !!!</h4>
					<%String Errorsmsg=(String)session.getAttribute("Errorsmsg");
						
						if(Errorsmsg!=null)
						{%>
							
							<p class="text-danger text-center"><%=Errorsmsg%></p>
						<%
						session.removeAttribute("Errorsmsg");
						}
						%>
						
						<%String logoutMsg=(String)session.getAttribute("logoutMsg");
						
						if(logoutMsg!=null)
						{%>
							
							<p class="text-success text-center"><%=logoutMsg%></p>
						<%
						session.removeAttribute("logoutMsg");
						}
						%>
						
						
						<form action="Login" method="post">
							<div class="form-group">
								<label for="exampleInputEmail1">Email address</label> <input
									type="email" name="email" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" placeholder="Enter email">
								
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Password</label> <input
									type="password" name="password" class="form-control" id="exampleInputPassword1"
									placeholder="Password">
							</div>
							<div class="text-center mt-9">
							<button type="submit" class="btn btn-primary">Login</button>
							</div>
					
							
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>
	<div style="margin-top: 342px"><%@ include
			file="component/footer.jsp"%></div>

</body>
</html>