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
<title>EventosBook | Meus Orçamentos</title>
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
<link href="<c:url value = "/resources/metronic/assets/admin/layout4/css/custom.css"/>"rel="stylesheet" type="text/css" />
<link href="<c:url value = "/resources/metronic/assets/admin/pages/css/todo.css"/>" rel="stylesheet" type="text/css" />
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
				<!-- BEGIN SAMPLE PORTLET CONFIGURATION MODAL FORM-->
				<div class="modal fade" id="portlet-config" tabindex="-1"
					role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true"></button>
								<h4 class="modal-title">Modal title</h4>
							</div>
							<div class="modal-body">Widget settings form goes here</div>
							<div class="modal-footer">
								<button type="button" class="btn blue">Save changes</button>
								<button type="button" class="btn default" data-dismiss="modal">Close</button>
							</div>
						</div>
						<!-- /.modal-content -->
					</div>
					<!-- /.modal-dialog -->
				</div>
				<!-- /.modal -->
				<!-- END SAMPLE PORTLET CONFIGURATION MODAL FORM-->

				

				<div class="page-head">
					<!-- BEGIN PAGE TITLE -->
					<div class="page-title">
						<h1>
							Meus Eventos <small>Visualize seus orçamentos</small>
						</h1>
					</div>
					<!-- END PAGE TITLE -->

				</div>
				<!-- END PAGE HEAD -->
				<!-- BEGIN PAGE BREADCRUMB -->
				<ul class="page-breadcrumb breadcrumb">
					<li><a href="<%=BibliotecaUrl.getInstance().getUrl(Constantes.LINK_CONTRATANTE_CONTROLADOR, Constantes.LINK_HOME_CONTRATANTE)%>">Home</a> <i
						class="fa fa-circle"></i></li>
					<li><a href="<%=BibliotecaUrl.getInstance().getUrl(Constantes.LINK_ORCAMENTO_CONTROLADOR, Constantes.LINK_EXIBIR_ORCAMENTO)%>">Meus Orçamentos</a> <i class="fa fa-circle"></i></li>

				</ul>
				
				
				
				<!-- BEGIN PAGE CONTENT-->
				<div class="row">
					
							<c:if test="${not empty msg}">
								<div class="col-md-6">
						 				${msg}
								</div>
							</c:if>
				
					<div class="col-md-12">
					<!-- Begin: life time stats -->
					<div class="portlet light">
						<div class="portlet-title tabbable-line">
							<div class="caption">
								<i class="glyphicon glyphicon-usd font-red-thunderbird"></i>
								<span class="caption-subject font-blue-madison bold uppercase">Orçamentos</span>
								<span class="caption-helper">Confira todos os seus orçamentos ativos.</span>
							</div>
							
							
						</div>
						<div class="portlet-body">
							<div class="tab-content">
								<div class="tab-pane active" id="portlet_tab1">
									
									
								<table class="table table-striped table-bordered table-hover"
									id="tabela_orcamento">
									<thead>
										<tr >
											<th>Codigo</th>
											<th>Detalhes</th>
											<th>Opções</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${listOrcamento}" var="lista">
											<tr >
												<td>${lista.codigo}</td>
												<td ><div  class="todo-tasklist">
													<div class="todo-tasklist-item ">
														<!-- Imagens -->
														<c:forEach items="${imagem}" var="img">
															<c:choose>
																<c:when test='${ not empty img && img.usuario.codigo eq lista.fornecedor.usuario.codigo}'>
																<img class="todo-userpic pull-left" src="${img.caminho}" height="50px" width="50px">
																</c:when>
																
															</c:choose>
														
														</c:forEach>
														<!-- Imagens -->
														
													<div class="todo-tasklist-item-title">
														 ${lista.fornecedor.nome}
													</div>
													<div class="todo-tasklist-item-text">
														 Evento ${lista.evento.descricao}
													</div>
													<div class="todo-tasklist-controls pull-left">
														<span class="todo-tasklist-date"><i class="fa fa-calendar"></i>Data Orçamento: <fmt:formatDate value='${lista.dataHora}' type='both'  pattern="dd/MM/yyyy HH:mm:ss"  /></span>
															
														
														<ul class="item-status stars list-inline" >
																		<li><i class="fa fa-star star-acesa"></i></li>
																		<li><i class="fa fa-star star-acesa"></i></li>
																		<li><i class="fa fa-star star-acesa"></i></li>
																		<li><i class="fa fa-star star-acesa"></i></li>
																		<li><i class="fa fa-star star-acesa"></i></li>
																		<li><span style="margin-top: -5px;" class="badge badge-primary badge-roundless">Bom </span></li>
														</ul>
														
																	
															</div>
														</div>
												</div></td>
												<td></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
									
									
								
									
								</div>
							</div>
						</div>
					</div>
					<!-- End: life time stats -->
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
		src="<c:url value = "/resources/metronic/assets/admin/pages/scripts/table-managed.js" />"></script>
	<script>
		jQuery(document).ready(function() {
			Metronic.init(); // init metronic core components
			Layout.init(); // init current layout
			tabelaOrcamento();
			
		});
	</script>
</body>
<!-- END BODY -->
</html>