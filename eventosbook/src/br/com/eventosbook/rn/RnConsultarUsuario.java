package br.com.eventosbook.rn;

import java.util.List;

import br.com.eventosbook.dao.impl.DaoUsuarioImpl;
import br.com.eventosbook.modelo.Usuario;

public class RnConsultarUsuario {
	
	private RnConsultarUsuario() {}
	
	private static RnConsultarUsuario aRnConsultarUsuario = new RnConsultarUsuario();
	
	public static RnConsultarUsuario getInstance(){
		if(RnConsultarUsuario.aRnConsultarUsuario == null){
			RnConsultarUsuario.aRnConsultarUsuario = new RnConsultarUsuario();
		}
		
		return RnConsultarUsuario.aRnConsultarUsuario;
	}
	
	
	public List<Usuario> executar(){
		return DaoUsuarioImpl.getInstance().consultar();
	}

}
