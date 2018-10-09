<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro</title>
</head>
<body>
	<label>Cadastrar:</label>
	<input type="text" name="cadastrar" />
	<input type="submit" value="Gravar" />
	<br />
	<br />

	<label>Remover:</label>
	<input type="text" name="remover" />
	<input type="submit" value="Gravar" />
	<br />
	<br />

	<label>Atualizar:</label>
	<input type="text" name="atualizar" />
	<input type="submit" value="Gravar" />
	<br />
	<br />

	<form action="index.html">
		<input type="submit" value="Voltar" /><br />
	</form>
</body>
</html>