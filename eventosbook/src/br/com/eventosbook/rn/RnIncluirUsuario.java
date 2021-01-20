package br.com.eventosbook.rn;

import br.com.eventosbook.dao.impl.DaoUsuarioImpl;
import br.com.eventosbook.modelo.Usuario;


public class RnIncluirUsuario {

	private RnIncluirUsuario() {	}
	
	
	private static RnIncluirUsuario aRnIncluirUsuario = new RnIncluirUsuario();
	
	public static RnIncluirUsuario getInstance(){
		if(RnIncluirUsuario.aRnIncluirUsuario == null){
			RnIncluirUsuario.aRnIncluirUsuario = new RnIncluirUsuario();
		}
		
		return RnIncluirUsuario.aRnIncluirUsuario;
	}
	
	
	public void executar(Usuario pUsuario){
		DaoUsuarioImpl.getInstance().incluir(pUsuario);
	}
}
