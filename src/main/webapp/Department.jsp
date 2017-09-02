<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
/* Set height of the grid so .sidenav can be 100% (adjust as needed) */
.row.content {
	height: 550px
}

/* Set gray background color and 100% height */
.sidenav {
	background-color: #f1f1f1;
	height: 100%;
}

/* On small screens, set height to 'auto' for the grid */
@media screen and (max-width: 767px) {
	.row.content {
		height: auto;
	}
}
</style>
</head>
<body>


	<c:choose>
		<c:when test="${not empty requestScope.deptObject}">
			<p>Department Id : ${requestScope.deptObject.id}</p>
			<p>Department Name : ${requestScope.deptObject.name}</p>

			<a
				href='<%=request.getContextPath()%>/department?deptNo=${requestScope.deptObject.id}'>
				Click here to view Employees</a>
		</c:when>
		<c:otherwise>
			<!--               No Department Exists with that ID -->
		</c:otherwise>
	</c:choose>



	<nav class="navbar navbar-inverse visible-xs">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Logo</a>
			</div>
		</div>
	</nav>

	<div class="container-fluid">
		<div class="row content">
			<div class="col-sm-3 sidenav hidden-xs">
				<h2>Logo</h2>
				<ul class="nav nav-pills nav-stacked">
					<li><a id="add" href="#add">Department Details</a></li>
				</ul>
				<br>
			</div>
			<br>
			<div id="msg">
				<br> <br>
				<c:if test="${not empty requestScope.msg}">${requestScope.msg}</c:if>
			</div>

			<div class="col-sm-4">
				<form id="addAction" action="/IMCSWebApp/department" method="post"
					style="display: none">
					Department Number: <input type="number" name="deptNo"> <br>
					<br> <input type="submit" value="submit"><br>
					<br>
				</form>
			</div>
		</div>
	</div>
	<script>
		$(document).ready(function() {
			$("#add").click(function() {
				$("#addAction").show();
				$("#updateAction").hide();
				$("#searchAction").hide();
				$("#deleteAction").hide();
				$("#msg").hide();

			});
		});
	</script>


</body>
</html>
