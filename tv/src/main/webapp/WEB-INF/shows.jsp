<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<%@ page isErrorPage="true"%>

<rapid:override name="header">  
    Welcome ${loggedName}
</rapid:override> 
 
<rapid:override name="main"> 
    <div>
        <table>
            <tr>
                <th>
                    Show
                </th>
                <th>
                    Network
                </th>
                <th>
                    Rating
                </th>
            </tr>
            <c:forEach var="i" items="${output}">
                <tr>
                    <td>
                        <a href="/show/${i.id}/">
                            ${i.name}
                        </a>
                    </td>
                    <td>
                        ${i.network}
                    </td>
                    <td>
                        ${i.getAverage()}
                    </td>
                </tr>
            </c:forEach>
        </table>

        <br>
        <a href="/create">
            <span class="accent">
                Add Show
            </span>
        </a>
    </div>
</rapid:override>  

<%@ include file="base.jsp"%> 
