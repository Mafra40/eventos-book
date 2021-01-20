/**Depedências: jquery-2.1.3.js
 * 
 */



function marcarDesmarcarTarefaCheckList(id){
	$.get("marcarDesmarcarTarefaCheckList?id="+id);
}

//consulta as cidades de cada estado e popula do select
function consultarCidadesPorEstadoAjax(pNmLinkConsulta , pTipoRequisicao , pCampoEstado , pCampoCidade, pCidadeSelecionada ){
		
	campoSelectEstado = $("#"+pCampoEstado);
	campoSelectCidade = $("#"+pCampoCidade);
	camopSelect2Cidade = $("#"+pCampoCidade);
	
	if (campoSelectEstado.val() != 0){

		var idCidadeSelecionada = pCidadeSelecionada;


		$.ajax({
			url: pNmLinkConsulta,
			data: { id_estado: campoSelectEstado.val() },
			type: pTipoRequisicao,           

			success: function(data) {

				campoSelectCidade.empty();
				cidades = $.parseJSON(data);
				if (cidades.length > 0 ){

					campoSelectCidade.append($('<option>', {
						value: "0",
						text:  "Selecione uma cidade" 
					}));
					
					camopSelect2Cidade.select2('val', '0');
					
					//popula o select
					for (var i = 0; i < cidades.length; i++) {

						campoSelectCidade.append($('<option>', {
							value: cidades[i]["codigo"],
							text:  cidades[i]["descricao"] 
						}));


					}
					campoSelectCidade.prop("disabled" , false);

					//se pCidadeSelecionada tiver o código da cidade setado.
					if( pCidadeSelecionada != null ){
						campoSelectCidade.val(idCidadeSelecionada);
					}

				}
			}
		});
	}else {
		
		campoSelectCidade.empty();
		camopSelect2Cidade.select2('val', '0');
		campoSelectCidade.append($('<option>', {
			value: "0",
			text:  "Selecione uma cidade" 
		}));
		campoSelectCidade.prop("disabled" , true);
	}
	
}
	
	

	//Ajax que consulta se algum documento está em uso.
	function consultarDocumentoEmUso(pNmLinkConsulta , pTipoRequisicao ,pCampo , pidTipoEntidade , tipoEntidade ){
		
		campo = $("#"+pCampo);
		idTipoEntidade = $("#"+pidTipoEntidade);
		retorno = "";
		$.ajax({
			url: pNmLinkConsulta,
			data: { numeroDocumento: campo.val() , idEntidade: idTipoEntidade.val(), tipoEntidade: tipoEntidade },
			type: pTipoRequisicao,           

			success: function(data) {

				//documento = $.parseJSON(data);
				
				if (data == "false"){
					$("#isDocumentoEmUso").val("false");
					retorno = false;
				}else {
					$("#isDocumentoEmUso").val("true");
					retorno = true;
				}
			}
		});
		
	}


//execulta quando a página carregar.
$( document ).ready(function() {
	var link = $("#ajaxEstadoLink").val(); //hidden
	//consultarCidadesPorEstadoAjax(link, 'GET', 'estado' , 'cidade', null );
	
});


	
	

