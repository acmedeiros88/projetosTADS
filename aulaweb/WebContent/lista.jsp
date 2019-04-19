<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Agenda de Contatos</title>
</head>
<body>
	<table id="contatos">
		<thead>
			<tr>
				<th>Id</th>
				<th>Nome</th>
				<th>Telefone</th>
				<th>Favoritos</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="contato" items="${lista_contatos}">
				<tr>
					<td>${contato.id}</td>
					<td>${contato.nome}</td>
					<td>
					<c:forEach var="telefone" items="${contato.telefones}">
						${telefone.telefone}
					</c:forEach>
					</td>
					<td>${contato.favoritos}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<form action="FrontControllerServlet">
		Primeiro nome:<input type="text" name="primeiro"> Segundo Nome:<input type="text" name="segundo"><br>
		Telefone:<input type="text" name="telefone"> Celular:<input type="text" name="celular"><br>
		Favorito: Sim<input type="radio" name="favoritos" value="1"> Não<input type="radio" name="favoritos" value="0"><br>
		URL:<input type="text" name="url"><br>
		Cadastrar <input type="radio" name="comando" value="Cadastrar" ><br>
		Remover <input type="radio" name="comando" value="Remover"> 
		<input type="text" name="id"><br>
		Atualizar <input type="radio" name="comando" value="Atualizar">
		<input type="number" name="idUpdate"><br>
		Recarregar <input type="radio" name="comando" checked="checked" value="ListarContatos">
		<br>
		<input type="submit" value="Atualizar lista">
	</form>
</body>
</html>