<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <link href="teste.css" rel="Stylesheet" type="text/css">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="FrontControllerServlet">
		<input type="text" name="login"> <br>
		<input type="password" name="password"> <br>
		<input hidden="true" name="comando" value="Logar">
		<input type="submit" value="Logar">
	</form>
</body>
</html>