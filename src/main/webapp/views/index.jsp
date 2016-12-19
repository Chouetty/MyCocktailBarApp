<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="header.jsp" />
</head>
<body>
	<h1 class="body"><center>Welcome on the CocktailBar Application</center></h1>
	<div class="container">
		<span class="menu">Choose Menu :</span>
		<ul>
			<c:forEach items="${menus}" var="menu">
				<div class="row">
					<c:url value="${menu.url}.html" var="menuUrl" />
					<li><a class="btn btn-chimene" href="${menuUrl}">${menu.title}</a></li>
				</div>
			</c:forEach>
		</ul>
	</div>
</body>
</html>