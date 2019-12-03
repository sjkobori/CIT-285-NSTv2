<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="cit285.project.domain.Book, java.util.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>List of books</title>
</head>
<body>
	This is the cart.jsp
	<form action="booklist" method="post">
		<input type="hidden" name="source" value="cart">
		<div id="button">
			<button type="submit" class="btn btn-primary btn-block">Continue Shopping</button>
		</div>
	</form>
</body>
</html>