package br.com.eventosbook.rn;

import br.com.eventosbook.modelo.Evento;

public class RnConsultarEventoContratante {
	
private static RnConsultarEventoContratante aRnConsultarEventoContratante = new RnConsultarEventoContratante();
	
	public static RnConsultarEventoContratante getInstance(){
		if(RnConsultarEventoContratante.aRnConsultarEventoContratante == null){
			RnConsultarEventoContratante.aRnConsultarEventoContratante = new RnConsultarEventoContratante();
		}
		
		return RnConsultarEventoContratante.aRnConsultarEventoContratante;
	}
	
	
	public Evento executar(Evento pEvento){
		return null;
	}
}
