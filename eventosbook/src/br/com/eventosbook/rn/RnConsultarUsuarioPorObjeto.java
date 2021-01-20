package br.com.eventosbook.rn;

import br.com.eventosbook.dao.impl.DaoUsuarioImpl;
import br.com.eventosbook.modelo.Usuario;

public class RnConsultarUsuarioPorObjeto {

	private RnConsultarUsuarioPorObjeto() {}

	private static RnConsultarUsuarioPorObjeto aRnConsultarUsuarioPorObjeto = new RnConsultarUsuarioPorObjeto();

	public static RnConsultarUsuarioPorObjeto getInstance(){
		if(RnConsultarUsuarioPorObjeto.aRnConsultarUsuarioPorObjeto == null){
			RnConsultarUsuarioPorObjeto.aRnConsultarUsuarioPorObjeto = new RnConsultarUsuarioPorObjeto();
		}

		return RnConsultarUsuarioPorObjeto.aRnConsultarUsuarioPorObjeto;
	}
	
	
	public Usuario executar(Usuario pUsuario){
		return DaoUsuarioImpl.getInstance().getUsuario(pUsuario);
	}

}
