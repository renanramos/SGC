<%@ page language="java" contentType="text/html"%>
<%@include file="../../imports.jspf"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../template/header.jsp" />
<title>SGC - Cadastro</title>
<link href="<c:url value="/resources/css-custom/style.css"/>"
	rel="stylesheet" />
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="margem">
				<legend>Contas</legend>
				<form class="form-group" method="post">
					<div class="col-md-8">
						<div class="form-group">
							<label for="descricao">Descrição</label> <input type="text"
								class="form-control" id="descricao" name="descricao"
								value="${conta.descricao}" placeholder="Descrição da conta">
						</div>
						<div class="form-group">
							<fmt:setLocale value="pt-BR" />
							<label for="valor">Valor da parcela R$</label> <input type="text"
								class="form-control" id="valor" name="valor"
								value="<fmt:formatNumber value="${conta.valor}" type="currency" pattern="000.00"/>"
								placeholder=" 0.00" oninput="atualTotal();" />
						</div>
						<div class="form-group">
							<label for="dataVencimento">Data de vencimento</label> <input
								class="form-control" type="date" name="dataVencimento"
								id="dataVencimento" pattern="dd/MM/yyyy"
								value="${conta.dataVencimento}" oninput="atualizaParcelas();" />
						</div>
						<div class="form-group">
							<label for="parcela">Nº. da Parcela</label> <input
								class="form-control" type="number" id="parcela" name="parcela"
								name="parcela" value="${conta.parcela}"
								oninput="atualizaParcelas();" />
						</div>
						<div class="form-group">
							<label for="dataPagamento">Data de pagamento</label> <input
								class="form-control" type="date" name="dataPagamento"
								name="dataPagamento" pattern="dd/MM/yyyy"
								value="${conta.dataPagamento}" />
						</div>
						<div class="form-group">
							<div class="input-group">
								<span class="input-group-addon"> <input id="fixa"
									name="fixa" type="checkbox" aria-label="..."
									<c:if test="${conta.fixa}">checked</c:if> />
								</span> <label class="form-control" aria-label="..." for="fixa">Esta
									é uma conta fixa?</label>
							</div>
							<!-- /input-group -->
						</div>
						<button type="submit" class="btn btn-success">Confirmar</button>
						<a type="submit" class="btn btn-default"
							href="<c:url value="/conta/filtro"/>">Cancelar</a>
					</div>
					<div class="row">
						<div class="col-md-4">
							<legend>Cadastro de parcelas</legend>
							<div class="form-group">
								<label for="dataInicio">Primeira</label> <input
									class="form-control" type="date" id="dataInicio"
									name="dataInicio" pattern="dd/MM/yyyy"
									value="${conta.dataInicio}" />
							</div>
							<div class="form-group">
								<label for="dataFim">Última</label> <input class="form-control"
									type="date" id="dataFim" name="dataFim" pattern="dd/MM/yyyy"
									value="${conta.dataFim}" />
							</div>
						</div>
						<div class="row">
							<div class="col-md-4">
								<legend>Total</legend>
								<h4>
									<p id="total"></p>
								</h4>
								<small class="text-muted">(valor da parcela X quantidade
									de parcelas)</small>
							</div></br></br>
							<div class="col-md-4">
								<legend>Observações</legend>
								<textarea rows="10" cols="50" class="form-control" id="observacao" name="observacao">${conta.observacao}</textarea>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<script src="<c:url value="/resources/js/script.js"/>"></script>
</body>
<%-- <jsp:include page="../template/footer.jsp" /> --%>
</html>