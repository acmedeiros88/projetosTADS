<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%if(request.getAttribute("mensagem") != null){ %>
		<p style="color:red"><%=request.getAttribute("mensagem")%> </p>
	<%} %>
	
	<form action="GerenciarUsuario">
		Nome:<input type="text" name="nome"><br>
		Login:<input type="text" name="login"><br>
		Senha:<input type="password" name="senha"><br>
		<input type="submit" value="Cadastrar">
		
	</form>
		<jsp:useBean id="dao" class="dao.UsuarioDao"/>
	<table>
		<c:forEach var="usuario" items="${dao.lista}">
			<tr>
				<td>${usuario.nome}</td>
				<td>${usuario.login}</td>
				<td>${usuario.senha}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>