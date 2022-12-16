<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<%@ page isErrorPage="true"%>

<rapid:override name="header">  
    Project
</rapid:override> 
 
<rapid:override name="main"> 
    <div>
        <img src="https://i.pinimg.com/originals/b3/c1/27/b3c127737b721824d41103b639948d35.gif">
        <h2>
            Projects
        </h2>
        The <b>Projects</b> table is part of a <span class="accent">Many-To-Many</span> relationship.
        <br>
        It's relationship is with the <i>Categories</i> table.
        <br>
        The table that <i>connects</i> <b>Projects</b> and <b>Categories</b> is <b>projects_categories</b>.
        <br>
        <br>
        <form:form action="/project/${output.id}/delete" method="delete">
            <input type="submit" value="Delete ${output.name} Project">
        </form:form>
    </div>
    <div>
        <h2>
            Name
        </h2>
            ${output.name}
        <br>
        <br>
        <h2>
            About Me:
        </h2>
        <!-- Description -->
        <c:forTokens var="i" items="${output.description}" delims=",">
            - ${i}
            <br>
        </c:forTokens>
        <br>
        <h2>
            My Categories:
        </h2>
        <!-- categories belong -->
        <c:forEach var="i" items="${output.categories}">
            - ${i.name}   
            <form:form class="small" action="/project/${output.id}/cat/delete" method="delete">
                <input type="hidden" name="cid" value="${i.id}">
                <input type="submit" class="small" value="Remove">
            </form:form>
            <br>
        </c:forEach>  
    </div>
    <div>
        <!-- add a category -->
        <form action="/project/${id}/add" method="post">
            <label for="cid">
                <span class="accent">
                    Add Category:
                </span>
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
        <h2>
            Change Me
        </h2>
        <!-- update project -->
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
            <form:textarea rows="5" cols="30" path="description"/>
            <!-- submit -->
            <input type="submit" value="Update Product">
        </form:form>
    </div>
</rapid:override>  

<%@ include file="base.jsp"%>
