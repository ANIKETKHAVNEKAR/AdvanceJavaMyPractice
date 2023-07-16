<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
<h2>Hello World!</h2>



Request URL : <%= request.getRequestURL() %>
  <%--  ${pageContext.request.url } --%>
<br/>
Request method : <%= request.getMethod() %>
  <%--  ${pageContext.request.method } --%>
    
  <c:set var="n" value="9" /> 
  
  <br/>
  <c:if test="${Integer.parseInt(n) > 10}" >
  	 <p style="color:green"> WELCOME </p>
  </c:if> 
  
   <c:if test="${Integer.parseInt(n) < 10}" >
  	 <p style="color:red"> HELLO </p>
  </c:if> 
</body>
</html>
