package br.com.eventosbook.rn;

import br.com.eventosbook.dao.impl.DaoFornecedorImpl;
import br.com.eventosbook.modelo.Fornecedor;

public class RnConsultarFornecedorPorObjeto {

	private RnConsultarFornecedorPorObjeto() {}

	private static RnConsultarFornecedorPorObjeto aRnConsultarFornecedorPorObjeto = new RnConsultarFornecedorPorObjeto();
	
	
	
	/**Consulta o fornecedor pelo objeto. Cascade.
	 * 
	 * @return
	 */
	public static RnConsultarFornecedorPorObjeto getInstance(){
		if(RnConsultarFornecedorPorObjeto.aRnConsultarFornecedorPorObjeto == null){
			RnConsultarFornecedorPorObjeto.aRnConsultarFornecedorPorObjeto = new RnConsultarFornecedorPorObjeto();
		}

		return RnConsultarFornecedorPorObjeto.aRnConsultarFornecedorPorObjeto;
	}
	
	
	public Fornecedor executar(Fornecedor pFornecedor){
		return DaoFornecedorImpl.getInstance().getFornecedor(pFornecedor);
	}
}
