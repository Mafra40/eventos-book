package br.com.eventosbook.rn;

import java.util.List;

import br.com.eventosbook.dao.impl.DaoEventoImpl;
import br.com.eventosbook.modelo.Evento;

public class RnConsultarEvento {
	
	private RnConsultarEvento() {}

	private static RnConsultarEvento aRnConsultarEvento = new RnConsultarEvento();

	public static RnConsultarEvento getInstance(){
		if(RnConsultarEvento.aRnConsultarEvento == null){
			RnConsultarEvento.aRnConsultarEvento = new RnConsultarEvento();
		}

		return RnConsultarEvento.aRnConsultarEvento;
	}
	
	public List<Evento> executar(Evento pFiltroEvento){
		return DaoEventoImpl.getInstance().consultar(pFiltroEvento);
	}

}
