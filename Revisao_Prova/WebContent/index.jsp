<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="index.jsp" method="post">
		<label>Nome</label>
		<input type="text" name="nome"><br><br>
		<label>Senha</label>
		<input type="password" name="senha"><br><br>
		<input type="submit" value="Enviar">
	</form>
	<%
		String nome = request.getParameter("nome");
		String senha = request.getParameter("senha");
		if(nome!=null && senha!=null && !nome.isEmpty() && !senha.isEmpty()){
			session.setAttribute("nome", nome);
			response.sendRedirect("cadastro.jsp");
		}
	%>
</body>
</html>