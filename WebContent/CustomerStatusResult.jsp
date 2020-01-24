<%@page import="bean.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%><%@page import="java.util.ArrayList,bean.Account" %>
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

<title>Customer Status Result</title>
<script language="javascript">

function refreshpage()
{

}

</script>

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
<form action="CustomerController" method="post" onsubmit="refreshpage();">
<%
   ArrayList<Customer>al=(ArrayList<Customer>)request.getAttribute("al");
if(al.size()>0){
	%>
<table class="table table-bordered" style="position: relative;left: 30px;">
<thead style="background-color: black; color: white;">
<tr>
<th>SSN ID</th>
<th>Customer ID</th>
<th>Status</th>
<th>Last Updated</th>
<th>options</th>
<th></th>
</tr>
</thead>
<tbody>
<% for(Customer l:al)
{ 
%>
<tr>
<td><%=l.getSsnId() %></td>
<td><%=l.getCustomerId() %></td>
<td><%=l.getStatus()%></td>
<td><%=l.getLastUpdated()%></td>

<td><button type="button" class="btn btn-success"><a
						href="CustomerController?action=refresh&custId=<%=l.getCustomerId()%>&ssnId=<%=l.getSsnId()%>">
							Refresh </a></button></td>




</tr>

<%}} %>
</tbody>
</table>

<input type="hidden" name="action" value="refresh"/>
</form>
</div>
</body>
</html>