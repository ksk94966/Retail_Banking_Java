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
<title>Customer Creation Form</title>
<script>
function validation()
{
	var ssnid=document.getElementById("ssnid").value;
	var custid=document.getElementById("custid").value;
	var accid=document.getElementById("accid").value;
	if((ssnid=="")&&(custid=="")&&(accid==""))
		{
		alert('Please enter any one');
		return false;
		}

	else if(isNaN(ssnid))
		{
		alert('Enter valid SSNID');
		return false;
		}
	else if(isNaN(custid))
	{
	alert('Enter valid Customer ID');
	return false;
	}
	else if((ssnid!="") &&(ssnid.length!=7))
		{
		alert('Check SSNID !!');
		return false;
		}
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
			<li><a href="searchhome.jsp">Home</a></li>
			 <li><a href="contact1.jsp">Contact</a></li>
          <li><a href="about1.jsp">About us</a></li>
           <li><a href="NewFile.html"style="color: white;"><span class="glyphicon glyphicon-log-out">Logout</span></a></li>

		</ul>
	</div>
	</nav>

	<div class="sidenav">
		<a href="searchhome.jsp">Home</a> 
			
	</div>

	<div class="main">
		
		<form class="form-horizontal" action="SearchController" method="post" onsubmit="return validation()">
		
		<div class="form-group">
      <label class="control-label col-sm-2">SSN ID</label>
      <div class="col-sm-5">
        <input type="text" class="form-control" placeholder="Please enter SSNID" name="ssnid" id="ssnid">
      </div>
    </div>
    
		<div class="form-group">
      <label class="control-label col-sm-2">Customer ID</label>
      <div class="col-sm-5">
        <input type="text" class="form-control" placeholder="Please enter CustomerId" name="custid" id="custid">
      </div>
    </div>
    
    
    <div class="form-group">
      <label class="control-label col-sm-2">Account ID</label>
      <div class="col-sm-5">
        <input type="text" class="form-control" placeholder="Please enter Account Id" name="accid" id="accid">
      </div>
    </div>
    
    
    
    
    
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-1">
        <button class="btn btn-success" type="submit" name="action" value="searchTeller">VIEW</button>
      </div>
              
      <div class="col-sm-offset-2 col-sm-1">
        <button class="btn btn-info" type="reset" value="Reset">Reset</button>
      </div>
    </div>
    
		</form>
		</div>
	

	<div class="footer">
		All Rights Reserved <strong>&copy; 2017</strong>.
	</div>



</body>
</html>