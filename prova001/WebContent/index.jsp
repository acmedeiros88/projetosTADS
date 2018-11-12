<%@page import="com.sun.org.apache.xml.internal.serialize.Printer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="data" uri="WEB-INF/taglib.tld"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menu Principal</title>
</head>
<body>
	<%
		if (request.getAttribute("mensagem") != null) {
	%>
	<%=request.getAttribute("mensagem")%>
	<%
		}
	%>
	<form action="Servidor" method="post">
		<label>Nome:</label> <input type="text" name="nome" /><br /> <label>Senha:</label>
		<input type="password" name="senha" /><br /> <input type="submit"
			value="Login" />
	</form>
	<data:dataAtual />
</body>
</html>