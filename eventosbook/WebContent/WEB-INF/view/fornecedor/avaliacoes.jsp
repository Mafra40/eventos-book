<%@page import="br.com.eventosbook.constante.Constantes"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page import="br.com.eventosbook.util.BibliotecaUrl"%>
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en">
<!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
<meta charset="utf-8"/>
<title>EventosBook</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1.0" name="viewport"/>
<meta http-equiv="Content-type" content="text/html; charset=utf-8">
<meta content="" name="description"/>
<meta content="" name="author"/>
<!-- BEGIN GLOBAL MANDATORY STYLES -->
<link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700&subset=all" rel="stylesheet" type="text/css">
<link href="<c:url value = "/resources/metronic/assets/global/plugins/font-awesome/css/font-awesome.min.css"/>" rel="stylesheet" type="text/css">
<link href="<c:url value = "/resources/metronic/assets/global/plugins/simple-line-icons/simple-line-icons.min.css"/>" rel="stylesheet" type="text/css">
<link href="<c:url value = "/resources/metronic/assets/global/plugins/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet" type="text/css">
<link href="<c:url value = "/resources/metronic/assets/global/plugins/uniform/css/uniform.default.css"/>" rel="stylesheet" type="text/css">
<link href="<c:url value = "/resources/metronic/assets/global/plugins/bootstrap-switch/css/bootstrap-switch.min.css"/>" rel="stylesheet" type="text/css"/>
<!-- END GLOBAL MANDATORY STYLES -->
<!-- BEGIN PAGE LEVEL STYLES -->
<link rel="stylesheet" type="text/css" href="<c:url value = "/resources/metronic/assets/global/plugins/bootstrap-wysihtml5/bootstrap-wysihtml5.css"/>"/>
<link rel="stylesheet" type="text/css" href="<c:url value = "/resources/metronic/assets/global/plugins/bootstrap-markdown/css/bootstrap-markdown.min.css"/>">
<!-- END PAGE LEVEL SCRIPTS -->
<!-- BEGIN THEME STYLES -->
<link href="<c:url value = "/resources/metronic/assets/global/css/components-rounded.css"/>" id="style_components" rel="stylesheet" type="text/css"/>
<link href="<c:url value = "/resources/metronic/assets/global/css/plugins.css"/>" rel="stylesheet" type="text/css"/>
<link href="<c:url value = "/resources/metronic/assets/admin/layout4/css/layout.css"/>" rel="stylesheet" type="text/css"/>
<link id="style_color" href="<c:url value = "/resources/metronic/assets/admin/layout4/css/themes/light.css"/>" rel="stylesheet" type="text/css"/>
<link href="<c:url value = "/resources/metronic/assets/admin/layout4/css/custom.css"/>" rel="stylesheet" type="text/css"/>
<!-- END THEME STYLES -->
<link rel="shortcut icon" href="favicon.ico"/>
<script type="text/javascript"
	src="<c:url value="/resources/js/bibliotecaFuncao.js"/>"></script>
</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->

<body class="page-header-fixed page-sidebar-closed-hide-logo">

<%@include file="../contratante/cabecalho.jsp"%>

<!-- BEGIN CONTAINER -->
<div class="page-container">

	<%@include file="../contratante/menu.jsp"%>
	
	<!-- BEGIN CONTENT -->
	<div class="page-content-wrapper">
		<div class="page-content">
			
			<!-- BEGIN PAGE HEADER-->
			<!-- BEGIN PAGE HEAD -->
			<div class="page-head">
				<!-- BEGIN PAGE TITLE -->
				<div class="page-title">
					<h1>${fornecedor.nome}  
					<small></small></h1>
				</div>
				<!-- END PAGE TITLE -->
				
			</div>
			<!-- END PAGE HEAD -->
			<!-- BEGIN PAGE BREADCRUMB -->
			<ul class="page-breadcrumb breadcrumb">
				<li>
					<a href="<%=BibliotecaUrl.getInstance().getUrl(Constantes.LINK_FORNECEDOR_CONTROLADOR, Constantes.LINK_HOME_FORNECEDOR)%>">Home</a>
					<i class="fa fa-circle"></i>
				</li>
				
				
			</ul>
			
			
			<!-- END PAGE BREADCRUMB -->
			<div class="row">
				<div class="col-md-12">
					
					<div class="row">
						<div class="col-md-12">
				
							<div class="row">
				<div class="col-md-12">
				
					<div class="col-md-2"> <!-- style="position: fixed; width: -150px;" -->
							<!-- BEGIN Portlet PORTLET-->
							<div class="portlet light bordered">
								<div class="portlet-title">
									<div class="caption font-blue">
										
										<span class="caption-subject bold uppercase">Avaliação Final</span>
									</div>
									
								</div>
								<div class="portlet-body">
										${nota}
										<p>
											Baseado em ${qtdAvaliacoes} avaliações. 
										</p>
										
									
								</div>
							</div>
							<!-- END Portlet PORTLET-->
						</div>
							<div class="note note-info col-md-10">
								<h4 class="block">${fornecedor.nome} ${estrelas}</h4>
								<p>
									${endereco.logradouro}<c:if test="${not empty endereco.numero}">, Nº ${endereco.numero} </c:if>, ${endereco.cidade.descricao}, ${endereco.cidade.estado.sigla} CEP: ${endereco.cep}<br />
								</p>
							</div>
				
							<c:forEach items="${comentario}" var="c">${c}</c:forEach>				
				
					
						
				</div>
			</div>
				
					
						</div>
					</div>
			<!-- END PAGE CONTENT-->
			
			
								</div>
							</div>
				</div>
			</div>
			<!-- END PAGE CONTENT-->
		</div>
	</div>
	<!-- END CONTENT -->
</div>
<!-- END CONTAINER -->
<!-- BEGIN FOOTER -->
<div class="page-footer">
	<div class="copyright">
		 2015 &copy; EventosBook.
	</div>
	<div class="scroll-to-top">
		<i class="icon-arrow-up"></i>
	</div>
</div>
<!-- END FOOTER -->
<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->
<!-- BEGIN CORE PLUGINS -->
<!--[if lt IE 9]>
<script src="<c:url value = "/resources/metronic/assets/global/plugins/respond.min.js" />"></script>
<script src="<c:url value = "/resources/metronic/assets/global/plugins/excanvas.min.js" />"></script> 
<![endif]-->
<script src="<c:url value = "/resources/metronic/assets/global/plugins/jquery.min.js" />" type="text/javascript"></script>
<script src="<c:url value = "/resources/metronic/assets/global/plugins/jquery-migrate.min.js" />" type="text/javascript"></script>
<!-- IMPORTANT! Load jquery-ui.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->
<script src="<c:url value = "/resources/metronic/assets/global/plugins/jquery-ui/jquery-ui.min.js" />" type="text/javascript"></script>
<script src="<c:url value = "/resources/metronic/assets/global/plugins/bootstrap/js/bootstrap.min.js" />" type="text/javascript"></script>
<script src="<c:url value = "/resources/metronic/assets/global/plugins/bootstrap-hover-dropdown/bootstrap-hover-dropdown.min.js" />" type="text/javascript"></script>
<script src="<c:url value = "/resources/metronic/assets/global/plugins/jquery-slimscroll/jquery.slimscroll.min.js" />" type="text/javascript"></script>
<script src="<c:url value = "/resources/metronic/assets/global/plugins/jquery.blockui.min.js" />" type="text/javascript"></script>
<script src="<c:url value = "/resources/metronic/assets/global/plugins/jquery.cokie.min.js" />" type="text/javascript"></script>
<script src="<c:url value = "/resources/metronic/assets/global/plugins/uniform/jquery.uniform.min.js" />" type="text/javascript"></script>
<script src="<c:url value = "/resources/metronic/assets/global/plugins/bootstrap-switch/js/bootstrap-switch.min.js" />" type="text/javascript"></script>
<!-- END CORE PLUGINS -->
<!-- BEGIN PAGE LEVEL PLUGINS -->
<script type="text/javascript" src="<c:url value = "/resources/metronic/assets/global/plugins/jquery-validation/js/jquery.validate.min.js" />"></script>
<script type="text/javascript" src="<c:url value = "/resources/metronic/assets/global/plugins/jquery-validation/js/additional-methods.min.js" />"></script>
<script type="text/javascript" src="<c:url value = "/resources/metronic/assets/global/plugins/select2/select2.min.js" />"></script>
<script type="text/javascript" src="<c:url value = "/resources/metronic/assets/global/plugins/bootstrap-datepicker/js/bootstrap-datepicker.js" />"></script>
<script type="text/javascript" src="<c:url value = "/resources/metronic/assets/global/plugins/bootstrap-wysihtml5/wysihtml5-0.3.0.js" />"></script>
<script type="text/javascript" src="<c:url value = "/resources/metronic/assets/global/plugins/bootstrap-wysihtml5/bootstrap-wysihtml5.js" />"></script>
<script type="text/javascript" src="<c:url value = "/resources/metronic/assets/global/plugins/ckeditor/ckeditor.js" />"></script>
<script type="text/javascript" src="<c:url value = "/resources/metronic/assets/global/plugins/bootstrap-markdown/js/bootstrap-markdown.js" />"></script>
<script type="text/javascript" src="<c:url value = "/resources/metronic/assets/global/plugins/bootstrap-markdown/lib/markdown.js" />"></script>
<!-- END PAGE LEVEL PLUGINS -->
<!-- BEGIN PAGE LEVEL STYLES -->
<script src="<c:url value = "/resources/metronic/assets/global/scripts/metronic.js" />" type="text/javascript"></script>
<script src="<c:url value = "/resources/metronic/assets/admin/layout4/scripts/layout.js" />" type="text/javascript"></script>
<!-- END PAGE LEVEL STYLES -->
<script>
jQuery(document).ready(function() {   
   // initiate layout and plugins
   Metronic.init(); // init metronic core components
   Layout.init(); // init current layout

   
});
</script>

</body>
<!-- END BODY -->
</html>