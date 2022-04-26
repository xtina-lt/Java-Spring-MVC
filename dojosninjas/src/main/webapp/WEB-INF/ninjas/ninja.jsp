<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ page isErrorPage="true"%>


<rapid:override name="header">
    Ninja
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
        <img src="https://c.tenor.com/6jWluq4U4gQAAAAi/stitch-ninja.gif">
		<br>
		<br>
		<b>One</b> <i>Ninja</i> is connected to <b>one</b> <i>Addresses</i> table as a <span class="accent">One-to-One Relationship</span>.
		<br>
		<br>
		It is also connected to the <i>Dojos</i> table as a <span class="accent">One-to-Many Relationship</span>.
		<br>
		<br>
		There can be <b>many</b> <i>Ninjas</i> in <b>one</b> <i>Dojo</i>.
		<br>
		<br>
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
     				Dojo
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
     				${output.dojo.name}
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
	</div>
    <div>
     	<h2>
   			Update 
   		</h2>
    	<!-- FORM -->
		<form:form action="/ninja/update" method="POST" modelAttribute="output">
		<input type="hidden" name="_method" value="put">
			<!-- id -->
			<form:input type="hidden" path="id"/>
				<form:label path="name">
				Name:
			</form:label>
			<br>
			<form:errors path="name"/>
			<form:input path="name"/>
			<!-- street -->
			<form:input type="hidden" path="address.id"/>
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
			<!-- dojo -->
			<form:label path="dojo">
				Dojo:
			</form:label>
			<form:select path="dojo">
        		<c:forEach var="d" items="${dojos}">
	            	<form:option value="${d.id}" path="dojo">
	                	${d.name}
	            	</form:option>
            	</c:forEach>
            </form:select>
			<!-- submit -->
			<input type="submit" value="Change Location">
		</form:form>
    </div>
</rapid:override>

<%@ include file="../base.jsp"%>
