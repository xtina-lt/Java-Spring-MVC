<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<%@ page isErrorPage="true"%>

<rapid:override name="header">  
    Add to your book shelf.
</rapid:override>

<rapid:override name="nav">  
	<a href="/">
		Home
	</a>
	<a href="/logout">
		Logout
	</a>
	<a href="/bookshelf">
		Bookshelf
	</a>
</rapid:override>  

<rapid:override name="main">  
	<div>
		<h2>
			Create a Book
		</h2>
		<br>
		<br>
		<img src="https://images.gr-assets.com/hostedimages/1394565585ra/8872184.gif">
	</div>
	<div>
		<form:form action="/book/new/process" method="POST" modelAttribute="b">
			<!-- id -->
			<!-- title -->
			<form:label path="title">
				Title:
			</form:label>
			<br>
			<form:errors path="title"/>
			<form:input path="title"/>
			<!-- description -->
			<form:label path="description">
				Description: 
			</form:label>
			<br>
			<form:errors path="description"/>
			<form:textarea path="description"/>
			<!-- img -->
			<form:label path="img">
				Image Url:
			</form:label>
			<br>
			<form:errors path="img"/>
			<form:textarea path="img"/>
			<!-- author id -->
			<form:label path="author">
					Author
			</form:label>
			<form:errors path="author"/>
			<form:select path="author">
				<c:forEach var="i" items="${a}">
					<form:option value="${i.id }" path="author">
						${ i.last }, ${ i.first }
					</form:option>
				</c:forEach>
			</form:select>
			<!-- user id -->
			<form:errors path="user"/>
			<form:hidden value="${u}" path="user"/>
			<!-- submit -->
			<input type="submit" value="Add to bookshelf!">
		</form:form>
	</div>
</rapid:override>  

<%@ include file="../base.jsp"%>

