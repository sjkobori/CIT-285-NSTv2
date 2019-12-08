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
<table>
	<h3>SignUp</h3>
	<form action="signUp" method="post">
	<input type="hidden" name="source" value="signUp">
			<TR>
				<TD>
				<label for="username">Username</label><input type="text" name="username">
				</TD>
			</TR>
			<TR>
				<TD>
			<label for="password">Password</label>
			<input type="password" name="password">
				</TD>
			</TR>
			<TR>
				<TD>
			<label for="confirmpassword">Confirm Password</label>
			<input type="password" name="confirmpassword">
				</TD>
			</TR>
			<TR>
				<TD>
			<label for="firstname">First Name</label>
			<input type="text" name="firstname">
				</TD>
			</TR>
			<TR>
				<TD>
			<label for="lastname">Last Name</label>
			<input type="text" name="lastname">
				</TD>
			</TR>
			<TR>
				<TD>
			<label for="companyname">Company Name</label>
			<input type="text" name="companyname">
				</TD>
			</TR>
			<TR>
				<TD>
			<label for="email">Email</label>
			<input type="text" name="email">
				</TD>
			</TR>
			<TR>
				<TD>
			<b>Address</b> 
			</TD>
			</TR>
			<TR>
				<TD>
			<label for="city">City</label>
			<input type="text" name="city">
				</TD>
			</TR>
			<TR>
				<TD>
			<label for="street">Street</label>
			<input type="text" name="street">
				</TD>
			</TR>
			<TR>
				<TD>
			<label for="zipcode">Zipcode</label>
			<input type="text" name="zipcode">
				</TD>
			</TR>
			<TR>
				<TD>
				<input type = "submit" value = "Submit">
				</TD>
			</TR>
		</form>
</table>
</body>
</html>