<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Logado</title>
</head>
<body>
		<form action="GerenciaUsuario" method="post">
	    Usuário:<input type="text" name="usuario"><br>
	    Nome:<input type="text" name="nome"><br>
	    Senha:<input type="password" name="senha"><br>
		<input type="submit" name ="gravar" value="Gravar"/><br/><br/>
		<%= request.getAttribute("cadastrado") %>
		</form>
		<form action="logado.jsp">
		<input type="submit" value="Voltar"/><br/>
		</form>
		
</body>
</html>