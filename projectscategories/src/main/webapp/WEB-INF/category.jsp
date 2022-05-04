<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<%@ page isErrorPage="true"%>

<rapid:override name="header">  
    ${output.name}
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
            My Projects:
        </h2>
        <c:forEach var="i" items="${output.projects}">
            - ${i.name}
            <br>
        </c:forEach>    
        <br>
        <form:form action="/category/${output.id}/delete" method="delete">
            <input type="submit" value="Delete">
        </form:form> 
    </div>
    <div>
        <h2>
            Add to Category
        </h2>
        <br>
        <form action="/category/${id}/add" method="post">
            <label for="pid">
                <h3>
                    Project:
                </h3>
            </label>				
            <select name="pid">
                <c:forEach var="i" items="${notin}">
                    <option value="${i.id}">
                        ${i.name}
                    </option>
                </c:forEach>
            </select>
            <input type="submit" value="Add"/>
        </form>
    </div>
    <div>
        <form:form action="/category/process" method="put" modelAttribute="c">
            <form:hidden path="id"/>
            <form:label path="name">
                Name:
            </form:label>
            <br>
            <form:errors path="name"/>
            <form:input path="name"/>
            <!-- submit -->
            <input type="submit" value="Update Category">
        </form:form>
    </div>
</rapid:override>  

<%@ include file="base.jsp"%>
