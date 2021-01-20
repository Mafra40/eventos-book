package br.com.eventosbook.rn;

import br.com.eventosbook.dao.impl.DaoTipoUsuarioImpl;
import br.com.eventosbook.modelo.TipoUsuario;

public class RnConsultarTipoUsuarioPorObjeto {
	
	private RnConsultarTipoUsuarioPorObjeto() {}
	
	private static RnConsultarTipoUsuarioPorObjeto aRnConsultarTipoUsuarioPorObjeto = new RnConsultarTipoUsuarioPorObjeto();
	
	public static RnConsultarTipoUsuarioPorObjeto getInstance(){
		if(RnConsultarTipoUsuarioPorObjeto.aRnConsultarTipoUsuarioPorObjeto == null){
			RnConsultarTipoUsuarioPorObjeto.aRnConsultarTipoUsuarioPorObjeto = new RnConsultarTipoUsuarioPorObjeto();
		}
		
		return RnConsultarTipoUsuarioPorObjeto.aRnConsultarTipoUsuarioPorObjeto;
	}

	
	public TipoUsuario executar(TipoUsuario pTipoUsuario){
		
		return DaoTipoUsuarioImpl.getInstance().getTipoUsuario(pTipoUsuario);
		
	}
}
