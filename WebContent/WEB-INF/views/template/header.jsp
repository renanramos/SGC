<%@ page language="java" contentType="text/html"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<title>SGC</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

<link href="<c:url value="/resources/css/bootstrap.css" />"
	rel="stylesheet" />
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/bootstrap-theme.css" />"
	rel="stylesheet" />
<link href="<c:url value="/resources/css/bootstrap-theme.min.css" />"
	rel="stylesheet" />
<link href="<c:url value="/resources/css-custom/style.css"/>"
	rel="stylesheet" />

<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="http://momentjs.com/downloads/moment-with-locales.min.js"></script>
<script src="<c:url value="/resources/js/jquery.maskedinput.min.js"/>"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
<script src="<c:url value="/resources/js/script.js"/>"></script>

<body>
	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Sistema de Gerenciamento de Contas</a>
			</div>
			<div class="nav navbar-nav navbar-right">
				<a class="navbar-brand" href="<c:url value="/conta/filtro"/>" title="Contas" >
					<span class="glyphicon glyphicon-list-alt" aria-hidden="true" title="Contas"></span>
				</a>
				<a class="navbar-brand" href="<c:url value="/usuario"/>" title="Usuários">
					<span class="glyphicon glyphicon-user" aria-hidden="true" title="Usuários"></span>&nbsp&nbsp${usuarioLogado.nome}
				</a>
				<a class="navbar-brand" href="<c:url value="/usuario/logout"/>">
					<span class="glyphicon glyphicon-log-out" aria-hidden="true" title="Sair"></span>&nbspSair
				</a>
			</div>
		</div>
	</nav>
</body>
</html>