<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" href="style.css">
<style type="text/css">
.btn {
	display: inline-block;
	padding: 10px 20px;
	font-size: 1em;
	text-decoration: none;
	color: white;
	background-color: green;
	border: none;
	border-radius: 5px;
	transition: background-color 0.3s ease;
}
body{
	margin: 0;
	padding: 0;
	height: 100%;
	font-family: Arial, sans-serif;
	align-items: center;
	background-image: url("shopping.jpg");
	background-position: center;
	background-repeat: no repeat;
	display: flex;
	background-size: cover;
	background-position: center;
	height: 100%;
	display: flex;
	justify-content: center;
	align-items: center;
	text-align: center;
}

.btn:hover {
	background-color: lavender;
	color: black;
}
</style>
</head>
<body>
	<div class="cover-container">
		<header>
			<h1>Welcome to Our Online Store</h1>
			<p>Discover amazing deals and shop from a wide range of products.</p>
			<a href="customerloginform.jsp" class="btn btn-success">Start Shopping</a>
		</header>
	</div>
</html>