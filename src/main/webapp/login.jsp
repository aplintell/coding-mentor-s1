<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Coding Mentor Login Page</title>
</head>
<body>
	<h1>Login Page</h1>
	<hr>
	<form action="LoginServlet" method="post">
		Username : <input type="text" name="username" /> <br> Password :
		<input type="password" name="password" /> <br> <input
			type="submit" value="Login" />
	</form>
</body>
</html>
