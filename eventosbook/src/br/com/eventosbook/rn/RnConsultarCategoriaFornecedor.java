package br.com.eventosbook.rn;

import java.util.List;

import br.com.eventosbook.dao.impl.DaoCategoriaImpl;
import br.com.eventosbook.modelo.Categoria;

public class RnConsultarCategoriaFornecedor {
	
private RnConsultarCategoriaFornecedor() {}
	
	private static RnConsultarCategoriaFornecedor aRnConsultarCategoriaFornecedor = new RnConsultarCategoriaFornecedor();
	
	public static RnConsultarCategoriaFornecedor getInstance(){
		if(RnConsultarCategoriaFornecedor.aRnConsultarCategoriaFornecedor == null){
			RnConsultarCategoriaFornecedor.aRnConsultarCategoriaFornecedor = new RnConsultarCategoriaFornecedor();
		}
		
		return RnConsultarCategoriaFornecedor.aRnConsultarCategoriaFornecedor;
	}
	
	public List<Categoria> executar(){
		return DaoCategoriaImpl.getInstance().consultar();
	}

}
