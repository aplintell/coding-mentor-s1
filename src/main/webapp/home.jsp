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
				<h3>
					Hello ${sessionScope.me.firstName} | <a
						href="CartServlet?action=VIEW">Cart(${sessionScope.cart.books.size()})</a>
				</h3>
				<a href="LoginServlet?command=logout">Logout</a>
			</c:if>


		</div>
	</div>
	<hr>
	<div id="body">
		<jsp:include page="categories.jsp"></jsp:include>
		<hr>

		<!--  Show BOOK LIST -->
		<c:if test="${not empty books && !showCart}">
			<c:forEach items="${books}" var="book">
				<a href="HomeServlet?bookId=${book.id}">${book.name}</a>
				<br />
			</c:forEach>
		</c:if>


		<!-- show BOOK DETAILS -->
		<c:if test="${not empty book}">
			<form method="get" action="CartServlet">
				<input hidden="true" name="bookId" value="${book.id}"> <input
					hidden="true" name="action" value="ADD">
				<h3>Title : Book DETAILS !!! ${book.name}</h3>
				<br /> Desciption: ${book.description} <br /> Stock :
				${book.stock}<br /> <input type="submit" value="Add To Cart">
			</form>
		</c:if>


		<!--  Show CART -->
		<c:if test="${showCart}">
			<c:forEach items="${sessionScope.cart.books}" var="book">
				<a href="HomeServlet?bookId=${book.id}">${book.name}</a>
				<br />
			</c:forEach>
			<c:if test="${empty sessionScope.cart.books}">
			Cart is empty</c:if>
			
			<a href="CartServlet?action=CHECKOUT">Checkout</a>
		</c:if>

	</div>
</body>
</html>