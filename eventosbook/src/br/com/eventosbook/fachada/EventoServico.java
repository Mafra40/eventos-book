package br.com.eventosbook.fachada;

import br.com.eventosbook.modelo.Evento;
import br.com.eventosbook.rn.RnConsultarEventoPorObjeto;

public class EventoServico {
	
private EventoServico() {}
	
	private static EventoServico aEventoServico = new EventoServico();
	
	public static EventoServico getInstance(){
		if(EventoServico.aEventoServico == null){
			EventoServico.aEventoServico = new EventoServico();
		}
		
		return EventoServico.aEventoServico;
	}
	
	/**Consulta 1 evento por objeto passado
	 * 
	 * @param pEvento
	 * @return
	 */
	public Evento consultarEventoPorObjeto(Evento pEvento){
		return RnConsultarEventoPorObjeto.getInstance().executar(pEvento);
	}

}
