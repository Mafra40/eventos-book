<%@page import="br.com.eventosbook.constante.Constantes"%>
<%@page import="br.com.eventosbook.util.BibliotecaUrl"%>
<%@page import="br.com.eventosbook.util.BibliotecaHtml"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
<link href="<c:url value = "/resources/css/estilo-tabelas.css"/>"
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
					<div class="col-md-9">
						<!-- BEGIN EXAMPLE TABLE PORTLET-->
						<div class="portlet light bordered">
							<div class="portlet-title">
								<div class="caption">
									<i class="fa fa-globe"></i>${fn:length(listaFornecedores)} Fornecedores disponíveis em: PE - Recife.
								</div>

							</div>
							<div class="portlet-body">
								<div class="table-toolbar">
									<div class="row col-md-9">
										<div class="btn-group">
														<button type="button" class="btn blue-chambray btn-default"><i class="fa fa-reorder"></i> Ordenar Por:</button>
														<button type="button" class="btn btn-default"><i class="fa fa-font"></i> Descrição</button>
														<div class="btn-group">
															<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
															<i class="fa fa-star"></i> Avaliação <i class="fa fa-angle-down"></i>
															</button>
															<ul class="dropdown-menu">
																<li>
																	<a href="javascript:;">
																	Crescente </a>
																</li>
																<li>
																	<a href="javascript:;">
																	Decrescente </a>
																</li>
															</ul>
														</div>
													</div>
									</div>
								</div>
								<table class="table table-striped table-bordered table-hover"
									id="sample_fornecedor">
									<thead>
										<tr>
											

										</tr>
									</thead>
									<tbody>
										<c:forEach var="fornecedor" items="${listaFornecedores}">
											<tr class="odd gradeX">

												<td>
												
												<div class="row">
													<div class="col-sm-12 col-md-3">
													<div class="thumbnail">
															<img src="${fornecedor.imagem}" alt="" style="width: 100%; height: 150px;">
													</div>
													</div>
													<div class="col-sm-12 col-md-9">
														<div class=" col-sm-12 col-md-8">
															
															<div class="caption">
																<h3><a
																		href="<%=BibliotecaUrl.getInstance().getUrl(Constantes.LINK_FORNECEDOR_CONTROLADOR, Constantes.LINK_FORNECEDOR_DETALHAMENTO)%>?idFornecedor=${fornecedor.codigoFornecedor}">
																			<div class="linha-tabela">${fornecedor.nomeFornecedor}</div>
																	</a>
																</h3>
																
																<p>${fornecedor.bairro} , ${fornecedor.cidade}.<br/>
																   <a href="<%=BibliotecaUrl.getInstance().getUrl(Constantes.LINK_FORNECEDOR_CONTROLADOR, Constantes.LINK_FORNECEDOR_DETALHAMENTO)%>?idFornecedor=${fornecedor.codigoFornecedor}">Ver mais detalhes...</a><br/>
																   Ultima avaliação dd/mm/yyyy</p>
																
															</div>
															
															</div>
															
														<div class="pull-left  col-sm-12 col-md-4">
															
															<div class="caption">
																${fornecedor.notaFinalHtml}
																<p>
																	Nota Baseada em ${fornecedor.totalAvaliacao} avaliações.
																</p>
																
															</div>
														</div>
															
															
														</div>
													</div>
											  </td>


											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
							<div class="portlet-body form">
								<div class="form-actions">
									<div class="row">
										<div class="col-md-offset-5 col-md-9">
											
											
											<ul class="pagination pagination-sm">
									<li>
										<a href="javascript:;">
										<i class="fa fa-angle-left"></i>
										</a>
									</li>
									<li>
										<a href="javascript:;">
										1 </a>
									</li>
									<li>
										<a href="javascript:;">
										2 </a>
									</li>
									<li>
										<a href="javascript:;">
										3 </a>
									</li>
									<li>
										<a href="javascript:;">
										4 </a>
									</li>
									<li>
										<a href="javascript:;">
										5 </a>
									</li>
									<li>
										<a href="javascript:;">
										6 </a>
									</li>
									<li>
										<a href="javascript:;">
										<i class="fa fa-angle-right"></i>
										</a>
									</li>
								</ul>
											
										</div>
									</div>
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