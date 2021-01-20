package br.com.eventosbook.rn.consultas;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.com.eventosbook.constante.sql.ConstantesSQL;
import br.com.eventosbook.hibernate.util.ConnectionFactory;
import br.com.eventosbook.modelo.Evento;


public class ConsultaDetalharEventoPorConstratante {

	private static ConsultaDetalharEventoPorConstratante aConsultaDetalharEventoPorConstratante = new ConsultaDetalharEventoPorConstratante();

	public static ConsultaDetalharEventoPorConstratante getInstance(){
		if(ConsultaDetalharEventoPorConstratante.aConsultaDetalharEventoPorConstratante == null){
			ConsultaDetalharEventoPorConstratante.aConsultaDetalharEventoPorConstratante = new ConsultaDetalharEventoPorConstratante();
		}

		return ConsultaDetalharEventoPorConstratante.aConsultaDetalharEventoPorConstratante;
	}

	public Evento consulta(Evento pEvento) throws NoResultException, Exception{

		Evento retorno = new Evento();
		Query q = ConnectionFactory.getInstace().getConnection().createNativeQuery(ConstantesSQL.QUERY_DETALHAR_EVENTO_POR_CONTRATANTE, Evento.class);



		q.setParameter(1, pEvento.getContratante().getCodigo());
		q.setParameter(2, pEvento.getCodigo());


		retorno = (Evento) q.getSingleResult();



		return retorno;
	}


}
