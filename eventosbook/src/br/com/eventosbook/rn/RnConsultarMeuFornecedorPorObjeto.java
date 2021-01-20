package br.com.eventosbook.rn;

import br.com.eventosbook.dao.impl.DaoMeuFornecedorImpl;
import br.com.eventosbook.modelo.MeuFornecedor;

public class RnConsultarMeuFornecedorPorObjeto {
	
private static RnConsultarMeuFornecedorPorObjeto aRnConsultarEventoContratante = new RnConsultarMeuFornecedorPorObjeto();
	
	public static RnConsultarMeuFornecedorPorObjeto getInstance(){
		if(RnConsultarMeuFornecedorPorObjeto.aRnConsultarEventoContratante == null){
			RnConsultarMeuFornecedorPorObjeto.aRnConsultarEventoContratante = new RnConsultarMeuFornecedorPorObjeto();
		}
		
		return RnConsultarMeuFornecedorPorObjeto.aRnConsultarEventoContratante;
	}
	
	
	public MeuFornecedor executar(Integer id){
		MeuFornecedor MeuFornecedor = new MeuFornecedor();
		MeuFornecedor.setCodigo(id);
		MeuFornecedor = DaoMeuFornecedorImpl.getInstance().getMeuFornecedor(MeuFornecedor);
		
		return MeuFornecedor;
	}

}
