package br.com.eventosbook.dao.impl;

import java.util.List;

import br.com.eventosbook.dao.DaoAvaliacao;
import br.com.eventosbook.hibernate.util.ConnectionFactory;
import br.com.eventosbook.modelo.Avaliacao;

public class DaoAvaliacaoImpl implements DaoAvaliacao {
	
	private DaoAvaliacaoImpl() {}
	private static DaoAvaliacaoImpl aDAOAvaliacao = new DaoAvaliacaoImpl();

	public static DaoAvaliacaoImpl getInstance(){
		if(DaoAvaliacaoImpl.aDAOAvaliacao == null){
			DaoAvaliacaoImpl.aDAOAvaliacao = new DaoAvaliacaoImpl();
		}

		return DaoAvaliacaoImpl.aDAOAvaliacao;
	}


	@Override
	public void incluir(Avaliacao pAvaliacao) {
		// TODO Auto-generated method stub

	}
	
	
	public Avaliacao incluirRetornadoObjeto(Avaliacao pAvaliacao) {
		Avaliacao retorno = new Avaliacao();
		try{
			ConnectionFactory.getInstace().getConnection().getTransaction().begin();
			retorno = ConnectionFactory.getInstace().getConnection().merge(pAvaliacao);
			ConnectionFactory.getInstace().getConnection().getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();

			ConnectionFactory.getInstace().getConnection().getTransaction().rollback();

		} finally{
			ConnectionFactory.getInstace().getCloseConnection();

		}
		return retorno;

	}

	

	@Override
	public void alterar(Avaliacao pAvaliacao) {
		// TODO Auto-generated method stub

	}

	@Override
	public void excluir(Avaliacao pAvaliacao) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Avaliacao> consultar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Avaliacao getAvaliacao(Avaliacao pAvaliacao) {
		// TODO Auto-generated method stub
		return null;
	}

}
