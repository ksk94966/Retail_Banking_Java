<%@page import="bean.Customer"%>
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
<title>Edit Customer</title>
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
			<li><a href="#">Contact</a></li>
			<li><a href="#">About us</a></li>
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
<form action="CustomerController" method="post">
<%Customer customer=(Customer)request.getAttribute("customer") ;
if(customer!=null){
%>
						<center>
							<table class="table-condensed ">
								<tr>
									<th>SSNID</th>
									<td><input type="text" name="ssnId"
										value=<%= customer.getSsnId() %> readonly></td>
								</tr>
								<tr>
									<th>CustomerName</th>
									<td><input type="text" name="custName"
										value=<%= customer.getName() %>>
								</tr>
								<tr>
									<th>CustomerId</th>
									<td><input type="text" name="cid"
										value=<%= customer.getCustomerId() %> readonly></td>
								</tr>
								
								<tr>
									<th>Age</th>
									<td><input type="text" name="age"
										value=<%=customer.getAge()%>>
								</tr>
								<tr>
									<th>Addressline1</th>
									<td><input type="text" name="addressline1"
										value=<%=customer.getAddress1() %>>
								</tr>
								<tr>
									<th>Addressline2</th>
									<td><input type="text" name="addressline2"
										value=<%=customer.getAddress2() %>>
								</tr>
								<tr>
									<th>City</th>
									<td><input type="text" name="city"
										value=<%=customer.getCity() %>>
								</tr>
								<tr>
									<th>State</th>
									<td><input type="text" name="state"
										value=<%=customer.getState() %>>
								</tr>
					<tr>
								<td><button class="btn btn-primary" type="submit" value="update">Update</button>
								<input type="hidden" name="action" value="update"></td>
								<td><button class="btn btn-primary" onclick="location.href='viewcustomer.jsp'">cancel</button> </td>
								</tr>
							</table>
							</center>
							<%} %>
							</form>
							</div>
</body>
</html>