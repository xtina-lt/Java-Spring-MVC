<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>XTINA.CODES</title>
<link rel="stylesheet" type="text/css" href="/css/style.css?value=10">
<link href="https://fonts.googleapis.com/css2?family=Barlow+Condensed&family=Lobster&display=swap" rel="stylesheet">
</head>
<body>

<header>
    <rapid:block name="header"> 
    </rapid:block>
</header>

<nav>
    <rapid:block name="nav"> 
        <a href="/dash">
            Dash
        </a>

        <c:if test="${loggedId != null}">
            <a href="/logout">
                Logout
            </a>
        </c:if>
    </rapid:block>
</nav>

<main>
    <rapid:block name="main"> 
    base_main_content
    </rapid:block>
</main>

</body>
</html>
