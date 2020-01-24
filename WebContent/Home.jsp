<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>€‹
<style>
  
  body{
  background-color:lightgray;
  
  
  }
  #pl #p2 #p3 #p4{
  height:10px;
 
  }
  

  
  
  </style>
</head>
<body>

<div class="jumbotron text-center" >
  <h1>Tata Global Bank</h1>
  <p>A complete banking solution....</p> 
</div>
  
<div class="container">
  <div class="row">
    <div class="col-sm-3 panel panel-default" id="p1" onclick="location.href='executive.jsp'">
      <h4>Customer Management</h4>
    
    </div>
    <div class="col-sm-3 panel panel-default" id="p2" onclick="location.href='AccountHome.jsp'">
      <h4>Account Management</h4>
    
   
    </div>
    <div class="col-sm-3 panel panel-default" id="p3" onclick="location.href='transaction.jsp'">
      <h4>Transactions</h4>        
     

    </div>
    <div class="col-sm-3 panel panel-default" id="p4" onclick="location.href='searchhome.jsp'">
      <h4>Search</h4>        
      <p></p>

    </div>
  </div>
</div>

</body>
</html>