<%@page import="br.com.eventosbook.constante.Constantes"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
<title>EventosBook | Imagens</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1.0" name="viewport"/>
<meta http-equiv="Content-type" content="text/html; charset=utf-8">
<meta content="" name="description"/>
<meta content="" name="author"/>
<!-- BEGIN GLOBAL MANDATORY STYLES 
<link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700&subset=all" rel="stylesheet" type="text/css">-->
<link href="<c:url value = "/resources/metronic/assets/global/plugins/font-awesome/css/font-awesome.min.css"/>" rel="stylesheet" type="text/css">
<link href="<c:url value = "/resources/metronic/assets/global/plugins/simple-line-icons/simple-line-icons.min.css"/>" rel="stylesheet" type="text/css">
<link href="<c:url value = "/resources/metronic/assets/global/plugins/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet" type="text/css">
<link href="<c:url value = "/resources/metronic/assets/global/plugins/uniform/css/uniform.default.css"/>" rel="stylesheet" type="text/css">
<link href="<c:url value = "/resources/metronic/assets/global/plugins/bootstrap-switch/css/bootstrap-switch.min.css"/>" rel="stylesheet" type="text/css"/>
<!-- END GLOBAL MANDATORY STYLES -->
<!-- BEGIN PAGE LEVEL STYLES -->
<link rel="stylesheet" type="text/css" href="<c:url value = "/resources/metronic/assets/global/plugins/select2/select2.css"/>"/>
<link rel="stylesheet" type="text/css" href="<c:url value = "/resources/metronic/assets/global/plugins/bootstrap-wysihtml5/bootstrap-wysihtml5.css"/>"/>
<link rel="stylesheet" type="text/css" href="<c:url value = "/resources/metronic/assets/global/plugins/bootstrap-markdown/css/bootstrap-markdown.min.css"/>">
<link rel="stylesheet" type="text/css" href="<c:url value = "/resources/metronic/assets/global/plugins/bootstrap-datepicker/css/datepicker.css"/>"/>
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

<%@include file="cabecalho.jsp"%>

<!-- BEGIN CONTAINER -->
<div class="page-container">

	<%@include file="menu.jsp"%>
	
	<!-- BEGIN CONTENT -->
	<div class="page-content-wrapper">
		<div class="page-content">
			
			<!-- BEGIN PAGE HEADER-->
			<!-- BEGIN PAGE HEAD -->
			<div class="page-head">
				<!-- BEGIN PAGE TITLE -->
				<div class="page-title">
					<h1>Galeria de Imagens <small>Fornecedor.</small></h1>
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
						
						
							<div class="col-md-9">
								<!-- BEGIN EXAMPLE TABLE PORTLET-->

								
								<div class="portlet light boxed">
						<div class="portlet-title">
							<div class="caption">
								<i class="fa fa-file-image-o"></i>Galeria de Imagens
							</div>
							
						</div>
						<div class="portlet-body">
							<div class="table-toolbar">
								<div class="row">
									<div class="col-md-6">
										<div class="btn-group">
											<a href="<%=BibliotecaUrl.getInstance().getUrl(Constantes.LINK_FORNECEDOR_CONTROLADOR, Constantes.LINK_FORNECEDOR_IMAGENS)%>"  id="sample_editable_1_new" class="btn blue">
											Adicionar <i class="fa fa-plus"></i>
											</a>
										</div>
									</div>
									
								</div>
							</div>
										<table class="table table-striped table-bordered table-hover"
											id="tabela_imagem">
											<thead>
												<tr>
													<th></th>
													<th></th>
												</tr>
											</thead>
											<tbody>
											
												<c:forEach items="${imagem}" var="imagem">
													
													
													<tr>
														
														<td><img width="200" height="150" src="${imagem.caminho}"></td>
														<td><a title="Clique para deletar esta imagem" class="btn-default btn btn-xs" href="<%=BibliotecaUrl.getInstance().getUrl(Constantes.LINK_FORNECEDOR_CONTROLADOR, Constantes.LINK_FORNECEDOR_REMOVER_IMAGENS)%>?cdImagem=${imagem.codigo}">
																<i class='fa fa-minus-circle font-red'></i></a>
															<c:if test='${imagem.imagem_principal eq "S"}'>
																<i class="fa fa-star font-yellow"></i> 
															</c:if> 
															<c:if test='${imagem.imagem_principal eq "N"}'>
																  <a title="Clique para tonar essa imagem principal." class="btn-default btn btn-xs" href="<%=BibliotecaUrl.getInstance().getUrl(Constantes.LINK_IMAGEM_CONTROLADOR, Constantes.LINK_EFETUAR_IMAGEM_PRINCIPAL)%>?cdImagem=${imagem.codigo}">
																  <i class="fa fa-star-o font-black"></i></a>
															</c:if>
														</td>
													</tr>

												</c:forEach>

											</tbody>
										</table>
									</div>
								</div>





							</div>
							<div>
								<div class="container-fluid">
									
								</div>
							</div>
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
<script
		src="<c:url value = "/resources/metronic/assets/global/plugins/jquery.min.js" />"
		type="text/javascript"></script>
	<script
		src="<c:url value = "/resources/metronic/assets/global/plugins/jquery-migrate.min.js" />"
		type="text/javascript"></script>
	<!-- IMPORTANT! Load jquery-ui.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->
	<script
		src="<c:url value = "/resources/metronic/assets/global/plugins/jquery-ui/jquery-ui.min.js" />"
		type="text/javascript"></script>
	<script
		src="<c:url value = "/resources/metronic/assets/global/plugins/bootstrap/js/bootstrap.min.js" />"
		type="text/javascript"></script>
	<script
		src="<c:url value = "/resources/metronic/assets/global/plugins/bootstrap-hover-dropdown/bootstrap-hover-dropdown.min.js" />"
		type="text/javascript"></script>
	<script
		src="<c:url value = "/resources/metronic/assets/global/plugins/jquery-slimscroll/jquery.slimscroll.min.js" />"
		type="text/javascript"></script>
	<script
		src="<c:url value = "/resources/metronic/assets/global/plugins/jquery.blockui.min.js" />"
		type="text/javascript"></script>
	<script
		src="<c:url value = "/resources/metronic/assets/global/plugins/jquery.cokie.min.js" />"
		type="text/javascript"></script>
	<script
		src="<c:url value = "/resources/metronic/assets/global/plugins/uniform/jquery.uniform.min.js" />"
		type="text/javascript"></script>
	<script
		src="<c:url value = "/resources/metronic/assets/global/plugins/bootstrap-switch/js/bootstrap-switch.min.js" />"
		type="text/javascript"></script>
	<!-- END CORE PLUGINS -->
	<!-- BEGIN PAGE LEVEL PLUGINS -->
	<script type="text/javascript"
		src="<c:url value = "/resources/metronic/assets/global/plugins/select2/select2.min.js" />"></script>
	<script type="text/javascript"
		src="<c:url value = "/resources/metronic/assets/global/plugins/datatables/media/js/jquery.dataTables.min.js" />"></script>
	<script type="text/javascript"
		src="<c:url value = "/resources/metronic/assets/global/plugins/datatables/plugins/bootstrap/dataTables.bootstrap.js" />"></script>
	<!-- END PAGE LEVEL PLUGINS -->
	<!-- BEGIN PAGE LEVEL SCRIPTS -->
	<script
		src="<c:url value = "/resources/metronic/assets/global/scripts/metronic.js" />"
		type="text/javascript"></script>
	<script
		src="<c:url value = "/resources/metronic/assets/admin/layout4/scripts/layout.js" />"
		type="text/javascript"></script>
	<script
		src="<c:url value = "/resources/metronic/assets/admin/layout4/scripts/demo.js" />"
		type="text/javascript"></script>
	<script src="<c:url value = "/resources/metronic/assets/admin/pages/scripts/table-managed.js"/>" type="text/javascript"></script>
	<script>
		jQuery(document).ready(function() {
			Metronic.init(); // init metronic core components
			Layout.init(); // init current layout
			  TableManaged.init();
		});
	</script>

</html>