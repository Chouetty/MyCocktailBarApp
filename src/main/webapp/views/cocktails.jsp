<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="header.jsp" />
<c:url value="/cocktails/delete" var="deleteUrl" />
<body>
	<div class="container">
		<h1><span class="menu">Cocktail List :</span></h1>
		<table id="cocktailsTable" class="table table-hover table-striped">
			<thead>
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Price</th>
					<th>With Alcohol</th>
					<th>Delete</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${cocktails}" var="cocktail">
					<tr>
						<td>${cocktail.id}</td>
						<td>${cocktail.name}</td>
						<td>${cocktail.price} €</td>
						<td>${cocktail.withAlcohol}</td>
						<td><a href="${deleteUrl}/${cocktail.id}.html">Delete</a></td>
					</tr>
						
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div
		style="buttom: 0; padding: 20px; font-size: 18px;">
		<a href="<c:url value='/'/>" class="btn btn-chimene">Go back</a>
	</div>
	<script type="text/javascript">
		var table = $('#cocktailsTable').DataTable({
			pageLength : 5,
			lengthMenu : [ 5, 10, 15 ],
			colReorder : true
		});
		
		$('#cocktailsTable tbody').on('click', 'tr',function() {
			var data = table.row(this).data();
			document.location = 'cocktail/edit/' + data[0] + '.html';
		});
	</script>
</body>
</html>