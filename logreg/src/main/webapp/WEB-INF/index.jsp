<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<rapid:override name="header">  
    TITLE NAME CHANGE ME
</rapid:override> 
 
<rapid:override name="nav">  
    <c:if test="${sessionScope.id == null}">
        <a href="/logoreg">
            Login
        </a>
    </c:if>
    <c:if test="${sessionScope.id != null}">
        <a href="/logout">
            Logout
        </a>
    </c:if>
</rapid:override>  

<rapid:override name="main">  
    <div>
        ${output}
    </div>
</rapid:override>  

<%@ include file="base.jsp"%>