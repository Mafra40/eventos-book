package br.com.eventosbook.rn;

import br.com.eventosbook.dao.impl.DaoTipoUsuarioImpl;
import br.com.eventosbook.modelo.TipoUsuario;

public class RnIncluirTipoUsuario {
	
private static RnIncluirTipoUsuario aRnIncluirTipoUsuario = new RnIncluirTipoUsuario();
	
	public static RnIncluirTipoUsuario getInstance(){
		if(RnIncluirTipoUsuario.aRnIncluirTipoUsuario == null){
			RnIncluirTipoUsuario.aRnIncluirTipoUsuario = new RnIncluirTipoUsuario();
		}
		
		return RnIncluirTipoUsuario.aRnIncluirTipoUsuario;
	}
	
	public void executar(TipoUsuario pTipoUsuario){
		DaoTipoUsuarioImpl.getInstance().incluir(pTipoUsuario);
	}

}
