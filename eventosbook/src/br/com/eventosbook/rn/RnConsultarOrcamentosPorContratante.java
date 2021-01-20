package br.com.eventosbook.rn;

import java.util.List;

import br.com.eventosbook.dao.impl.DaoOrcamentoImpl;
import br.com.eventosbook.modelo.Orcamento;

/**Implementa rn de consultar todos os orçamenentos de cada fornecedor e contratante.
 * 
 * @author Mafra
 *
 */
public class RnConsultarOrcamentosPorContratante {
	
private static RnConsultarOrcamentosPorContratante aRnConsultarOrcamentosPorContratante = new RnConsultarOrcamentosPorContratante();
	
	public static RnConsultarOrcamentosPorContratante getInstance(){
		if(RnConsultarOrcamentosPorContratante.aRnConsultarOrcamentosPorContratante == null){
			RnConsultarOrcamentosPorContratante.aRnConsultarOrcamentosPorContratante = new RnConsultarOrcamentosPorContratante();
		}
		
		return RnConsultarOrcamentosPorContratante.aRnConsultarOrcamentosPorContratante;
	}
	
	public  List<Orcamento> executar(Orcamento pFiltroContratanteFornecedor){
		return DaoOrcamentoImpl.getInstance().consultar(pFiltroContratanteFornecedor);
	}
}
