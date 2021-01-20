<%@page import="br.com.eventosbook.constante.Constantes"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page import="br.com.eventosbook.util.BibliotecaUrl"%>
<!DOCTYPE html>

<!--[if IE 8]> <html lang="en" class="ie8 no-"/>"  <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-"/>"  <![endif]-->
<!--[if !IE]><!-->
<html lang="en">
<!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
<meta charset="utf-8"/>
<title>EventosBook |Cadastro </title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1.0" name="viewport"/>
<meta http-equiv="Content-type" content="text/html; charset=utf-8">
<meta content="" name="description"/>
<meta content="" name="author"/>
<!-- BEGIN GLOBAL MANDATORY STYLES -->
<link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700&subset=all" rel="stylesheet" type="text/css"/>
<link href="<c:url value = "/resources/metronic/assets/global/plugins/font-awesome/css/font-awesome.min.css"/>" rel="stylesheet" type="text/css"/>
<link href="<c:url value = "/resources/metronic/assets/global/plugins/simple-line-icons/simple-line-icons.min.css" />"rel="stylesheet" type="text/css"/>
<link href="<c:url value = "/resources/metronic/assets/global/plugins/bootstrap/css/bootstrap.min.css" />"rel="stylesheet" type="text/css"/>
<link href="<c:url value = "/resources/metronic/assets/global/plugins/uniform/css/uniform.default.css" />"rel="stylesheet" type="text/css"/>
<!-- END GLOBAL MANDATORY STYLES -->
<!-- BEGIN PAGE LEVEL STYLES -->
<link href="<c:url value = "/resources/metronic/assets/global/plugins/select2/select2.css" />"rel="stylesheet" type="text/css"/>
<link href="<c:url value = "/resources/metronic/assets/admin/pages/css/login3.css" />"rel="stylesheet" type="text/css"/>
<!-- END PAGE LEVEL SCRIPTS -->
<!-- BEGIN THEME STYLES -->
<link href="<c:url value = "/resources/metronic/assets/global/css/components-rounded.css" />"id="style_components" rel="stylesheet" type="text/css"/>
<link href="<c:url value = "/resources/metronic/assets/global/css/plugins.css" />"rel="stylesheet" type="text/css"/>
<link href="<c:url value = "/resources/metronic/assets/admin/layout/css/layout.css" />"rel="stylesheet" type="text/css"/>
<link href="<c:url value = "/resources/metronic/assets/admin/layout/css/themes/default.css" />"rel="stylesheet" type="text/css" id="style_color"/>
<link href="<c:url value = "/resources/metronic/assets/admin/layout/css/custom.css" />"rel="stylesheet" type="text/css"/>
<!-- END THEME STYLES -->
<link rel="shortcut icon" href="favicon.ico"/>
</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body class="login">
<!-- BEGIN LOGO -->
<div class="logo">
</div>
<!-- END LOGO -->
<!-- BEGIN SIDEBAR TOGGLER BUTTON -->
<div class="menu-toggler sidebar-toggler">
</div>
<!-- END SIDEBAR TOGGLER BUTTON -->
<!-- BEGIN LOGIN -->
<div class="content">
	<!-- BEGIN REGISTRATION FORM -->
	<form class="register-form-contratante" action="<%=Constantes.LINK_EFETUAR_CADASTRO_CONTRATANTE%>" method="post">
	<c:if test="${usuarioJaCadastrado eq true}">
					<div class="alert alert-danger alert-dismissable">
					<button class="close" data-close="alert"></button>
						<span>
							Este usuário ja está cadastrado!!!
						</span>
					</div>
				</c:if>
				
				<c:if test="${erroInesperado eq true}">
					<div class="alert alert-danger alert-dismissable">
					<button class="close" data-close="alert"></button>
						<span>
							Erro: ${erro}
							Erro: ${erro2}
						</span>
					</div>
				</c:if>
				
				
				
		<h3>Cadastro Contratante</h3>
		<p>
			 Digite suas informações pessoais
		</p>
		<div class="form-group">
			<label class="control-label visible-ie8 visible-ie9">Full Name</label>
			<div class="input-icon">
				<i class="fa fa-font"></i>
				<input class="form-control placeholder-no-fix" type="text" placeholder="Nome Completo" name="nome" onkeydown="focusProxElementoOnEnter(event, 'email');"/>
			</div>
		</div>
		<div class="form-group">
			<!--ie8, ie9 does not support html5 placeholder, so we just show field title for that-->
			<label class="control-label visible-ie8 visible-ie9">Email</label>
			<div class="input-icon">
				<i class="fa fa-envelope"></i>
				<input class="form-control placeholder-no-fix" type="text" placeholder="Email" name="email" id="email" onkeydown="focusProxElementoOnEnter(event, 'register_password');"/>
			</div>
		</div>
		
		<p>
			 Digite os dados da conta:
		</p>

		<div class="form-group">
			<label class="control-label visible-ie8 visible-ie9">Password</label>
			<div class="input-icon">
				<i class="fa fa-lock"></i>
				<input class="form-control placeholder-no-fix" type="password" autocomplete="off" id="register_password" placeholder="Senha" name="senha" onkeydown="focusProxElementoOnEnter(event, 'confirmsenha');"/>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label visible-ie8 visible-ie9">Re-type Your Password</label>
			<div class="controls">
				<div class="input-icon">
					<i class="fa fa-check"></i>
					<input class="form-control placeholder-no-fix" type="password" autocomplete="off" placeholder="Repita a senha" name="confirmSenha" id="confirmSenha"/>
				</div>
			</div>
		</div>
		<!--<div class="form-group">
			<label>
			<input type="checkbox" name="tnc"/> I agree to the <a href="javascript:;">
			Terms of Service </a>
			and <a href="javascript:;">
			Privacy Policy </a>
			</label>
			<div id="register_tnc_error">
			</div>
		</div>-->
		<div class="form-actions">
					<a href="<%=BibliotecaUrl.getInstance().getUrl(Constantes.LINK_USUARIO_CONTROLADOR, Constantes.LINK_LOGIN)%>" id="back-btn-recuperarConta" class="btn blue-book ">
					<i class="m-icon-swapleft m-icon-white"></i> Voltar
				</a>
			<button type="submit" id="register-submit-btn" class="btn blue-book pull-right">
			Confirmar <i class="m-icon-swapright m-icon-white"></i>
			</button>
		</div>
	</form>
	<!-- END REGISTRATION FORM -->
</div>
<!-- END LOGIN -->
<!-- BEGIN COPYRIGHT -->
<div class="copyright">
	 2015 &copy; Eventosbook.
</div>
<!-- END COPYRIGHT -->
<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->
<!-- BEGIN CORE PLUGINS -->
<!--[if lt IE 9]>
<script src="<c:url value = "/resources/metronic/assets/global/plugins/respond.min."/>" </script>
<script src="<c:url value = "/resources/metronic/assets/global/plugins/excanvas.min."/>" </script> 
<![endif]-->
<script src="<c:url value = "/resources/metronic/assets/global/plugins/jquery.min.js"/>" type="text/javascript"></script>
<script src="<c:url value = "/resources/metronic/assets/global/plugins/jquery-migrate.min.js" />"type="text/javascript"></script>
<script src="<c:url value = "/resources/metronic/assets/global/plugins/bootstrap/js/bootstrap.min.js" />"type="text/javascript"></script>
<script src="<c:url value = "/resources/metronic/assets/global/plugins/jquery.blockui.min.js" />"type="text/javascript"></script>
<script src="<c:url value = "/resources/metronic/assets/global/plugins/uniform/jquery.uniform.min.js" />"type="text/javascript"></script>
<script src="<c:url value = "/resources/metronic/assets/global/plugins/jquery.cokie.min.js" />"type="text/javascript"></script>
<!-- END CORE PLUGINS -->
<!-- BEGIN PAGE LEVEL PLUGINS -->
<script src="<c:url value = "/resources/metronic/assets/global/plugins/jquery-validation/js/jquery.validate.min.js"/>" type="text/javascript"></script>
<script src="<c:url value = "/resources/metronic/assets/global/plugins/select2/select2.min.js"/> " type="text/javascript" ></script>
<!-- END PAGE LEVEL PLUGINS -->
<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script src="<c:url value = "/resources/metronic/assets/global/scripts/metronic.js" />"type="text/javascript"></script>
<script src="<c:url value = "/resources/metronic/assets/admin/layout/scripts/layout.js" />"type="text/javascript"></script>
<script src="<c:url value = "/resources/metronic/assets/admin/layout/scripts/demo.js" />"type="text/javascript"></script>
<script src="<c:url value = "/resources/metronic/assets/admin/pages/scripts/login.js" />"type="text/javascript"></script>
<!-- END PAGE LEVEL SCRIPTS -->
<script type="text/javascript" src="<c:url value="/resources/js/bibliotecaFuncao.js"/>"></script>


<script>
jQuery(document).ready(function() {     
  Metronic.init(); // init metronic core components
  Layout.init(); // init current layout
  Login.init();
});
</script>
<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>