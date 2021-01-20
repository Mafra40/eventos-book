<%@page import="br.com.eventosbook.constante.Constantes"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<script>
//variavel global
	var linkConsultaDocumento = '<%=Constantes.LINK_AJAX_CONTROLADOR+"/"+Constantes.LINK_CONSULTA_DOCUMENTO%>';
	var idContratante = "idContratante";
	var tipoContratante = '<%=Constantes.SIGLA_TIPO_USUARIO_CONTRATANTE%>';
	var tipoDocumento = "CPF";
		
</script>
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
					<a href="<%=Constantes.LINK_HOME_FORNECEDOR%>">Home</a>
					<i class="fa fa-circle"></i>
				</li>
				<li>
					<a href="<%=Constantes.LINK_ALTERACAO_FORNECEDOR%>">Perfil Fornecedor</a>
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
					action="<%=Constantes.LINK_EFETUAR_ALTERACAO_CONTRATANTE%>"
					method="POST" class="form-horizontal"
					onkeydown="ignoraSubmitFormOnEnter(event);"
					>
					
						<input type="hidden" id="idUsuario" name="idUsuario"
							value='<c:if test="${not empty contratante}">${contratante.usuario.codigo}</c:if>' />
						<input type="hidden" id="idContratante" name="idContratante"
							value='<c:if test="${not empty contratante}">${contratante.codigo}</c:if>' />
						<input type="hidden" id="idEndereco" name="idEndereco"
							value='<c:if test="${not empty endereco}">${endereco.codigo}</c:if>' />
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
							<input type="text" class="form-control" id="nome"
								value='<c:if test="${not empty contratante}">${contratante.nome}</c:if>'
								
								onkeyup="focusProxElementoOnEnter(event, 'CPF');"
									
								placeholder="Digite seu Nome Completo" name="nome" maxlength="255" />
						</div></div>


						<div class="form-group">
										<label class="control-label col-md-3">CPF <span class="required">
										* </span>
										</label>
										<div class="col-md-4">
							<input type="text" class="form-control cpf" id="CPF"
								placeholder="CPF" name="CPF" maxlength="15"
								onkeydown="focusProxElementoOnEnter(event, 'sexo');"
									onblur="consultarDocumentoEmUso('<%=BibliotecaUrl.getInstance().getUrl(Constantes.LINK_AJAX_CONTROLADOR, Constantes.LINK_CONSULTA_DOCUMENTO)%>' , 'GET' , 'CPF' , 'idContratante' , '<%=Constantes.SIGLA_TIPO_USUARIO_CONTRATANTE%>');"
									 value="<c:if test="${not empty contratante}">${contratante.cpf}</c:if>" />
							<input class="form-control"  type="hidden" id="isDocumentoEmUso" name="isDocumentoEmUso" value="false"/>

						</div></div>

						<div class="form-group">
										<label class="col-md-3 control-label">Sexo </label>
										<div class="col-md-4">
							<select onkeydown="focusProxElementoOnEnter(event, 'dataNascimento');" id="sexo" name="sexo" class="form-control select2me">
								<option value="N">Selecione seu sexo</option>
								<c:forEach var="sexo" items='${slSexo}'>
									<option ${sexo.selected} value="${sexo.valor}">${sexo.descricao}</option>
								</c:forEach>
							</select>

						</div></div>

		
						<div class="form-group">
										<label class="control-label col-md-3">Data de nascimento <span class="required">
										* </span>
										</label>
										<div class="col-md-4">
						
							<input type="text" class="form-control data"
								id="dataNascimento" placeholder="Data Nacimento"
								name="dataNascimento"
								onkeyup="formatarCampoData(this, event, false);" 
								onkeydown="focusProxElementoOnEnter(event, 'estado');"
								maxlength="10"
								value="<fmt:formatDate value='${contratante.dataNascimento.time}' type='date' pattern="dd/MM/yyyy" />" />
						</div></div>




							<div class="form-group">
										<label class="col-md-3 control-label">Estado </label>
										<div class="col-md-4">
							<select onkeydown="focusProxElementoOnEnter(event, 'cidade');" 
									id="estado" name="estado" class="form-control select2me"
									onchange="consultarCidadesPorEstadoAjax('<%=BibliotecaUrl.getInstance().getUrl(Constantes.LINK_AJAX_CONTROLADOR, Constantes.LINK_CONSULTA_CIDADES_ESTADO)%>' , 'GET' , 'estado' , 'cidade' );"
									>
								<option value="0">Selecione um estado</option>
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

						</div></div>


							<div class="form-group">
										<label class="col-md-3 control-label">Cidade </label>
										<div class="col-md-4">
							<select onkeydown="focusProxElementoOnEnter(event, 'bairro');" id="cidade" name="cidade" class="form-control select2me">
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

						</div></div>
							
						<div class="form-group">
										<label class="control-label col-md-3">Bairro
										</label>
										<div class="col-md-4">
							<input type="text" class="form-control " id="bairro"
								placeholder="Bairro" name="bairro" maxlength="20" onkeydown="focusProxElementoOnEnter(event, 'logradouro');"
								value="<c:if test="${not empty endereco}">${endereco.bairro}</c:if>" />



						</div></div>




						<div class="form-group">
										<label class="control-label col-md-3">Logradouro
										</label>
										<div class="col-md-4">
							<input onkeydown="focusProxElementoOnEnter(event, 'cep');" type="text" class="form-control " id="logradouro"
								placeholder="logradouro" name="logradouro" maxlength="200"
								value="<c:if test="${not empty endereco}">${endereco.logradouro}</c:if>" />



						</div></div>

						<div class="form-group">
										<label class="control-label col-md-3">CEP
										</label>
										<div class="col-md-4">
							<input type="text" class="form-control cep" id="cep" onkeydown="focusProxElementoOnEnter(event, 'numero');"
								placeholder="CEP" name="cep" maxlength="15"
								value="<c:if test="${not empty endereco}">${endereco.cep}</c:if>" />

						</div></div>

						<div class="form-group">
										<label class="control-label col-md-3">Número
										</label>
										<div class="col-md-4">
							<input type="text" class="form-control " id="numero" onkeydown="focusProxElementoOnEnter(event, 'complemento');"
								placeholder="Nº" name="numero" maxlength="5"
								value="<c:if test="${not empty endereco}">${endereco.numero}</c:if>" />



						</div></div>

						<div class="form-group">
										<label class="control-label col-md-3">Complemento
										</label>
										<div class="col-md-4">
							<input type="text" class="form-control" id="complemento"
								placeholder="Complemento" name="complemento" maxlength="100"
								onkeydown="focusProxElementoOnEnter(event, 'telefone1');"
								value="<c:if test="${not empty endereco}">${endereco.complemento}</c:if>" />

						</div></div>



						<c:set var="count" value="1" scope="page" />
						<c:if test='${fn:length(telefone) gt 0}'>

							<c:forEach var="telefone" items="${telefone}">

								<div class="form-group">
										<label class="control-label col-md-3">Telefone
										</label>
										<div class="col-md-4">
									<input type="text" class="form-control telefone"
										id="telefone${count}" placeholder="(DDD) 9999-9999"
										name="telefone${count}" maxlength="20"
										
										<c:choose>
										<c:when test='${count eq 3}'>
												onkeydown="focusProxElementoOnEnter(event, 'btnCadastrar');"
										</c:when>
										<c:otherwise>
												onkeydown="focusProxElementoOnEnter(event, 'telefone${count+1}');"
										</c:otherwise>
									</c:choose>
										
										value='<c:if test="${not empty telefone}">${telefone.telefone}</c:if>' />
									<form:errors path="formulario.telefone${count}"
										cssStyle="color:red" />
								</div></div>
								<input type="hidden" id="idTelefone${count}"
									name="idTelefone${count}"
									
									value='<c:if test="${not empty telefone.codigo}">${telefone.codigo}</c:if>' />
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
									<input type="text" class="form-control telefone"
										id="telefone${count}" placeholder="(DDD) 9999-9999" maxlength="20"
										name="telefone${count}" 
										
									<c:choose>
										<c:when test='${count eq 3}'>
												onkeydown="focusProxElementoOnEnter(event, 'btnCadastrar');"
										</c:when>
										<c:otherwise>
												onkeydown="focusProxElementoOnEnter(event, 'telefone${count+1}');"
										</c:otherwise>
									</c:choose>
										
										value='' />
									<form:errors path="formulario.telefone${count}"
										cssStyle="color:red" />
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
</html>
