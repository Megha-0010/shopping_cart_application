<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LOGIN AS MERCHANT</title>
</head>
<body>
${msg}
<form action="validateloginmerchant" >
Enter email : <input type="email"  name="email"><br>
Enter password :<input type="password"  name="password"><br>
		<input type="submit">
	</form>
</body>
</html>