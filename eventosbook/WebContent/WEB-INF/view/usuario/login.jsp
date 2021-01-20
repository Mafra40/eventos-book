<%@page import="br.com.eventosbook.constante.Constantes"%>
<%@page import="br.com.eventosbook.util.BibliotecaUrl"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>

<!--[if IE 8]> <html lang="en" class="ie8 no-"/>"  <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-"/>"  <![endif]-->
<!--[if !IE]><!-->
<html lang="en">
<!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
<meta charset="utf-8" />
<title>EventosBook | Login Options</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1.0" name="viewport" />
<meta http-equiv="Content-type" content="text/html; charset=utf-8">
<meta content="" name="description" />
<meta content="" name="author" />
<!-- BEGIN GLOBAL MANDATORY STYLES -->

<link
	href="<c:url value = "/resources/metronic/assets/global/plugins/font-awesome/css/font-awesome.min.css"/>"
	rel="stylesheet" type="text/css" />
<link
	href="<c:url value = "/resources/metronic/assets/global/plugins/simple-line-icons/simple-line-icons.min.css" />"
	rel="stylesheet" type="text/css" />
<link
	href="<c:url value = "/resources/metronic/assets/global/plugins/bootstrap/css/bootstrap.min.css" />"
	rel="stylesheet" type="text/css" />
<link
	href="<c:url value = "/resources/metronic/assets/global/plugins/uniform/css/uniform.default.css" />"
	rel="stylesheet" type="text/css" />
<!-- END GLOBAL MANDATORY STYLES -->
<!-- BEGIN PAGE LEVEL STYLES -->
<link
	href="<c:url value = "/resources/metronic/assets/global/plugins/select2/select2.css" />"
	rel="stylesheet" type="text/css" />
<link
	href="<c:url value = "/resources/metronic/assets/admin/pages/css/login3.css" />"
	rel="stylesheet" type="text/css" />
<!-- END PAGE LEVEL SCRIPTS -->
<!-- BEGIN THEME STYLES -->
<link
	href="<c:url value = "/resources/metronic/assets/global/css/components-rounded.css" />"
	id="style_components" rel="stylesheet" type="text/css" />
<link
	href="<c:url value = "/resources/metronic/assets/global/css/plugins.css" />"
	rel="stylesheet" type="text/css" />
<link
	href="<c:url value = "/resources/metronic/assets/admin/layout/css/layout.css" />"
	rel="stylesheet" type="text/css" />
<link
	href="<c:url value = "/resources/metronic/assets/admin/layout/css/themes/default.css" />"
	rel="stylesheet" type="text/css" id="style_color" />
<link
	href="<c:url value = "/resources/metronic/assets/admin/layout/css/custom.css" />"
	rel="stylesheet" type="text/css" />
<!-- END THEME STYLES -->
<link rel="shortcut icon" href="favicon.ico" />
</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body class="login">
	<!-- BEGIN LOGO -->
	<div class="logo"></div>
	<!-- END LOGO -->
	<!-- BEGIN SIDEBAR TOGGLER BUTTON -->
	<div class="menu-toggler sidebar-toggler"></div>
	<!-- END SIDEBAR TOGGLER BUTTON -->
	<!-- BEGIN LOGIN -->
	<div class="content">
		<!-- BEGIN LOGIN FORM -->
		<form class="login-form" action="<%=Constantes.LINK_EFETUAR_LOGIN%>"
			method="post">
			<h3 class="form-title">Faça seu login</h3>
			<div class="alert alert-danger display-hide">
				<button class="close" data-close="alert"></button>
				<span> Favor preencher os campos abaixo "Email" e "Senha" </span>
			</div>

			<div class="box-alerts">

				<c:if test="${logout eq true}">
					<div class="alert alert-success alert-dismissable">
						<button class="close" data-close="alert"></button>
						<span>Obrigado por acessar o EventosBook, esperamos você em breve.</span>
					</div>
				</c:if>
				<c:if test="${senhaAlterada eq true}">
					<div class="alert alert-success alert-dismissable">
					<button class="close" data-close="alert"></button>
						<p>Senha alterada com sucesso!!!</p>
						<p>Faça seu login!!!</p>
					</div>

				</c:if>

				<c:if test="${usuarioNaoEncontrado eq true}">
					<div class="alert alert-danger alert-dismissable">
					<button class="close" data-close="alert"></button>
						<span>
							Usuario ou Senha Inválidos,
							por favor tente novamente, ou esta área não pertence a seu perfil
						</span>
					</div>
				</c:if>

				<c:if test="${loginInvalido eq true}">
					<div class="alert alert-danger alert-dismissable">
						<button class="close" data-close="alert"></button>
						<span>Usuario ou Senha Inválidos, por favor tente novamente, ou esta área não pertence a seu perfil</span>
					</div>

				</c:if>
				
				<c:if test="${usuarioCadastrado eq true}">
					<div class="alert alert-success alert-dismissable">
						<button class="close" data-close="alert"></button>
						<span>Usuário cadastrado com sucesso, favor efetue o login</span>
					</div>

				</c:if>
				
				<c:if test="${erroInesperado eq true}">
					<div class="alert alert-success alert-dismissable">
						<button class="close" data-close="alert"></button>
						<span>Erro: ${erro}</span>
					</div>
				</c:if>
				


			</div>

			<div class="form-group">
				<!--ie8, ie9 does not support html5 placeholder, so we just show field title for that-->
				<label class="control-label visible-ie8 visible-ie9">Username</label>
				<div class="input-icon">
					<i class="fa fa-user"></i> <input
						class="form-control placeholder-no-fix" type="text"
						autocomplete="off" placeholder="Digite seu email" name="email" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label visible-ie8 visible-ie9">Password</label>
				<div class="input-icon">
					<i class="fa fa-lock"></i> <input
						class="form-control placeholder-no-fix" type="password"
						autocomplete="off" placeholder="Digite sua senha" name="senha" />
				</div>
			</div>
			<div class="form-actions">
				<label class="checkbox"> <input type="checkbox"
					name="remember" value="1" /> Lembre me
				</label>
				<button type="submit" class="btn blue-book pull-right">
					Login <i class="m-icon-swapright m-icon-white"></i>
				</button>
			</div>

			<div class="form-actions">
				<a href="<%=BibliotecaUrl.getInstance().getUrl(Constantes.LINK_CONTRATANTE_CONTROLADOR, Constantes.LINK_CADASTRAR_CONTRATANTE)%>"
					class="btn blue-book btn-block">Cadastrar Contratante</a>
			</div>
			<div class="form-actions">
				<a href="<%=BibliotecaUrl.getInstance().getUrl(Constantes.LINK_FORNECEDOR_CONTROLADOR, Constantes.LINK_CADASTRAR_FORNECEDOR)%>"
					class="btn blue-book btn-block">Cadastrar Fornecedor</a>
			</div>



			<div class="forget-password">
				<h4>Esqueci minha senha</h4>
				<p>
					Para lembrar sua senha clique <a
						href="<%=Constantes.LINK_RECUPERACAO_CONTA%>" id="forget-password">
						aqui </a>.

				</p>
			</div>
		</form>
		<div></div>
		<!-- END LOGIN FORM -->
	</div>
	<!-- END LOGIN -->
	<!-- BEGIN COPYRIGHT -->
	<div class="copyright">2015 &copy; Eventosbook.</div>
	<!-- END COPYRIGHT -->
	<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->
	<!-- BEGIN CORE PLUGINS -->
	<!--[if lt IE 9]>
<script src="<c:url value = "/resources/metronic/assets/global/plugins/respond.min."/>" </script>
<script src="<c:url value = "/resources/metronic/assets/global/plugins/excanvas.min."/>" </script> 
<![endif]-->
	<script
		src="<c:url value = "/resources/metronic/assets/global/plugins/jquery.min.js"/>"
		type="text/javascript"></script>
	<script
		src="<c:url value = "/resources/metronic/assets/global/plugins/jquery-migrate.min.js" />"
		type="text/javascript"></script>
	<script
		src="<c:url value = "/resources/metronic/assets/global/plugins/bootstrap/js/bootstrap.min.js" />"
		type="text/javascript"></script>
	<script
		src="<c:url value = "/resources/metronic/assets/global/plugins/jquery.blockui.min.js" />"
		type="text/javascript"></script>
	<script
		src="<c:url value = "/resources/metronic/assets/global/plugins/uniform/jquery.uniform.min.js" />"
		type="text/javascript"></script>
	<script
		src="<c:url value = "/resources/metronic/assets/global/plugins/jquery.cokie.min.js" />"
		type="text/javascript"></script>
	<!-- END CORE PLUGINS -->
	<!-- BEGIN PAGE LEVEL PLUGINS -->
	<script
		src="<c:url value = "/resources/metronic/assets/global/plugins/jquery-validation/js/jquery.validate.min.js"/>"
		type="text/javascript"></script>
	<script
		src="<c:url value = "/resources/metronic/assets/global/plugins/select2/select2.min.js"/> "
		type="text/javascript"></script>
	<!-- END PAGE LEVEL PLUGINS -->
	<!-- BEGIN PAGE LEVEL SCRIPTS -->
	<script
		src="<c:url value = "/resources/metronic/assets/global/scripts/metronic.js" />"
		type="text/javascript"></script>
	<script
		src="<c:url value = "/resources/metronic/assets/admin/layout/scripts/layout.js" />"
		type="text/javascript"></script>
	<script
		src="<c:url value = "/resources/metronic/assets/admin/layout/scripts/demo.js" />"
		type="text/javascript"></script>
	<script
		src="<c:url value = "/resources/metronic/assets/admin/pages/scripts/login.js" />"
		type="text/javascript"></script>
	<!-- END PAGE LEVEL SCRIPTS -->
	<script>
		jQuery(document).ready(function() {
			Metronic.init(); // init metronic core components
			Layout.init(); // init current layout
			Login.init();
			Demo.init();
		});
	</script>
	<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>