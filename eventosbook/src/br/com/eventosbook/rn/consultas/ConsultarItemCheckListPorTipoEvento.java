package br.com.eventosbook.rn.consultas;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import br.com.eventosbook.constante.sql.ConstantesSQL;
import br.com.eventosbook.hibernate.util.ConnectionFactory;
import br.com.eventosbook.modelo.Item;
import br.com.eventosbook.modelo.TipoEvento;


public class ConsultarItemCheckListPorTipoEvento {
	
	private static ConsultarItemCheckListPorTipoEvento aConsultarItemCheckList = new ConsultarItemCheckListPorTipoEvento();

	public static ConsultarItemCheckListPorTipoEvento getInstance(){
		if(ConsultarItemCheckListPorTipoEvento.aConsultarItemCheckList == null){
			ConsultarItemCheckListPorTipoEvento.aConsultarItemCheckList = new ConsultarItemCheckListPorTipoEvento();
		}

		return ConsultarItemCheckListPorTipoEvento.aConsultarItemCheckList;
	}
	
		
	/**
	 * O Motivo do @SuppressWarnings é: o compilador da JVM, é muito burro para indentificar em RUNTIME,
	 * o tipo do objeto que será retornado na consulta, culpa também do JPA que não deixa tipar a interface Query<?>.
	 */
	
	@SuppressWarnings(value = "unchecked")
	public List<Item> consultar(TipoEvento pTipoEvento) {
		List<Item> retorno = new  ArrayList<Item>();
		Query q = ConnectionFactory.getInstace().getConnection().createNativeQuery(ConstantesSQL.QUERY_ITEM_CHECK_LIST_POR_TIPO_EVENTO, Item.class);
		
		q.setParameter(1, pTipoEvento.getCodigo());
		
		retorno = q.getResultList();		
		
		return retorno;
		
		
	}
}
