<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="cit285.project.domain.User, java.util.*"%>
<jsp:useBean id = "user" scope = "request"
 class = "cit285.project.domain.User"> </jsp:useBean>
<!DOCTYPE html>
<html lang="en">
<head>
<title>List of users</title>
</head>
<body>
		<form action="backToBooklist" method="post">
		<input type="hidden" name="source" value="userlist">
		<div id="button">
			<button type="submit" class="btn btn-primary btn-block">Back To Book List</button>
		</div>
	</form>
	<form action="logout" method="post">
		<input type="hidden" name="source" value="userlist">
		<div id="button">
			<button type="submit" class="btn btn-primary btn-block">Logout</button>
		</div>
	</form>
	<hr />

	<!-- Display Users -->
	<TABLE>
	
	<% ArrayList<User> userlist = (ArrayList<User>) session.getAttribute("users"); %>
		<% for (int i = 0; i < userlist.size(); i++) { %>
		<TR>
			
			<TD> (<%= userlist.get(i).getUserid() %>) </TD>
			<TD> (<%= userlist.get(i).getFirstName() + " " + userlist.get(i).getLastName()  %>) </TD>
			<TD> (<%= userlist.get(i).getCompanyName() %>) </TD>
			<TD>  
				<form action="removeUser" method="post">
					<input type="hidden" name="source" value="userlist">
					<input type="hidden" name="user" value=<%= i %>>
					<div id="button">
						<button type="submit" class="btn btn-primary btn-block">Remove User</button>
					</div>
				</form>
			</TD>
			<TD>  
			
		</TR>
		<% } %>
	</TABLE>
</body>
</html>