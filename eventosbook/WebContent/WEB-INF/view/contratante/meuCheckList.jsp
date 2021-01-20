<%@page import="br.com.eventosbook.constante.Constantes"%>
<%@page import="br.com.eventosbook.util.BibliotecaUrl"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>

<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en">
<!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
<meta charset="utf-8" />
<title>EventosBook | CheckList</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1.0" name="viewport" />
<meta http-equiv="Content-type" content="text/html; charset=utf-8">
<meta content="" name="description" />
<meta content="" name="author" />
<!-- BEGIN GLOBAL MANDATORY STYLES -->
<link
	href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700&subset=all"
	rel="stylesheet" type="text/css">
<link
	href="<c:url value = "/resources/metronic/assets/global/plugins/font-awesome/css/font-awesome.min.css"/>"
	rel="stylesheet" type="text/css">
<link
	href="<c:url value = "/resources/metronic/assets/global/plugins/simple-line-icons/simple-line-icons.min.css"/>"
	rel="stylesheet" type="text/css">
<link
	href="<c:url value = "/resources/metronic/assets/global/plugins/bootstrap/css/bootstrap.min.css"/>"
	rel="stylesheet" type="text/css">
<link
	href="<c:url value = "/resources/metronic/assets/global/plugins/uniform/css/uniform.default.css"/>"
	rel="stylesheet" type="text/css">
<link
	href="<c:url value = "/resources/metronic/assets/global/plugins/bootstrap-switch/css/bootstrap-switch.min.css"/>"
	rel="stylesheet" type="text/css" />
<!-- END GLOBAL MANDATORY STYLES -->
<!-- BEGIN PAGE LEVEL STYLES -->
<link rel="stylesheet" type="text/css"
	href="<c:url value = "/resources/metronic/assets/global/plugins/select2/select2.css"/>" />
<link rel="stylesheet" type="text/css"
	href="<c:url value = "/resources/metronic/assets/global/plugins/datatables/plugins/bootstrap/dataTables.bootstrap.css"/>" />
<!-- END PAGE LEVEL STYLES -->
<!-- BEGIN THEME STYLES -->
<link
	href="<c:url value = "/resources/metronic/assets/global/css/components-rounded.css"/>"
	id="style_components" rel="stylesheet" type="text/css" />
<link
	href="<c:url value = "/resources/metronic/assets/global/css/plugins.css"/>"
	rel="stylesheet" type="text/css" />
<link
	href="<c:url value = "/resources/metronic/assets/admin/layout4/css/layout.css"/>"
	rel="stylesheet" type="text/css" />
<link id="style_color"
	href="<c:url value = "/resources/metronic/assets/admin/layout4/css/themes/light.css"/>"
	rel="stylesheet" type="text/css" />
<link
	href="<c:url value = "/resources/metronic/assets/admin/layout4/css/custom.css"/>"
	rel="stylesheet" type="text/css" />
<!-- END THEME STYLES -->
<link rel="shortcut icon" href="favicon.ico" />

<!-- BEGIN STYLES EVENTOSBOOK -->
<link
	href="<c:url value = "/resources/css/estilo-tabelas.css"/>"
	rel="stylesheet" type="text/css" />
<!-- END STYLES EVENTOSBOOK -->

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
				

				<!-- BEGIN PAGE CONTENT-->
				<div class="row">
					<div class="col-md-12">
						<!-- BEGIN EXAMPLE TABLE PORTLET-->
						<div class="portlet box grey-cascade">
							<div class="portlet-title">
								<div class="caption">
									<i class="fa fa-globe"></i>Check List
								</div>

							</div>
							<div class="portlet-body">
								<div class="table-toolbar">
									<div class="row">
										<div class="col-md-6"></div>
										<div class="col-md-6">
											<div class="btn-group pull-right">

												<ul class="dropdown-menu pull-right">
													<li><a href="javascript:;"> Print </a></li>
													<li><a href="javascript:;"> Save as PDF </a></li>
													<li><a href="javascript:;"> Export to Excel </a></li>
												</ul>
											</div>
										</div>
									</div>
								</div>
								<table class="table table-striped table-bordered table-hover"
									id="sample_checklist">
									<thead>
										<tr>
											<th class="table-checkbox"></th>
											<th>Descrição</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="checklist" items="${listaItens}" varStatus="i">
											<tr class="odd gradeX">
													<c:if test="${checklist.status eq 'A'}">
													<td><input type="checkbox" class="checkboxes"
														value="${checklist.status}" id="item"
														onclick="marcarDesmarcarTarefaCheckList('${checklist.codigo}');" /></td>
									

													<td> 
														<a href="<%=BibliotecaUrl.getInstance().getUrl(Constantes.LINK_CONTRATANTE_CONTROLADOR, Constantes.LINK_FORNECEDOR_PARAMETRIZADO)%>?idCategoria=${checklist.item.categoria.codigo}&idSubcategoria=${checklist.item.subCategoria.codigo}">
																<div class = "linha-tabela">${checklist.item.descricao}</div>
														</a>
													</td>
												</c:if>

												<c:if test="${checklist.status eq 'I'}">
													<td><input type="checkbox" class="checkboxes"
														value="${checklist.status}" id="item"
														onclick="marcarDesmarcarTarefaCheckList('${checklist.codigo}');"
														checked="true" />
													<td> 
														<a href="<%=BibliotecaUrl.getInstance().getUrl(Constantes.LINK_CONTRATANTE_CONTROLADOR, Constantes.LINK_FORNECEDOR_PARAMETRIZADO)%>?idCategoria=${checklist.item.categoria.codigo}&idSubcategoria=${checklist.item.subCategoria.codigo}">
																<div class = "linha-tabela">${checklist.item.descricao}</div>
														</a>
													</td>
												</c:if>
											</tr>
										</c:forEach>
									</tbody>
								</table>

								<div class="form-actions">

									<a href="<%=BibliotecaUrl.getInstance().getUrl(Constantes.LINK_CONTRATANTE_CONTROLADOR, Constantes.LINK_MEU_EVENTO)%>"
										class="btn default btn-block">Voltar</a>

								</div>
							</div>
						</div>
						<!-- END EXAMPLE TABLE PORTLET-->
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
		<div class="page-footer-inner">2015 &copy; EventosBook.</div>
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
	<script
		src="<c:url value = "/resources/metronic/assets/admin/pages/scripts/table-managed.js" />"></script>
	<!-- BEGIN JS EVENTOSBOOK -->
	<script src="<c:url value = "/resources/js/bibliotecaAjax.js" />"></script>
	<script src="<c:url value = "/resources/js/bibliotecaFuncao.js" />"></script>
	<!-- END JS EVENTOSBOOK -->



	<script>
		jQuery(document).ready(function() {
			Metronic.init(); // init metronic core components
			Layout.init(); // init current layout
			Demo.init(); // init demo features
			TableManaged.init();
		});
	</script>
</body>
<!-- END BODY -->
</html>