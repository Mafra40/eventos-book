package br.com.eventosbook.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import br.com.eventosbook.constante.Constantes;
import br.com.eventosbook.dao.DaoContratante;
import br.com.eventosbook.hibernate.util.ConnectionFactory;
import br.com.eventosbook.modelo.Contratante;


public class DaoContratanteImpl implements DaoContratante{

	private DaoContratanteImpl() {}
	private static DaoContratanteImpl aDAOContratante = new DaoContratanteImpl();

	public static DaoContratanteImpl getInstance(){
		if(DaoContratanteImpl.aDAOContratante == null){
			DaoContratanteImpl.aDAOContratante = new DaoContratanteImpl();
		}
		
		return DaoContratanteImpl.aDAOContratante;
	}
	
	
	@Override
	public void incluir(Contratante pContratante) throws Exception {
		try{
			ConnectionFactory.getInstace().getConnection().getTransaction().begin();
			ConnectionFactory.getInstace().getConnection().persist(pContratante);
			ConnectionFactory.getInstace().getConnection().getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			
			ConnectionFactory.getInstace().getConnection().getTransaction().rollback();
			
		} finally{
			ConnectionFactory.getInstace().getCloseConnection();

		}
		
	}

	@Override
	public void alterar(Contratante pContratante) {
		try{
			ConnectionFactory.getInstace().getConnection().getTransaction().begin();
			ConnectionFactory.getInstace().getConnection().merge(pContratante);
			ConnectionFactory.getInstace().getConnection().getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			
			ConnectionFactory.getInstace().getConnection().getTransaction().rollback();
			
		} finally{
			ConnectionFactory.getInstace().getCloseConnection();

		}
		

	}

	@Override
	public void excluir(Contratante pContratante) {
		try{
			ConnectionFactory.getInstace().getConnection().getTransaction().begin();
			ConnectionFactory.getInstace().getConnection().remove(pContratante);
			ConnectionFactory.getInstace().getConnection().getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			
			ConnectionFactory.getInstace().getConnection().getTransaction().rollback();
			
		} finally{
			ConnectionFactory.getInstace().getCloseConnection();

		}
		

	}

	@Override
	public List<Contratante> consultar() {
		List<Contratante> retorno = new ArrayList<Contratante>();
		try {
			String sql = "FROM " + Constantes.PATH_PROJECT + ".modelo.Contratante";
			
			TypedQuery<Contratante> q = ConnectionFactory.getInstace().getConnection().createQuery(sql, Contratante.class);
			retorno = q.getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
			retorno = null;
		}
		
		return retorno;
	}

	@Override
	public Contratante getContratante(Contratante pContratante) {
		Contratante retorno = new Contratante();
		
		try{
			
			if(pContratante !=null){
				
				String sql = "FROM " + Constantes.PATH_PROJECT + ".modelo.Contratante WHERE 1=1";
				
				if(pContratante.getCodigo() != null){
					sql += " AND id_contratante =:id";
				}
		
				if(pContratante.getCpf() != null){
					sql += " AND  cpf =:cpf";
				}
				
				
				TypedQuery<Contratante> q = ConnectionFactory.getInstace().getConnection().createQuery(sql, Contratante.class);
				
				if(pContratante.getCodigo() != null){
					q.setParameter("id", pContratante.getCodigo());
				}
	
				if(pContratante.getCpf() != null){
					q.setParameter("cpf", pContratante.getCpf());
				}
				
				
				retorno = q.getSingleResult();
			}
			
		}catch(Exception e){
			e.printStackTrace();
			retorno = null;
		}
		
		return retorno;
		
	}

}
