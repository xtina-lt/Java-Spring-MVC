<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %>


<rapid:override name="header">  
    Dojos and Ninjas 
</rapid:override>  

<rapid:override name="nav">  
    <a href="/addresses">
        Addresses
    </a>
    <a href="/dojos">
        Dojos
    </a> 
</rapid:override>  

<rapid:override name="main">  
    <div>
    	<img src="https://64.media.tumblr.com/99579f222388a9a610d1d87016f6063a/tumblr_oy3frlRqUQ1ud4rwdo1_640.gifv">
	</div>
	
    <div>
    	<h2>
    		Objectives:
    	</h2>
	    <ul>
	    	<li>
	    		Implement, manipulate, and show <span class="accent">one-to-one</span> relationships.
	    	</li>
	    	<li>
	    		Implement a <span class="accent">one-to-many</span> relationship.
	    	</li>
	    	<li>
	    		Manipulate lists to model <span class="accent">one-to-many</span>  relationships in the database.
	    	</li>
	    	<li>
	    		Implement a <span class="accent">foreign-key relationship</span> by assigning instances of a class as a member variable.
	    	</li>
	    </ul>
    </div>
</rapid:override>  

<%@ include file="base.jsp"%>

