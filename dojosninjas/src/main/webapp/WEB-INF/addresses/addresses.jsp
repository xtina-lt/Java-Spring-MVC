<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ page isErrorPage="true"%>


<rapid:override name="header">  
    Addresses
</rapid:override>

<rapid:override name="nav"> 
    <a href="/">
        Home
    </a>
    <a href="/dojos">
        Dojos
    </a> 
</rapid:override>

<rapid:override name="main"> 
	<div>
    	<img src="https://y.yarn.co/03e9bd0e-a55e-4692-ab9f-05fc0d512b88_text.gif">
		<br>
		<br>
		The addresses db table is connected to two <span class="accent">One-to-One Relationships</span>.
		<br>
		The relationships are with both Ninjas and Dojos.
    	<br>
    	<br>
   		<h2>
   			Add Address..
   		</h2>
    	<!-- FORM -->
		<form:form action="/address/create" method="POST" modelAttribute="input">

			<!-- street -->
			<form:label path="street">
				Street:
			</form:label>
			<br>
			<form:errors path="street"/>
			<form:input path="street"/>
			<!-- city -->
			<form:label path="city">
				City:
			</form:label>
			<br>
			<form:errors path="city"/>
			<form:input path="city"/>
			<!-- state -->
			<form:label path="state">
				State:
			</form:label>
			<br>
			<form:errors path="state"/>
			<form:input path="state"/>
			<!-- zip -->
			<form:label path="zip">
				Zip:
			</form:label>
			<br>
			<form:errors path="zip"/>
			<form:input type="number" path="zip" min="00501"/>
			<!-- submit -->
			<input type="submit" value="Get Located!">
		</form:form>
	</div>
    <div>
     	<table>
     		<tr>
     			<th>
     				ID
     			</th>
     			<th>
     				Street
     			</th>
     			<th>
     				City
     			</th>
     			<th>
     				State
     			</th>
     			<th>
     				Zip
     			</th>
     			<th>
     				Created
     			</th>
     			<th>
     				Created
     			</th>
     			<th>
     				Options
     			</th>
     		</tr>
	     	<c:forEach var="i" items="${ output }">
	     		<tr> 
	     			<td>
	     				${i.id}
	     			</td>
	     			<td>
	     				${i.street}
	     			</td>
	     			<td>
	     				${i.city}
	     			</td>
	     			<td>
	     				${i.state}
	     			</td>
	     			<td>
	     				${i.zip}
	     			</td>
	     			<td>
	     				<fmt:formatDate type="both" dateStyle="long" timeStyle="long" value="${ i.createdAt }"/>
	     			</td>
	     			<td>
	     				<fmt:formatDate type="both" dateStyle="long" timeStyle="long" value="${ i.updatedAt }"/>
	     			</td>
	     			<td>
	     				<a href="/address/${i.id}">
	     					Edit
	     				</a>
	     			</td>
	     		</tr>
	     	</c:forEach>
     	</table>
    </div>
</rapid:override>

<%@ include file="../base.jsp"%>

