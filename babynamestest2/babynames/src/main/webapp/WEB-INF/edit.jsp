<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<%@ page isErrorPage="true"%>

<rapid:override name="header">  
    ${e.name}
</rapid:override> 
 
<rapid:override name="main"> 
	<div>
		<h2>
    		Edit
    	</h2>
    	<h2>
			${e.name}
		</h2>
    	<!-- FORM -->
    	<form:form action="/name/process" method="PUT" modelAttribute="e">
    	<!-- user -->
		<form:hidden value="${loggedId}" path="user"/>
		<form:hidden value="${e.id}" path="id"/>
		<!-- name -->
		<form:hidden value="${e.name}" path="name"/>
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
    	<input type="submit" value="Change it up!">
    	</form:form>
		<br>
		<form:form action="/name/${e.id}/delete" method="delete">
		<input type="submit" value="Delete">
		</form:form>
	</div>
</rapid:override>  

<%@ include file="base.jsp"%>