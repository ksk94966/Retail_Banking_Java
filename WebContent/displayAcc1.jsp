<%@page import="java.sql.*"%>
<%@page import="bean.*"%>
<%@page import="DAO.*"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="/Project_RetailBanking/CSS/bank.css">


<title>Display Accounts</title>
</head>
<body>
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">TATA Global Bank</a>
		</div>
		<!-- <ul class="nav navbar-nav">
      <li class="active"><a href="#">Home</a></li>
     <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Page 1 <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#">Home</a></li>
          <li><a href="#">Contact</a></li>
          <li><a href="#">About us</a></li>
        </ul>
      </li>
      <li><a href="#">Page 2</a></li>
    </ul> -->
		<ul class="nav navbar-nav navbar-right">
			<!--       <li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li> -->
			<li><a href="Executivehome.jsp">Home</a></li>
			 <li><a href="contact1.jsp">Contact</a></li>
          <li><a href="about1.jsp">About us</a></li>

		</ul>
	</div>
	</nav>

	<div class="sidenav">
		<a href="executive.jsp">Home</a> 
			
	</div>
<form action="SearchController" method="post" >
<%
int ssnid=Integer.parseInt(request.getAttribute("ssnid").toString());
%>
	<div class="main">
		<table class="table table-hover">
			<thead style="background-color: white; color: black;">
				<tr>
					
<tr>
	<td>ACCOUNT TYPE:</td>
	<td><select name="acctype">
	<option value="select">Select</option>
	<option value="Savings">Savings</option>
	<option value="Current">Current</option>
	</select>
	</td></tr>
	
			
 <tr>
	<td><input type="submit" value="view"></td>
	<td>  <input type="hidden" value="viewAccount" name="action"></td>
	  <td><input type="hidden" value="<%=ssnid %>" name="ssnid"></td>	  
	   
	<td><input type="reset" value="reset"></td>
	</tr>
			
		</table>
		
	</div>

	<div class="footer">
		All Rights Reserved <strong>&copy; 2017</strong>.
	</div>

</form>
</body>
</html>