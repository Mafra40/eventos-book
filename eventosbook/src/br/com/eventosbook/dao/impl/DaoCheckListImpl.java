package br.com.eventosbook.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import br.com.eventosbook.constante.Constantes;
import br.com.eventosbook.dao.DaoCheckList;
import br.com.eventosbook.hibernate.util.ConnectionFactory;
import br.com.eventosbook.modelo.CheckList;

public class DaoCheckListImpl implements DaoCheckList {

	private DaoCheckListImpl() {}
	private static DaoCheckListImpl aDAOCheckList = new DaoCheckListImpl();

	public static DaoCheckListImpl getInstance(){
		if(DaoCheckListImpl.aDAOCheckList == null){
			DaoCheckListImpl.aDAOCheckList = new DaoCheckListImpl();
		}

		return DaoCheckListImpl.aDAOCheckList;
	}

	@Override
	public void incluir(CheckList pCheckList) {
		try{
			ConnectionFactory.getInstace().getConnection().getTransaction().begin();
			ConnectionFactory.getInstace().getConnection().persist(pCheckList);
			ConnectionFactory.getInstace().getConnection().getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();

			ConnectionFactory.getInstace().getConnection().getTransaction().rollback();

		} finally{
			ConnectionFactory.getInstace().getCloseConnection();

		}

	}

	@Override
	public CheckList alterar(CheckList pCheckList) {
		CheckList checkList = new CheckList();
		try{
			ConnectionFactory.getInstace().getConnection().getTransaction().begin();
			checkList = ConnectionFactory.getInstace().getConnection().merge(pCheckList);
			ConnectionFactory.getInstace().getConnection().getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();

			ConnectionFactory.getInstace().getConnection().getTransaction().rollback();

		} finally{
			ConnectionFactory.getInstace().getCloseConnection();

		}

		return checkList;

	}

	@Override
	public void excluir(CheckList pCheckList) {
		try{
			ConnectionFactory.getInstace().getConnection().getTransaction().begin();
			ConnectionFactory.getInstace().getConnection().remove(ConnectionFactory.getInstace().getConnection().getReference(CheckList.class, pCheckList.getCodigo()));
			ConnectionFactory.getInstace().getConnection().getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();

			ConnectionFactory.getInstace().getConnection().getTransaction().rollback();

		} finally{
			ConnectionFactory.getInstace().getCloseConnection();

		}

	}

	@Override
	public List<CheckList> consultar() {
		List<CheckList> retorno = new ArrayList<CheckList>();
		try {
			String sql = "FROM " + Constantes.PATH_PROJECT + ".modelo.CheckList";

			TypedQuery<CheckList> q = ConnectionFactory.getInstace().getConnection().createQuery(sql, CheckList.class);
			retorno = q.getResultList();

		} catch (Exception e) {
			e.printStackTrace();
			retorno = null;
		}

		return retorno;
	}

	@Override
	public CheckList getCheckList(CheckList pCheckList) {
		CheckList retorno = new CheckList();

		try {

			String sql = "FROM " + Constantes.PATH_PROJECT + ".modelo.CheckList WHERE 1=1";

			if(pCheckList.getCodigo() != null){
				sql+= "AND id_checkList =:id";
			}


			TypedQuery<CheckList> q = ConnectionFactory.getInstace().getConnection().createQuery(sql, CheckList.class);


			if(pCheckList.getCodigo() != null){
				q.setParameter("id", pCheckList.getCodigo());
			}
			
			retorno =  q.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			retorno = null;

		}

		return retorno;
	}

}
