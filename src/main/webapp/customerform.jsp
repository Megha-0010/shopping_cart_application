<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<style>
body{
background-color:pink
}
</style>
<body>
<h1>Register</h1>
<form:form action="savecustomer" modelAttribute="customerobj">
Enter name  : <form:input path="name" /><br>
Enter mobile: <form:input path="mobile"/><br>
Enter email : <form:input path="email" /><br>
Enter password :<form:input path="password" /><br>
		<input type="submit">
	</form:form>
</body>
</html>