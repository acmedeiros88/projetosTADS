<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%> 
<!DOCTYPE html>
<html lang="pt-br">
<head>
	<meta charset="UTF-8"/>
	<link rel="stylesheet" type="text/css" href="../css/estilizacao.css">
	<link rel="stylesheet" type="text/css" href="../css/estiloTelaPedido.css">
	<style>
		#pedidoNav {
		 background-color: grey;
		 color: white;
		}
	</style>
	<title>Pedidos</title>
</head>
<body>
	<main>
			<c:import url="menuPrincipal.jsp" />
			
		    <section id="sectionPedido">
			<h1>PEDIDOS</h1>
			<form>
				<div>
					<input id="inputNomeClientePedido" type="text" name="nomeClientePedido" placeholder="Nome Cliente" autofocus>
					<br>
					<input type="number" id="inputTelefoneClientePedido" name="telefoneClientePedido" min="0" placeholder="Telefone">
					<input type="button" id="inputBuscarClientePedido" name="buscarClientePedido" value="Buscar">
					<br>
					<input list="produtosPedido" id="inputListaProdutosPedido" name="listaProdutosPedido" placeholder="Produto">
						<datalist id="produtosPedido">
							<option value="Bolo"></option>
							<option value="Salgado"></option>
						</datalist>
					<label>Quantidade:</label><input id="inputQuantidadeProdutoPedido" type="number" name="quantidadeProdutoPedido" min="1" placeholder="und">
					<br>
					<input id="inputSalvarPedido" type="button" name="salvarPedido" value="Salvar">
					<input id="inputCancelarPedido" type="reset" name="cancelarPedido" value="Cancelar">
				</div>
				<div id="pedidosFeitos">
					<legend>Lista de Pedidos Feitos</legend>
					<table id="tablePedido">
						<tr>
							<th>Data</th>
							<th>Nome Cliente</th>
							<th>Produto</th>
							<th>Quantidade</th>
							<th>Atendido</th>
						</tr>
						<tr>
							<td>01/01/2019</td>
							<td>cliente01</td>
							<td>produto01</td>
							<td>1</td>
							<td>EXCLUIR</td>
						</tr>
						<tr>
							<td>01/01/2019</td>
							<td>cliente02</td>
							<td>produto02</td>
							<td>1</td>
							<td>EXCLUIR</td>
						</tr>
						<tr>
							<td>01/01/2019</td>
							<td>cliente02</td>
							<td>produto02</td>
							<td>1</td>
							<td>EXCLUIR</td>
						</tr>
					</table>
				</div>
			</form>	
		</section>
	</main>
</body>
</html>