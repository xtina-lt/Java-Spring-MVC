<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<%@ page isErrorPage="true"%>

<rapid:override name="header">  
    Hello ${loggedName}, here are some baby names.
</rapid:override> 
 
<rapid:override name="main"> 
    <div>
        <table>
            <tr>
            	<th>
            		Vote TO DO
            	</th>
                <th>
                    Name
                </th>
                <th>
                    Gender
                </th>
                <th>
                	Origin
                </th>
                <th>
                   Votes
                </th>
            </tr>
            <c:forEach var="i" items="${output}">
                <tr>
                	<td>
               	        <c:set var="foundYa" value="false" />
						<c:forEach var="j" items="${i.likes}">
						  <c:if test="${j.id eq loggedId}">
						    <c:set var="foundYa" value="true" />
						  </c:if>
						</c:forEach>
						
						<c:if test="${foundYa}">
						    Voted
						 </c:if>
						 <c:if test="${!foundYa}">
						   	<a href="/vote/${i.id}">
                				UpVote
                			</a>
						 </c:if>
                	</td>
                    <td>
                        <a href="/name/${i.id}/">
                            ${i.name}
                        </a>
                    </td>
                    <td>
                        ${i.gender}
                    </td>
                    <td>
                        Origin: 
                        ${i.origin}
                    </td>
                    <td>
                    	${i.likes.size()}
                    </td>
                </tr>
            </c:forEach>
        </table>

        <br>
        <a href="/create">
            <span class="accent">
                Add Name
            </span>
        </a>
    </div>
</rapid:override>  

<%@ include file="base.jsp"%> 
