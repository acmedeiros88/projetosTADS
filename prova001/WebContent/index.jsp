<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<%if(request.getAttribute("mensagem") != null){ %>
		<p style="color:red"><%=request.getAttribute("mensagem")%> </p>
	<%} %>
	<form action="Logar" method="post">
		CPF:<input type="text" name="cpf"><br><br>
		Senha:<input type="text" name="senha"><br><br>
		<input type="submit" value="Enviar"> 
	</form>
	
	<a href="cadastroUsuario.jsp">Cadastrar Usuario</a>
</body>
</html>