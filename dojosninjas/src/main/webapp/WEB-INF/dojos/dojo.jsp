<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ page isErrorPage="true"%>


<rapid:override name="header">
    Dojo
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
    <a href="/ninjas">
    	Ninjas
    </a>
</rapid:override> 

<rapid:override name="main">  
    <div>
    	<img src="https://i.pinimg.com/originals/2a/14/56/2a1456f6895cb3bb029b4cba034b7682.gif">
		<br>
		<br>
		One <i>Dojo</i> is connected by a <span class="accent">One-to-One Relationship</span> to an <i>Address</i>.
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
     			<th>
     				Options
     			</th>
     		</tr>
     		<tr> 
     			<td>
     				${output.id}
     			</td>
     			 <td>
     				${output.name}
     			</td>
     			<td>
     				${output.address.street}
     			</td>
     			<td>
     				${output.address.city}
     			</td>
     			<td>
     				${output.address.state}
     			</td>
     			<td>
     				${output.address.zip}
     			</td>
     			<td>
     				<fmt:formatDate type="both" dateStyle="long" timeStyle="long" value="${ output.createdAt }"/>
     			</td>
     			<td>
     				<fmt:formatDate type="both" dateStyle="long" timeStyle="long" value="${ output.updatedAt }"/>
     			</td>
     			<td>
     				<a href="/dojo/${output.id}/delete">
     					Delete
     				</a>
     			</td>
     		</tr>
     	</table>
     	<br>
     	<h2>
   			Update 
   		</h2>
    	<!-- FORM -->
		<form:form action="/dojo/update" method="PUT" modelAttribute="o">
			<!-- id -->
			<form:input type="hidden" path="id"/>
			<form:label path="name">
				Name:
			</form:label>
			<br>
			<form:errors path="name"/>
			<form:input path="name"/>
			<!-- address id -->
			<form:input type="hidden" path="address.id"/>
			<!-- street -->
			<form:label path="address.street">
				Address:
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
			<input type="submit" value="Change Location">
		</form:form>
    </div>
</rapid:override>

<%@ include file="../base.jsp"%>
