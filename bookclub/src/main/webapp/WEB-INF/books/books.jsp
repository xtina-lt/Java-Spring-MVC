<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<%@ page isErrorPage="true"%>

<rapid:override name="header">  
    Welcome ${loggedUser.first}!
</rapid:override>

<rapid:override name="nav">  
	<a href="/">
		Home
	</a>
	<a href="/logout">
		Logout
	</a>
	<a href="/book/new">
		New
	</a>
</rapid:override>  

<rapid:override name="main">  
	<div>
		<h2>
			Book Shelf
		</h2>
		<br>
		The bookshelf is a collection of books from the database table <i>book</i>.
		<br>
		It is the <span class="accent">many</span> in two <span class="accent">One To Many</span> relationships.
		<br>
		It is connected to both <i>author</i> and <i>book</i> tables.
		<br>
		<br>
		<img src="https://media2.giphy.com/media/3o7aCQI45LfvqhURIQ/giphy.gif">
	</div>
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
					Author Name
				</th>
				<th>
					Posted By
				</th>
			</tr>
			<c:forEach var="i" items="${output}">
			<tr>
				<td>
					${i.id}
				</td>
				<td>
					<a href="/book/${i.id}">
						${i.title}
					</a>
				</td>
				<td>
					${i.author.last}, ${i.author.first}
				</td>
				<td>
					<c:if test="${i.user.id == loggedUser.id}">
					    You
					</c:if>
					<c:if test="${i.user.id != loggedUser.id}">
					    ${i.user.last}, ${i.user.first}
					</c:if>
				</td>
			</tr>
			</c:forEach>
		</table>
	</div>
</rapid:override>  

<%@ include file="../base.jsp"%>

