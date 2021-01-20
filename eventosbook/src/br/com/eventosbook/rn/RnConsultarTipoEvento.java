package br.com.eventosbook.rn;

import java.util.List;

import br.com.eventosbook.dao.impl.DaoTipoEventoImpl;
import br.com.eventosbook.modelo.TipoEvento;

public class RnConsultarTipoEvento {
	
private RnConsultarTipoEvento() {}
	
	private static RnConsultarTipoEvento aRnConsultarTipoEvento = new RnConsultarTipoEvento();
	
	public static RnConsultarTipoEvento getInstance(){
		if(RnConsultarTipoEvento.aRnConsultarTipoEvento == null){
			RnConsultarTipoEvento.aRnConsultarTipoEvento = new RnConsultarTipoEvento();
		}
		
		return RnConsultarTipoEvento.aRnConsultarTipoEvento;
	}
	
	public List<TipoEvento> executar(){
		return DaoTipoEventoImpl.getInstance().consultar();
	}

}
