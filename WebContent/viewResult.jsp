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


<title>Viewing Customer Details</title>
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
		
			
	</div>
<form action="SearchController" method="post" onsubmit="refreshpage();">
<% ArrayList<Customer>cuslist=(ArrayList<Customer>)request.getAttribute("cuslist");
if(cuslist.size()>0)
{
	%>
	<div class="main">
		<table class="table table-hover">
			<thead>
				<tr>
					
<tr>
	<th>SSN ID</th>
	<th>Customer ID</th>
	<th>Name</th>
	<th>Address</th>
	<th>Age</th>
	</tr><%
	for(Customer c:cuslist)
	{%>
<tr>
	<td><%=c.getSsnId()%></td>
	<td><%=c.getCustomerId()%></td>
	<td><%=c.getName()%></td>
	<td><%=c.getAddress1()%></td>
	<td><%=c.getAge()%></td>
	</tr>
	<%
	}
	%>
	</table>
	<%
}
else
{
	%>
	Error !!!
	<%
}%>
	
		
	</div>

	<div class="footer">
		All Rights Reserved <strong>&copy; 2017</strong>.
	</div>

</form>
</body>
</html>