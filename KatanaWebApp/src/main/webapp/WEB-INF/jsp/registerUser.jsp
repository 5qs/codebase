<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
</head>
<body>

<form action="commonsubmitUser" method="post">

<label for="username">Username :</label>
<input name="username" id="username"/>

<label for="password">Password :</label>
<input type="password"  name="password" id="password"/>

<label for="confirmPassword">Password :</label>
<input type="password" name="confirmPassword" id="confirmPassword"/>

<label for="firstName">First Name :</label>
<input name="firstName" id="firstName"/>

<label for="lastName">Last Name :</label>
<input name="lastName" id="lastName"/>

<input type="submit" value="Submit">

</form>

</body>
</html>