package br.com.eventosbook.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import br.com.eventosbook.constante.Constantes;
import br.com.eventosbook.dao.DaoFuncaoSistema;
import br.com.eventosbook.hibernate.util.ConnectionFactory;
import br.com.eventosbook.modelo.FuncaoSistema;

public class DaoFuncaoSistemaImpl implements DaoFuncaoSistema {
	
	private DaoFuncaoSistemaImpl() {}
	private static DaoFuncaoSistemaImpl aDAOFuncaoSistema = new DaoFuncaoSistemaImpl();

	public static DaoFuncaoSistemaImpl getInstance(){
		if(DaoFuncaoSistemaImpl.aDAOFuncaoSistema == null){
			DaoFuncaoSistemaImpl.aDAOFuncaoSistema = new DaoFuncaoSistemaImpl();
		}
		
		return DaoFuncaoSistemaImpl.aDAOFuncaoSistema;
	}

	@Override
	public void incluir(FuncaoSistema pFuncaoSistema) {
		
		try{
			ConnectionFactory.getInstace().getConnection().getTransaction().begin();
			ConnectionFactory.getInstace().getConnection().persist(pFuncaoSistema);
			ConnectionFactory.getInstace().getConnection().getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			ConnectionFactory.getInstace().getConnection().getTransaction().rollback();
			
		} finally{
			ConnectionFactory.getInstace().getCloseConnection();

		}

	}

	@Override
	public void alterar(FuncaoSistema pFuncaoSistema) {
		try{
			ConnectionFactory.getInstace().getConnection().getTransaction().begin();
			ConnectionFactory.getInstace().getConnection().merge(pFuncaoSistema);
			ConnectionFactory.getInstace().getConnection().getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			ConnectionFactory.getInstace().getConnection().getTransaction().rollback();
			
		} finally{
			ConnectionFactory.getInstace().getCloseConnection();

		}


	}

	@Override
	public void excluir(FuncaoSistema pFuncaoSistema) {
		try{
			ConnectionFactory.getInstace().getConnection().getTransaction().begin();
			ConnectionFactory.getInstace().getConnection().remove(pFuncaoSistema);
			ConnectionFactory.getInstace().getConnection().getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			ConnectionFactory.getInstace().getConnection().getTransaction().rollback();
			
		} finally{
			ConnectionFactory.getInstace().getCloseConnection();

		}

	}

	@Override
	public List<FuncaoSistema> consultar() {
		List<FuncaoSistema> retorno = new ArrayList<FuncaoSistema>();
		try {
			String sql = "FROM " + Constantes.PATH_PROJECT + ".modelo.FuncaoSistema";
			
			TypedQuery<FuncaoSistema> q = ConnectionFactory.getInstace().getConnection().createQuery(sql, FuncaoSistema.class);
			retorno = q.getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
			retorno = null;
		}
		
		return retorno;
	}

	@Override
	public FuncaoSistema getFuncaoSistema(FuncaoSistema pFuncaoSistema) {
		// TODO Auto-generated method stub
		return null;
	}

}
