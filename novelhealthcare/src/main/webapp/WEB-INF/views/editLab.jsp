<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="updateLab" modelAttribute="labBean">
LabId:<form:input path="labId"/><br>
LabName:<form:input path="labName"/><br>
Email:<form:input path="email"/><br>
MobileNo:<form:input path="mobileno"/><br>
<input type="submit" value="update">
<input type="submit" value="cancel">
</form:form>


</body>
</html>