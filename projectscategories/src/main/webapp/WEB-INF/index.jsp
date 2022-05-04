<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<rapid:override name="header">  
    Projects and Categories
</rapid:override> 
 
<rapid:override name="nav">  
    <a href="/">
        Home
    </a>
    <a href="/new">
        New
    </a>
</rapid:override>  

<rapid:override name="main"> 
    <div>
        <h2>
            Projects and Categories Objectives:
        </h2>
        <ul>
            <li>
	            - Implement a many-to-many relationship.
            </li>
            <li>
                - JPA methods applied to n:m relationships.
            </li>
            <li>
                - Establish many-to-many relationships between models.
            </li>
            <li>
                - Create an instance of a many-to-many relationship.
            </li>
            <li>
                - Read an instance with associated relationship data.
            </li>
        </ul>
        <img src="https://media3.giphy.com/media/26tn33aiTi1jkl6H6/200.gif">
    </div> 
    <div>
        <h2>
            Projects
        </h2>
        <table>
            <tr>
                <th>
                    Name
                </th>
                <th>
                    Description
                </th>
                <th>

                </th>
            </tr>
            <c:forEach var="i" items="${p}">
            <tr>
                <td>
                    ${i.name}
                </td>
                <td>
                    <c:forTokens var="t" items="${i.description}" delims=",">
                        - ${t}
                        <br>
                    </c:forTokens>
                </td>
                <td>
                    <a href="/project/${i.id}">
                        View ${i.id}
                    </a>
                </td>
            </tr>
            </c:forEach>
            </table>
    </div>


    <div>
        <h2>
            Categories
        </h2>
        <table>
            <tr>
                <th>
                    Name
                </th>
                <th>
                    Date
                </th>
                <th>

                </th>
            </tr>
            <c:forEach var="i" items="${c}">
            <tr>
                <td>
                    ${i.name}
                </td>
                <td>
                    ${i.getTimePassed()}
                </td>
                <td>
                    <a href="/category/${i.id}">
                        View
                    </a>
                </td>
            </tr>
            </c:forEach>
        </table>
    </div>
</rapid:override>  

<%@ include file="base.jsp"%>
