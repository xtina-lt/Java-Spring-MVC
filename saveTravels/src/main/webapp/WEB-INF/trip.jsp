
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>XTINA.CODES</title>
<link rel="stylesheet" type="text/css" href="/css/style.css?version=5">
<link href="https://fonts.googleapis.com/css2?family=Barlow+Condensed&family=Lobster&display=swap" rel="stylesheet">

</head>

<body>
	<header>
	    ${output.getName()}
	</header>
	
	<nav>
		<a href="/">
			Home
		</a>
		<a href="/trips">
			Trips
		</a>
	</nav>
	
	<main>
		<div>
			<img src="${output.img}">
			<table>
				<tr>
					<th>
						ID
					</th>
					<th>
						Name
					</th>
					<th>
						Amount
					</th>
					<th>
						Created At
					</th>
					<th>
						Updated At
					</th>
					<th>
						Delete
					</th>
				</tr>
					<tr>
					<td>
						${output.id}
					</td>
					<td>
						${output.name}
					</td>
					<td>
					<fmt:formatNumber type="number" minFractionDigits="2" value="${output.amount} "/>
					</td>
					<td>
						<fmt:formatDate type="both" dateStyle="long" timeStyle="long" value="${ output.createdAt }"/>
					</td>
					<td>
						<fmt:formatDate type="both" dateStyle="long" timeStyle="long" value="${ output.updatedAt }"/>
					</td>
					<td>
						<a href="/trip/${output.id}/delete">Delete</a>
					</td>
				</tr>
			</table>
		</div>
		<div>
			<h1>
				Update Trip
			</h1>
			<!-- FORM -->
			<form:form action="/trip/update" method="POST" modelAttribute="output">
				<input type="hidden" name="_method" value="put">
				<!-- id -->
				<form:input type="hidden" path="id"/>
				<!-- name -->
				<form:label path="name">
					Name:
				</form:label>
				<br>
				<form:errors path="name"/>
				<form:input path="name"/>
				<!-- amount -->
				<form:label path="amount">
					Amount:
				</form:label>
				<br>
				<form:errors path="amount"/>
				<form:input type="number" path="amount" step="0.01"/>
				<!-- img -->
				<form:label path="img">
					Image Url:
				</form:label>
				<br>
				<form:errors path="img"/>
				<form:input path="img"/>
				<!-- submit -->
				<input type="submit" value="Change it up!">
			</form:form>
		</div>
	</main>
</body>

</html>
