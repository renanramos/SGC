<%@ page language="java" contentType="text/html"%>
<%@include file="../imports.jspf"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

<link href="<c:url value="/resources/css/bootstrap.css" />"
	rel="stylesheet" />
<link href="<c:url value="/resources/css/bootstrap.css.map" />"
	rel="stylesheet" />
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/bootstrap.min.css.map" />"
	rel="stylesheet" />
<link href="<c:url value="/resources/css/bootstrap-theme.css" />"
	rel="stylesheet" />
<link href="<c:url value="/resources/css/bootstrap-theme.css.map" />"
	rel="stylesheet" />
<link href="<c:url value="/resources/css/bootstrap-theme.min.css" />"
	rel="stylesheet" />
<link
	href="<c:url value="/resources/css/bootstrap-theme.min.css.map" />"
	rel="stylesheet" />
<link href="<c:url value="/resources/css-custom/style.css"/>"
	rel="stylesheet" />

<script src="<c:url value="/resources/js/bootstrap.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<title>SGC - Home</title>
</head>
<body class="login">
	<div class="container">
		<div class="form-login">
			<div class="row">
				<form action="home/login" method="post">
					<div class="form-group">
						<label for="usuario">Usuário</label> <input type="text"
							class="form-control" id="usuario" name="usuario" placeholder="Usuario">
					</div>
					<div class="form-group">
						<label for="password">Senha</label> <input type="password"
							class="form-control" id="password" name="password" placeholder="Senha">
					</div>
					<button class="btn btn-primary" type="submit">Acessar</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>