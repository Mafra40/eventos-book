package br.com.eventosbook.rn;

import br.com.eventosbook.constante.Constantes;
import br.com.eventosbook.fachada.ContratanteServico;
import br.com.eventosbook.fachada.FornecedorServico;
import br.com.eventosbook.modelo.Contratante;
import br.com.eventosbook.modelo.Fornecedor;

public class RnValidarDocumentoEmUso {
	
	private RnValidarDocumentoEmUso() {}
	
	private static RnValidarDocumentoEmUso aRnValidarDocumentoEmUso = new RnValidarDocumentoEmUso();
	
	public static RnValidarDocumentoEmUso getInstance(){
		if(RnValidarDocumentoEmUso.aRnValidarDocumentoEmUso == null){
			RnValidarDocumentoEmUso.aRnValidarDocumentoEmUso = new RnValidarDocumentoEmUso();
		}
		
		return RnValidarDocumentoEmUso.aRnValidarDocumentoEmUso;
	}
	
	/**Execulta o processamento de verificar se o documento está sendo usado.
	 * 
	 * @param pTipoEntidade
	 * @param pNumeroDocumento
	 * @param pIdEntidade
	 * @return
	 */
	public String executar(String pTipoEntidade , String pNumeroDocumento , String pIdEntidade){
		String json = "";
		
		//se for tipo F
		if(pTipoEntidade.equals(Constantes.SIGLA_TIPO_USUARIO_FORNECEDOR.toString())){
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setNumeroDocumento(pNumeroDocumento);
		fornecedor = FornecedorServico.getInstance().ConsultarFornecedorPorObjeto(fornecedor);
		
		if (fornecedor != null && fornecedor.getCodigo() != null){//é pq existe.
		
			if (!pIdEntidade.equals("") ){
				if (fornecedor.getNumeroDocumento().equals(pNumeroDocumento) && fornecedor.getCodigo().toString().equals(pIdEntidade) ){ //verifica se é o mesmo.
					json = "false";
				}else{
					json = "true";
				}
			}
			
			
		}else {
			json = "false";
		}
		
		
		//se for tipo C
		}else 	if(pTipoEntidade.equals(Constantes.SIGLA_TIPO_USUARIO_CONTRATANTE.toString())){
			Contratante contratante = new Contratante();
			contratante.setCpf(pNumeroDocumento);
			contratante = ContratanteServico.getInstance().consultarContratantePorObjeto(contratante);
			if (contratante != null && contratante.getCodigo() != null){//é pq existe.
				
				if (!pIdEntidade.equals("") ){
					if (contratante.getCpf().equals(pNumeroDocumento) && contratante.getCodigo().toString().equals(pIdEntidade) ){ //verifica se é o mesmo.
						json = "false";
					}else{
						json = "true";
					}
				}
				
				
			}else {//não existe OK!
				json = "false";
			}
			
		}
		
		return json;
	}

}
