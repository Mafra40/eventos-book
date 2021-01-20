package br.com.eventosbook.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import br.com.eventosbook.constante.Constantes;
import br.com.eventosbook.dao.DaoSituacao;
import br.com.eventosbook.hibernate.util.ConnectionFactory;
import br.com.eventosbook.modelo.Situacao;

public class DaoSituacaoImpl implements DaoSituacao {
	
	private DaoSituacaoImpl() {}
	
	private static DaoSituacaoImpl aDaoSituacao = new DaoSituacaoImpl();
	
	public static DaoSituacaoImpl getInstance(){

		if(DaoSituacaoImpl.aDaoSituacao == null){
			DaoSituacaoImpl.aDaoSituacao = new DaoSituacaoImpl();
		}
		
		return  DaoSituacaoImpl.aDaoSituacao;
	}

	@Override
	public void incluir(Situacao pSituacao) {
		
		try{
			ConnectionFactory.getInstace().getConnection().getTransaction().begin();
			ConnectionFactory.getInstace().getConnection().persist(pSituacao);
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
	public void alterar(Situacao pSituacao) {
	
		try{
			ConnectionFactory.getInstace().getConnection().getTransaction().begin();
			ConnectionFactory.getInstace().getConnection().merge(pSituacao);
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
	public void excluir(Situacao pSituacao) {
		try{
			ConnectionFactory.getInstace().getConnection().getTransaction().begin();
			ConnectionFactory.getInstace().getConnection().remove(pSituacao);
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
	public List<Situacao> consultar() {
		List<Situacao> retorno = new ArrayList<Situacao>();
		
		try{
			String sql = "FROM " + Constantes.PATH_PROJECT + ".modelo.Situacao";
			
			TypedQuery<Situacao> q = ConnectionFactory.getInstace().getConnection().createQuery(sql, Situacao.class);
			retorno = q.getResultList();
			
		}catch(Exception e){
			e.printStackTrace();
			retorno = null;
		}
		
		return retorno;
	}

	@Override
	public Situacao getSituacao(Situacao pSituacao) {
		
		Situacao retorno = new Situacao();
		
		try {
			
			
			String sql = "FROM " + Constantes.PATH_PROJECT + ".modelo.Situacao WHERE 1=1";
			
			if(pSituacao.getCodigo() != null){
				sql+= "AND id_situacao =:id";
			}
			
			if(pSituacao.getDescricao() != null){
				sql+= "AND descricao =:descricao";
			}
			
			if(pSituacao.getSigla() != null){
				sql+= "AND sigla =:sigla";
			}
			
			
			TypedQuery<Situacao> q = ConnectionFactory.getInstace().getConnection().createQuery(sql, Situacao.class);
			
			
			if(pSituacao.getCodigo() != null){
				q.setParameter("id", pSituacao.getCodigo());
			}

			if(pSituacao.getDescricao() != null){
				q.setParameter("descricao", pSituacao.getDescricao());
			}
			if(pSituacao.getSigla() != null){
				q.setParameter("sigla", pSituacao.getSigla());
			}
			
			retorno =  q.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			retorno = null;
			
		}
		
		return retorno;
		
	}

}
