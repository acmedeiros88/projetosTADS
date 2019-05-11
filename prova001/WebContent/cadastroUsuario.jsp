<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="GerenciarUsuario" method="post">
		<label>Nome:</label>
		<input type="text" name="nome"><br><br>
		<label>CPF:</label>
		<input type="text" name="cpf"><br><br>
		<label>Senha:</label>
		<input type="text" name="senha"><br><br>
		<p>ENDEREÇO:</p><br>
		<label>Rua:</label>
		<input type="text" name="rua">
		<label>número:</label>
		<input type="number" name="numero">
		<label>Complemento:</label>
		<input type="text" name="complemento">
		<input type="submit" value="Enviar">
	</form>
</body>
</html>