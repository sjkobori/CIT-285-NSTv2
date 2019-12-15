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
	<h2>Welcome to NST Bookstore! </h2>
	<h3>Login </h3>
	<form action="login" method="post">
		<input type="hidden" name="source" value="login">
		<label  id="usernamelb" for="username">Username:</label>
		<!-- checks if username is not null -->
		<input type="text" name="username" value=<c:if test="${not empty username}">${username}</c:if>>
		<label  id="passwordlb" for="password">Password:</label>
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
	<label><c:if test="${not empty error}">${error}</c:if></label>
	
</body>
</html>