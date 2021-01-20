package br.com.eventosbook.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import br.com.eventosbook.constante.Constantes;
import br.com.eventosbook.dao.DaoEstado;
import br.com.eventosbook.hibernate.util.ConnectionFactory;
import br.com.eventosbook.modelo.Estado;

public class DaoEstadoImpl implements DaoEstado{

	public static final String order_by = "order by descricao asc";

	private DaoEstadoImpl() {}
	private static DaoEstadoImpl aDAOEstado = new DaoEstadoImpl();

	public static DaoEstadoImpl getInstance(){
		if(DaoEstadoImpl.aDAOEstado == null){
			DaoEstadoImpl.aDAOEstado = new DaoEstadoImpl();
		}

		return DaoEstadoImpl.aDAOEstado;
	}



	@Override
	public void incluir(Estado pEstado) {

		try{
			ConnectionFactory.getInstace().getConnection().getTransaction().begin();
			ConnectionFactory.getInstace().getConnection().persist(pEstado);
			ConnectionFactory.getInstace().getConnection().getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(e.getMessage());
			ConnectionFactory.getInstace().getConnection().getTransaction().rollback();

		} finally{
			ConnectionFactory.getInstace().getCloseConnection();

		}


	}


	@Override
	public void alterar(Estado pEstado) {
		// TODO Auto-generated method stub

	}


	@Override
	public void excluir(Estado pEstado) {
		// TODO Auto-generated method stub

	}



	@Override
	public List<Estado> consultar() {
		List<Estado> retorno = new ArrayList<Estado>();
		try {
			String sql = "FROM " + Constantes.PATH_PROJECT + ".modelo.Estado order by descricao asc";

			TypedQuery<Estado> q = ConnectionFactory.getInstace().getConnection().createQuery(sql, Estado.class);
			retorno = q.getResultList();

		} catch (Exception e) {
			e.printStackTrace();
			retorno = null;
		}

		return retorno;
	}


	@Override
	public Estado getEstado(Estado pEstado) {
		Estado retorno = new Estado();

		try{

			if(pEstado !=null){
				int i = 0;
				String sql = "FROM " + Constantes.PATH_PROJECT + ".modelo.Estado";
				String sqlWhere = "";
				String sqlConector = "";

				if(pEstado.getCodigo() != null){
					i++;
					sqlWhere += sqlConector + "id_estado =:id_estado";
					sqlConector = " AND ";
				}

				
				if (i > 0){
					//Construe the where.
					sql = sql + " WHERE " + sqlWhere;
				}

				TypedQuery<Estado> q = ConnectionFactory.getInstace().getConnection().createQuery(sql, Estado.class);


				if (i > 0){
					if(pEstado.getCodigo() != null){
						q.setParameter("id_estado", pEstado.getCodigo());
					}
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
