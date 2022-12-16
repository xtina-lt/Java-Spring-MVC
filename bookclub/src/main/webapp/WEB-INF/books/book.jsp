<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<%@ page isErrorPage="true"%>

<rapid:override name="header">  
    ${output.title}
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
			Book
		</h2>
		<br>
		Each book is the <span class="accent">many</span> in two <span class="accent">One To Many</span> relationships.
		<br>
		It is connected to both <i>author</i> and <i>book</i> tables.
		<br>
		This is <span class="id">joined</span> by the <span class="id">foreign keys</span> <i>author_id</i> and <i>user_id</i>.
	</div>
	<div>
		<img src="${ output.img }">
		<br>
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
				<c:if test="${output.user.id == loggedUser.id}">
					<th>
						Options
					</th>
				</c:if>
			</tr>
			<tr>
				<td>
					${output.id}
				</td>
				<td>
					${ output.title }
				</td>
				<td>
					${ output.author.last }, ${ output.author.first }
				</td>
				<td>
					<c:if test="${output.user.id == loggedUser.id}">
					    You
					</c:if>
					<c:if test="${output.user.id != loggedUser.id}">
					    ${output.user.last}, ${output.user.first}
					</c:if>
				</td>
				<c:if test="${output.user.id == loggedUser.id}">
					<td>
						<a href="/book/${output.id}/edit">
							Edit
						</a>
						<form:form action="/book/${output.id}/delete" method="delete">
							<input type="submit" value="Delete">
						</form:form>
					</td>
				</c:if>
			</tr>
		</table>
	</div>
</rapid:override>  

<%@ include file="../base.jsp"%>

