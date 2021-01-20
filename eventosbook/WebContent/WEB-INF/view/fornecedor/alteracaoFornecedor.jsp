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
<title>EventosBook | Alterar Perfil</title>
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
					<h1>Alteração de perfil <small>Fornecedor.</small></h1>
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
				<li>
					<a href="<%=BibliotecaUrl.getInstance().getUrl(Constantes.LINK_FORNECEDOR_CONTROLADOR, Constantes.LINK_ALTERACAO_FORNECEDOR)%>">Perfil Fornecedor</a>
					<i class="fa fa-circle"></i>
				</li>
				
			</ul>
			<!-- END PAGE BREADCRUMB -->
			<div class="row">
				<div class="col-md-12">
					
					<div class="row">
						<div class="col-md-12">
					<!-- BEGIN VALIDATION STATES-->
					<div class="portlet box green">
						<div class="portlet-title">
							<div class="caption">
								<i class="glyphicon glyphicon-cog"></i>Alteração de Perfil
							</div>
						</div>
						
						
						<div class="portlet-body form">
							<!-- BEGIN FORM-->
							<form id="form_sample_3"  
								  name="form_sample_3"
									action="<%=BibliotecaUrl.getInstance().getUrl(Constantes.LINK_FORNECEDOR_CONTROLADOR, Constantes.LINK_EFETUAR_ALTERACAO_FORNECEDOR)%>"
								  method="POST" 
								  onkeydown="ignoraSubmitFormOnEnter(event);" class="form-horizontal">
							
							
							<input type="hidden" id="idUsuario" name="idUsuario" value='<c:if test="${not empty fornecedor}">${fornecedor.usuario.codigo}</c:if>' />
							<input type="hidden" id="idFornecedor" name="idFornecedor" value='<c:if test="${not empty fornecedor}">${fornecedor.codigo}</c:if>' />
							<input type="hidden" id="idEndereco" name="idEndereco" value='<c:if test="${not empty endereco}">${endereco.codigo}</c:if>' />
							<input type="hidden" id="ajaxEstadoLink" name="ajaxEstadoLink" value='<%=Constantes.LINK_AJAX_CONTROLADOR+"/"+Constantes.LINK_CONSULTA_CIDADES_ESTADO%>' />
							
								<div class="form-body">
									
									<div class="alert alert-danger display-hide">
										<button class="close" data-close="alert"></button>
										Você tem alguns erros destacados abaixo.
									</div>
									
									<div class="alert alert-success display-hide">
										<button class="close" data-close="alert"></button>
										Todos as informações estão corretas, aguarde a atualização!
									</div>
									
									
									
									<div class="form-group">
										<label class="control-label col-md-3">Nome <span class="required">
										* </span>
										</label>
										<div class="col-md-4">
											<input type="text" id="nome"
																value='<c:if test="${not empty fornecedor}">${fornecedor.nome}</c:if>'
																placeholder="Digite seu Nome Completo" name="nome"
																onkeyup="focusProxElementoOnEnter(event, 'descricao');"
																maxlength="255" data-required="1" class="form-control"/>
										</div>
									</div>
									
									
									<div class="form-group">
										<label class="control-label col-md-3">Descrição <span class="required">
										* </span>
										</label>
										<div class="col-md-4">
										<textarea class="form-control" id="descricao" placeholder="Breve descrição da Empresa" name="descricao"  rows="10" ><c:if test="${not empty fornecedor}">${fornecedor.descricao}</c:if></textarea>
										</div>
									</div>
									
									<div class="form-group">
										<label class="col-md-3 control-label">Categoria <span class="required">
										* </span></label>
										<div class="col-md-4">
										<select id="categoria" name="categoria"
											class="form-control select2me"
											onkeyup="focusProxElementoOnEnter(event, 'servicos');" >
											<option value="0">Selecione uma categoria</option>
											<c:forEach var="categoria" items='${categoria}'>
												<c:choose>
													<c:when
														test="${fornecedor_categoria.codigo == categoria.codigo}">
														<option selected value="${categoria.codigo}">${categoria.descricao}</option>
													</c:when>
													<c:otherwise>
														<option value="${categoria.codigo}">${categoria.descricao}</option>
													</c:otherwise>
												</c:choose>
											</c:forEach>
										</select>
										</div>
									</div>	
									
									
									<div class="form-group">
										<label class="control-label col-md-3" id="servicos" name="servicos">Serviços adicionais
										</label>
										<div class="col-md-4">
										<textarea class="form-control" id="descricao" placeholder="Descrição dos Serviços adicionais" name="servicos"  rows="10" ><c:if test="${not empty fornecedor}">${fornecedor.descricao}</c:if></textarea>
										</div>
									</div>
									
									
									<div class="form-group">
										<label class="control-label col-md-3">Nº Documento <span class="required">
										* </span>
										</label>
										<div class="col-md-4">
											<input type="text" class="form-control"
												id="numeroDocumento"
												placeholder="Número do Documento (CNPJ ou CPF ou IE)"
												 onblur="consultarDocumentoEmUso('<%=BibliotecaUrl.getInstance().getUrl(Constantes.LINK_AJAX_CONTROLADOR, Constantes.LINK_CONSULTA_DOCUMENTO)%>' , 'GET' , 'numeroDocumento' , 'idFornecedor' , '<%=Constantes.SIGLA_TIPO_USUARIO_FORNECEDOR%>');"
												name="numeroDocumento" maxlength="18"
												onkeyup="focusProxElementoOnEnter(event, 'horarioAtendimento');"
												
												value="<c:if test="${not empty fornecedor}">${fornecedor.numeroDocumento}</c:if>" />
												<input type="hidden" id="isDocumentoEmUso" name="isDocumentoEmUso" value="false"/>
										</div>
									</div>
									
									<div class="form-group">
										<label class="control-label col-md-3">Horário <span class="required">
										* </span>
										</label>
										<div class="col-md-4">
											<input type="text" class="form-control campo_horario"
											id="horarioAtendimento" placeholder="07:00h às 22:00h"
											name="horarioAtendimento" maxlength="20"
											onkeyup="focusProxElementoOnEnter(event, 'estado');"
											value="<c:if test="${not empty fornecedor}">${fornecedor.horarioAtendimento}</c:if>" />
										</div>
									</div>
									
									<div class="form-group">
										<label class="col-md-3 control-label">Estado</label>
										<div class="col-md-4">
									<select onkeyup="focusProxElementoOnEnter(event, 'cidade');" id="estado" name="estado" class="form-control select2me"
											onchange="consultarCidadesPorEstadoAjax('<%=BibliotecaUrl.getInstance().getUrl(Constantes.LINK_AJAX_CONTROLADOR, Constantes.LINK_CONSULTA_CIDADES_ESTADO)%>' , 'GET' , 'estado' , 'cidade' , null );">
											<option value="0">Selecione uma estado</option>
											<c:forEach var="estado" items='${estado}'>
												<c:choose>
													<c:when test="${endereco.cidade.estado.codigo == estado.codigo}">
														<option selected value="${estado.codigo}">${estado.descricao}</option>
													</c:when>
													<c:otherwise>
														<option value="${estado.codigo}">${estado.descricao}</option>
													</c:otherwise>
												</c:choose>
											</c:forEach>
										</select>
								</div>
							</div>

					


					
						<div class="form-group">
										<label class="col-md-3 control-label">Cidade</label>
										<div class="col-md-4">
									<select onkeyup="focusProxElementoOnEnter(event, 'bairro');" id="cidade" name="cidade" class="form-control select2me">
										<option value="0">Selecione uma cidade</option>
										<c:forEach var="cidade" items='${cidade}'>
											<c:choose>
												<c:when test="${endereco.cidade.codigo == cidade.codigo}">
													<option selected value="${cidade.codigo}">${cidade.descricao}</option>
												</c:when>
												<c:otherwise>
													<option value="${cidade.codigo}">${cidade.descricao}</option>
												</c:otherwise>
											</c:choose>
										</c:forEach>
									</select>
								</div>
							</div>
							
							
							<div class="form-group">
										<label class="control-label col-md-3">Bairro
										</label>
										<div class="col-md-4">
											<input type="text" class="form-control" id="bairro"
												maxlength="20" placeholder="Bairro" name="bairro"
												onkeyup="focusProxElementoOnEnter(event, 'logradouro');"
												value="<c:if test="${not empty endereco}">${endereco.bairro}</c:if>" />	
										</div>
									</div>
							
								
								
								<div class="form-group">
										<label class="control-label col-md-3">Logradouro
										</label>
										<div class="col-md-4">
											<input type="text" class="form-control" id="logradouro"
								placeholder="Logradouro" name="logradouro" maxlength="20"
								onkeyup="focusProxElementoOnEnter(event, 'cep');"
								value="<c:if test="${not empty endereco}">${endereco.logradouro}</c:if>" />
										</div>
									</div>
									
									
									
								
							<div class="form-group">
										<label class="control-label col-md-3">CEP
										</label>
										<div class="col-md-4">	
								<input type="text" class="form-control cep" id="cep"
								placeholder="CEP" name="cep" maxlength="10"
								onkeyup="focusProxElementoOnEnter(event, 'numero');"
								value="<c:if test="${not empty endereco}">${endereco.cep}</c:if>" />
							</div>
							</div>
				

					
								<div class="form-group">
										<label class="control-label col-md-3">Número
										</label>
										<div class="col-md-4">	
							<input type="text" class="form-control" id="numero"
								placeholder="Nº" name="numero" maxlength="10"
								onkeyup="focusProxElementoOnEnter(event, 'complemento');"
								value="<c:if test="${not empty endereco}">${endereco.numero}</c:if>" />
									</div>
							</div>

			

						<div class="form-group">
										<label class="control-label col-md-3">Complemento
										</label>
										<div class="col-md-4">	
							<input type="text" class="form-control" id="complemento"
								placeholder="Complemento" name="complemento" maxlength="100"
								onkeyup="focusProxElementoOnEnter(event, 'telefone1');"
								value="<c:if test="${not empty endereco}">${endereco.complemento}</c:if>" />
								</div>
							</div>
									
								
								
								
								
						<c:set var="count" value="1" scope="page" />
						<c:if test='${fn:length(telefone) gt 0}'>

							<c:forEach var="telefone" items='${telefone}'>

								
								<div class="form-group">
										<label class="control-label col-md-3">Telefone <span class="required">
										* </span>
										</label>
										<div class="col-md-4">
									<input type="text" class="form-control telefone"
										id="telefone${count}" placeholder="(DDD) 9999-9999"
										name="telefone${count}" maxlength="15"
										onkeyup="focusProxElementoOnEnter(event, 'contato${count}');"
										value='<c:if test="${not empty telefone}">${telefone.telefone}</c:if>' />
								</div>		
								</div>
										
										
								<div class="form-group">
										<label class="control-label col-md-3">Contato
										</label>
										<div class="col-md-4">
									<input type="text" class="form-control"
										id="contato${count}" placeholder="Contato"
										name="contato${count}" maxlength="30"
										<c:choose>
											<c:when test='${count eq 3}'>
													onkeyup="focusProxElementoOnEnter(event, 'btnCadastrar');"
											</c:when>
											<c:otherwise>
													onkeyup="focusProxElementoOnEnter(event, 'telefone${count+1}');"
											</c:otherwise>
										</c:choose>
										value='<c:if test="${not empty telefone}">${telefone.contato}</c:if>' />

									</div>
									</div>
							
								<input type="hidden" id="idTelefone${count}"
									name="idTelefone${count}"
									value='<c:if test="${not empty telefone.codigo}">${telefone.codigo}</c:if>'/>
								<c:set var="count" value="${count + 1}" scope="page" />
							</c:forEach>
						</c:if>


						<!--  end="3"  QUANTIDADE MÁXIMA DE TELEFONES QUE PODE CONTER -->
						<c:if test='${count gt 0}'>
							<c:forEach begin="${count}" end="3">
								
								
								<div class="form-group">
										<label class="control-label col-md-3">Telefone
										</label>
										<div class="col-md-4">
									<input type="text" class="form-control input-lg telefone"
										id="telefone${count}" placeholder="(DDD) 9999-9999"
										name="telefone${count}" value='' maxlength="15" 
													onkeyup="focusProxElementoOnEnter(event, 'contato${count}');"
										
										/> 
										
										</div></div>
										
								
								<div class="form-group">
										<label class="control-label col-md-3">Contato 
										</label>
										<div class="col-md-4">		
									<input
										type="text" class="form-control input-lg" id="contato${count}"
										placeholder="Contato" maxlength="30" name="contato${count}"
										value=''
										<c:choose>
											<c:when test='${count eq 3}'>
													onkeyup="focusProxElementoOnEnter(event, 'btnCadastrar');"
											</c:when>
											<c:otherwise>
													onkeyup="focusProxElementoOnEnter(event, 'telefone${count+1}');"
											</c:otherwise>
										</c:choose>
										 />
									
									</div></div>	 
										 
					
							
								<input type="hidden" id="idTelefone${count}"
									name="idTelefone${count}" value='' />
								<c:set var="count" value="${count + 1}" scope="page" />
							</c:forEach>
						</c:if>
								
								
								
				
								
									
									
								<div class="form-actions">
									<div class="row">
										<div class="col-md-offset-3 col-md-9">
											<button type="submit" class="btn green">Confirmar</button>
										</div>
									</div>
								</div>
							</form>
							<!-- END FORM-->
						</div>
						<!-- END VALIDATION STATES-->
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
<script src="<c:url value = "/resources/metronic/assets/admin/pages/scripts/form-validation.js" />"></script>
<!-- END PAGE LEVEL STYLES -->
<script>
jQuery(document).ready(function() {   
   // initiate layout and plugins
   Metronic.init(); // init metronic core components
   Layout.init(); // init current layout

   FormValidation.init();
   
});
</script>

<script type="text/javascript" src="<c:url value="/resources/js/jquery.mask.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/bibliotecaAjax.js"/>"></script>	
<script type="text/javascript" src="<c:url value="/resources/js/bibliotecaValidacaoDataHora.js"/>"></script>
<script type="text/javascript" charset="UTF-8" src="<c:url value="/resources/js/bibliotecaMascara.js"/>"></script>
</body>
<!-- END BODY -->
</html>