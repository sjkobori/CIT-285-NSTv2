<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<title>Welcome</title>
		<link rel="stylesheet" href="WEB-INF/css/welcome.css">
	</head>
	<body>
	Current time is <%= new java.util.Date() %>
		<form action="signUp" method="post">
			<input type="text" name="firstname">
			<input type="text" name="lastname">
			<input type="text" name="companyname">
			<input type = "submit" value = "Submit" />
		</form>
		<hr />
		<!-- Display Students -->
		<div id="studentslist" class="studentslist_format">
			<c:forEach items="${students}" var="student">
				<br />
 				${student}
			</c:forEach>
		</div>
	</body>
</html>