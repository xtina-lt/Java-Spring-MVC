
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<%@ page isErrorPage="true"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>XTINA.CODES</title>
<link rel="stylesheet" type="text/css" href="/css/style.css?version=51">
<link href="https://fonts.googleapis.com/css2?family=Barlow+Condensed&family=Lobster&display=swap" rel="stylesheet">

</head>

<body>
	<header>
	    All Trips
	</header>
	
	<nav>
		<a href="/">
			Home
		</a>
	</nav>
	
	<main>
		<div>
			<img src="https://i.pinimg.com/originals/16/d9/19/16d919ee1bc706024179c70b432b2ccd.gif">
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
				</tr>
				<c:forEach var="i" items="${ output }">
					<tr>
						<td>
							${ i.getId() }
						</td>
						<td>
							<a href="/trip/${i.id}">
							${i.getName()}
							</a>
						</td>
						<td>
							<fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${i.amount} "/>
						</td>
						<td>
							<fmt:formatDate type="both" dateStyle="long" timeStyle="long" value="${ i.createdAt }"/>
						</td>
						<td>
							<fmt:formatDate type="both" dateStyle="long" timeStyle="long" value="${ i.updatedAt }"/>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div>
			<h1>
				Create New Trip
			</h1>
			<!-- FORM -->
			<form:form action="/trip/create" method="POST" modelAttribute="input">
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
