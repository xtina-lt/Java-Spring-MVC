<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ page isErrorPage="true"%> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 


<rapid:override name="header">  
    Address 
</rapid:override>  

<rapid:override name="nav">  
    <a href="/">
        Home
    </a>
    <a href="/addresses">
        Addresses
    </a>
    <a href="/dojos">
        Dojos
    </a> 
</rapid:override>  

<rapid:override name="main">  
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
     				Updated
     			</th>
     		</tr>
     		<tr> 
     			<td>
     				${output.id}
     			</td>
     			<td>
     				${output.street}
     			</td>
     			<td>
     				${output.city}
     			</td>
     			<td>
     				${output.state}
     			</td>
     			<td>
     				${output.zip}
     			</td>
     			<td>
     				<fmt:formatDate type="both" dateStyle="long" timeStyle="long" value="${ output.createdAt }"/>
     			</td>
     			<td>
     				<fmt:formatDate type="both" dateStyle="long" timeStyle="long" value="${ output.updatedAt }"/>
     			</td>
     		</tr>
     	</table>
     	
     	
     	<br>
     	<h2>
   			Update
   		</h2>
    	<!-- FORM -->
		<form:form action="/address/update" method="POST" modelAttribute="output">
		<input type="hidden" name="_method" value="put">
			<!-- id -->
			<form:input type="hidden" path="id"/>
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
			<input type="submit" value="Change Location">
		</form:form>
    </div>
    <div>
    	<img src="https://y.yarn.co/03e9bd0e-a55e-4692-ab9f-05fc0d512b88_text.gif">
		<br>
		<br>
		
		
		One address is connected by a <span class="accent">One-to-One Relationship</span>.
		<br>
		The relationships are with both Ninjas and Dojos.
    	<br>
    	<br>
   </div>
</rapid:override>  

<%@ include file="../base.jsp"%>