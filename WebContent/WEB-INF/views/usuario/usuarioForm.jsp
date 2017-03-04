<%@ page language="java" contentType="text/html"%>
<%@include file="../../imports.jspf"%>
<!DOCTYPE html">
<html>
<head>
 <meta charset="UTF-8">
<jsp:include page="../template/header.jsp" />
<script src="<c:url value="/resources/js/script.js" />"></script>
<title>SGC - Cadastro</title>
<link href="<c:url value="/resources/css-custom/style.css"/>"
	rel="stylesheet" />
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="margem">
			<div class="col-md-4">
				<form class="form-group" method="post">
					<div class="form-group">
						<label for="nome">Nome</label> <input type="text"
							class="form-control" id="nome" name="nome" value="${usuario.nome}"
							placeholder="nome">
					</div>
					<div class="form-group">
						<label for="usuario">Usuário</label> <input type="text"
							class="form-control" id="usuario" name="usuario" value="${usuario.usuario}"
							placeholder="usuário">
					</div>
					<div class="form-group">
						<label for="password">Senha</label> <input type="password"
							class="form-control" id="password" name="password" value="${usuario.password}"
							placeholder="senha">
					</div>
					<div class="form-group">
						<label for="confirma_password">Confirmar senha</label> <input type="password"
							class="form-control" id="confirma_password"
							placeholder="confirmação de senha" oninput="comparaSenha();" >
							<div class="alert alert-danger" role="alert" id="senhaNaoConfere">Senhas não conferem!</div>		
					</div>
					<button type="submit" class="btn btn-success" id="buttonConfirmaCadastro">Confirmar</button>
				</form>
			</div>	
			</div>
		</div>	
	</div>
</body>
</html>