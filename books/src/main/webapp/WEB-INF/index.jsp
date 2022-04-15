
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
		<a href="/books">Books</a>
	</nav>
	
	<main>
		<div>
		<span class="large">
			<c:out value="${greet}"/>
		</span>
		<br>
		<br>
		<img src="https://acegif.com/wp-content/gifs/book-94.gif">
		</div>
	</main>
</body>

</html>
