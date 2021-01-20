package br.com.eventosbook.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import br.com.eventosbook.constante.Constantes;
import br.com.eventosbook.dao.DaoCategoria;
import br.com.eventosbook.hibernate.util.ConnectionFactory;
import br.com.eventosbook.modelo.Categoria;

public class DaoCategoriaImpl implements DaoCategoria {
	
	
	private DaoCategoriaImpl() {}
	private static DaoCategoriaImpl aDAOCategoria = new DaoCategoriaImpl();

	public static DaoCategoriaImpl getInstance(){
		if(DaoCategoriaImpl.aDAOCategoria == null){
			DaoCategoriaImpl.aDAOCategoria = new DaoCategoriaImpl();
		}
		
		return DaoCategoriaImpl.aDAOCategoria;
	}
	

	@Override
	public void incluir(Categoria pCategoria) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterar(Categoria pCategoria) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir(Categoria pCategoria) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Categoria> consultar() {
		List<Categoria> retorno = new ArrayList<Categoria>();
		try {
			String sql = "FROM " + Constantes.PATH_PROJECT + ".modelo.Categoria order by descricao asc";
			
			TypedQuery<Categoria> q = ConnectionFactory.getInstace().getConnection().createQuery(sql, Categoria.class);
			retorno = q.getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
			retorno = null;
		}
		
		return retorno;
	}

	@Override
	public Categoria getCategoria(Categoria pCategoria) {
		Categoria retorno = new Categoria();
		
		String sql = "FROM " + Constantes.PATH_PROJECT + ".modelo.Categoria WHERE 1=1";
		
		try {
			
			if(pCategoria.getCodigo() != null){
				sql+= "AND id_categoria =:id";
			}
			
			if(pCategoria.getDescricao() != null){
				sql+="AND descricao =:descricao";
			}
			
			
			TypedQuery<Categoria> q = ConnectionFactory.getInstace().getConnection().createQuery(sql, Categoria.class);
			
			
			if(pCategoria.getCodigo() != null){
				q.setParameter("id", pCategoria.getCodigo());
			}
			
			if(pCategoria.getDescricao() != null){
				q.setParameter("descricao", pCategoria.getDescricao());
			}
			
			retorno =  q.getSingleResult();
			
		} catch (Exception e) {
			e.printStackTrace();
			
			retorno = null;
		}

		return retorno;
	}

}
