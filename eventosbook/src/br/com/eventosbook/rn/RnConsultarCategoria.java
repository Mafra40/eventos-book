package br.com.eventosbook.rn;

import java.util.List;

import br.com.eventosbook.dao.impl.DaoCategoriaImpl;
import br.com.eventosbook.modelo.Categoria;

public class RnConsultarCategoria  {
	
	
private RnConsultarCategoria() {}
	
	private static RnConsultarCategoria aRnConsultarCategoria = new RnConsultarCategoria();
	
	public static RnConsultarCategoria getInstance(){
		if(RnConsultarCategoria.aRnConsultarCategoria == null){
			RnConsultarCategoria.aRnConsultarCategoria = new RnConsultarCategoria();
		}
		
		return RnConsultarCategoria.aRnConsultarCategoria;
	}
	
	public List<Categoria> executar(){
		return DaoCategoriaImpl.getInstance().consultar();
	}


}
