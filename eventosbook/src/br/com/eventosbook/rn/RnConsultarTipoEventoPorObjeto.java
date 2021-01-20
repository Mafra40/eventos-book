package br.com.eventosbook.rn;

import br.com.eventosbook.dao.impl.DaoTipoEventoImpl;
import br.com.eventosbook.modelo.TipoEvento;

public class RnConsultarTipoEventoPorObjeto {
	
	private static RnConsultarTipoEventoPorObjeto aRnConsultarTipoEventoPorObjeto = new RnConsultarTipoEventoPorObjeto();

	public static RnConsultarTipoEventoPorObjeto getInstance(){
		if(RnConsultarTipoEventoPorObjeto.aRnConsultarTipoEventoPorObjeto == null){
			RnConsultarTipoEventoPorObjeto.aRnConsultarTipoEventoPorObjeto = new RnConsultarTipoEventoPorObjeto();
		}

		return RnConsultarTipoEventoPorObjeto.aRnConsultarTipoEventoPorObjeto;
	}
	
	public TipoEvento executar(TipoEvento pTipoEvento){
		return DaoTipoEventoImpl.getInstance().getTipoEvento(pTipoEvento);
	}

}
