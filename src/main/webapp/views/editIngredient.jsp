<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<jsp:include page="header.jsp" />
<c:url value="/ingredient/save.html" var="saveUrl" />
</head>
<body>
	<div class="ingredient-details container">
		<h1>
			<span class="menu">Edit Ingredient :</span>
		</h1>
		<form:form modelAttribute="ingredient" action="${saveUrl}">
			<form:hidden path="id" />
			<div class="form-group">
				<form:label path="name">Name :</form:label>
				<form:input path="name" class="form-control" />
				<form:errors element="div" path="name"
					cssClass="alert alert-danger fade in" />
			</div>
			<div class="form-group">
				<form:label path="state">State :</form:label>
				<form:input path="state" type="number" step="0.01"
					class="form-control" />
				<form:errors element="div" path="state"
					cssClass="alert alert-danger fade in" />
				<button class="btn btn-chimene">Submit</button>
			</div>
		</form:form>
	</div>
	<div style="buttom: 0; padding: 20px; font-size: 18px;">
		<a href="<c:url value='/'/>" class="btn btn-chimene">Go back</a>
	</div>
	<script type="text/javascript">
		$('#ingredientTable').DataTable();
	</script>

</body>
</html>