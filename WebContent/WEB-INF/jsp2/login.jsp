<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Login</title>
<link rel="stylesheet" href="WEB-INF/css/welcome.css">
</head>
<body>
	This is login.jsp
	<form action="login" method="post">
		<input type="hidden" name="source" value="login">
		<input type="text" name="username">
		<input type="password" name="password">
		<div id="button">
			<button type="submit" class="btn btn-primary btn-block">Login</button>
		</div>
	</form>
	<form action="redirect" method="post">
		<input type="hidden" name="source" value="SignUp">
		<div id="button">
			<button type="submit" class="btn btn-primary btn-block">Sign Up</button>
		</div>
	</form>
	<%= session.getAttribute("username") %>
</body>
</html>