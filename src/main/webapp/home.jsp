<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div id="header" style="display: flex; padding: 20px;">
		<div style="display: flex; width: 50%;">
			<h1>Coding Mentor Library</h1>
		</div>
		<div style="width: 50%; text-align: right; display: table;">
			<c:if test="${empty sessionScope.me}">
				<a href="LoginServlet">Login</a>
			</c:if>

			<c:if test="${not empty sessionScope.me}">
				<h3>Hello ${sessionScope.me.firstName}</h3>
				<a href="LoginServlet?command=logout">Logout</a>
			</c:if>


		</div>
	</div>
	<hr>
	<div id="body">
		<c:forEach	items="${categories}" var="category">
			<a href="HomeServlet?categoryId=${category.id}">${category.name}</a> <br/>
		</c:forEach>
		
		<hr>
		
		<c:forEach	items="${books}" var="book">
			${book.name} : ${book.description} <br/>
		</c:forEach>
		
	</div>
</body>
</html>