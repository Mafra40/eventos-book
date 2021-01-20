<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="br.com.eventosbook.constante.Constantes"%>
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
<title>EventosBook | Imagens</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1.0" name="viewport" />
<meta http-equiv="Content-type" content="text/html; charset=utf-8">
<meta content="" name="description" />
<meta content="" name="author" />
<!-- BEGIN GLOBAL MANDATORY STYLES -->
<link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700&subset=all" rel="stylesheet" type="text/css">
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

<!-- BEGIN PAGE LEVEL STYLES -->
<link href="../resources/metronic/assets/global/plugins/jquery-file-upload/blueimp-gallery/blueimp-gallery.min.css" rel="stylesheet"/>
<link href="../resources/metronic/assets/global/plugins/jquery-file-upload/css/jquery.fileupload.css" rel="stylesheet"/>
<link href="../resources/metronic/assets/global/plugins/jquery-file-upload/css/jquery.fileupload-ui.css" rel="stylesheet"/>
<!-- END PAGE LEVEL STYLES -->
	
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
						<h1>
							Importação de Imagens <small>Fornecedor.</small>
						</h1>
					</div>
					<!-- END PAGE TITLE -->

				</div>
				<!-- END PAGE HEAD -->
				<!-- BEGIN PAGE BREADCRUMB -->
				<ul class="page-breadcrumb breadcrumb">
					<li><a href="<%=BibliotecaUrl.getInstance().getUrl(Constantes.LINK_FORNECEDOR_CONTROLADOR, Constantes.LINK_HOME_FORNECEDOR)%>">Home</a> <i
						class="fa fa-circle"></i></li>


				</ul>
				<!-- END PAGE BREADCRUMB -->

						<div class="portlet light">
				<div class="portlet-body">
					<div class="row">
						<div class="col-md-12">
							<div class="note note-info">
								<p>
									Arraste uma imagem para cá ou pressione em "Adicionar" para carregar suas imagens.
								</p>
							</div>
							<form id="fileupload" 
								  action="<%=BibliotecaUrl.getInstance().getUrl(Constantes.LINK_AJAX_CONTROLADOR, Constantes.LINK_UPLOAD_FOTO_IMAGEM)%>" 
								  method="POST"
								  class="form-horizontal form-bordered" 
								  enctype="multipart/form-data">
								<!-- The fileupload-buttonbar contains buttons to add/delete files and start/cancel the upload -->
								<div class="row fileupload-buttonbar">
									<div class="col-lg-7">
										<!-- The fileinput-button span is used to style the file input field as button -->
										<span class="btn green fileinput-button">
										<i class="fa fa-plus"></i>
										<span>
										Adicionar </span>
										<input type="file" name="files[]" multiple="">
										</span>
										<button type="submit" class="btn blue start">
										<i class="fa fa-upload"></i>
										<span>
										Enviar</span>
										</button>
										<button type="reset" class="btn warning cancel">
										<i class="fa fa-ban-circle"></i>
										<span>
										Cancelar</span>
										</button>
										
										
										
									</div>
									<!-- The global progress information -->
									<div class="col-lg-5 fileupload-progress fade">
										<!-- The global progress bar -->
										<div class="progress progress-striped active" role="progressbar" aria-valuemin="0" aria-valuemax="100">
											<div class="progress-bar progress-bar-success" style="width:0%;">
											</div>
										</div>
										<!-- The extended global progress information -->
										<div class="progress-extended">
											 &nbsp;
										</div>
									</div>
								</div>
								<!-- The table listing the files available for upload/download -->
								<table role="presentation" class="table table-striped clearfix">
								<tbody class="files">
								</tbody>
								</table>
							</form>
							<div class="panel panel-success">
								<div class="panel-heading">
									<h3 class="panel-title">Atenção</h3>
								</div>
								<div class="panel-body">
									<ul>
										<li>
											 Tamanaho máximo da imagem permitido é <strong>3 MB</strong>.
										</li>
										<li>
											 Somente arquivos de imagens do tipo (<strong>JPG, GIF, PNG</strong>) são permitidos.
										</li>
										
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			

					
					
					
					
					
				</div>
			</div>


		</div>
		<div>
			<div class="container-fluid"></div>
		</div>

	<!-- END PAGE CONTENT-->

	<!-- END CONTENT -->

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
<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->
<script id="template-upload" type="text/x-tmpl">
{% for (var i=0, file; file=o.files[i]; i++) { %}
    <tr class="template-upload fade">
        <td>
            <span class="preview"></span>
        </td>
        <td>
            <p class="name">{%=file.name%}</p>
            <strong class="error text-danger label label-danger"></strong>
        </td>
        <td>
            <p class="size">Processing...</p>
            <div class="progress progress-striped active" role="progressbar" aria-valuemin="0" aria-valuemax="100" aria-valuenow="0">
            <div  class="progress-bar progress-bar-success barra" style="width:0%;"></div>
            </div>
        </td>
        <td>
            {% if (!i && !o.options.autoUpload) { %}
                <button class="btn blue start" disabled>
                    <i class="fa fa-upload"></i>
                    <span>Enviar</span>
                </button>
            {% } %}
            {% if (!i) { %}
                <button class="btn red cancel">
                    <i class="fa fa-ban"></i>
                    <span>Remover</span>
                </button>
            {% } %}
        </td>
    </tr>
{% } %}
</script>
<!-- The template to display files available for download -->
<script id="template-download" type="text/x-tmpl">
        {% for (var i=0, file; file=o.files[i]; i++) { %}
            <tr class="template-download fade">
                <td>
                    <span class="preview">
                        {% if (file.thumbnailUrl) { %}
                            <a href="{%=file.url%}" title="{%=file.name%}" download="{%=file.name%}" data-gallery><img src="{%=file.thumbnailUrl%}"></a>
                        {% } %}
                    </span>
                </td>
                <td>
                    <p class="name">
                        {% if (file.url) { %}
                            <a href="{%=file.url%}" title="{%=file.name%}" download="{%=file.name%}" {%=file.thumbnailUrl?'data-gallery':''%}>{%=file.name%}</a>
                        {% } else { %}
                            <span>{%=file.name%}</span>
                        {% } %}
                    </p>
                    {% if (file.error) { %}
                        <div><span class="label label-danger">Error</span> {%=file.error%}</div>
                    {% } %}
                </td>
                <td>
                    <span class="size">{%=o.formatFileSize(file.size)%}</span>
                </td>
                <td>
                    {% if (file.deleteUrl) { %}
                        <button class="btn red delete btn-sm" data-type="{%=file.deleteType%}" data-url="{%=file.deleteUrl%}"{% if (file.deleteWithCredentials) { %} data-xhr-fields='{"withCredentials":true}'{% } %}>
                            <i class="fa fa-trash-o"></i>
                            <span>Deletar</span>
                        </button>
                        <input type="checkbox" name="delete" value="1" class="toggle">
                    {% } else { %}
                        <button class="btn yellow cancel btn-sm">
                            <i class="fa fa-ban"></i>
                            <span>Cancelar</span>
                        </button>
                    {% } %}
                </td>
            </tr>
        {% } %}
    </script>

	<script src="<c:url value = "../resources/metronic/assets/global/plugins/jquery.min.js" />" type="text/javascript"></script>
<script src="<c:url value = "../resources/metronic/assets/global/plugins/jquery-migrate.min.js" />" type="text/javascript"></script>
<!-- IMPORTANT! Load jquery-ui.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->
<script src="<c:url value = "../resources/metronic/assets/global/plugins/jquery-ui/jquery-ui.min.js" />" type="text/javascript"></script>
<script src="<c:url value = "../resources/metronic/assets/global/plugins/bootstrap/js/bootstrap.min.js" />" type="text/javascript"></script>
<script src="<c:url value = "../resources/metronic/assets/global/plugins/bootstrap-hover-dropdown/bootstrap-hover-dropdown.min.js" />" type="text/javascript"></script>
<script src="<c:url value = "../resources/metronic/assets/global/plugins/jquery-slimscroll/jquery.slimscroll.min.js" />" type="text/javascript"></script>
<script src="<c:url value = "../resources/metronic/assets/global/plugins/jquery.blockui.min.js" />" type="text/javascript"></script>
<script src="<c:url value = "../resources/metronic/assets/global/plugins/jquery.cokie.min.js" />" type="text/javascript"></script>
<script src="<c:url value = "../resources/metronic/assets/global/plugins/uniform/jquery.uniform.min.js" />" type="text/javascript"></script>
<script src="<c:url value = "../resources/metronic/assets/global/plugins/bootstrap-switch/js/bootstrap-switch.min.js" />" type="text/javascript"></script>
<!-- END CORE PLUGINS -->
	<!-- BEGIN:File Upload Plugin JS files-->
<script src="../resources/metronic/assets/global/plugins/fancybox/source/jquery.fancybox.pack.js"></script>
<!-- The jQuery UI widget factory, can be omitted if jQuery UI is already included -->
<script src="../resources/metronic/assets/global/plugins/jquery-file-upload/js/vendor/jquery.ui.widget.js"></script>
<!-- The Templates plugin is included to render the upload/download listings -->
<script src="../resources/metronic/assets/global/plugins/jquery-file-upload/js/vendor/tmpl.min.js"></script>
<!-- The Load Image plugin is included for the preview images and image resizing functionality -->
<script src="../resources/metronic/assets/global/plugins/jquery-file-upload/js/vendor/load-image.min.js"></script>
<!-- The Canvas to Blob plugin is included for image resizing functionality -->
<script src="../resources/metronic/assets/global/plugins/jquery-file-upload/js/vendor/canvas-to-blob.min.js"></script>
<!-- blueimp Gallery script -->
<script src="../resources/metronic/assets/global/plugins/jquery-file-upload/blueimp-gallery/jquery.blueimp-gallery.min.js"></script>
<!-- The Iframe Transport is required for browsers without support for XHR file uploads -->
<script src="../resources/metronic/assets/global/plugins/jquery-file-upload/js/jquery.iframe-transport.js"></script>
<!-- The basic File Upload plugin -->
<script src="../resources/metronic/assets/global/plugins/jquery-file-upload/js/jquery.fileupload.js"></script>
<!-- The File Upload processing plugin -->
<script src="../resources/metronic/assets/global/plugins/jquery-file-upload/js/jquery.fileupload-process.js"></script>
<!-- The File Upload image preview & resize plugin -->
<script src="../resources/metronic/assets/global/plugins/jquery-file-upload/js/jquery.fileupload-image.js"></script>
<!-- The File Upload audio preview plugin -->
<script src="../resources/metronic/assets/global/plugins/jquery-file-upload/js/jquery.fileupload-audio.js"></script>
<!-- The File Upload video preview plugin -->
<script src="../resources/metronic/assets/global/plugins/jquery-file-upload/js/jquery.fileupload-video.js"></script>
<!-- The File Upload validation plugin -->
<script src="../resources/metronic/assets/global/plugins/jquery-file-upload/js/jquery.fileupload-validate.js"></script>
<!-- The File Upload user interface plugin -->
<script src="../resources/metronic/assets/global/plugins/jquery-file-upload/js/jquery.fileupload-ui.js"></script>
<!-- The main application script -->
<!-- The XDomainRequest Transport is included for cross-domain file deletion for IE 8 and IE 9 -->
<!--[if (gte IE 8)&(lt IE 10)]>
    <script src="../resources/metronic/assets/global/plugins/jquery-file-upload/js/cors/jquery.xdr-transport.js"></script>
    <![endif]-->
<!-- END:File Upload Plugin JS files-->
<script src="../resources/metronic/assets/global/scripts/metronic.js" type="text/javascript"></script>
<script src="../resources/metronic/assets/admin/layout4/scripts/layout.js" type="text/javascript"></script>
<script src="../resources/metronic/assets/admin/pages/scripts/form-fileupload.js"></script>
	<script
		src="<c:url value = "../resources/metronic/assets/admin/layout4/scripts/demo.js" />"
		type="text/javascript"></script>

	<script>
		jQuery(document).ready(function() {
			Metronic.init(); // init metronic core components
			Layout.init(); // init current layout
			 FormFileUpload.init();
		});
	</script>

</body>





</html>