<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<f:form action="save" modelAttribute="nemp">
		Empid : <f:input path="empid"/> <br/>
		Emp name : <f:input path="ename"/> <br/>
		Dept no : <f:input path="deptno"/> <br/>
		Salary : <f:input path="salary"/> <br/>
		<input type="submit" value="Save Emp" />
		
	</f:form>


</body>
</html>