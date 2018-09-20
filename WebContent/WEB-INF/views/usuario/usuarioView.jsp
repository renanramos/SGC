<%@ page language="java" contentType="text/html"%>
<%@include file="../../imports.jspf"%>
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="../template/header.jsp" />
<title>SGC - Usuário</title>
<link href="<c:url value="/resources/css-custom/style.css"/>"
	rel="stylesheet" />
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="margem">
				<div class="col-md-2"></div>
				<div class="col-md-8">
					<legend>Usuário</legend>
					<div class="form-group">
						<label for="nome">Nome</label> <input type="text"
							class="form-control" id="nome" name="nome" value="${usuario.nome}"
							placeholder="nome" readonly="readonly">
					</div>
					<div class="form-group">
						<label for="usuario">Usuário</label> <input type="text"
							class="form-control" id="usuario" name="username" value="${usuario.username}"
							placeholder="usuário" readonly="readonly">
					</div>
					<div class="form-group">
						<label for="password">Senha</label> <input type="password"
							class="form-control" id="password" name="password" value="${usuario.password}"
							placeholder="senha" readonly="readonly">
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>