<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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

<link href="<c:url value = "/resources/metronic/assets/admin/pages/css/search.css"/>" rel="stylesheet" type="text/css"/>
<link href="<c:url value = "/resources/metronic/assets/global/plugins/carousel-owl-carousel/owl-carousel/owl.carousel.css" />" rel="stylesheet" type="text/css" >
<link href="<c:url value = "/resources/metronic/assets/global/plugins/carousel-owl-carousel/owl-carousel/owl.theme.css" />" rel="stylesheet" type="text/css" >
<link href="<c:url value = "/resources/metronic/assets/global/plugins/carousel-owl-carousel/owl-carousel/owl.transitions.css" />" rel="stylesheet" type="text/css" >


<!-- BEGIN THEME STYLES -->
<link href="<c:url value = "/resources/metronic/assets/global/css/components-rounded.css"/>" id="style_components" rel="stylesheet" type="text/css"/>
<link href="<c:url value = "/resources/metronic/assets/global/css/plugins.css"/>" rel="stylesheet" type="text/css"/>
<link href="<c:url value = "/resources/metronic/assets/admin/layout4/css/layout.css"/>" rel="stylesheet" type="text/css"/>
<link id="style_color" href="<c:url value = "/resources/metronic/assets/admin/layout4/css/themes/light.css"/>" rel="stylesheet" type="text/css"/>
<link href="<c:url value = "/resources/metronic/assets/admin/layout4/css/custom.css"/>" rel="stylesheet" type="text/css"/>
<!-- END THEME STYLES -->
<link rel="shortcut icon" href="favicon.ico"/>

<style type="text/css">
	#owl-fornecedor-img .owl-item div{
  padding:1px;
}
#owl-fornecedor-img .owl-item img{
  display: block;
  width: 100%;
  height: auto;
  -webkit-border-radius: 3px;
  -moz-border-radius: 3px;
  border-radius: 3px;
}


html,body{height:100%;}


</style>

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
				
				<!-- END PAGE TITLE -->
				
				
			</div>
			<!-- END PAGE HEAD -->
		
			<!-- END PAGE HEADER-->
			<!-- BEGIN PAGE CONTENT-->

				<div class="row">
					<div class="col-md-8">
					
						<div  id="owl-fornecedor-img" >
 														<c:set var="i" value="0" scope="page" />
 														<c:forEach items="${imagem}" var="imagem">
														  <div class="col-md-5 thumbnails" style="margin-left:50px;  width: 80%; height: 10%;" ><img id="img${i}" src="${imagem.caminho}"></div>
														<c:set var="i" value="${i+1}" scope="page" />
														</c:forEach>  
												</div>
					
						
						</div>
						
				<div class="col-md-4 ">
					<!-- BEGIN Portlet PORTLET-->
					<div class="portlet light bordered">
						<div class="portlet-title">
											<div class="caption caption-md">
												<i class="icon-bar-chart theme-font hide"></i> <span
													class="caption-subject font-blue-madison bold uppercase">Avaliação</span>
													
											</div>

										</div>
							 <div class="row booking-results ">
											<div class="col-md-12">
												<div class="booking-result">
													
													<div class="booking-info">
													
															${nota}
															<p>Nota baseada em ${qtdAvaliacoes} avaliações.</p>
														
														
														
																
													
													</div>
												</div>
											</div>
											
										
						</div>
					</div>
					<!-- END Portlet PORTLET-->
				</div>
				
				
				
				<div class="col-md-4">
					<!-- BEGIN Portlet PORTLET-->
					<div class="portlet light bordered">
						<div class="portlet-title">
											<div class="caption caption-md">
												<i class="icon-bar-chart theme-font hide"></i> <span
													class="caption-subject font-blue-madison bold uppercase">Serviços</span>
													
											</div>

										</div>
							 <div class="row booking-results">
											<div class="col-md-12 ">
												<div class="booking-result">
													
													<div class="booking-info">
													
														<ul class=" list-inline">
															<li><span class="badge badge-primary badge-roundless"> Serviço 1</span></li>
															<li><span class="badge badge-primary badge-roundless"> Serviço 2</span></li>
															<li><span class="badge badge-primary badge-roundless"> Serviço 3</span></li>
															<li><span class="badge badge-primary badge-roundless"> Serviço 4</span></li>
															<li><span class="badge badge-primary badge-roundless"> Serviço 5</span></li>
															<li><span class="badge badge-primary badge-roundless"> Serviço 6</span></li>
														</ul>
														
														
																
													
													</div>
												</div>
											</div>
											
										
						</div>
					</div>
					<!-- END Portlet PORTLET-->
				</div>
						
					
						
						<!--  Inicio Bloco -->
					<div class="col-md-12 ">
					<!-- BEGIN Portlet PORTLET-->
					<div class="portlet light bordered">
						<div class="portlet-title">
							<div class="caption">
											<i class="icon-bar-chart theme-font hide"></i> <span
												class="caption-subject font-blue-madison bold uppercase"><c:if
													test="${not empty fornecedor}">${fornecedor.nome}</c:if> </span> <span
												class="caption-helper bold"></span>
										</div>




									</div>

									<div class="row booking-results">
										<div class="col-md-12">
											<div class="booking-result">

												<div class="booking-info">

													<div style="float: left;" class="font-blue-madison">Endereço:&nbsp;</div>
													<div>
														${endereco.logradouro}
														<c:if test="${not empty endereco.numero}">, Nº ${endereco.numero} </c:if>
														${endereco.cidade.descricao},
														${endereco.cidade.estado.sigla} CEP: ${endereco.cep}<br />

													</div>



													<p class="font-blue-madison">
														Horário de Atendimento: <span class="font-black"> <c:if
																test="${not empty fornecedor}">${fornecedor.horarioAtendimento}</c:if></span>
													</p>

													<span class="font-blue-madison">Descrição:</span>
													<p>
														&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
														<c:if test="${not empty fornecedor}">${fornecedor.descricao}</c:if>
													</p>

												</div>
											</div>
										</div>

								


				<div class="col-md-12 ">
					<!-- BEGIN Portlet PORTLET-->
					<div class="portlet light">
						<div class="portlet-title">
							<div class="caption">
								Ultimas Avaliações
							</div>
							
						</div>
						<div class="portlet-body">
						
						<div style="margin-left: 20px;" class="note note-success col-md-6">
								
								<p>
									Apenas pessoas que tiveram seus eventos realizados são capazes de avaliar e comentar, assim como você.
								</p>
						</div>
							
							<div class="row">
								<div class="col-md-12">
														
									<c:forEach items="${comentario}" var="c">${c}</c:forEach>
									
								
								</div>
								
									<%  //TODO FAZER O CONTADOR CORRETO DAS AVALIAÇÕES%>
														<div class="task-footer">
															<div class="btn-arrow-link pull-left">
																<c:if test="${qtdAvaliacoes > 1}">
																<a href="<%=Constantes.LINK_VIZUALIZAR_TOTAL_AVALIACOES +"?idFornecedor="%>${fornecedor.codigo}">Ver todas as ${qtdAvaliacoes} avaliações </a>
																</c:if>
																
															</div>
														</div>
								
							</div>
							
						</div>
					</div>
					<!-- END Portlet PORTLET-->
				</div>
								</div>




							</div>
						</div>
					</div>
					<!--  Fim Bloco -->
						
						
						<%  //TODO ALTERA A FORMA DE PEGAR O EVENTO NO BOTAO &idEvento=${2}
							//Na hora de adicionar um orçamento para o fornecedor, verificar se o contratante possui um evento criado.
						%>
						<div class="form-actions">
									<div class="row">
										<div class="col-md-offset-4 col-md-8">
										
											<a href="<%=BibliotecaUrl.getInstance().getUrl(Constantes.LINK_ORCAMENTO_CONTROLADOR, Constantes.LINK_SOLICITAR_ORCAMENTO)+"?idFornecedor="%>${fornecedor.codigo}&idEvento=${2}" title="Solicitar Orçamento." class="btn green"><i class="fa fa-usd"></i> Solicitar Orçamento </a>
											<a href="<%=BibliotecaUrl.getInstance().getUrl(Constantes.LINK_CONTRATANTE_CONTROLADOR, Constantes.LINK_ADD_MEUS_FORNECEDORES)+"?idFornecedor="%>${fornecedor.codigo}&idEvento=${idEvento}" title="Adicionar aos meus fornecedores." class="btn red"><i class="fa fa-plus-circle"></i> Meus Fornecedores </a>
						
										</div>
									</div>
						</div>
						
						
						
						
					</div>
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
<script src="<c:url value = "/resources/metronic/assets/global/plugins/carousel-owl-carousel/owl-carousel/owl.carousel.js" />" type="text/javascript"></script>
<script>
 jQuery(document).ready(function() {    
 Metronic.init(); // init metronic core components
 Layout.init(); // init current layout
 Demo.init(); // init demo features

</script>
<script type="text/javascript" src="<c:url value="/resources/js/bibliotecaDeImagem.js"/>"></script>

<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>