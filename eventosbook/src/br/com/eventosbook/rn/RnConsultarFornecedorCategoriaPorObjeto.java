package br.com.eventosbook.rn;

import br.com.eventosbook.dao.impl.DaoCategoriaImpl;
import br.com.eventosbook.modelo.Categoria;

public class RnConsultarFornecedorCategoriaPorObjeto {
	
	
private static RnConsultarFornecedorCategoriaPorObjeto aRnConsultarFornecedorCategoriaPorObjeto = new RnConsultarFornecedorCategoriaPorObjeto();
	
	public static RnConsultarFornecedorCategoriaPorObjeto getInstance(){
		if(RnConsultarFornecedorCategoriaPorObjeto.aRnConsultarFornecedorCategoriaPorObjeto == null){
			RnConsultarFornecedorCategoriaPorObjeto.aRnConsultarFornecedorCategoriaPorObjeto = new RnConsultarFornecedorCategoriaPorObjeto();
		}
		
		return RnConsultarFornecedorCategoriaPorObjeto.aRnConsultarFornecedorCategoriaPorObjeto;
	}
	
	
	public Categoria executar(Categoria pCategoria){
		return DaoCategoriaImpl.getInstance().getCategoria(pCategoria);
	}
	

}
