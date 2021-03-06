package br.com.eventosbook.dao.impl;

import java.util.List;

import br.com.eventosbook.dao.DaoProdutor;
import br.com.eventosbook.hibernate.util.ConnectionFactory;
import br.com.eventosbook.modelo.Produtor;

public class DaoProdutorImpl implements DaoProdutor {
	
	private DaoProdutorImpl() {}
	private static DaoProdutorImpl aDAOProdutor = new DaoProdutorImpl();

	public static DaoProdutorImpl getInstance(){
		if(DaoProdutorImpl.aDAOProdutor == null){
			DaoProdutorImpl.aDAOProdutor = new DaoProdutorImpl();
		}
		
		return DaoProdutorImpl.aDAOProdutor;
	}

	@Override
	public void incluir(Produtor pProdutor) {
		try{
			ConnectionFactory.getInstace().getConnection().getTransaction().begin();
			ConnectionFactory.getInstace().getConnection().persist(pProdutor);
			ConnectionFactory.getInstace().getConnection().getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			ConnectionFactory.getInstace().getConnection().getTransaction().rollback();
		} finally{
			ConnectionFactory.getInstace().getCloseConnection();

		}
		
	}

	@Override
	public void alterar(Produtor pProdutor) {
		try{
			ConnectionFactory.getInstace().getConnection().getTransaction().begin();
			ConnectionFactory.getInstace().getConnection().merge(pProdutor);
			ConnectionFactory.getInstace().getConnection().getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			ConnectionFactory.getInstace().getConnection().getTransaction().rollback();
		} finally{
			ConnectionFactory.getInstace().getCloseConnection();
		}

	}

	@Override
	public void excluir(Produtor pProdutor) {
		try{
			ConnectionFactory.getInstace().getConnection().getTransaction().begin();
			ConnectionFactory.getInstace().getConnection().remove(pProdutor);
			ConnectionFactory.getInstace().getConnection().getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			ConnectionFactory.getInstace().getConnection().getTransaction().rollback();
		} finally{
			ConnectionFactory.getInstace().getCloseConnection();
		}

	}

	@Override
	public List<Produtor> consultar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Produtor getProdutor(Produtor pProdutor) {
		// TODO Auto-generated method stub
		return null;
	}

}
