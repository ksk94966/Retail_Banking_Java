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
 <li><a href="NewFile.html"style="color: white;"><span class="glyphicon glyphicon-log-out">Logout</span></a></li>
		</ul>
	</div>
	</nav>

	<div class="sidenav">
		<a href="createcustomer.jsp">Create Customer</a> <a
			href="viewcustomer.jsp">View Customer</a>
			<a href="viewcustomerstatus.jsp">View Status</a>
			
	</div>
	</div>

	<div class="main">
		<table class="table table-hover">
			<thead style="background-color: black; color: white;">
				<tr>
					<th>SSN ID</th>
					<th>CUSTOMER NAME</th>
					<th>CUSTOMER ID</th>
					<th>AGE</th>
					<th>ADDRESSLINE1</th>
					<th>ADDRESSLINE2</th>
					<th>CITY</th>
					<th>STATE</th>
					<th>OPTIONS</th>
				</tr>
			</thead>
			<tbody>
				<% 
DBUtil db=new DBUtil();
Connection conn = db.getConnection();
PreparedStatement ps=conn.prepareStatement("select * from customerDetails");
ResultSet rs=ps.executeQuery();
while(rs.next())
{
%>

				<tr>
					<td><%=rs.getInt(1)%></td>
					<td><%=rs.getString(2)%></td>
					<td><%=rs.getInt(3)%></td>
					<td><%=rs.getInt(4)%></td>
					<td><%=rs.getString(5)%></td>
					<td><%=rs.getString(6)%></td>
					<td><%=rs.getString(7)%></td>
					<td><%=rs.getString(8)%></td>
					<td>
					<button type="button" class="btn btn-success"><a
						href="CustomerController?action=edit&cid=<%=rs.getInt(3)%>">
							Edit </a></button>
					<button type="button" class="btn btn-danger"> <a
						href="CustomerController?action=delete&cid=<%=rs.getInt(3)%>">
							Delete </a></button>
					
					</td>
				</tr>

				<%} %>
			</tbody>
		</table>
	</div>

	<div class="footer">
		All Rights Reserved <strong>&copy; 2017</strong>.
	</div>


</body>
</html>