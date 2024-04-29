<%@page import="com.jsp.shoppingCart_Application.dto.Merchant"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	${msg}
	<%
	Merchant m = (Merchant) session.getAttribute("merchantinfo");

	if (m != null) {
	%>
	<button>
		<a href="addproduct">Add Product</a>
	</button>
	<button>
		<a href="viewallproduct">View All Product</a>
	</button>
	<%
	} else {
	%>
	
	<a href="merchantloginform.jsp"> LOGIN  FIRST</a>

	<%
	}
	%>
</body>
</html>