package br.com.eventosbook.rn.consultas;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import br.com.eventosbook.constante.sql.ConstantesSQL;
import br.com.eventosbook.hibernate.util.ConnectionFactory;
import br.com.eventosbook.modelo.Fornecedor;
import br.com.eventosbook.modelo.Item;



public class ConsultarFornecedorPorItem {
	private static ConsultarFornecedorPorItem aConsultarFornecedorPorItem = new ConsultarFornecedorPorItem();
	
	
	public static ConsultarFornecedorPorItem getInstance(){
		if(ConsultarFornecedorPorItem.aConsultarFornecedorPorItem == null){
			ConsultarFornecedorPorItem.aConsultarFornecedorPorItem = new ConsultarFornecedorPorItem();
		}
		
		return ConsultarFornecedorPorItem.aConsultarFornecedorPorItem;
	}
	
	
	/**
	 * O Motivo do @SuppressWarnings é: o compilador da JVM, é muito burro para indentificar em RUNTIME,
	 * o tipo do objeto que será retornado na consulta, culpa também do JPA que não deixa tipar a interface Query<?>.
	 */
	
	@SuppressWarnings(value = "unchecked")
	public List<Fornecedor> consultar(Item pItem, String pAtributoOrdenacao){
		String query = ConstantesSQL.QUERY_FORNECEDOR_POR_ITEM;
		List<Fornecedor> retorno = new  ArrayList<Fornecedor>();
		
		if(pItem.getCategoria().getCodigo() != null){
			query+= " AND eventosbook.fornecedor_categoria.fk_categoria = ?";
		}
		
		if(pItem.getSubCategoria().getCodigo() != null){
			query+= " AND eventosbook.fornecedor_categoria.fk_subcategoria = ?";
		}
		
		if(pAtributoOrdenacao!=null){
			query+= " ORDER BY "+pAtributoOrdenacao;
		}
		
		Query q = ConnectionFactory.getInstace().getConnection().createNativeQuery(query, Fornecedor.class);
		
		if(pItem.getCategoria().getCodigo() != null){
			q.setParameter(1, pItem.getCategoria().getCodigo());
		}
		
		if(pItem.getSubCategoria().getCodigo() != null){
			q.setParameter(2, pItem.getSubCategoria().getCodigo());
		}
		
		retorno = q.getResultList();
		
		return retorno;
		
	}
	
}
