var item = 0;
var valorTotalVenda;
var valorDesc;
$(function() {
	$("#inputAddPreVenda").click(
			function() {
				item++;
				var codigo = 0;
				var produto = $("#inputListaProdutos").val();
				var qtd = $("#inputQuantidadeProdutoVenda").val();
				var valorUnt = 6;
				var desconto = $("#inputDescontoItemProduto").val();
				var totalItem = 6 * qtd - desconto;
				$("table").append(
						"<tr><td>" + item + "</td><td>" + codigo + "</td><td>"
								+ produto + "</td><td>" + qtd + "</td><td>"
								+ "R$ " + valorUnt + ",00" + "</td><td>"
								+ "R$ " + desconto + "</td><td>" + totalItem
								+ "</td></tr>");
				valorTotalVenda = totalItem;
				valorDesc = Number(desconto);
			});
	$("#inputAddPreVenda").click(function() {
		var subTotal = $("#inputValorTotalDaVenda").val();
		var total = Number(subTotal);
		$("#inputValorTotalDaVenda").val(total + valorTotalVenda);

		var subTotalDesc = $("#inputValorDescontoTotalDaVenda").val();
		var descTotal = Number(subTotalDesc);
		$("#inputValorDescontoTotalDaVenda").val(descTotal + valorDesc);
		
		/*Apos adicionar na lista da preVenda limpas os campos.*/
		$('#inputListaProdutos').val("");
		$('#inputQuantidadeProdutoVenda').val("");
		$('#inputDescontoItemProduto').val("");
	});
});

var indice=0;
$(function() {
	$("#botaoAdicionarIngrediente").click(function() {
		indice++;
		var componente = $("#inputListaingrediente").val();
		var qtd = $("#inputQuantidadeIngrediente").val();
		$("#tableListaIngredProd").append("<tr><td>" + componente + "</td><td>" + qtd + "</td></tr>");
		
		/*Apos adicionar os componentes a lista do produto limpa os campos*/
		$('#inputListaingrediente').val("");
		$('#inputQuantidadeIngrediente').val("");
	});
});