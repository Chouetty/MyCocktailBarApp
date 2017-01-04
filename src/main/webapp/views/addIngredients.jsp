<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="header.jsp" />
<body>
<div class="container">
	<c:url value="/ingredients/add.html" var="addUrl" />
	<h1><span class="menu">Add ingredient</span></h1>
	<form action="${addUrl}" method="POST">
		<div class="form-group">
			<label for="name">Name :</label> <input id="name" name="name"
				class="form-control" />
		</div>
		<div class="form-group">
			<label for="state">State :</label> <input type="number" min="0"
				max="2" id="state" name="state" class="form-control" />
		<button class="btn btn-chimene">Submit</button>
		</div>
	</form>
	</div>
	<div
		style="position: fixed; buttom: 0; padding: 20px; font-size: 18px;">
		<a href="<c:url value='/'/>" class="btn btn-chimene">Go back</a>
</body>
</html>