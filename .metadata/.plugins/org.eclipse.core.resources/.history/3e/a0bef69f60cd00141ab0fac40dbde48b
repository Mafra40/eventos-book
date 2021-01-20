<%@page import="br.com.eventosbook.constante.Constantes"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Login</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/style_page.css" />" />
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/bootstrap/css/bootstrap.min.css" />" />
<script type="text/javascript"
	src="<c:url value="/resources/bootstrap/js/bootstrap.min.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery-2.1.3.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/bibliotecaNavegacaoAjax.js"/>"></script>
</head>


<body>

	<div class="row">
		<div class="col-sm-4"></div>

		<div class="col-sm-4">
			<div class="container-fluid">
				<form class="form-horizontal"
					action="<%=Constantes.LINK_EFETUAR_LOGIN%>" method="POST">
					<div class="form-group">

						<input type="email" class="form-control input-lg" id="inputEmail3"
							placeholder="Digite seu email" name="email" />
						<form:errors path="usuario.email" cssStyle="color:red" />

					</div>

					<div class="form-group">

						<input type="password" class="form-control input-lg"
							id="inputPassword3" placeholder="Digite sua Senha" name="senha" />
						<form:errors path="usuario.senha" cssStyle="color:red" />
					</div>

					<div class="form-group">

						<input type="submit" id="btnLogin" class="btn btn-primary"
							value="Login">

					</div>

					<div class="form-group">

						<a href="<%=Constantes.LINK_CADASTRAR_CONTRATANTE %>" id="btnCadastrar" class="btn btn-primary">Cadastrar-se</a>

					</div>


					<div class="form-group" id="btnLink">

						<a href="<%=Constantes.LINK_RECUPERACAO_CONTA%>"
							class="btn btn-link">Esqueci a Senha </a>

					</div>
				</form>
			</div>
		</div>

		<div class="col-sm-4"></div>
	</div>

</body>
</html>