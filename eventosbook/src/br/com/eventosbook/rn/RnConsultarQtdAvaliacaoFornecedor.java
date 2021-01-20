package br.com.eventosbook.rn;

import br.com.eventosbook.rn.consultas.ConsultarQtdAvaliacoesFornecedor;
import br.com.eventosbook.rn.consultas.filtro.FiltroConsultarQtdAvaliacoesFornecedor;

public class RnConsultarQtdAvaliacaoFornecedor {

	
	private RnConsultarQtdAvaliacaoFornecedor() {}

	private static RnConsultarQtdAvaliacaoFornecedor aRnConsultarComentarioFornecedor = new RnConsultarQtdAvaliacaoFornecedor();

	public static RnConsultarQtdAvaliacaoFornecedor getInstance(){
		if(RnConsultarQtdAvaliacaoFornecedor.aRnConsultarComentarioFornecedor == null){
			RnConsultarQtdAvaliacaoFornecedor.aRnConsultarComentarioFornecedor = new RnConsultarQtdAvaliacaoFornecedor();
		}

		return RnConsultarQtdAvaliacaoFornecedor.aRnConsultarComentarioFornecedor;
	}
	
	
	public Integer executar(FiltroConsultarQtdAvaliacoesFornecedor pFiltroConsultarQtdAvaliacoesFornecedor){
		return ConsultarQtdAvaliacoesFornecedor.getInstance().consultar(pFiltroConsultarQtdAvaliacoesFornecedor);
	}

}
