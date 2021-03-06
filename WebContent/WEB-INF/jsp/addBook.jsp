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
                      	<TD> <input type="text" name="title" required pattern=".{1,100}" title="Length must be between 1-100 characters."> </TD>
                      </TR>
                      <TR>
                      	<TD>ISBN:</TD>
                      	<TD> <input type="text" name="isbn" required pattern="[0-9].{12}" maxLength="13" title="Required length: 13 <br/> Valid Input: Numbers between 0-9"> </TD>                 	
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
                      	<TD> <input type="text" name="year" required pattern="[0-9].{,4}" maxLength ="4" title="Maximum length: 4 Valid Input: Numbers between 0-9"> </TD>
                      </TR>
                      <TR>
                      	<TD>Edition:</TD>
                      	<TD> <input type="text" name="edition" maxlength="20" required> </TD>
                      </TR>
                      <TR>
                      	<TD>Editor:</TD>
                      	<TD> <input type="text" name="editor" maxlength="50" required> </TD>
                      </TR>
                      <TR>
                      	<TD>Price:</TD>
                      	<TD> <input type="text" name="price" pattern="[0-9]+(\.[0-9][0-9]?)?" title="Must be a currency format ex: 10.00" maxlength="18" required> </TD>
                      </TR>
                      <TR>
                      	<TD>Description:</TD>
                      	<TD> <input type="text" name="description" maxlength="100"> </TD>
                      </TR>
                      <TR>
                      	<TD>Imagepath:</TD>
                      	<TD> <input type="text" name="imagepath" maxlength="50"> </TD>
                      </TR>
           </TABLE>
           
			<div id="button">
				<button type="submit" class="btn btn-primary btn-block">Add Book</button>
			</div>
			<label><c:if test="${not empty error}">${error}</c:if></label>
			<label><c:if test="${not empty confirmation}">${confirmation}</c:if></label>
			</form>

</body>
</html>