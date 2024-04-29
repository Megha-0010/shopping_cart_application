<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<style type="text/css">
body{

background-image:url("shopping.jpg");
background-repeat:no repeat;
background-size:cover;
background-color:lightcyan;
}
form {
	margin: 0;
	padding: 0;
	height: 100%;
	font-family: Arial, sans-serif;
	align-items: center;
	display: flex;
	background-size: cover;
	background-position: center;
	height: 100%;
	display: flex;
	justify-content: center;
	align-items: center;
	text-align: center;
}

h1 {
	text-align: center;
}
</style>
</head>
<body>

	${msg}

	<h1>login</h1>
	<form action="validatelogincustomer">
		<table align="center" border="2px" cellspacing="0" cellpadding="15px" >
			<tr>
				<td><label>Enter Email</label></td>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<td><label>Password</label></td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td colspan="2"><button type="submit" class="btn btn-primary">login</button></td>
			<tr>
				<td colspan="2"><button><a href="addcustomer">new user? click here</a></button></td>
						
			</tr>
		</table>

	</form>
</body>
</html>