<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en">
<!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
<meta charset="utf-8"/>
<title>EventosBook | Home</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1.0" name="viewport"/>
<meta http-equiv="Content-type" content="text/html; charset=utf-8">
<meta content="" name="description"/>
<meta content="" name="author"/>
<!-- BEGIN GLOBAL MANDATORY STYLES -->
<link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700&subset=all" rel="stylesheet" type="text/css">
<link href="<c:url value = "/resources/metronic/assets/global/plugins/font-awesome/css/font-awesome.min.css"/>" rel="stylesheet" type="text/css"/>
<link href="<c:url value = "/resources/metronic/assets/global/plugins/simple-line-icons/simple-line-icons.min.css"/>" rel="stylesheet" type="text/css">
<link href="<c:url value = "/resources/metronic/assets/global/plugins/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet" type="text/css">
<link href="<c:url value = "/resources/metronic/assets/global/plugins/uniform/css/uniform.default.css"/>" rel="stylesheet" type="text/css">
<link href="<c:url value = "/resources/metronic/assets/global/plugins/bootstrap-switch/css/bootstrap-switch.min.css"/>" rel="stylesheet" type="text/css"/>
<!-- END GLOBAL MANDATORY STYLES -->
<!-- BEGIN THEME STYLES -->
<link href="<c:url value = "/resources/metronic/assets/global/css/components-rounded.css"/>" id="style_components" rel="stylesheet" type="text/css"/>
<link href="<c:url value = "/resources/metronic/assets/global/css/plugins.css"/>" rel="stylesheet" type="text/css"/>
<link href="<c:url value = "/resources/metronic/assets/admin/layout4/css/layout.css"/>" rel="stylesheet" type="text/css"/>
<link id="style_color" href="<c:url value = "/resources/metronic/assets/admin/layout4/css/themes/light.css"/>" rel="stylesheet" type="text/css"/>
<link href="<c:url value = "/resources/metronic/assets/admin/layout4/css/custom.css"/>" rel="stylesheet" type="text/css"/>
<!-- END THEME STYLES -->
<link rel="shortcut icon" href="favicon.ico"/>
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
				
				<!-- END PAGE TITLE -->
				<!-- BEGIN PAGE TOOLBAR -->
				<div class="page-toolbar">
					
				</div>
				<!-- END PAGE TOOLBAR -->
			</div>
			<!-- END PAGE HEAD -->
		
			<!-- END PAGE HEADER-->
			<!-- BEGIN PAGE CONTENT-->
			<div class="row">
				<div class="col-md-12">
					
					<div class="row">
						<div class="col-md-12">
						<c:if test="${not empty msg}">
												${msg}
						</c:if>
						
					
					</div>
				</div>
			<!-- END PAGE CONTENT-->
			
			
								</div>
							</div>
		</div>
	</div>
	<!-- END CONTENT -->
</div>
<!-- END CONTAINER -->
<!-- BEGIN FOOTER -->
<div class="page-footer">
	<div class="page-footer-inner">
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
<script src="<c:url value = "/resources/metronic/assets/global/scripts/metronic.js" />" type="text/javascript"></script>
<script src="<c:url value = "/resources/metronic/assets/admin/layout4/scripts/layout.js" />" type="text/javascript"></script>
<script src="<c:url value = "/resources/metronic/assets/admin/layout4/scripts/demo.js" />" type="text/javascript"></script>
<script>
 jQuery(document).ready(function() {    
 Metronic.init(); // init metronic core components
 Layout.init(); // init current layout
 Demo.init(); // init demo features
});
   </script>
<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>