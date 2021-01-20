<%@page import="br.com.eventosbook.constante.Constantes"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Cadastro Efetuado com sucesso</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/style_page.css" />" />
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/bootstrap/css/bootstrap.min.css" />" />
</head>

<body>

	<div class="row">
		<div class="col-sm-4"></div>

		<div class="col-sm-4">
			<div class="container-login">
				<div class="container-fluid">
					<p>Olá Cadastro realizado com sucesso verifique sua caixa de
						email para validar seu cadastro.</p>
				</div>
			</div>
		</div>
		<div class="col-sm-4"></div>
	</div>
</body>
<script type="text/javascript"
	src="<c:url value="/resources/bootstrap/js/bootstrap.min.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery-2.1.3.js"/>"></script>
</html>