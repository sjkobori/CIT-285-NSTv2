<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign Up</title>
</head>
<body>
This is SignUp.jsp
	<form action="signUp" method="post">
			<input type="hidden" name="source" value="signUp">
			<label for="username">Username</label>
			<input type="text" name="username">
			<label for="password">Password</label>
			<input type="password" name="password">
			<label for="confirmpassword">Confirm Password</label>
			<input type="password" name="confirmpassword">
			<label for="firstname">First Name</label>
			<input type="text" name="firstname">
			<label for="lastname">Last Name</label>
			<input type="text" name="lastname">
			<label for="companyname">Company Name</label>
			<input type="text" name="companyname">
			<label for="email">Email</label>
			<input type="text" name="email">
			<div> <h4>Address</h4>
			<label for="city">City</label>
			<input type="text" name="city">
			<label for="street">Street</label>
			<input type="text" name="street">
			<label for="zipcode">Zipcode</label>
			<input type="text" name="zipcode">
			<input type = "submit" value = "Submit" />
			</div>
		</form>
</body>
</html>