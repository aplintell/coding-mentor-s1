<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:forEach items="${categories}" var="category">
	<a href="HomeServlet?categoryId=${category.id}">${category.name}</a>
	<br />
</c:forEach>