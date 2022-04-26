<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ page isErrorPage="true"%>

<rapid:override name="header"> 
    Ninjas
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
        <img src="https://c.tenor.com/6jWluq4U4gQAAAAi/stitch-ninja.gif">
		<br>
		<br>
		The <i>Ninjas database table</i> is connected to the <i>Addresses table</i> as a <span class="accent">One-to-One Relationship</span>.
		<br>
		<br>
		It is also connected to the <i>Dojos table</i> as a <span class="accent">One-to-Many Relationship</span>.
		<br>
		<br>
		There can be <b>many</b> <i>Ninjas</i> in <b>one</b> <i>Dojo</i>.
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
	     	<c:forEach var="i" items="${ output }">
	     		<tr> 
	     			<td>
	     				${i.id}
	     			</td>
	     			<td>
	     				${i.name}
	     			</td>
	     			<td>
	     				${i.address.city}, ${i.address.state}
	     			</td>
	     			<td>
	     				${i.dojo.name}
	     			</td>
	     			<td>
	     				<fmt:formatDate type="both" dateStyle="long" timeStyle="long" value="${ i.createdAt }"/>
	     			</td>
	     			<td>
	     				<fmt:formatDate type="both" dateStyle="long" timeStyle="long" value="${ i.updatedAt }"/>
	     			</td>
	     			<td>
	     				<a href="/ninja/${i.id}">
	     					Edit
	     				</a>
	     			</td>
	     		</tr>
	     	</c:forEach>
     	</table>
    </div>
	<div>
   		<h2>
   			Add Ninja..
   		</h2>
    	<!-- FORM -->
		<form:form action="/ninja/create" method="POST" modelAttribute="input">
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
			<!-- dojos -->
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
			<input type="submit" value="Get Located!">
		</form:form>
	</div>
</rapid:override>  

<%@ include file="../base.jsp"%>
