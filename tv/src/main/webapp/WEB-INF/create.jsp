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
    		Add New Show
    	</h2>
    	<!-- FORM -->
    	<form:form action="/show/create" method="POST" modelAttribute="s">
    	<!-- user -->
		<form:hidden value="${loggedId}" path="user"/>
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
    	<input type="submit" value="Add">
    	</form:form>
	</div>
</rapid:override>  

<%@ include file="base.jsp"%>
