<%@page import="com.jsp.shoppingCart_Application.dto.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	List<Product> products = (List<Product>) request.getAttribute("productlist");
	%>
	<a href="viewitemsfromcart">View Cart</a>
	<table cellPadding="20px" border="1">

		<th>brand</th>
		<th>category</th>
		<th>price</th>
		<th>add</th>

		<%
		for (Product p : products) {
		%>
		<tr>

			<td><%=p.getBrand()%></td>
			<td><%=p.getCategory()%></td>
			<td><%=p.getPrice()%></td>
			<td><a href="additems?id=<%=p.getId()%>">ADD TO CART</a></td>

		</tr>
		<%
		}
		%>
	</table>
</body>
</html>