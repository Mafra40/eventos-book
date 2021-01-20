package br.com.eventosbook.rn.consultas;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import br.com.eventosbook.constante.sql.ConstantesSQL;
import br.com.eventosbook.hibernate.util.ConnectionFactory;
import br.com.eventosbook.modelo.Evento;
import br.com.eventosbook.modelo.Item;

public class ConsultarItemCheckListPorEvento {
	
	private static ConsultarItemCheckListPorEvento aConsultarItemCheckList = new ConsultarItemCheckListPorEvento();

	public static ConsultarItemCheckListPorEvento getInstance(){
		if(ConsultarItemCheckListPorEvento.aConsultarItemCheckList == null){
			ConsultarItemCheckListPorEvento.aConsultarItemCheckList = new ConsultarItemCheckListPorEvento();
		}

		return ConsultarItemCheckListPorEvento.aConsultarItemCheckList;
	}
	
	
	/**
	 * O Motivo do @SuppressWarnings é: o compilador da JVM, é muito burro para indentificar em RUNTIME,
	 * o tipo do objeto que será retornado na consulta, culpa também do JPA que não deixa tipar a interface Query<?>.
	 */
	
	@SuppressWarnings(value = "unchecked")
	public List<Item> consultar(Evento pEvento) {
		List<Item> retorno = new  ArrayList<Item>();
		Query q = ConnectionFactory.getInstace().getConnection().createNativeQuery(ConstantesSQL.QUERY_ITEM_CHECK_LIST_POR_EVENTO, Item.class);
		
		q.setParameter(1, pEvento.getCodigo());
		
		retorno = q.getResultList();		
		
		return retorno;
		
	}
}
