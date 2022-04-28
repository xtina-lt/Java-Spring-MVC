<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<%@ page isErrorPage="true"%>

<rapid:override name="header">  
    Test
</rapid:override>  

<rapid:override name="nav">  
	<a href="/">
		Home
	</a>
</rapid:override>  

<rapid:override name="main">  
    <div class="minWidth">
    	<h2>
    		Register
    	</h2>
    	<!-- FORM -->
    	<form:form action="/register" method="POST" modelAttribute="u">
    	<!-- first -->
    	<form:label path="first">
    		First Name:
    	</form:label>
    	<br>
    	<form:errors path="first"/>
    	<form:input path="first"/>
    	<!-- last -->
    	<form:label path="last">
    		Last Name:
    	</form:label>
    	<br>
    	<form:errors path="last"/>
    	<form:input path="last"/>
    	<!-- email -->
    	<form:label path="email">
    		Email:
    	</form:label>
    	<br>
    	<form:errors path="email"/>
    	<form:input path="email"/>
    	<!-- confirme -->
    	<form:label path="confirmE">
    		Confirm Email:
    	</form:label>
    	<br>
    	<form:errors path="confirmE"/>
    	<form:input path="confirmE"/>
    	<!-- pword -->
    	<form:label path="password">
    		Password:
    	</form:label>
    	<br>
    	<form:errors path="password"/>
    	<form:password path="password"/>
    	<!-- confirmp -->
    	<form:label path="confirmP">
    		Confirm Password:
    	</form:label>
    	<br>
    	<form:errors path="confirmP"/>
    	<form:password path="confirmP"/>
    	<!-- submit -->
    	<input type="submit" value="Join Us">
    	</form:form>
    </div>
    
    <div class="minWidth">
    	<h2>
    		Login
    	</h2>
    	<form:form action="/login" method="POST" modelAttribute="l">
    	<!-- email -->
    	<form:label path="email">
    		Email:
    	</form:label>
    	<br>
    	<form:errors path="email"/>
    	<form:input path="email"/>
    	<!-- pass -->
    	<form:label path="password">
    		Password:
    	</form:label>
    	<br>
    	<form:errors path="password"/>
    	<form:password path="password"/>
    	<!-- submit -->
    	<input type="submit" value="Come On In!">
    	</form:form>
    	<br>
    	<img src="https://c.tenor.com/U7un0u6w3d8AAAAM/retriever-puppy.gif">
    </div>
</rapid:override>  

<%@ include file="base.jsp"%>

