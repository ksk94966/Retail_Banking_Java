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

<title>Insert title here</title>
<style>

body
{
 background-color:#FFF8DC;
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
      <li class="active"><a href="#">Home</a></li>
     <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Page 1 <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#">Home</a></li>
          <li><a href="#">Contact</a></li>
          <li><a href="#">About us</a></li>
        </ul>
      </li>
      <li><a href="#">Page 2</a></li>
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
Account deleted successfully !!
<a href="AccountHome.jsp">Home</a>
</div>
</body>
</html>