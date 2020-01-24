<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="/Project_RetailBanking/CSS/bank.css">

<title>Insert title here</title>
<style>

body
{
 background-color:white;
 }
</style>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">TATA Global Bank</a>
    </div>
     <ul class="nav navbar-nav">
     
    </ul> 
    <ul class="nav navbar-nav navbar-right">
<!--       <li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li> -->
      <li><a href="/Project_RetailBanking/Executivehome.jsp">Home</a></li>
          <li><a href="contact1.jsp">Contact</a></li>
          <li><a href="about1.jsp">About us</a></li>
          <li><a href="NewFile.html"style="color: white;"><span class="glyphicon glyphicon-log-out">Logout</span></a></li>
          
    </ul>
  </div>
</nav>
  
<div class="sidenav">
  <a href="ManageAccDetailsCreate.jsp">Create Account</a>
<a href="DeleteAccount.jsp">Delete Account</a>
<a href="viewAccountStatus.jsp">View Account Status</a>
</div>

<div class="main">
<%int a=Integer.parseInt(request.getAttribute("rows").toString()) ;
if(a==-1)
{
	System.out.print(a);
%>
<h1>Error...Invalid Customer Id</h1>
<%}
else
{
	%>
	<h1>Error..Account already exists..</h1>
<% }%>
</div>
</body>
</html>