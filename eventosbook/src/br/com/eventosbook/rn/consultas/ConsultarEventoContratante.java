package br.com.eventosbook.rn.consultas;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import br.com.eventosbook.constante.Constantes;
import br.com.eventosbook.hibernate.util.ConnectionFactory;
import br.com.eventosbook.modelo.Evento;

public class ConsultarEventoContratante {
	
private static ConsultarEventoContratante aConsultarEventoContratante = new ConsultarEventoContratante();
	
	public static ConsultarEventoContratante getInstance(){
		if(ConsultarEventoContratante.aConsultarEventoContratante == null){
			ConsultarEventoContratante.aConsultarEventoContratante = new ConsultarEventoContratante();
		}
		
		return ConsultarEventoContratante.aConsultarEventoContratante;
	}
	
	public List<Evento> consultar(Evento pEvento){
		List<Evento> retorno = new ArrayList<Evento>();
		try {
			String sql = "FROM " + Constantes.PATH_PROJECT + ".modelo.Evento";
			
			TypedQuery<Evento> q = ConnectionFactory.getInstace().getConnection().createQuery(sql, Evento.class);
			retorno = q.getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
			retorno = null;
		}
		
		return retorno;
	}

}
