<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	String sesao = (String) session.getAttribute("nome");
	if(sesao==null){
		response.sendRedirect("index.jsp");
	}else{
		out.print("Bem vindo, "+sesao+"<br/>");
	}
%>
<form action="GerenciarCadastro" method="post">
<label>ID:</label><input type="number" name="id">
<br><br>
	<label>Nome</label>
	<input type="text" name="nome"><br><br>
	<label>CPf</label>
	<input type="text" name="cpf"><br><br>
	<label>Telefone</label>
	<input type="text" name="telefone"><br><br>
	<input type="submit" value="Enviar" name="acao">
	<input type="submit" value="Remover" name="acao">
	<input type="submit" value="Atualizar" name="acao">
	<input type="submit" value="Sair" name="acao">
	<br><a href="deslogar.jsp">Deslogar</a>
</form>
	<table id="contatos">
		<thead>
			<tr>
				<th>Id</th>
				<th>Nome</th>
				<th>CPF</th>
				<th>Telefone</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="contato" items="${listaContato}">
				<tr>
					<td>${contato.id}</td>
					<td>${contato.nome}</td>
					<td>${contato.cpf}</td>
					<td>${contato.tel}</td>
				</tr>	
			</c:forEach>
		</tbody>
	</table>
</body>
</html>