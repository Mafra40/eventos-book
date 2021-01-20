package br.com.eventosbook.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import br.com.eventosbook.constante.Constantes;
import br.com.eventosbook.dao.DaoImagem;
import br.com.eventosbook.hibernate.util.ConnectionFactory;
import br.com.eventosbook.modelo.Imagem;

public class DaoImagemImpl implements DaoImagem {

	private DaoImagemImpl() {}
	private static DaoImagemImpl aDAOImagem = new DaoImagemImpl();
	
	public static final String order_by = " order by id_imagens asc ";

	public static DaoImagemImpl getInstance(){
		if(DaoImagemImpl.aDAOImagem == null){
			DaoImagemImpl.aDAOImagem = new DaoImagemImpl();
		}
		
		return DaoImagemImpl.aDAOImagem;
	}

	@Override
	public void incluir(Imagem pImagem) {
		try{
			ConnectionFactory.getInstace().getConnection().getTransaction().begin();
			ConnectionFactory.getInstace().getConnection().persist(pImagem);
			ConnectionFactory.getInstace().getConnection().getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			ConnectionFactory.getInstace().getConnection().getTransaction().rollback();
			
		} finally{
			ConnectionFactory.getInstace().getCloseConnection();

		}

	}


	@Override
	public void alterar(Imagem pImagem) {
		try{
			ConnectionFactory.getInstace().getConnection().getTransaction().begin();
			ConnectionFactory.getInstace().getConnection().merge(pImagem);
			ConnectionFactory.getInstace().getConnection().getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			ConnectionFactory.getInstace().getConnection().getTransaction().rollback();
			
		} finally{
			ConnectionFactory.getInstace().getCloseConnection();

		}
		
	}

	@Override
	public void excluir(Imagem pImagem) {
		try{
			ConnectionFactory.getInstace().getConnection().getTransaction().begin();
			ConnectionFactory.getInstace().getConnection().remove(pImagem);
			ConnectionFactory.getInstace().getConnection().getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			
			ConnectionFactory.getInstace().getConnection().getTransaction().rollback();
			
		} finally{
			ConnectionFactory.getInstace().getCloseConnection();

		}
		
	}

	@Override
	public List<Imagem> consultar(Imagem pImagem) {
		List<Imagem> retorno = new ArrayList<Imagem>();

		
			
			if(pImagem !=null){
				
				int i = 0;
				String sql = "FROM " + Constantes.PATH_PROJECT + ".modelo.Imagem ";
				String sqlWhere = "";
				String sqlConector = "";
				
				if(pImagem.getCodigo() != null){
					i++;
					sqlWhere += " id_contratante =:id" ;
					sqlConector = " AND ";
				}
		
				if(pImagem.getUsuario().getCodigo() != null){
					i++;
					sqlWhere += " fk_usuario =:fk_usuario ";
					sqlConector = " AND ";
				}
				
				if(pImagem.getImagem_principal() != null){
					i++;
					sqlWhere += sqlConector + " imagem_principal =:imagem_principal ";
					sqlConector = " AND ";
				}
				
				if (i > 0){
					//Construe the where.
					sql = sql + " WHERE " + sqlWhere + order_by;
				}
				
				
				TypedQuery<Imagem> q = ConnectionFactory.getInstace().getConnection().createQuery(sql, Imagem.class);
				
				if (i > 0){
					if(pImagem.getCodigo() != null){
						q.setParameter("id", pImagem.getCodigo());
					}
				}
				if (i > 0){
					if(pImagem.getUsuario().getCodigo() != null && pImagem.getUsuario().getCodigo() != null){
						q.setParameter("fk_usuario", pImagem.getUsuario().getCodigo());
					}
				}
				if (i > 0){
					if(pImagem.getImagem_principal() != null && pImagem.getImagem_principal() != null){
						q.setParameter("imagem_principal", pImagem.getImagem_principal());
					}
				}
				try{
					retorno = q.getResultList();
				}catch(Exception e){
					e.printStackTrace();
					retorno = null;
				}
			}
			
				
			
		
		
		return retorno;
	}

	@Override
	public Imagem getImagem(Imagem pImagem) {
		Imagem retorno = new Imagem();

		try{
			
			if(pImagem !=null){
				
				int i = 0;
				String sql = "FROM " + Constantes.PATH_PROJECT + ".modelo.Imagem ";
				String sqlWhere = "";
				String sqlConector = "";
				
				if(pImagem.getCodigo() != null){
					i++;
					sqlWhere += sqlConector + " id_imagens =:id_imagens ";
					sqlConector = " AND ";
				}
		
				if(pImagem.getUsuario() != null){
					i++;
					sqlWhere += sqlConector + " fk_usuario =:fk_usuario ";
					sqlConector = " AND ";
				}
				
				if(pImagem.getImagem_principal() != null){
					i++;
					sqlWhere += sqlConector + " imagem_principal =:imagem_principal ";
					sqlConector = " AND ";
				}
				
				
				if (i > 0){
					//Construe the where.
					sql = sql + " WHERE " + sqlWhere;
				}
				
				TypedQuery<Imagem> q = ConnectionFactory.getInstace().getConnection().createQuery(sql, Imagem.class);
				
				if(pImagem.getCodigo() != null){
					q.setParameter("id_imagens", pImagem.getCodigo());
				}
	
				if(pImagem.getUsuario() != null){
					q.setParameter("fk_usuario", pImagem.getUsuario().getCodigo());
				}
				
				if(pImagem.getImagem_principal() != null){
					q.setParameter("imagem_principal", pImagem.getImagem_principal());
				}
				
				
				retorno = q.getSingleResult();
			}
			
		}catch(Exception e){
			//e.printStackTrace();
			retorno = null;
		}
		
		return retorno;
	}

}
