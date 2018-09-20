<%@ page language="java" contentType="text/html"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta charset="UTF-8">
<title>SGC</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

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

<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet" />

<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="http://momentjs.com/downloads/moment-with-locales.min.js"></script>
<script src="<c:url value="/resources/js/jquery.maskedinput.min.js"/>"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
<script src="<c:url value="/resources/js/script.js"/>"></script>

<body>
	<nav class="navbar navbar-default navbar-fixed-top navbar-inverse">
		<div class="container">
			<div class="navbar-header">				
				<span class="navbar-brand"><i class="fa fa-empire fa-1x"></i>  Sistema de Gerenciamento de Contas</span>
			</div>
			<div class="nav navbar-nav navbar-right">
				<a class="navbar-brand" href="<c:url value="/conta/filtro"/>" title="Contas" >
					<span class="fa fa-calculator" aria-hidden="true" title="Contas"> Contas</span>
				</a>
				<c:if test="${usuarioLogado.username != 'admin'}">
					<a class="navbar-brand" href="<c:url value="/usuario/${usuarioLogado.id}/view"/>" title="Perfil">
						<span class="fa fa-user-circle" aria-hidden="true" title="Perfil"> ${usuarioLogado.nome}</span>
					</a>
				</c:if>
				<c:if test="${usuarioLogado.username == 'admin'}">
					<a class="navbar-brand" href="<c:url value="#"/>" title="Gerencia de caixa">
						<span class="fa fa-money" aria-hidden="true" title="Gerencia de caixa"> Caixa</span>
					</a>
					<a class="navbar-brand" href="<c:url value="/usuario"/>" title="Lista de usuários">
						<span class="fa fa-group" aria-hidden="true" title="Lista de usuários"> Usuarios</span>
					</a>
				</c:if>				
				<a class="navbar-brand" href="<c:url value="/usuario/logout"/>">
					<span class="glyphicon glyphicon-log-out" aria-hidden="true" title="Sair"> Sair</span>
				</a>
			</div>
						
		</div>
	</nav>
</body>
</html>