<%@ page language="java" contentType="text/html"%>
<%@include file="../../imports.jspf"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../template/header.jsp" />
<title>SGC - Conta</title>
<link href="<c:url value="/resources/css-custom/style.css"/>"
	rel="stylesheet" />
</head>
<body>
	<div class="margem"></div>
	<div class="container">
		<div class="page-header">
			<h3>
				Contas <small>registradas no sistema.</small>
			</h3>
		</div>
		<div class="row">
			<div class="col-md-7">
				<form method="post" action="<c:url value="/conta/filtro"/>">
					<legend>
						<span class="glyphicon glyphicon-filter" aria-hidden="true"></span>&nbspFiltro
					</legend>
					<div class="col-md-4">
						<div class="input-group input-group-md">
							De:<input type="date" id="dataInicial" class="form-control"
								name="dataInicial" pattern="dd/MM/yyyy" value="${dataInicial}" />
						</div>
					</div>
					<div class="col-md-4">
						<div class="input-group input-group-md">
							Até:<input type="date" id="dataFim" class="form-control"
								name="dataFim" pattern="dd/MM/yyyy" value="${dataFim}" />
						</div>
					</div>
					<div class="col-md-4">
						&nbsp
						<div class="input-group">
							<button class="btn btn-primary" type="submit" data-toggle="tooltip" data-placement="top" title="Filtro por período">Aplicar
								filtro</button>
						</div>
					</div>
				</form>
			</div>
			<div class="col-md-5">
				<legend>
					<span class="glyphicon glyphicon-search" aria-hidden="true"></span>&nbspPesquisa
				</legend>
				<div class="col-md-10">
					&nbsp
					<form class="form-horizontal" action="<c:url value="/conta/mes"/>"
						method="post">
						<div class="input-group">
							<select id="mes" name="mes" class="form-control" onchange="this.form.submit()">
								<option>${mesSelecionado}</option>
								<c:forEach items="${meses}" var="mes" varStatus="index">
									<option>${mes}</option>
									<!--  -  -->
								</c:forEach>
							</select>
							<div class="input-group-btn">
								<button class="btn btn-default" type="submit" data-toggle="tooltip" data-placement="top" title="Fazer pesquisa por mês">GO!</button>
							</div>
						</div>
					</form>
				</div>
			</div>
			<div class="col-lg-12">
				<div class="col-md-6"></div>
				<div class="col-md-6"></div>
				</br> </br>
				<table class="table table-hover table-striped" id="table">
					<c:choose>
						<c:when test="${empty contas}">
							<legend>Nenhuma conta registrada!</legend>
							<br />
						</c:when>
						<c:otherwise>
							<thead>
								<tr>
									<td class="td-table"><b>Descrição</b></td>
									<td class="td-table"><b>Valor</b></td>
									<td class="td-table"><b>Data Pagamento</b></td>
									<td class="td-table"><b>Data Vencimento</b></td>
									<td class="td-table"><b>Parcela</b></td>
									<td class="td-table"><b>Pagar</b></td>
									<td colspan="3" class="td-table"><b>Opções</b></td>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${contas}" var="conta">
									<tr id="listaContas" class="active">
										<td>${conta.descricao}</td>
										<td><c:set var="valor" value="${conta.valor}" /> <fmt:setLocale
												value="pt_BR" scope="application" /> <fmt:formatNumber
												value="${valor}" type="currency" pattern="R$ ###,###,#00.00"
												currencySymbol="R$ " /></td>
										<td class="td-table" id="idPagar"><input id="dataPag"
											value="${conta.dataPagamento}" type="hidden" /> <fmt:formatDate
												value="${conta.dataPagamento}" pattern="dd/MM/yyyy" /> <c:if
												test="${!empty conta.dataPagamento}">
												<span class="glyphicon glyphicon-ok"></span>
											</c:if></td>
										<td class="td-table"><input id="dataVenc"
											value="${conta.dataVencimento}" type="hidden" /> <fmt:formatDate
												value="${conta.dataVencimento}" pattern="dd/MM/yyyy" /> <c:if
												test="${empty conta.dataVencimento}">
												<span class="glyphicon glyphicon-minus"></span>
											</c:if></td>
										<td class="td-table">${conta.parcela}</td>
										<td class="td-table">											
											<a id="labelPagar" class="label label-warning"
												type="button" data-toggle="modal" data-target="#modalPagar"
												data-whatever="${conta.id}">
												<span id="iconPagar" class="glyphicon glyphicon-refresh" data-toggle="tooltip" data-placement="top" title="Pagar"></span>
											</a>
										</td>
										<td class="td-table"><a class="label label-info"
											href="<c:url value="/conta/${conta.id}/view"/>"><span
												class="glyphicon glyphicon-eye-open" data-toggle="tooltip" data-placement="top" title="Visualizar"></span></a></td>
										<td class="td-table"><a class="label label-primary"
											href="<c:url value="/conta/${conta.id}/editar"/>"><span class="glyphicon glyphicon-pencil" data-toggle="tooltip" data-placement="top" title="Editar"></span></a></td>
										<td class="td-table"><a class="label label-danger"
											type="button" data-toggle="modal" data-target="#modal"
											data-whatever="${conta.id}"><span
												class="glyphicon glyphicon-trash" data-toggle="tooltip" data-placement="top" title="Excluir"></span></a></td>
									</tr>
								</c:forEach>
							</tbody>
							<br />
						</c:otherwise>
					</c:choose>
				</table>
				<div class="panel panel-default">
					<div class="col-md-10">
						<div class="panel-body">
							<h3>
								Total:&nbsp&nbsp
								<fmt:formatNumber value="${total}" type="currency"
									pattern="R$ ###,###,#00.00" currencySymbol="R$ " />
							</h3>
						</div>
					</div>
					<div class="col-md-2">
						&nbsp
						<div class="input-group">
							<a class="btn btn-primary btn-lg" type="button"
								href="<c:url value="/conta/novo"/>">Adicionar</a>
						</div>
					</div>
				</div>
			</div>
		</div>
		</br>
	</div>
	<!-- Modal Excluir-->
	<div class="modal fade" tabindex="-1" role="dialog" id="modal"
		data-backdrop="static">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header alert alert-danger">
					<button type="button" class="close" aria-label="close"
						data-dismiss="modal">
						<span aria-hidden="true">&times;</span>
					</button>
					<p>
					<h4>Você deseja realmente excluir?</h4>
					</p>
				</div>
				<div class="modal-body">
					<h4 class="modal-title"></h4>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
					<a id="deleteLink" href="#" type="button" class="btn btn-danger">Sim,
						desejo excluir.</a>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal excluir-->

	<!-- Modal Pagar-->
	<div class="modal fade" tabindex="-1" role="dialog" id="modalPagar"
		data-backdrop="static">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header alert alert-default">
					<button type="button" class="close" aria-label="close"
						data-dismiss="modal">
						<span aria-hidden="true">&times;</span>
					</button>
					<p>
					<h4>Pagamento de conta</h4>
					</p>
				</div>
				<div class="modal-body">
					<h5 class="modal-title"></h5>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
					<a id="pagarLink" href="#" type="button" class="btn btn-success">Pagar</a>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal pagar-->

	<script>
		$('#modal').on(
				'show.bs.modal',
				function(event) {
					var button = $(event.relatedTarget)
					var cod = button.data('whatever')
					var modal = $('#modal')
					console.log('Aqui');
					modal.find('.modal-title').text(
							'Atenção: esta operação não pode ser desfeita.')
					modal.find('.modal-footer a').attr('href',
							'<c:url value="/conta/' + cod + '/excluir"/>');
				});

		$('#modalPagar').on(
				'show.bs.modal',
				function(event) {
					var buttonPagar = $(event.relatedTarget)
					var codPagar = buttonPagar.data('whatever')
					var modalPagar = $('#modalPagar')
					console.log('Aqui');
					modalPagar.find('.modal-title').text(
							'Efetuar pagamento de conta.');
					modalPagar.find('.modal-footer a').attr('href',
							'<c:url value="/conta/' + codPagar + '/pagar"/>');

				});
	</script>
</body>
<%-- <jsp:include page="../template/footer.jsp" /> --%>
</html>