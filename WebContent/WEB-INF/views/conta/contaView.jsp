<%@ page language="java" contentType="text/html"%>
<%@include file="../../imports.jspf"%>
<!DOCTYPE html">
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="../template/header.jsp" />
<title>SGC</title>
<link href="<c:url value="/resources/css-custom/style.css"/>"
	rel="stylesheet" />
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="margem">
				<legend>Contas</legend>
				<div class="col-md-8">
<!-- 					<form class="form-group" method="post"> -->
						<div class="form-group">
							<label for="descricao">Descrição</label> <input type="text"
								class="form-control" id="descricao" name="descricao"
								value="${conta.descricao}" placeholder="Descrição da conta" disabled>
						</div>
						<div class="form-group">
							<fmt:setLocale value="pt-BR" />
							<label for="valor">Valor R$</label> <input type="text"
								class="form-control" id="valor" name="valor"
								value="<fmt:formatNumber value="${conta.valor}" type="currency" pattern="R$ ###,###,#00.00"  currencySymbol="R$ "/>"
								placeholder="R$ 0,00" disabled/>
						</div>
						<div class="form-group">
							<label for="dataVencimento">Data de vencimento</label> <input
								class="form-control" type="date" name="dataVencimento"
								id="dataVencimento" pattern="dd/MM/yyyy"
								value="${conta.dataVencimento}" disabled/>
						</div>
						<div class="form-group">
							<label for="parcela">Nº. da Parcela</label> <input
								class="form-control" type="number" id="parcela" name="parcela"
								name="parcela" value="${conta.parcela}"
								oninput="atualizaParcelas();" disabled/>
						</div>
						<div class="form-group">
							<label for="dataPagamento">Data de pagamento</label> <input
								class="form-control" type="date" name="dataPagamento"
								name="dataPagamento" pattern="dd/MM/yyyy"
								value="${conta.dataPagamento}" disabled/>
						</div>

						<div class="form-group">
							<div class="input-group">
								<span class="input-group-addon"> 
								<input id="fixa" name="fixa" type="checkbox" aria-label="..."
								 <c:if test="${conta.fixa}">checked</c:if> disabled/>								 
								</span> <label class="form-control" aria-label="..." for="fixa">Esta é uma	conta fixa?</label>
							</div>
							<!-- /input-group -->
						</div>
						<a type="submit" class="btn btn-success" href="<c:url value="/conta/${conta.id}/editar"/>">Alterar</a>
						<a type="submit" class="btn btn-default"
							href="<c:url value="/conta/filtro"/>">Voltar</a>

<!-- 					</form> -->
				</div>
				<div class="row">
					<div class="col-md-4">
						<legend>Cadastro de parcelas</legend>
						<div class="form-group">
							<label for="dataInicio">Primeira</label> <input
								class="form-control" type="date" id="dataInicio"
								name="dataInicio" pattern="dd/MM/yyyy" value="${conta.dataInicio}" disabled/>
						</div>
						<div class="form-group">
							<label for="dataFim">Última</label> 
							<input class="form-control"
								type="date" id="dataFim" name="dataFim" pattern="dd/MM/yyyy"
								value="${conta.dataFim}" disabled/>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="<c:url value="/resources/js/script.js"/>"></script>
<jsp:include page="../template/footer.jsp" />
</body>
</html>