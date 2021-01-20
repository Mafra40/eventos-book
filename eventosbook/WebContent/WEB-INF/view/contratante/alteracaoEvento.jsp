<%@page import="br.com.eventosbook.constante.Constantes"%>
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
<meta charset="utf-8" />
<title>EventosBook | Novo Evento</title>
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
	href="<c:url value = "/resources/metronic/assets/global/plugins/bootstrap-wysihtml5/bootstrap-wysihtml5.css"/>" />
<link rel="stylesheet" type="text/css"
	href="<c:url value = "/resources/metronic/assets/global/plugins/bootstrap-markdown/css/bootstrap-markdown.min.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value = "/resources/metronic/assets/global/plugins/bootstrap-datepicker/css/datepicker.css"/>" />
<!-- END PAGE LEVEL SCRIPTS -->
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
						<div class="tab-pane" id="tab_7">
							<div class="portlet box green ">
								<div class="portlet-title">
									<div class="caption">
										<i class="glyphicon glyphicon-list-alt"></i>Alterar Evento
									</div>
								</div>
								<div class="portlet-body form">
									<!-- BEGIN FORM-->
									<form action="<%=BibliotecaUrl.getInstance().getUrl(Constantes.LINK_CONTRATANTE_CONTROLADOR, Constantes.LINK_EFETUAR_ALTERACAO_EVENTO)%>"
										id="form_sample_2"
										class="form-horizontal form-bordered form-label-stripped">
										<input type="hidden" value="${evento.codigo}" name="codigo" />
										<input type="hidden" value="${evento.dataCriacao}" name="dataCriacao" />
										
										<div class="alert alert-danger display-hide">
											<button class="close" data-close="alert"></button>
											Verifique todos os campos estão preenchidos corretmente.
										</div>
										<div class="form-body">
											<div class="form-group">
												<label class="control-label col-md-3">Descrição do
													Evento <span class="required"> * </span>
												</label>
												<div class="col-md-9">
													<div class="input-icon right">
														<i class="fa"></i> <input type="text"
															placeholder="Ex: Meu Casamento" class="form-control"
															name="nome" value="${evento.descricao}" />
													</div>
												</div>
											</div>
											<div class="form-group">
												<label class="control-label col-md-3">Categoria <span
													class="required"> * </span>
												</label>
												<div class="col-md-9">
													<div class="input-icon right">
														<i class="fa"></i> <select
															class="form-control select2_category" name="valorSelect">
																<option value="">Selecione o tipo de evento</option>
																<c:forEach items="${listaTipoEvento}" var="tipoEvento">
									
																	<c:choose>
																		<c:when test="${tipoEvento.codigo eq evento.tipoEvento.codigo}">
																			<option selected value="${tipoEvento.codigo}">${tipoEvento.descricao}</option>
																		</c:when>
																		<c:otherwise>
																			<option value="${tipoEvento.codigo}">${tipoEvento.descricao}</option>
																		</c:otherwise>
																	</c:choose>
		
																</c:forEach>
														</select>
													</div>
												</div>
											</div>
											<div class="form-group">
												<label class="control-label col-md-3">Data do evento
													<span class="required"> * </span>
												</label>
												<div class="col-md-9">
													<div class="input-icon right">
														<i class="fa"></i> <input type="text" id="campoData"
															class="form-control" placeholder="dd/mm/yyyy" name="data" onkeyup="formatarCampoData(this, event, false);" 
															value="<fmt:formatDate value="${evento.dataEvento.time}" type="date" pattern="dd/MM/yyyy" />" />
													</div>
												</div>
											</div>
											<div class="form-group">
												<label class="control-label col-md-3">Horário do
													evento <span class="required"> * </span>
												</label>
												<div class="col-md-9">
													<div class="input-icon right">
														<i class="fa"></i> <input type="text" id="campoHora" class="form-control"
															name="hora" placeholder="hh:mm"
															value="<fmt:formatDate value="${evento.horarioEvento}" type="time" pattern="HH:mm" />" />
													</div>
												</div>
											</div>
										</div>
										<div class="form-actions">
											<div class="row">
												<div class="col-md-offset-3 col-md-9">
													<button type="submit" class="btn green">
														<i class="fa fa-check"></i> Alterar
													</button>
													<a href="<%=BibliotecaUrl.getInstance().getUrl(Constantes.LINK_CONTRATANTE_CONTROLADOR, Constantes.LINK_MEU_EVENTO)%>" class="btn default">Cancelar</a>
												</div>
											</div>
										</div>
									</form>
									<!-- END FORM-->
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
		<div class="copyright">2015 &copy; EventosBook.</div>
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
		src="<c:url value = "/resources/metronic/assets/global/plugins/jquery-validation/js/jquery.validate.min.js" />"></script>
	<script type="text/javascript"
		src="<c:url value = "/resources/metronic/assets/global/plugins/jquery-validation/js/additional-methods.min.js" />"></script>
	<script type="text/javascript"
		src="<c:url value = "/resources/metronic/assets/global/plugins/select2/select2.min.js" />"></script>
	<script type="text/javascript"
		src="<c:url value = "/resources/metronic/assets/global/plugins/bootstrap-datepicker/js/bootstrap-datepicker.js" />"></script>
	<script type="text/javascript"
		src="<c:url value = "/resources/metronic/assets/global/plugins/bootstrap-wysihtml5/wysihtml5-0.3.0.js" />"></script>
	<script type="text/javascript"
		src="<c:url value = "/resources/metronic/assets/global/plugins/bootstrap-wysihtml5/bootstrap-wysihtml5.js" />"></script>
	<script type="text/javascript"
		src="<c:url value = "/resources/metronic/assets/global/plugins/ckeditor/ckeditor.js" />"></script>
	<script type="text/javascript"
		src="<c:url value = "/resources/metronic/assets/global/plugins/bootstrap-markdown/js/bootstrap-markdown.js" />"></script>
	<script type="text/javascript"
		src="<c:url value = "/resources/metronic/assets/global/plugins/bootstrap-markdown/lib/markdown.js" />"></script>
	<!-- END PAGE LEVEL PLUGINS -->
	<!-- BEGIN PAGE LEVEL STYLES -->
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
		src="<c:url value = "/resources/metronic/assets/admin/pages/scripts/form-validation.js" />"></script>
	<!-- END PAGE LEVEL STYLES -->
<!-- BEGIN JS EVENTOSBOOK -->
	<script type="text/javascript" src="<c:url value = "/resources/js/jquery.mask.js" />"></script>
	<script type="text/javascript" src="<c:url value = "/resources/js/bibliotecaMascara.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/bibliotecaFuncao.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/bibliotecaValidacaoDataHora.js"/>"></script>

	<!-- END JS EVENTOSBOOK -->

	<script>
		jQuery(document).ready(function() {
			// initiate layout and plugins
			Metronic.init(); // init metronic core components
			Layout.init(); // init current layout
			Demo.init(); // init demo features
			FormValidation.init();
		});
	</script>
	<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>