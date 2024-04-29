<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form action="saveproduct" modelAttribute="productobj">
Enter brand  : <form:input path="brand" />
Enter category: <form:input path="category" />
Enter price : <form:input path="price" />
Enter stock :<form:input path="stock" />
		<input type="submit">
	</form:form>
</body>
</html>