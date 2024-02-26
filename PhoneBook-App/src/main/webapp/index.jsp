<%@page import="com.entity.User"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.conn.DbConnect"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="component/allCssjsp.jsp" %>
<style type="text/css">
.back-img
{
background:url("img/person-woman-hand-smartphone.jpg");
 width: 100%;
 height:88vh;
  background-repeat: no-repeat; 
background-size: cover; 

}
</style>
</head>
<body>
<%@include file="component/navbar.jsp"%>
<div class="container-fluid back-img text-center text-danger">
<!--   <h1>Welcome To Phone Book Application</h1> -->

  <marquee><h5 style="background-color: rgb(242, 255, 0); text-align: center; margin-top: 90px;">Welcome To My Phone Book Application</h5></marquee>
<marquee behavior="scroll" direction="up" scrollamount="1"><h1 style="color: aqua;">Slow Scrolling</h1></marquee>
<marquee behavior="scroll" direction="right" scrollamount="9"><h1 style="color: coral;">Welcome</h1></marquee>
<marquee behavior="scroll" direction="left" scrollamount="18"><h1 style="color: red;">Welcome</h1></marquee>
<marquee behavior="scroll" direction="right" scrollamount="27"><h4 style="background-color:yellow; text-align: center;">Happy To See You</h4></marquee>
<marquee behavior="scroll" direction="left" scrollamount="18"><h1 style="color: red;">Welcome</h1></marquee>
<marquee behavior="scroll" direction="right" scrollamount="9"><h1 style="color: coral;">Welcome</h1></marquee>
<marquee behavior="scroll" direction="right" scrollamount="27"><h4 style="background-color:sandybrown; text-align: center;">Happy To See You</h4></marquee>
<marquee behavior="scroll" direction="right" scrollamount="9"><h1 style="color: yellow;">Welcome</h1></marquee>
</div>
<%@ include file="component/footer.jsp"%>
</body>
</html>