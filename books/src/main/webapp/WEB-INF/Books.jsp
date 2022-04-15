
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>XTINA.CODES</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<link href="https://fonts.googleapis.com/css2?family=Barlow+Condensed&family=Lobster&display=swap" rel="stylesheet">

</head>

<body>
	<header>
	    Books
	</header>
	
	<nav>
		<a href="/">Home</a>
	</nav>
	
	<main>
		<div>
			<table>
				<tr>
					<th>
						ID
					</th>
					<th>
						Title
					</th>
					<th>
						Pages
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
							<a href="/book/${i.getId()}">
							${i.getTitle()}
							</a>
								
							
						</td>
						<td>
							${ i.getPages() }
						</td>
						<td>
							<fmt:formatDate type="both" dateStyle="long" timeStyle="long" value="${ i.getCreatedAt() }"/>
						</td>
						<td>
							<fmt:formatDate type="both" dateStyle="long" timeStyle="long" value="${ i.getUpdatedAt() }"/>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</main>
</body>

</html>
