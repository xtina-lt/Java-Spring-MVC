<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<%@ page isErrorPage="true"%>

<rapid:override name="header">  
    Category
</rapid:override> 
 
<rapid:override name="main"> 
    <div>
        <div>
            <img src="https://cdn.dribbble.com/users/529932/screenshots/9694508/organize_21.01_-_gif_300.gif">
            <h2>
                Categories
            </h2>
            The <b>Categories</b> table is part of a <span class="accent">Many-To-Many</span> relationship.
            <br>
            It's relationship is with the <i>Projects</i> table.
            <br>
            The table that <i>connects</i> <b>Projects</b> and <b>Categories</b> is <b>projects_categories</b>.
            <br>
            <br>
            <form:form action="/category/${output.id}/delete" method="delete">
                <input type="submit" value="Delete">
            </form:form> 
        </div>
    </div>
    <div>
        <h2>
            Name
        </h2>
            ${output.name}
        <h2>
            My Projects:
        </h2>
        <c:forEach var="i" items="${output.projects}">
            - ${i.name}
            <br>
        </c:forEach>    
    </div>
    <div>
        <form action="/category/${id}/add" method="post">
            <label for="pid">
                <h2>
                    Add a project:
                </h2>
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
        <br>
        <br>
        <h2>
            Update Category
        </h2>
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
