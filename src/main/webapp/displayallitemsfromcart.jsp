<%@page import="com.jsp.shoppingCart_Application.dto.Items"%>
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
 List<Items>items= (List<Items>)request.getAttribute("itemslist");
 double totalprice=(double)request.getAttribute("totalprice");
 %>
 <table cellpadding="20px" border="1">
 <th>Brand</th>
 <th>Category</th>
 <th>Quantity</th>
 <th>Price</th>
 
 <%
 for(Items i: items){
 %>
 <tr>
 <td><%=i.getBrand() %></td>
 <td><%=i.getCategory() %></td>
 <td><%=i.getQuantity() %></td>
 <td><%=i.getPrice() %></td>
 </tr>
 
 <%} %>
 </table>
 TotalPrice:<%=totalprice %>
 
 <a href="addorder">BUY NOW</a>
</body>
</html>