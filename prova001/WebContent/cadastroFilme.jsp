<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%if(request.getAttribute("mensagem") != null){ %>
		<p style="color:red"><%=request.getAttribute("mensagem")%> </p>
	<%} %>
	<form action="GerenciarFilme" method="post">
		Nome do Filme<input type="text" name="nomeFilme"><br><br>
		Ano:<input type="text" name="anoFilme"><br><br>
		<input type="submit" value="Enviar"> 
	</form>
</body>
</html>