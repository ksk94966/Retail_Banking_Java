<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="/Project_RetailBanking/CSS/bank.css">

<title>Executive Account home</title>

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
      
          <li><a href="contact.jsp">Contact</a></li>
          <li><a href="about.jsp">About us</a></li>
                     <li><a href="NewFile.html"style="color: white;"><span class="glyphicon glyphicon-log-out">Logout</span></a></li>
          
    </ul>
  </div>
</nav>
  
<div class="sidenav">
  
<a href="refer.jsp">Home</a>

</div>

<div class="main">
  
<%
 ResultSet rs=(ResultSet)request.getAttribute("list");
 
%>
<table border="1">
<tr>
<td><b>Trans_Id</b></td><td><b>Date and Time</b></td><td><b>Trans_Type</b></td><td><b>Account_Id</b></td><td><b>Balance</b></td>
</tr>

<%  
	while(rs.next())
				{
					%>
<tr>
<td><%= rs.getInt(1)%></td><td><%= rs.getTimestamp(2)%></td><td><%= rs.getString(3)%></td><td><%= rs.getInt(4)%></td><td><%=rs.getInt(5)%></td>
</tr>
	<% 
				}
%>



</table>

</div>


<div class="footer">All Rights Reserved <strong>&copy; 2017</strong>.</div>
</body>
</html>