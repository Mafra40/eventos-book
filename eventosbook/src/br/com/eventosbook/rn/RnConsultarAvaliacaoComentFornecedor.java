package br.com.eventosbook.rn;

import java.util.List;

import br.com.eventosbook.rn.consultas.ConsultarAvaliacaoComentFornecedor;
import br.com.eventosbook.rn.consultas.filtro.FiltroConsultarAvaliacaoComentFornecedor;
/**Regra que implementa a consulta dos comentários e avaliações do fornecedor.
 * 
 * @author rodrigo.leite
 *
 */
public class RnConsultarAvaliacaoComentFornecedor {
	
	private RnConsultarAvaliacaoComentFornecedor() {}

	private static RnConsultarAvaliacaoComentFornecedor aRnConsultarComentarioFornecedor = new RnConsultarAvaliacaoComentFornecedor();

	public static RnConsultarAvaliacaoComentFornecedor getInstance(){
		if(RnConsultarAvaliacaoComentFornecedor.aRnConsultarComentarioFornecedor == null){
			RnConsultarAvaliacaoComentFornecedor.aRnConsultarComentarioFornecedor = new RnConsultarAvaliacaoComentFornecedor();
		}

		return RnConsultarAvaliacaoComentFornecedor.aRnConsultarComentarioFornecedor;
	}
	
	
	public List<FiltroConsultarAvaliacaoComentFornecedor> executar(FiltroConsultarAvaliacaoComentFornecedor pFiltroConsultarComentarioFornecedor){
		return ConsultarAvaliacaoComentFornecedor.getInstance().consultar(pFiltroConsultarComentarioFornecedor);
	}

}
