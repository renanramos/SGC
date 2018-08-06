<%@ page language="java" contentType="text/html"%>
<%@include file="../../imports.jspf"%>
<!DOCTYPE html">
<html>
<head>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<jsp:include page="../template/header.jsp" />
<title>SGC - Usuários</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="margem">
				<div class="col-lg-6">
					<div class="input-group">
						<input type="text" class="form-control"
							placeholder="Pesquisar por nome..."> <span
							class="input-group-btn">
							<button class="btn btn-defaulty" type="button">Pesquisar</button>
						</span>
					</div>
				</div>
				<div class="col-lg-6">
					<div class="input-group">
						<a class="btn btn-primary" type="button" href="<c:url value="/usuario/novo"/>">
							<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>&nbsp&nbspAdicionar
						</a>
					</div>
				</div>
				<table class="table table-hover">
					<thead>
						<tr>
							<td><b>#</b></td>
							<td><b>Nome</b></td>
							<td><b>Usuario</b></td>
							<td colspan="2" align="center"><b>Opções</b></td>
						</tr>
					</thead>
					<c:if test="${empty usuarios}">
						<h2>Não foram encontrados usuários cadastrados.</h2>
					</c:if>
					<c:forEach items="${usuarios}" var="usuario">
						<tbody>
							<td>${usuario.id}</td>
							<td>${usuario.nome}</td>
							<td>${usuario.username}</td>
							<td>
								<a href="usuario/${usuario.id}/editar"><span class="glyphicon glyphicon-pencil"></span></a>
							</td>
							<td>
								<a type="button"data-toggle="modal" data-target="#modal" data-whatever="${usuario.id}"><span class="glyphicon glyphicon-trash" ></span></a>
							</td>
						</tbody>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
	
	<!-- Modal -->
	<div class="modal fade" tabindex="-1" role="dialog" id="modal" data-backdrop="static">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header alert alert-danger">
					<button type="button" class="close" aria-label="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span>
					</button>		
					<p><h4>Você deseja realmente excluir?</h4></p>
				</div>
				<div class="modal-body">
					<h5 class="modal-title"></h5>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
					<a id="deleteLink" href="#" type="button" class="btn btn-danger">Sim, desejo excluir.</a>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->
	<script>
		$('#modal').on('show.bs.modal', function (event) {
			  var button = $(event.relatedTarget)
			  var cod = button.data('whatever') 
			  var modal = $(this)

			  modal.find('.modal-title').text('Atenção: esta operação não pode ser desfeita.')
			  modal.find('.modal-footer a').attr('href', 'usuario/'+cod+'/excluir');
		})
	</script>
</body>

</html>