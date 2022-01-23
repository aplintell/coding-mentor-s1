<div id="categories">
	<c:forEach items="${param.categories}" var="category">
		<a href="HomeServlet?categoryId=${category.id}">${category.name}</a>
		<br />
	</c:forEach>
</div>

