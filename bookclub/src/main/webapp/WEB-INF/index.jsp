<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<rapid:override name="header">  
    Book Club 
</rapid:override>  

<rapid:override name="nav">  
	<c:if test="${sessionScope.loggedUser == null}">
		<a href="/logoreg">
			Login
		</a>
	</c:if>
	<c:if test="${sessionScope.loggedUser != null}">
		<a href="/logoreg">
			Logout
		</a>
	</c:if>

	<a href="/bookshelf">
		BookShelf
	</a>
</rapid:override>  

<rapid:override name="main">  
    <div>
    	<!--<img src="https://media4.giphy.com/media/12qxR8tbj3qvq23V7z/giphy.gif?cid=82a1493bh8992tpsnopnvuczj3ijxk4vt15r5ptk41cyu3fy&rid=giphy.gif&ct=v">-->
		<!-- https://images.gr-assets.com/hostedimages/1394565585ra/8872184.gif -->
		<img src="https://c.tenor.com/hd8vZu_qKX8AAAAd/dog-read.gif">
	</div>
	
    <div>
    	<h2>
    		Objectives:
    	</h2>
	    <ul>
	    	<li>
	    		Add users to an application with Create and Read capabilities.
	    	</li>
	    	<li>
	    		Implement a one-to-many relationship between User and another model.
	    	</li>
	    	<li>
	    		Identify and implement routes for requests based on a wireframe.
	    	</li>
	    	<li>
	    		Manage a user session (log in status) by storing and reading their ID in session.
	    	</li>
	    	<li>
	    		Apply cumulative skills to build and de-bug a full-stack application.
	    	</li>
	    </ul>
	    <br>
	    <br>
	    <h2>
	    	Project Links
	    </h2>
	    <ul>
	    	<li>
	    		<a href="/erd">
	    			<span class="accent">
	    				Entity Relationship Diagram (ERD)
	    			</span>
	    		</a>
	    	</li>
	    	<li>
	    		<a href="https://github.com/xtina-lt/Java-Spring-MVC/tree/main/bookclub" target="#">
	    			<span class="accent">
	    				Code / Brilliant Brain
	    			</span>
	    		</a>
	    	</li>
	    </ul>
    </div>
</rapid:override>  

<%@ include file="base.jsp"%>

