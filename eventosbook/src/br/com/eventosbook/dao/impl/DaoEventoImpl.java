package br.com.eventosbook.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import br.com.eventosbook.constante.Constantes;
import br.com.eventosbook.dao.DaoEvento;
import br.com.eventosbook.hibernate.util.ConnectionFactory;
import br.com.eventosbook.modelo.Evento;

public class DaoEventoImpl implements DaoEvento {

	private DaoEventoImpl() {}
	private static DaoEventoImpl aDAOEvento = new DaoEventoImpl();

	public static DaoEventoImpl getInstance(){
		if(DaoEventoImpl.aDAOEvento == null){
			DaoEventoImpl.aDAOEvento = new DaoEventoImpl();
		}

		return DaoEventoImpl.aDAOEvento;
	}

	@Override
	public void incluir(Evento pEvento) {
		try{
			ConnectionFactory.getInstace().getConnection().getTransaction().begin();
			ConnectionFactory.getInstace().getConnection().persist(pEvento);
			ConnectionFactory.getInstace().getConnection().getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			ConnectionFactory.getInstace().getConnection().getTransaction().rollback();
		} finally{
			ConnectionFactory.getInstace().getCloseConnection();

		}

	}
	
	public Evento incluirRetornandoObjeto(Evento pEvento) {
		Evento evento = new Evento();
		
		try{
			ConnectionFactory.getInstace().getConnection().getTransaction().begin();
			evento = ConnectionFactory.getInstace().getConnection().merge(pEvento);
			ConnectionFactory.getInstace().getConnection().getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			ConnectionFactory.getInstace().getConnection().getTransaction().rollback();
		} finally{
			ConnectionFactory.getInstace().getCloseConnection();

		}
		
		return evento;

	}


	@Override
	public void alterar(Evento pEvento) {

		try{
			ConnectionFactory.getInstace().getConnection().getTransaction().begin();
			ConnectionFactory.getInstace().getConnection().merge(pEvento);
			ConnectionFactory.getInstace().getConnection().getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			ConnectionFactory.getInstace().getConnection().getTransaction().rollback();
		} finally{
			ConnectionFactory.getInstace().getCloseConnection();

		}

	}

	@Override
	public void excluir(Evento pEvento) {
		try{
			ConnectionFactory.getInstace().getConnection().getTransaction().begin();
			ConnectionFactory.getInstace().getConnection().remove(ConnectionFactory.getInstace().getConnection().getReference(Evento.class, pEvento.getCodigo()));
			ConnectionFactory.getInstace().getConnection().getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			ConnectionFactory.getInstace().getConnection().getTransaction().rollback();
		} finally{
			ConnectionFactory.getInstace().getCloseConnection();

		}

	}

	@Override
	public List<Evento> consultar(Evento pFiltroEvento) {
		List<Evento> retorno = new ArrayList<Evento>();

		try{

			if(pFiltroEvento !=null){
				int i = 0;
				String sql = "FROM " + Constantes.PATH_PROJECT + ".modelo."+Evento.NM_ENTIDADE;
				String sqlWhere = "";
				String sqlConector = "";

				if(pFiltroEvento.getCodigo() != null){
					i++;
					sqlWhere += sqlConector + Evento.NM_COL_CODIGO + "=:"+Evento.NM_COL_CODIGO;
					sqlConector = " AND ";
				}
				
				if(pFiltroEvento.getContratante() != null && pFiltroEvento.getContratante().getCodigo() != null){
					i++;
					sqlWhere += sqlConector + Evento.NM_FK_CODIGO_CONTRATANTE+ "=:" +Evento.NM_FK_CODIGO_CONTRATANTE;
					sqlConector = " AND ";
				}
				
				

				
				if (i > 0){
					//Constroe o where.
					sql = sql + " WHERE " + sqlWhere;
				}

				TypedQuery<Evento> q = ConnectionFactory.getInstace().getConnection().createQuery(sql, Evento.class);


				if (i > 0){
					if(pFiltroEvento.getCodigo() != null){
						q.setParameter(Evento.NM_COL_CODIGO, pFiltroEvento.getCodigo());
					}
				}
				
				if (i > 0){
					if(pFiltroEvento.getContratante() != null && pFiltroEvento.getContratante().getCodigo() != null){
						q.setParameter(Evento.NM_FK_CODIGO_CONTRATANTE, pFiltroEvento.getContratante().getCodigo());
					}
				}
				
				



				retorno = q.getResultList();
			}

		}catch(Exception e){
			e.printStackTrace();
			retorno = null;
		}

		return retorno;
	}

	@Override
	public Evento getEvento(Evento pEvento) {

		Evento retorno = new Evento();

		try {

			String sql = "FROM " + Constantes.PATH_PROJECT + ".modelo.Evento WHERE 1=1 ";

			if(pEvento.getCodigo() != null){
				sql+= "AND id_evento =:id";
			}

			if(pEvento.getDescricao() != null){
				sql+= "AND descricao =:descricao";
			}


			TypedQuery<Evento> q = ConnectionFactory.getInstace().getConnection().createQuery(sql, Evento.class);

			if(pEvento.getCodigo() != null){
				q.setParameter("id", pEvento.getCodigo());
			}

			if(pEvento.getDescricao() != null){
				q.setParameter("descricao", pEvento.getDescricao());
			}

			retorno = q.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			retorno = null;
		}

		return retorno;
	}

}
