package br.com.eventosbook.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import br.com.eventosbook.constante.Constantes;
import br.com.eventosbook.dao.DaoTipoUsuario;
import br.com.eventosbook.hibernate.util.ConnectionFactory;
import br.com.eventosbook.modelo.TipoUsuario;

public class DaoTipoUsuarioImpl implements DaoTipoUsuario{
	
	private DaoTipoUsuarioImpl() {}
	private static DaoTipoUsuarioImpl aDAOTipoUsuario = new DaoTipoUsuarioImpl();

	public static DaoTipoUsuarioImpl getInstance(){
		if(DaoTipoUsuarioImpl.aDAOTipoUsuario == null){
			DaoTipoUsuarioImpl.aDAOTipoUsuario = new DaoTipoUsuarioImpl();
		}
		
		return DaoTipoUsuarioImpl.aDAOTipoUsuario;
	}
	


	@Override
	public void incluir(TipoUsuario pTipoUsuario) {

		try{
			ConnectionFactory.getInstace().getConnection().getTransaction().begin();
			ConnectionFactory.getInstace().getConnection().persist(pTipoUsuario);
			ConnectionFactory.getInstace().getConnection().getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			ConnectionFactory.getInstace().getConnection().getTransaction().rollback();
			
		} finally{
			ConnectionFactory.getInstace().getCloseConnection();

		}
	}

	@Override
	public void alterar(TipoUsuario pTipoUsuario) {
		try{
			ConnectionFactory.getInstace().getConnection().getTransaction().begin();
			ConnectionFactory.getInstace().getConnection().merge(pTipoUsuario);
			ConnectionFactory.getInstace().getConnection().getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			ConnectionFactory.getInstace().getConnection().getTransaction().rollback();
			
		} finally{
			ConnectionFactory.getInstace().getCloseConnection();

		}
	
	}

	@Override
	public void excluir(TipoUsuario pTipoUsuario) {
		try{
			ConnectionFactory.getInstace().getConnection().getTransaction().begin();
			ConnectionFactory.getInstace().getConnection().remove(pTipoUsuario);
			ConnectionFactory.getInstace().getConnection().getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			ConnectionFactory.getInstace().getConnection().getTransaction().rollback();
			
		} finally{
			ConnectionFactory.getInstace().getCloseConnection();

		}

		
	}

	@Override
	public List<TipoUsuario> consultar() {
		List<TipoUsuario> retorno = new ArrayList<TipoUsuario>();
		try{
			String sql = "FROM " + Constantes.PATH_PROJECT + ".modelo.TipoUsuario";
			
			TypedQuery<TipoUsuario> q = ConnectionFactory.getInstace().getConnection().createQuery(sql, TipoUsuario.class);
			retorno = q.getResultList();
			
		}catch(Exception e){
			e.printStackTrace();
			retorno = null;
		}
		
		return retorno;
	}

	@Override
	public TipoUsuario getTipoUsuario(TipoUsuario pTipoUsuario) {

		TipoUsuario retorno = new TipoUsuario();
		
		try {
			
			String sql = "FROM " + Constantes.PATH_PROJECT + ".modelo.TipoUsuario WHERE 1=1 ";
			
			if(pTipoUsuario.getCodigo() != null){
				sql+= "AND id_TipoUsuario =:id";
			}
			
			if(pTipoUsuario.getDescricao() != null){
				sql+= "AND descricao =:descricao";
			}
			
			if(pTipoUsuario.getSigla() != null){
				sql+= "AND sigla =:sigla";
			}
			
			TypedQuery<TipoUsuario> q = ConnectionFactory.getInstace().getConnection().createQuery(sql, TipoUsuario.class);

			if(pTipoUsuario.getCodigo() != null){
				q.setParameter("id", pTipoUsuario.getCodigo());
			}

			if(pTipoUsuario.getDescricao() != null){
				q.setParameter("descricao", pTipoUsuario.getDescricao());
			}
			if(pTipoUsuario.getSigla() != null){
				q.setParameter("sigla", pTipoUsuario.getSigla());
			}
			
			retorno = q.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			retorno = null;
		}
		
		return retorno;
	}

}
