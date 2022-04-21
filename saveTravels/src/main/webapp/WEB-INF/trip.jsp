
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isErrorPage="true"%>

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
			<img src="${output.getImg()}">
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
						${output.getId()}
					</td>
					<td>
						${output.getName()}
					</td>
					<td>
					<fmt:formatNumber type="number" minFractionDigits="2" value="${output.getAmount()} "/>
					</td>
					<td>
						<fmt:formatDate type="both" dateStyle="long" timeStyle="long" value="${ output.getCreatedAt() }"/>
					</td>
					<td>
						<fmt:formatDate type="both" dateStyle="long" timeStyle="long" value="${ output.getUpdatedAt() }"/>
					</td>
					<td>
						<a href="/trip/${output.getId()}/delete">Delete</a>
					</td>
				</tr>
			</table>
		</div>
		<div>
			<h1>
				Update Trip
			</h1>
			<!-- FORM -->
			<form action="/trip/update" method="POST">
			<!-- id -->
			<input type="hidden" name="id" value="${output.getId()}">
			<!-- name -->
			<label for="name">
				Name:
			</label>
			<input type="text" name="name" value="${output.getName()}" required>
			<!-- amount -->
			<label for="amount">
				Amount:
			</label>
			<input type="number" name="amount" value="${output.getAmount()}" step="0.01" required>
			<!-- img -->
			<label for="img">
				Image Url:
			</label>
			<input type="text" name="img" value="${output.getImg()}" required>
			<!-- submit -->
			<input type="submit" value="Change it up!">
			</form>
		</div>
	</main>
</body>

</html>
