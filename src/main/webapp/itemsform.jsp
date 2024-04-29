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

<form:form action="additemtocart" modelAttribute="itemsobj">
				<form:hidden path="pid"/>
Enter brand  : <form:input path="brand" readonly="true"/>
Enter category: <form:input path="category" readonly="true"/>
Enter price : <form:input path="price" readonly="true" />
Enter quantity :<form:input path="quantity" />

		<input type="submit">
	</form:form>
</body>
</html>