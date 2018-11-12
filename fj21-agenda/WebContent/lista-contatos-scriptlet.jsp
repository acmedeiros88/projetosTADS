<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="java.util.*,
                  br.com.caelum.jdbc.dao.*,
                  br.com.caelum.jdbc.modelo.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Contatos</title>
</head>
<body>
	<table>
		<tr>
			<th>NOME</th>
			<th>E-Mail</th>
			<th>ENDEREÇO</th>
		</tr>
		<%
			ContatoDao dao = new ContatoDao();
			List<Contato> contatos = dao.getLista();

			for (Contato contato : contatos) {
		%>
		<tr>
			<td><%=contato.getNome() %></td>
			<td><%=contato.getEmail() %></td>
			<td><%=contato.getEndereco() %></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>