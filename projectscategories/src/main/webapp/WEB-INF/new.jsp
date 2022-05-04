<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<%@ page isErrorPage="true"%>

<rapid:override name="header">  
    New Project or Category
</rapid:override> 
 
<rapid:override name="nav">  
    <a href="/">
        Home
    </a>
</rapid:override>  

<rapid:override name="main">  
    <div>
        <h2>
            New Project:
        </h2>
        <form:form action="/project/create" method="POST" modelAttribute="p">
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
            <!-- categories -->


            <!-- submit -->
            <input type="submit" value="Create Product">
        </form:form>
    </div>
    <div>
        <h2>
            New Category:
        </h2>
        <form:form action="/category/create" method="POST" modelAttribute="c">
            <form:label path="name">
                Name:
            </form:label>
            <br>
            <form:errors path="name"/>
            <form:input path="name"/>
            <input type="submit" value="Create Category">    
        </form:form>
    </div>
</rapid:override>  

<%@ include file="base.jsp"%>
