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
            Name:
        </h2>
        <table>
            <tr>
                <th>
                    Posted by:
                </th>
                <th>
	                <c:if test="${output.user.id == loggedId}">
			            You :)
		        	</c:if>
		        	<c:if test="${output.user.id != loggedId}">
			            ${output.user.name}
		        	</c:if>
                </th>
            </tr>
            <tr>
                <td>
                    Gender
                </td>
                <td>
                    ${output.gender}
                </td>
            </tr>
            <tr>
                <td>
                    Origin:
                </td>
                <td>
                    ${output.origin}
                </td>
            </tr>
            <tr>
                <td>
                    Meaning:
                </td>
                <td>
                    ${output.meaning}
                </td>
            </tr>
        </table>
        <!-- if liked -->
        <c:set var="foundYa" value="false" />
		<c:forEach var="i" items="${output.likes}">
		  <c:if test="${i.id eq loggedId}">
		    <c:set var="foundYa" value="true" />
		  </c:if>
		</c:forEach>
		<c:if test="${foundYa}">
		    <span class="accent">
		    	You liked this!
		    </span>
		 </c:if>
		 <c:if test="${!foundYa}">
		   	<a href="/vote/${i.id}">
            				UpVote
            	</a>
		 </c:if>
		 <br>
		 <br>
		<!-- edit -->
        <c:if test="${output.user.id == loggedId}">
            <a href="/name/${id}/change">
                Edit
            </a>
        </c:if>
    </div>

</rapid:override>  

<%@ include file="base.jsp"%> 
