<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="validation.js"></script>
</head>

<body>
<form action="Controller" method="post">
<table  border="1">

<tr>
<td>User Name</td>
<td><input type="text" name="username" id="username" ></td>
</tr>

<tr>
<td>Password</td>
<td><input type="password" name="password" id="password" minlength="10"></td>
</tr>

<tr>
<td><input type="submit" value="Login" onClick="return loginValidation();"></td>

<td><input type="reset" value="Reset"></td>
</tr>
</table>
<input type="hidden" name="action" value="login">
</form>
</body>

</html>