<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign Up</title>
<link rel="stylesheet" href="web/css/default.css">
</head>
<body>
<h3>Sign Up</h3>
<table>
	
	<form action="signup" method="post">
	<input type="hidden" name="source" value="signUp">
			<TR>
				<TD>Username:</TD>
				<TD><input type="text" name="username" maxlength="20" required></TD>
			</TR>
			<TR>
				<TD>Password:</TD>
				<TD><input type="password" name="password" pattern=".{6,}" title="Six or more characters" maxlength="20" required></TD>
			</TR>
			<TR>
				<TD>Confirm Password:</TD>
				<TD><input type="password" name="confirmpassword" maxlength="20" required></TD>
			</TR>
			<TR>
				<TD>First Name:</TD>
				<TD><input type="text" name="firstname" pattern="[A-Za-z]+" title="Only letters" maxlength="20" required></TD>
			</TR>
			<TR>
				<TD><label for="lastname">Last Name</label></TD>
				<TD><input type="text" name="lastname" pattern="[A-Za-z]+" title="Only letters" maxlength="20" required></TD>
			</TR>
			<TR>
				<TD><label for="companyname">Company Name</label></TD>
				<TD><input type="text" name="companyname" maxlength="50"></TD>
			</TR>
			<TR>
				<TD><label for="email">Email</label></TD>
				<TD><input type="email" name="email" maxlength="50" required></TD>
			</TR>
			<TR>
				<TD><b>Address</b></TD>
			</TR>
			<TR>
				<TD><label for="street">Street</label></TD>
				<TD><input type="text" name="street"  maxlength="50" required></TD>
			</TR>
			<TR>
				<TD><label for="city">City</label></TD>
				<TD><input type="text" name="city" maxlength="20" required></TD>
			</TR>			
			<TR>
				<TD><label for="country">State</label></TD>
				<TD><input type="text" name="state" pattern="[A-Z]{2}" title="Please Enter a 2 Character State code" maxlength="2" required></TD>
			</TR>
			<TR>
				<TD><label for="zipcode">Zipcode</label></TD>
				<TD><input type="text" name="zipcode" pattern="[0-9]+" title="Only Numbers" maxlength="5" required></TD>
			</TR>
			<TR>
				<TD><label for="country">Country</label></TD>
				<TD><input type="text" name="country" maxlength="20" required></TD>
			</TR>
			<TR>
				<TD><input type = "submit" value = "Submit"></TD>
				<TD><label><c:if test="${not empty error}">${error}</c:if></label><TD>
			</TR>
		</form>
</table>
</body>
</html>