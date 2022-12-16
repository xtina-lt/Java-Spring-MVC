<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<%@ page isErrorPage="true"%>

<rapid:override name="header">  
    ${output.name}
</rapid:override> 
 
<rapid:override name="main"> 
    <div>
        <h2>
            Show:
        </h2>
        <table>
            <tr>
                <th>
                    Posted by:
                </th>
                <th>
                    ${output.user.name}
                </th>
            </tr>
            <tr>
                <td>
                    Network
                </td>
                <td>
                    ${output.network}
                </td>
            </tr>
            <tr>
                <td>
                    Description:
                </td>
                <td>
                    ${output.description}
                </td>
            </tr>
        </table>
        <c:if test="${output.user.id == loggedId}">
            <a href="/show/${id}/change">
                Edit
            </a>
        </c:if>
    </div>

    <div>
        <h2>
            Ratings:
        </h2>
        <table>
            <tr>
                <th>
                    Name
                </th>
                <th>
                    Rating
                </th>
            </tr>
        </table>
        <c:forEach var="r" items="${output.ratings}">
            <tr>
                <td>
                    ${r.user.name}
                </td>
                <td>
                    ${r.num}
                </td>
            </tr>
        </c:forEach>
        <br>
        <br>

    	<!-- FORM -->
    	<form:form action="/rating/create" method="POST" modelAttribute="r">
    	<!-- user -->
		<form:hidden value="${loggedId}" path="user"/>
		<!-- name -->
    	<form:label path="num">
            <span class="accent">
                Leave a Rating:
            </span>
    	</form:label>
    	<br>
    	<form:errors path="num"/>
    	<form:input type="number" min="0" max="5" path="num"/>
    	<!-- submit -->
    	<input type="submit" value="Add">
    	</form:form>
    </div>
</rapid:override>  

<%@ include file="base.jsp"%> 
