<%@page import="br.com.eventosbook.constante.Constantes"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Alteração</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/style_page.css" />" />
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/bootstrap/css/bootstrap.min.css" />" />
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/jasny-bootstrap/css/jasny-bootstrap.css" />" />

</head>
<body>

	<div class="row">
		<div class="col-sm-4">
		
		<%@include file="menu.jsp"%>
		</div>
		<div class="col-sm-6">
			<div class="container-fluid">
				<form id="form" action="<%=Constantes.LINK_EFETUAR_ALTERACAO_FORNECEDOR%>"
					method="POST" class="form-horizontal">
					<div class="form-group">
						<input type="hidden" id="idUsuario" name="idUsuario"
							value='<c:if test="${not empty fornecedor}">${fornecedor.usuario.codigo}</c:if>' />
						<input type="hidden" id="idFornecedor" name="idFornecedor"
							value='<c:if test="${not empty fornecedor}">${fornecedor.codigo}</c:if>' />
						<input type="hidden" id="idEndereco" name="idEndereco"
							value='<c:if test="${not empty endereco}">${endereco.codigo}</c:if>' />

						<div class="form-group">
							<input type="text" class="form-control input-lg" id="nome"
								value='<c:if test="${not empty fornecedor}">${fornecedor.nome}</c:if>'
								placeholder="Digite seu Nome Completo" name="nome" maxlength="255" />

							<form:errors path="formulario.nome" cssStyle="color:red" />

						</div>
						
						<div class="form-group">
							<textarea class="form-control input-lg" id="descricao" placeholder="Breve descrição da Empresa" name="descricao" >
							<c:if test="${not empty fornecedor}">${fornecedor.descricao}</c:if>
							</textarea>

							<form:errors path="formulario.descricao" cssStyle="color:red" />

						</div>
						
						
						<div class="form-group">

							<select id="categoria" name="categoria" class="form-control input-lg">
								<option value="0">Selecione uma categoria</option>
								<c:forEach var="categoria" items='${categoria}'>
									<c:choose>
										<c:when test="${fornecedor_categoria.codigo == categoria.codigo}">
											<option selected value="${categoria.codigo}">${categoria.descricao}</option>
										</c:when>
										<c:otherwise>
											<option value="${categoria.codigo}">${categoria.descricao}</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</select>
							<form:errors path="formularioContratante.estado"
								cssStyle="color:red" />
						</div>
	
	
						<div class="form-group">
							<textarea class="form-control input-lg" id="servicos" placeholder="Serviços Adicionais" name="servicos" >
							
							</textarea>

							<form:errors path="formulario.servicos" cssStyle="color:red" />

						</div>

						<div class="form-group">
							<input type="text" class="form-control input-lg" id="numeroDocumento"
								placeholder="" name="numeroDocumento" maxlength="18"
								value="<c:if test="${not empty fornecedor}">${fornecedor.numeroDocumento}</c:if>" />

							<form:errors path="formularioContratante.numeroDocumento"
								cssStyle="color:red" />

						</div>


						<div class="form-group">
							<input type="text" class="form-control input-lg"
								id="horarioAtendimento" placeholder="07:00h às 22:00h"
								name="horarioAtendimento"
								maxlength="20"
								value="<c:if test="${not empty fornecedor}">${fornecedor.horarioAtendimento}</c:if>" />

							<form:errors path="formularioContratante.horarioAtendimento"
								cssStyle="color:red" />

						</div>

						
						
						
						
						<div class="form-group">

							<select id="estado" name="estado" class="form-control input-lg">
								<option value="0">Selecione uma estado</option>
								<c:forEach var="estado" items='${estado}'>
									<c:choose>
										<c:when test="${endereco.estado.codigo == estado.codigo}">
											<option selected value="${estado.codigo}">${estado.descricao}</option>
										</c:when>
										<c:otherwise>
											<option value="${estado.codigo}">${estado.descricao}</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</select>
							<form:errors path="formularioContratante.estado"
								cssStyle="color:red" />
						</div>
						

						<div class="form-group">

							<select id="cidade" name="cidade" class="form-control input-lg">
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
							<form:errors path="formularioContratante.cidade"
								cssStyle="color:red" />
						</div>
	
						<div class="form-group">
							<input type="text" class="form-control input-lg" id="bairro" maxlength="20"
								placeholder="" name="bairro"
								value="<c:if test="${not empty endereco}">${endereco.bairro}</c:if>" />

							<form:errors path="formulario.bairro" cssStyle="color:red" />

						</div>
						
						
						

						<div class="form-group">
							<input type="text" class="form-control input-lg" id="logradouro"
								placeholder="" name="logradouro" maxlength="20"
								value="<c:if test="${not empty endereco}">${endereco.logradouro}</c:if>" />

							<form:errors path="formulario.logradouro" cssStyle="color:red" />

						</div>

						<div class="form-group">
							<input type="text" class="form-control input-lg" id="cep"
								placeholder="" name="cep" maxlength="10"
								value="<c:if test="${not empty endereco}">${endereco.cep}</c:if>" />

							<form:errors path="formulario.cep" cssStyle="color:red" />

						</div>

						<div class="form-group">
							<input type="text" class="form-control input-lg" id="numero"
								placeholder="" name="numero" maxlength="10"
								value="<c:if test="${not empty endereco}">${endereco.numero}</c:if>" />

							<form:errors path="formulario.numero" cssStyle="color:red" />

						</div>

						<div class="form-group">
							<input type="text" class="form-control input-lg" id="complemento"
								placeholder="" name="complemento" maxlength="100"
								value="<c:if test="${not empty endereco}">${endereco.complemento}</c:if>" />

							<form:errors path="formulario.complemento" cssStyle="color:red" />

						</div>
						
						

						<c:set var="count" value="1" scope="page" />
						<c:if test='${fn:length(telefone) gt 0}'>

							<c:forEach var="telefone" items='${telefone}'>

								<div class="form-group">

									<input type="text" class="form-control input-lg"
										id="telefone${count}" placeholder="(81) 9999-9999"
										name="telefone${count}" maxlength="15"
										value='<c:if test="${not empty telefone}"> ${telefone.telefone}</c:if>' />
										
										<input type="text" class="form-control input-lg"
										id="contato${count}" placeholder="Contato"
										name="contato${count}" maxlength="30"
										value='<c:if test="${not empty telefone}"> ${telefone.contato}</c:if>' />	
										
									<form:errors path="formulario.telefone${count}"
										cssStyle="color:red" />
								</div>
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

									<input type="text" class="form-control input-lg"
										id="telefone${count}" placeholder="(81) 9999-9999"
										name="telefone${count}" value='' maxlength="15" />
										
										<input type="text" class="form-control input-lg"
										id="contato${count}" placeholder="Contato" maxlength="30"
										name="contato${count}"
										value='' />	
									<form:errors path="formulario.telefone${count}"
										cssStyle="color:red" />
								</div>
								<input type="hidden" id="idTelefone${count}"
									name="idTelefone${count}" value='' />
								<c:set var="count" value="${count + 1}" scope="page" />
							</c:forEach>
						</c:if>



						<div class="form-group">

							<input type="password" class="form-control input-lg"
								id="senha" placeholder="Alterar Senha" name="senha"
								value='' maxlength="20" />
							<form:errors path="formulario.senha" cssStyle="color:red" />
						</div>

						<div class="form-group">

							<input type="password" class="form-control input-lg"
								id="confirmSenha" placeholder="Confirme sua senha" maxlength="20"
								name="confirmSenha" />
							<form:errors path="formulario.confirmSenha" cssStyle="color:red" />
						</div>



						<div class="form-group">


							<input type="submit" id="btnCadastrar" class="btn btn-primary"
								value="Confirmar">

						</div>

					</div>
				</form>
			</div>
		</div>
		<div class="col-sm-2"></div>
	</div>

	<script>
		var nome = document.getElementById("nome");
		var cpf = document.getElementById("documento");
		var descricao = document.getElementById("descricao");
		var horarioAtendimento = document.getElementById("horarioAtendimento");
		var categoria = document.getElementById("categoria");
		var logradouro = document.getElementById("logradouro");
		var cep = document.getElementById("cep");
		var numero = document.getElementById("numero");
		var complemento = document.getElementById("complemento");
		var bairro = document.getElementById("bairro");
		var cidade = document.getElementById("cidade");
		var senha = document.getElementById("senha");
		var senhaRepetida = document.getElementById("confirmSenha");
		var telefone1 = document.getElementById("telefone1");
		var telefone2 = document.getElementById("telefone2");
		var telefone3 = document.getElementById("telefone3");
		
		var form = document.getElementById("form");
		
		//valida antes de submeter o formulário
		form.onsubmit = function() {
				if (nome.value.length <= 4){
					alert("Campo obrigatório");
					nome.focus();
					return false;
				}
				
				if (logradouro.value.length <= 4){
					alert("Campo obrigatório");
					logradouro.focus();
					return false;
				}
				
				if (horarioAtendimento.value.length <= 4){
					alert("Campo obrigatório");
					horarioAtendimento.focus();
					return false;
				}
				
				
				if (categoria.options[categoria.selectedIndex].value == '0'){
					alert("Campo obrigatório");
					categoria.focus();
					return false;
				}
				
				if (telefone1.value.length <= 4 && telefone2.value.length <= 4 && telefone2.value.length <= 4){
					alert("Pelo menos 1 telefone válido deve ser preenchido.");
					telefone1.focus();
					return false;
				}
				
				if (dataNascimeno.value.length == 0){
					alert("Campo obrigatório");
					dataNascimeno.focus();
					return false;
				}
				
				
				
				if (senha.value.length > 0 || senhaRepetida.value.length > 0) {
						if (senha.value.length <= 4 || senhaRepetida.value.length <= 4) {
		
							alert("Tamanho de senha invalido.");
							if (senhaRepetida.value.length <= 4) {
								senhaRepetida.focus();
							}
							if (senha.value.length <= 4) {
								senha.focus();
							}
							return false;
							
						}
						
						if (senha.value != senhaRepetida.value) {
							alert("A senhas estão diferente");
							senha.focus();
							return false;
						}
					}
				
			return true;
		}
	</script>

</body>
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery-2.1.3.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/bootstrap/js/bootstrap.min.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/jasny-bootstrap/js/jasny-bootstrap.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/bibliotecaFuncao.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/bibliotecaValidacaoDataHora.js"/>"></script>
</html>