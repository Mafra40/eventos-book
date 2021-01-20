<%@page import="br.com.eventosbook.constante.Constantes"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Cadastro</title>
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
				<form action="<%=Constantes.LINK_EFETUAR_CADASTRO_CONTRATANTE%>" method="POST" class="form-horizontal">
					<div class="form-group">

						<div class="form-group">
							<input type="text" class="form-control input-lg" id="inputName3"
								placeholder="Digite seu Nome Completo" name="nome" />

							<form:errors path="formulario.nome" cssStyle="color:red" />

						</div>
						
						<div class="form-group">
							<input type="text" class="form-control input-lg" id="inputCPF3"
								placeholder="CPF" name="numeroDocumento" />

							<form:errors path="formulario.numeroDocumento" cssStyle="color:red" />

						</div>

						<div class="form-group">
							<input type="email" class="form-control input-lg"
								id="inputEmail3" placeholder="Digite seu email" name="email" />

							<form:errors path="formulario.email" cssStyle="color:red" />
						</div>

						<div class="form-group">

							<input type="password" class="form-control input-lg"
								id="inputPassword3" placeholder="Digite uma senha" name="senha" />
							<form:errors path="formulario.senha" cssStyle="color:red" />
						</div>

						<div class="form-group">

							<input type="password" class="form-control input-lg"
								id="inputPassword3" placeholder="Confirme sua senha"
								name="confirmSenha" />
							<form:errors path="formulario.confirmSenha" cssStyle="color:red" />
						</div>

						<div class="form-group">

							
						<input type="submit" id="btnCadastrar" class="btn btn-primary"
							value="Confirmar">

						</div>

					</div>
				</form>
			</div>
		</div>
		<div class="col-sm-4"></div>
	</div>

</body>
</html>