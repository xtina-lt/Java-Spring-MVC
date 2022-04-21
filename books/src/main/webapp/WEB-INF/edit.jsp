
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
	    Edit ${output.title}
	</header>
	
	<nav>
		<a href="/">
			Home
		</a>
		<a href="/books">
			Books
		</a>
		<a href="/book/new">
			New Book
		</a>
	</nav>
	
	<main>
		<div>
		<form action="/update" method="post">
		<input type="hidden" name="id" value="${output.id}">
		<label for="title">
			Title:
		</label>
		<input type="text" name="title" value="${output.title}"required>
		<label for="pages">
			Pages:
		</label>
		<input type="number" name="pages" value="${output.pages}"required>
		<input type="submit" value="create">
		</form>
		</div>
	</main>
</body>

</html>
