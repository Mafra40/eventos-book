package br.com.eventosbook.rn;

import br.com.eventosbook.dao.impl.DaoCategoriaImpl;
import br.com.eventosbook.modelo.Categoria;

public class RnConsultarCategoriaPorObjeto {
	
	private RnConsultarCategoriaPorObjeto() {}

	private static RnConsultarCategoriaPorObjeto aRnConsultarContratante = new RnConsultarCategoriaPorObjeto();

	public static RnConsultarCategoriaPorObjeto getInstance(){
		if(RnConsultarCategoriaPorObjeto.aRnConsultarContratante == null){
			RnConsultarCategoriaPorObjeto.aRnConsultarContratante = new RnConsultarCategoriaPorObjeto();
		}

		return RnConsultarCategoriaPorObjeto.aRnConsultarContratante;
	}
	
	
	public Categoria executar(Categoria pCategoria){
		return DaoCategoriaImpl.getInstance().getCategoria(pCategoria);
	}
}
