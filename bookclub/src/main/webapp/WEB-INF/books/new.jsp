<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<%@ page isErrorPage="true"%>

<rapid:override name="header">  
    Add to your Book Shelf.
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
		The <i>Books</i> table is connected to the <i>Authors</i> table.
		<br>
		It is the <i>Many</i> in the <span class="accent">One-to-Many</span> Relationship.
		<br>
		The <span class="accent">foreign key</span> is <b>author_id</b> and is located in the <i>Books</i> table.
		<br>
		<img src="https://images.gr-assets.com/hostedimages/1394565585ra/8872184.gif">
	</div>
	<div>
		<h2>
			New Book
		</h2>
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
				<c:forEach var="i" items="${as}">
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
	<div>
		<h2>
			New Author
		</h2>
		<form:form action="/authors/create" method="POST" modelAttribute="a">
			<!-- first -->
			<form:label path="first">
				First:
			</form:label>
			<br>
			<form:errors path="first"/>
			<form:input path="first"/>
			<!-- last -->
			<form:label path="last">
				Last: 
			</form:label>
			<br>
			<form:errors path="last"/>
			<form:input path="last"/>
			<!-- submit -->
			<input type="submit" value="Add Author">
		</form:form>
	</div> 
</rapid:override>  

<%@ include file="../base.jsp"%>

