package br.com.eventosbook.dao.impl;

import java.util.List;

import br.com.eventosbook.dao.DaoEmail;
import br.com.eventosbook.hibernate.util.ConnectionFactory;
import br.com.eventosbook.modelo.Email;

public class DaoEmailImpl implements DaoEmail{
	
	private DaoEmailImpl() {}
	private static DaoEmailImpl aDAOEmail = new DaoEmailImpl();

	public static DaoEmailImpl getInstance(){
		if(DaoEmailImpl.aDAOEmail == null){
			DaoEmailImpl.aDAOEmail = new DaoEmailImpl();
		}
		
		return DaoEmailImpl.aDAOEmail;
	}

	@Override
	public void incluir(Email pEmail) throws Exception {
		try{
			ConnectionFactory.getInstace().getConnection().getTransaction().begin();
			ConnectionFactory.getInstace().getConnection().persist(pEmail);
			ConnectionFactory.getInstace().getConnection().getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			ConnectionFactory.getInstace().getConnection().getTransaction().rollback();
		} finally{
			ConnectionFactory.getInstace().getCloseConnection();

		}
		
	}

	@Override
	public void alterar(Email pEmail) throws Exception {
		try{
			ConnectionFactory.getInstace().getConnection().getTransaction().begin();
			ConnectionFactory.getInstace().getConnection().merge(pEmail);
			ConnectionFactory.getInstace().getConnection().getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			ConnectionFactory.getInstace().getConnection().getTransaction().rollback();
		} finally{
			ConnectionFactory.getInstace().getCloseConnection();

		}
		
	}

	@Override
	public void excluir(Email pEmail) throws Exception {
		try{
			ConnectionFactory.getInstace().getConnection().getTransaction().begin();
			ConnectionFactory.getInstace().getConnection().remove(ConnectionFactory.getInstace().getConnection().getReference(Email.class, pEmail.getCodigo()));
			ConnectionFactory.getInstace().getConnection().getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			ConnectionFactory.getInstace().getConnection().getTransaction().rollback();
		} finally{
			ConnectionFactory.getInstace().getCloseConnection();

		}
		
	}

	@Override
	public List<Email> consultar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Email getEmail(Email pEmail) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
}
