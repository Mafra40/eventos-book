package br.com.eventosbook.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import br.com.eventosbook.constante.Constantes;
import br.com.eventosbook.dao.DaoFornecedor;
import br.com.eventosbook.hibernate.util.ConnectionFactory;
import br.com.eventosbook.modelo.Fornecedor;

public class DaoFornecedorImpl implements DaoFornecedor {
	
	private DaoFornecedorImpl() {}
	private static DaoFornecedorImpl aDAOFornecedor = new DaoFornecedorImpl();

	public static DaoFornecedorImpl getInstance(){
		if(DaoFornecedorImpl.aDAOFornecedor == null){
			DaoFornecedorImpl.aDAOFornecedor = new DaoFornecedorImpl();
		}
		
		return DaoFornecedorImpl.aDAOFornecedor;
	}

	@Override
	public void incluir(Fornecedor pFornecedor) {
		try{
			ConnectionFactory.getInstace().getConnection().getTransaction().begin();
			ConnectionFactory.getInstace().getConnection().persist(pFornecedor);
			ConnectionFactory.getInstace().getConnection().getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			ConnectionFactory.getInstace().getConnection().getTransaction().rollback();
			
		} finally{
			ConnectionFactory.getInstace().getCloseConnection();

		}

	}

	@Override
	public void alterar(Fornecedor pFornecedor) {
		try{
			ConnectionFactory.getInstace().getConnection().getTransaction().begin();
			ConnectionFactory.getInstace().getConnection().merge(pFornecedor);
			ConnectionFactory.getInstace().getConnection().getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			ConnectionFactory.getInstace().getConnection().getTransaction().rollback();
			
		} finally{
			ConnectionFactory.getInstace().getCloseConnection();

		}

	}

	@Override
	public void excluir(Fornecedor pFornecedor) {
		try{
			ConnectionFactory.getInstace().getConnection().getTransaction().begin();
			ConnectionFactory.getInstace().getConnection().remove(pFornecedor);
			ConnectionFactory.getInstace().getConnection().getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			ConnectionFactory.getInstace().getConnection().getTransaction().rollback();
			
		} finally{
			ConnectionFactory.getInstace().getCloseConnection();

		}

	}

	@Override
	public List<Fornecedor> consultar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Fornecedor getFornecedor(Fornecedor pFornecedor) {
		Fornecedor retorno = new Fornecedor();
		
		try{
			
			if(pFornecedor !=null){
				
				String sql = "FROM " + Constantes.PATH_PROJECT + ".modelo.Fornecedor WHERE 1=1";
				
				if(pFornecedor.getCodigo() != null){
					sql += " AND id_fornecedor =:id_fornecedor";
				}
		
				if(pFornecedor.getNumeroDocumento() != null){
					sql += " AND  numero_documento =:numero_documento";
				}
				
				
				TypedQuery<Fornecedor> q = ConnectionFactory.getInstace().getConnection().createQuery(sql, Fornecedor.class);
				
				if(pFornecedor.getCodigo() != null){
					q.setParameter("id_fornecedor", pFornecedor.getCodigo());
				}
	
				if(pFornecedor.getNumeroDocumento() != null){
					q.setParameter("numero_documento", pFornecedor.getNumeroDocumento());
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
