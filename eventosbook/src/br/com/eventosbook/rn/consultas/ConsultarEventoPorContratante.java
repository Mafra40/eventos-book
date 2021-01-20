package br.com.eventosbook.rn.consultas;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import br.com.eventosbook.constante.sql.ConstantesSQL;
import br.com.eventosbook.hibernate.util.ConnectionFactory;
import br.com.eventosbook.modelo.Contratante;
import br.com.eventosbook.modelo.Evento;

public class ConsultarEventoPorContratante {
	
	private ConsultarEventoPorContratante() {}

	private static ConsultarEventoPorContratante aConsultaEventoContratante = new ConsultarEventoPorContratante();

	public static ConsultarEventoPorContratante getInstance(){
		if(ConsultarEventoPorContratante.aConsultaEventoContratante == null){
			ConsultarEventoPorContratante.aConsultaEventoContratante = new ConsultarEventoPorContratante();
		}

		return ConsultarEventoPorContratante.aConsultaEventoContratante;
	}
	
	
	/**
	 * O Motivo do @SuppressWarnings é: o compilador da JVM, é muito burro para indentificar em RUNTIME,
	 * o tipo do objeto que será retornado na consulta, culpa também do JPA que não deixa tipar a interface Query<?>.
	 */
	
	@SuppressWarnings(value = "unchecked")
	public List<Evento> consulta(Contratante pContratante){
		List<Evento> retorno = new ArrayList<Evento>();
		
		
		try {
			
			Query q = ConnectionFactory.getInstace().getConnection().createNativeQuery(ConstantesSQL.QUERY_CONSULTAR_EVENTO_POR_CONTRATANTE, Evento.class);
			q.setParameter(1, pContratante.getCodigo());
	
			retorno = q.getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
			retorno = null;
		}
		
		return retorno;
	}
	
}
