package br.com.eventosbook.rn;

import java.util.List;

import br.com.eventosbook.modelo.MeuFornecedor;
import br.com.eventosbook.rn.consultas.ConsultarMeuFornecedorPorContratante;
import br.com.eventosbook.rn.consultas.filtro.FiltroConsultarMeuFornecedorPorContratante;

/**Classe que implementa RN de consultar por filtro.
 * 
 * @author rodrigo.leite
 *
 */
public class RnConsultarMeuFornecedorPorContratante {
	
	private RnConsultarMeuFornecedorPorContratante() {}

	private static RnConsultarMeuFornecedorPorContratante aRnConsultarContratante = new RnConsultarMeuFornecedorPorContratante();

	public static RnConsultarMeuFornecedorPorContratante getInstance(){
		if(RnConsultarMeuFornecedorPorContratante.aRnConsultarContratante == null){
			RnConsultarMeuFornecedorPorContratante.aRnConsultarContratante = new RnConsultarMeuFornecedorPorContratante();
		}

		return RnConsultarMeuFornecedorPorContratante.aRnConsultarContratante;
	}
	
	
	public List<MeuFornecedor> executar(FiltroConsultarMeuFornecedorPorContratante pFiltroConsultarMeuFornecedorPorContratante){
		return ConsultarMeuFornecedorPorContratante.getInstance().consultar(pFiltroConsultarMeuFornecedorPorContratante);
	}

}
