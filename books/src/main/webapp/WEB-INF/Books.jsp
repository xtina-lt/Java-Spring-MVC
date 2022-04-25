
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
	    All Books
	</header>
	
	<nav>
		<a href="/">
			Home
		</a>
		<a href="/book/new">
			New Book
		</a>
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
					<th>
						Options
					</th>
				</tr>
				<c:forEach var="i" items="${ output }">
					<tr>
						<td>
							${ i.id }
						</td>
						<td>
							<a href="/book/${i.id}">
							${i.title}
							</a>
								
							
						</td>
						<td>
							${ i.pages }
						</td>
						<td>
							<fmt:formatDate type="both" dateStyle="long" timeStyle="long" value="${ i.createdAt }"/>
						</td>
						<td>
							<fmt:formatDate type="both" dateStyle="long" timeStyle="long" value="${ i.updatedAt }"/>
						</td>
						<td>
							<a href="/book/${i.id}/update"> EDIT</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</main>
</body>

</html>
