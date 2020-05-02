<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
<title>New Student</title>
</head>
<body>
	<div class="container container-fluid sp-3">
		<h1 style="display:inline-block; margin-right:10%;">New Student</h1>
		<a href="/index">Go back</a>
		<form:form action="/students/create" method="get"
			modelAttribute="student" style="width:40%">
			<p class="form-group">
				<form:label path="firstName">First Name</form:label>
				<form:input path="firstName" class="form-control" />
				<form:errors path="firstName" />
			</p>
			<p class="form-group">
				<form:label path="lastName">Last Name</form:label>
				<form:input path="lastName" class="form-control" />
				<form:errors path="lastName" />
			</p>
			<p class="form-group">
				<form:label path="age">Age</form:label>
				<form:input type="number" step="1" min="1" value="1" path="age" class="form-control" />
				<form:errors path="age" />
			</p>
			<input type="submit" value="Create" class="btn btn-outline-primary" />
		</form:form>
	</div>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
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