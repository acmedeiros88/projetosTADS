<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
	<meta charset="UTF-8"/>
	<link rel="stylesheet" type="text/css" href="../css/estilizacao.css">
	<link rel="stylesheet" type="text/css" href="../css/inputsTelaVenda.css">
	<style>
		#vendaNav {
		 background-color: grey;
		 color: white;
		}
	</style>
	<title>Venda</title>
</head>
<body>
	<main>
		<c:import url="menuPrincipal.jsp" />
		
		<section id="sectionVenda">
			<h1>VENDAS</h1>
			<form>
				<div class="cInputDadosPreVenda">
					<input id="inputClienteVenda" type="text" name="clienteVenda" placeholder="Cliente" autofocus>
					<select name="formaDePagamento" id="selectFormaDePagamneto" class="cInputDir" required>
						<option disabled selected>Forma de Pagamento</option>
						<option value="dinheiro">Dinheiro</option>
						<option value="cartaoCredito">Cartão Credito</option>
						<option value="cartaoDebito">Cartão Debito</option>
						<option value="aPrazo">a Prazo</option>
					</select><br><br>
					<input list="produtos" id="inputListaProdutos" name="" placeholder="Produto">
						<datalist id="produtos">
							<option value="Bolo"></option>
							<option value="Salgado"></option>
						</datalist>
					<label class="cInputDir">Quantidade:</label><input id="inputQuantidadeProdutoVenda" class="cInputDir" type="number" name="quantidadeProdutoVenda" min="1" placeholder="und"><br><br>
					<input id="inputDescontoItemProduto" type="number" name="descontoItemProduto" min="0" placeholder="Valor de Desconto">
					<input id="inputAddPreVenda" class="cInputDir" type="reset" name="addPreVenda" value="OK"><br><br>
				</div>
				<div>
					<table id="tablePreVenda">
						<tr>
							<th>Código</th>
							<th>Produto</th>
							<th>Qtd</th>
							<th>Valor Unitario</th>
							<th>Desconto</th>
							<th>Total</th>
						</tr>
						<tr>
							<td>001</td>
							<td>Produto001</td>
							<td>1</td>
							<td>R$6,00</td>
							<td></td>
							<td>R$6,00</td>
						</tr>
						<tr>
							<td>002</td>
							<td>Produto002</td>
							<td>1</td>
							<td>R$6,00</td>
							<td>R$1,00</td>
							<td>R$5,00</td>
						</tr>
						<tr>
							<td>003</td>
							<td>Produto003</td>
							<td>1</td>
							<td>R$6,00</td>
							<td></td>
							<td>R$6,00</td>
						</tr>
					</table>
					<label>Valor Desconto</label><input id="inputValorDescontoTotalDaVenda" type="number" name="valorDescontoTotalDaVenda" min="0" placeholder="R$ 1,00" readonly>
					<label class="cInputDir">Valor Total</label><input id="inputValorTotalDaVenda" class="cInputDir" type="number" name="valorTotalDaVenda" min="0" placeholder="R$ 17,00" readonly><br><br>
					<div id="inputSubmitReset">
						<input id="inputFinalizarVenda" type="submit" name="finalizarVenda" value="Finalizar">
						<input id="inputCancelarVenda" type="reset" name="cancelarVenda" value="Cancelar">
					</div>
				</div>
			</form>	
		</section>
	</main>
</body>
</html>