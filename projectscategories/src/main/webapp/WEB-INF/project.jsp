<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<%@ page isErrorPage="true"%>

<rapid:override name="header">  
    Project: ${output.name}
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
            About Me:
        </h2>
        <c:forTokens var="i" items="${output.description}" delims=",">
                        - ${i}
                        <br>
        </c:forTokens>
        <br>
        <form:form action="/project/${output.id}/delete" method="delete">
            <input type="submit" value="Delete">
        </form:form>
    </div>
    <div>
        <h2>
            My Categories:
        </h2>
        <c:forEach var="i" items="${output.categories}">
            - ${i.name}   
            <form:form class="small" action="/project/${output.id}/cat/delete" method="delete">
                <input type="hidden" name="cid" value="${i.id}">
                <input type="submit" class="small" value="Remove">
            </form:form>
            <br>
        </c:forEach>   
        <br>
        <form action="/project/${id}/add" method="post">
            <label for="cid">
                <h3>
                    Category:
                </h3>
            </label>				
            <select name="cid">
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
        <form:form action="/project/process" method="put" modelAttribute="p">
            <form:hidden path="id"/>
            <form:label path="name">
                Name:
            </form:label>
            <br>
            <form:errors path="name"/>
            <form:input path="name"/>
            <!-- description -->
            <form:label path="description">
                Description: 
            </form:label>
            <br>
            <form:errors path="description"/>
            <form:textarea path="description"/>
            <!-- submit -->
            <input type="submit" value="Update Product">
        </form:form>
    </div>
</rapid:override>  

<%@ include file="base.jsp"%>
