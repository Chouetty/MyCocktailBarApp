<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="header.jsp" />
<c:url value="/cocktail/save.html" var="saveUrl" />
</head>
<body>
		<div class="cocktail-details container">
			<h1>
				<span class="menu">Edit Cocktail :</span>
			</h1>
			<form:form modelAttribute="cocktail" action="${saveUrl}">
				<form:hidden path="id" />
				<div class="form-group">
					<form:label path="name">Name :</form:label>
					<form:input path="name" class="form-control" />
					<form:errors element="div" path="name" cssClass="alert alert-danger fade in" />
				</div>
				<div class="form-group">
					<form:label path="price">Price :</form:label>
					<form:input path="price" type="number" step="0.01"
						class="form-control" />
					<form:errors element="div" path="price"
						cssClass="alert alert-danger fade in" />
				</div>
				<div class="form-group">
					<form:label path="withAlcohol">With Alcohol :</form:label>
					<form:input path="withAlcohol" type="number" min="0" max="1"
						class="form-control" />
				</div>
				<button class="btn btn-chimene">Submit</button>
			</form:form>
		</div>
	<div class="cocktail-ingredients container">
	<h1><span class="menu">Edit Ingredient List :</span></h1>
	<form action="<c:url value='/cocktail/saveIngredients.html' />" method="POST">
		<table id="cocktailIngredientsTable">
			<thead>
				<tr>
					<th>Ingredients :</th>
					<th>Quantity :</th>
					<th />
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ingredientCocktails}" var="ingredientCocktail">
					<tr>
						<c:url value="/cocktail/removeIngredient.html" var="removeUrl">
							<c:param name="ingredientId"
								value="${ingredientCocktail.ingredient.id}" />
						</c:url>
						<tr>
						<td>${ingredientCocktail.ingredient.name}</td>
						<td><input name= "quantity_${ingredientCoktail.ingredient.id}" type="number" min="0" value="${ingredientCocktail.quantity}"/></td>
						<td><a href="${removeUrl}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<button class="btn btn-chimene">Submit</button>
		</form>
		<form action="<c:url value='/cocktail/addIngredient.html'/>">
		<select name="ingredientId">
		<c:forEach items="${ingredients}" var="ingredient">
		<option value="${ingredient.id}">${ingredient.name}</option>
		</c:forEach>
		</select>
		<button class="btn btn-chimene">Add</button>
		</form>
	</div>
	<div
		style="buttom: 0; padding: 20px; font-size: 18px;">
		<a href="<c:url value='/'/>" class="btn btn-chimene">Go back</a>
	</div>
	<script type="text/javascript">
	$('#cocktailIngredientsTable').DataTable();
	</script>

</body>
</html>