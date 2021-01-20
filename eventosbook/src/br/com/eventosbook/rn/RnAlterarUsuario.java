package br.com.eventosbook.rn;

import br.com.eventosbook.dao.impl.DaoUsuarioImpl;
import br.com.eventosbook.modelo.Usuario;

public class RnAlterarUsuario {
private static RnAlterarUsuario aRnAlterarUsuario = new RnAlterarUsuario();
	
	public static RnAlterarUsuario getInstance(){
		if(RnAlterarUsuario.aRnAlterarUsuario == null){
			RnAlterarUsuario.aRnAlterarUsuario = new RnAlterarUsuario();
		}
		
		return RnAlterarUsuario.aRnAlterarUsuario;
	}
	
	public void executar(Usuario pUsuario){
		DaoUsuarioImpl.getInstance().alterar(pUsuario);
	}

	
}
