package br.com.eventosbook.fachada;

import java.util.List;

import br.com.eventosbook.modelo.Cidade;
import br.com.eventosbook.rn.RnConsultarCidade;

public class CidadeServico {
	
private CidadeServico() {}
	

	private static CidadeServico aCidadeServico = new CidadeServico();
	
	public static CidadeServico getInstance(){
		if(CidadeServico.aCidadeServico == null){
			CidadeServico.aCidadeServico = new CidadeServico();
		}
		
		return CidadeServico.aCidadeServico;
	}

	/**Consulta as cidades apartir do estado.
	 * 
	 * @return
	 */
	public List<Cidade> consultarCidade(){
		return RnConsultarCidade.getInstance().executar();
	}
	
}
