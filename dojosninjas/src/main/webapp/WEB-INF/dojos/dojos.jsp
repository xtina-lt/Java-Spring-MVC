<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ page isErrorPage="true"%>

<rapid:override name="header"> 
    Dojos
</rapid:override> 

<rapid:override name="nav">  
    <a href="/">
        Home
    </a>
    <a href="/addresses">
    	Addresses
    </a>
    <a href="/ninjas">
    	Ninjas
    </a>
</rapid:override> 

<rapid:override name="main"> 
	<div>
    	<img src="https://i.pinimg.com/originals/2a/14/56/2a1456f6895cb3bb029b4cba034b7682.gif">
		<br>
		The <i>Dojos database table</i> is connected to the Addresses table as a <span class="accent">One-to-One Relationship</span>.
		<br>
   		<h2>
   			Add Dojo..
   		</h2>
    	<!-- FORM -->
		<form:form action="/dojo/create" method="POST" modelAttribute="input">
			<!-- name -->
			<form:label path="name">
				Name:
			</form:label>
			<br>
			<form:errors path="name"/>
			<form:input path="name"/>
			<!-- street -->
			<form:label path="address.street">
				Street:
			</form:label>
			<br>
			<form:errors path="address.street"/>
			<form:input path="address.street"/>
			<!-- city -->
			<form:label path="address.city">
				City:
			</form:label>
			<br>
			<form:errors path="address.city"/>
			<form:input path="address.city"/>
			<!-- state -->
			<form:label path="address.state">
				State:
			</form:label>
			<br>
			<form:errors path="address.state"/>
			<form:input path="address.state"/>
			<!-- zip -->
			<form:label path="address.zip">
				Zip:
			</form:label>
			<br>
			<form:errors path="address.zip"/>
			<form:input type="number" path="address.zip" min="00501"/>
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
     				Name
     			</th>
     			<th>
     				Location
     			</th>
     			<th>
     				Updated
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
	     				<a href="/dojo/${i.id}">
	     					${i.name}
	     				</a>
	     			</td>
	     			<td>
	     				${i.address.city}, ${i.address.state}
	     			</td>
	     			<td>
	     				<fmt:formatDate type="both" dateStyle="long" timeStyle="long" value="${ i.createdAt }"/>
	     			</td>
	     			<td>
	     				<fmt:formatDate type="both" dateStyle="long" timeStyle="long" value="${ i.updatedAt }"/>
	     			</td>
	     			<td>
	     				<a href="/dojo/${i.id}">
	     					Edit
	     				</a>
	     			</td>
	     		</tr>
	     	</c:forEach>
     	</table>
    </div>
</rapid:override>  

<%@ include file="../base.jsp"%>
