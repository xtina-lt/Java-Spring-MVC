<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<%@ page isErrorPage="true"%>

<rapid:override name="header">  
    ${s.name}
</rapid:override> 
 
<rapid:override name="main"> 
	<div>
		<h2>
    		Edit
    	</h2>
    	<!-- FORM -->
    	<form:form action="/show/process" method="PUT" modelAttribute="s">
    	<!-- user -->
		<form:hidden value="${loggedId}" path="user"/>
		<form:hidden value="${s.id}" path="id"/>
		<!-- name -->
    	<form:label path="name">
    		Name:
    	</form:label>
    	<br>
    	<form:errors path="name"/>
    	<form:input path="name"/>
    	<!-- network -->
    	<form:label path="network">
    		Network:
    	</form:label>
    	<br>
    	<form:errors path="network"/>
    	<form:input path="network"/>
    	<!-- description -->
    	<form:label path="description">
    		Description:
    	</form:label>
    	<br>
    	<form:errors path="description"/>
    	<form:input path="description"/>
    	<!-- submit -->
    	<input type="submit" value="Change it up!">
    	</form:form>

		<br>
		<form:form action="/show/${s.id}/delete" method="delete">
		<input type="submit" value="Delete">
		</form:form>
	</div>
</rapid:override>  

<%@ include file="base.jsp"%>