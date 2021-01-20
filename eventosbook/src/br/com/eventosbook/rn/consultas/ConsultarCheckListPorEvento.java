package br.com.eventosbook.rn.consultas;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import br.com.eventosbook.constante.sql.ConstantesSQL;
import br.com.eventosbook.hibernate.util.ConnectionFactory;
import br.com.eventosbook.modelo.CheckList;
import br.com.eventosbook.modelo.Evento;

public class ConsultarCheckListPorEvento {
	
	private static ConsultarCheckListPorEvento aConsultarItemCheckList = new ConsultarCheckListPorEvento();

	public static ConsultarCheckListPorEvento getInstance(){
		if(ConsultarCheckListPorEvento.aConsultarItemCheckList == null){
			ConsultarCheckListPorEvento.aConsultarItemCheckList = new ConsultarCheckListPorEvento();
		}

		return ConsultarCheckListPorEvento.aConsultarItemCheckList;
	}
	
	/**
	 * O Motivo do @SuppressWarnings é: o compilador da JVM, é muito burro para indentificar em RUNTIME,
	 * o tipo do objeto que será retornado na consulta, culpa também do JPA que não deixa tipar a interface Query<?>.
	 */
	
	@SuppressWarnings(value = "unchecked")
	public List<CheckList> consultar(Evento pEvento){
		
		List<CheckList> retorno = new  ArrayList<CheckList>();
		Query q = ConnectionFactory.getInstace().getConnection().createNativeQuery(ConstantesSQL.QUERY_CHECK_LIST_POR_EVENTO, CheckList.class);
		
		q.setParameter(1, pEvento.getCodigo());
		
		retorno = q.getResultList();
		
		return retorno;
		
	}

}
