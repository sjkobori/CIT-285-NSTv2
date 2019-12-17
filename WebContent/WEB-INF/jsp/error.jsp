<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Error</title>
<link rel="stylesheet" href="web/css/default.css">
</head>
<body>
	YOU HAVE REACHED THE ERROR PAGE, HOW DID THAT HAPPEN?!
	<form action="redirect" method="post">
		<input type="hidden" name="source" value="error">
		<div id="button">
			<button type="submit" class="btn btn-primary btn-block">Return to Login</button>
		</div>
	</form>
</body>
</html>