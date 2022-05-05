<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<rapid:override name="header">  
    ERD
</rapid:override> 
 
<rapid:override name="main"> 
    <div>
        <img id="erd" src="/erd.png">
    </div>
</rapid:override>  

<%@ include file="base.jsp"%>
