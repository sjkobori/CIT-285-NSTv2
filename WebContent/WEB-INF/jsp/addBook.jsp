<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="cit285.project.domain.*, java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<title>Add Book</title>
<link rel="stylesheet" href="web/css/default.css">
</head>
<body>
<form action="redirect" method="post">
		<input type="hidden" name="source" value="addBook">
		<div id="button">
			<button type="submit" class="btn btn-primary btn-block">Return to Home</button>
		</div>
	</form>
	<hr>
<b> Add a Book </b>
<form action="addbook" method="post" id="addform">
			<input type="hidden" name="source" value="addBook">
           <TABLE>
                      <TR>
                      	<TD>Title:</TD>
                      	<TD> <input type="text" name="title"> </TD>
                      </TR>
                      <TR>
                      	<TD>ISBN:</TD>
                      	<TD> <input type="text" name="isbn"> </TD>                 	
                      </TR>
                      <TR>
                      	<TD>Author:</TD>
                      	<TD> <select name="authorindex" form="addform">
                      	<% ArrayList<Author> authorlist = (ArrayList<Author>) session.getAttribute("authors"); %>
							<% for (int i = 0; i < authorlist.size(); i++) { %>
							
							<option value="<%= i %>"><%=authorlist.get(i).toString()%></option>
							<!--<c:forEach items="${authors}" var="author">-->
                      			<!--<option value="${author.getAuthorid()}">${author.toString()}</option>-->
							<!--</c:forEach>-->
							<% } %>
							</select>
			 			</TD>
                      <TR>
                      	<TD>Year:</TD>
                      	<TD> <input type="text" name="year"> </TD>
                      </TR>
                      <TR>
                      	<TD>Edition:</TD>
                      	<TD> <input type="text" name="edition"> </TD>
                      </TR>
                      <TR>
                      	<TD>Editor:</TD>
                      	<TD> <input type="text" name="editor""> </TD>
                      </TR>
                      <TR>
                      	<TD>Price:</TD>
                      	<TD> <input type="text" name="price"> </TD>
                      </TR>
                      <TR>
                      	<TD>Description:</TD>
                      	<TD> <input type="text" name="description"> </TD>
                      </TR>
                      <TR>
                      	<TD>Imagepath:</TD>
                      	<TD> <input type="text" name="imagepath"> </TD>
                      </TR>
           </TABLE>
           
			<div id="button">
				<button type="submit" class="btn btn-primary btn-block">Add Book</button>
			</div>
			</form>

		<!--  <form action ="addAuthor" method="post">
		<div>
			<input type="hidden" name="source" value="addAuthor">
			<label for="Author First Name">Author First Name</label>
			<input type="text" name="authorfirstname">
			<label for="Author Last Name">Author Last Name</label>
			<input type="text" name="authorlastname">
			<input type = "submit" value = "Submit" />
			</div>
		</form> -->
</body>
</html>