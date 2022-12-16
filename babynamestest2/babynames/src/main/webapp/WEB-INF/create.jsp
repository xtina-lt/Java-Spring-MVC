<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<%@ page isErrorPage="true"%>

<rapid:override name="header">  
    Welcome ${loggedName}
</rapid:override> 
 
<rapid:override name="main"> 
	<div>
		<h2>
    		Add New Name
    	</h2>
    	<!-- FORM -->
    	<form:form action="/name/create" method="POST" modelAttribute="e">
    	<!-- user -->
		<form:hidden value="${loggedId}" path="user"/>
		<!-- name -->
    	<form:label path="name">
    		Name:
    	</form:label>
    	<br>
    	<form:errors path="name"/>
    	<form:input path="name"/>
    	<!-- gender -->
    	<form:label path="gender">
    		Gender:
    	</form:label>
    	<br>
    	<form:errors path="gender"/>
    	<form:input path="gender"/>
    	<!-- origin -->
    	<form:label path="origin">
    		Origin:
    	</form:label>
    	<br>
    	<form:errors path="origin"/>
    	<form:input path="origin"/>
    	<!-- meaning -->
    	<form:label path="meaning">
    		Meaning:
    	</form:label>
    	<br>
    	<form:errors path="meaning"/>
    	<form:input path="meaning"/>
    	<!-- submit -->
    	<input type="submit" value="Get Creative!">
    	</form:form>
	</div>
</rapid:override>  

<%@ include file="base.jsp"%>
