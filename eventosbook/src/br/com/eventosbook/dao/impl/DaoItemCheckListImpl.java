package br.com.eventosbook.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import br.com.eventosbook.constante.Constantes;
import br.com.eventosbook.dao.DaoItemCheckList;
import br.com.eventosbook.hibernate.util.ConnectionFactory;
import br.com.eventosbook.modelo.Item;

public class DaoItemCheckListImpl implements DaoItemCheckList{
	
	private DaoItemCheckListImpl() {}
	private static DaoItemCheckListImpl aDAOItemCheckList = new DaoItemCheckListImpl();

	public static DaoItemCheckListImpl getInstance(){
		if(DaoItemCheckListImpl.aDAOItemCheckList == null){
			DaoItemCheckListImpl.aDAOItemCheckList = new DaoItemCheckListImpl();
		}
		
		return DaoItemCheckListImpl.aDAOItemCheckList;
	}

	@Override
	public void incluir(Item pItemCheckList) {
		try{
			ConnectionFactory.getInstace().getConnection().getTransaction().begin();
			ConnectionFactory.getInstace().getConnection().persist(pItemCheckList);
			ConnectionFactory.getInstace().getConnection().getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			
			ConnectionFactory.getInstace().getConnection().getTransaction().rollback();
			
		} finally{
			ConnectionFactory.getInstace().getCloseConnection();

		}
		
	}

	@Override
	public void alterar(Item pItemCheckList) {
		try{
			ConnectionFactory.getInstace().getConnection().getTransaction().begin();
			ConnectionFactory.getInstace().getConnection().merge(pItemCheckList);
			ConnectionFactory.getInstace().getConnection().getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			
			ConnectionFactory.getInstace().getConnection().getTransaction().rollback();
			
		} finally{
			ConnectionFactory.getInstace().getCloseConnection();

		}
		
	}

	@Override
	public void excluir(Item pItemCheckList) {
		try{
			ConnectionFactory.getInstace().getConnection().getTransaction().begin();
			ConnectionFactory.getInstace().getConnection().remove(pItemCheckList);
			ConnectionFactory.getInstace().getConnection().getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			
			ConnectionFactory.getInstace().getConnection().getTransaction().rollback();
			
		} finally{
			ConnectionFactory.getInstace().getCloseConnection();

		}
		
	}

	@Override
	public List<Item> consultar() {
		List<Item> retorno = new ArrayList<Item>();
		try {
			String sql = "FROM " + Constantes.PATH_PROJECT + ".modelo.ItemCheckList";
			
			TypedQuery<Item> q = ConnectionFactory.getInstace().getConnection().createQuery(sql, Item.class);
			retorno = q.getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
			retorno = null;
		}
		
		return retorno;
	}

	@Override
	public Item getItemCheckList(Item pItemCheckList) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
