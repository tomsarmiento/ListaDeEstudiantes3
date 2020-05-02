<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<title>Dorm</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
	<div class="container container-fluid" style="margin-top: 20px;">
		<a href="/index">Go back</a>
		<h1 style="margin: 10px 0px 30px 0px;"><c:out value="${dorm.name}"/> Dormitory</h1>
		<form action="/dorms/${dorm.id}/add" method="get" class="form1" style="width:20%; margin-bottom:20px;">
			<p class="form-group">
			<select name="student" class="form-control">
				<c:forEach var="student" items="${students}">
					<option value="${student.id}" label="${student.firstName} ${student.lastName}"/>
				</c:forEach>
			</select>
			</p>
			<input type="submit" value="Add student" class="btn btn-outline-primary form-control"/>
		</form>
		<table class="table table-hover table-bordered">
			<tr>
				<th>Name</th>
				<th>Action</th>
			</tr>
			<c:forEach var="student" items="${dorm.students}">
				<tr>
					<td><c:out value="${student.firstName} ${student.lastName}"/></td>
					<td><form action="/dorms/${dorm.id}/remove" method="get"><input type="hidden" value="${student.id}" name="student"/><input type="submit" value="Remove" class="btn btn-link"/></form></td>
				</tr>
			</c:forEach>
			
		</table>
		
	</div>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
</body>
</html>