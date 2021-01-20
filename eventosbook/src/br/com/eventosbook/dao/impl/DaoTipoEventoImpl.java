package br.com.eventosbook.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import br.com.eventosbook.constante.Constantes;
import br.com.eventosbook.dao.DaoTipoEvento;
import br.com.eventosbook.hibernate.util.ConnectionFactory;
import br.com.eventosbook.modelo.TipoEvento;

public class DaoTipoEventoImpl implements DaoTipoEvento {
	
	private DaoTipoEventoImpl() {}
	private static DaoTipoEventoImpl aDAOTipoEvento = new DaoTipoEventoImpl();

	public static DaoTipoEventoImpl getInstance(){
		if(DaoTipoEventoImpl.aDAOTipoEvento == null){
			DaoTipoEventoImpl.aDAOTipoEvento = new DaoTipoEventoImpl();
		}
		
		return DaoTipoEventoImpl.aDAOTipoEvento;
	}

	
	@Override
	public void incluir(TipoEvento pTipoEvento) {
		try{
			ConnectionFactory.getInstace().getConnection().getTransaction().begin();
			ConnectionFactory.getInstace().getConnection().persist(pTipoEvento);
			ConnectionFactory.getInstace().getConnection().getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			
			ConnectionFactory.getInstace().getConnection().getTransaction().rollback();
			
		} finally{
			ConnectionFactory.getInstace().getCloseConnection();

		}

	}

	@Override
	public void alterar(TipoEvento pTipoEvento) {
		try{
			ConnectionFactory.getInstace().getConnection().getTransaction().begin();
			ConnectionFactory.getInstace().getConnection().merge(pTipoEvento);
			ConnectionFactory.getInstace().getConnection().getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			
			ConnectionFactory.getInstace().getConnection().getTransaction().rollback();
			
		} finally{
			ConnectionFactory.getInstace().getCloseConnection();

		}

	}

	@Override
	public void excluir(TipoEvento pTipoEvento) {
		try{
			ConnectionFactory.getInstace().getConnection().getTransaction().begin();
			ConnectionFactory.getInstace().getConnection().remove(pTipoEvento);
			ConnectionFactory.getInstace().getConnection().getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			
			ConnectionFactory.getInstace().getConnection().getTransaction().rollback();
			
		} finally{
			ConnectionFactory.getInstace().getCloseConnection();

		}

	}

	@Override
	public List<TipoEvento> consultar() {
		List<TipoEvento> retorno = new ArrayList<TipoEvento>();
		try {
			String sql = "FROM " + Constantes.PATH_PROJECT + ".modelo.TipoEvento";
			
			TypedQuery<TipoEvento> q = ConnectionFactory.getInstace().getConnection().createQuery(sql, TipoEvento.class);
			retorno = q.getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
			retorno = null;
		}
		
		return retorno;
	}

	@Override
	public TipoEvento getTipoEvento(TipoEvento pTipoEvento) {

		TipoEvento retorno = new TipoEvento();
		
		try {
			
			String sql = "FROM " + Constantes.PATH_PROJECT + ".modelo.TipoEvento WHERE 1=1 ";
			
			if(pTipoEvento.getCodigo() != null){
				sql+= "AND id_tipo_evento =:id";
			}
			
			if(pTipoEvento.getDescricao() != null){
				sql+= "AND descricao =:descricao";
			}

			
			TypedQuery<TipoEvento> q = ConnectionFactory.getInstace().getConnection().createQuery(sql, TipoEvento.class);

			if(pTipoEvento.getCodigo() != null){
				q.setParameter("id", pTipoEvento.getCodigo());
			}

			if(pTipoEvento.getDescricao() != null){
				q.setParameter("descricao", pTipoEvento.getDescricao());
			}
			
			retorno = q.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			retorno = null;
		}
		
		return retorno;
	}

}
