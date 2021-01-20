package br.com.eventosbook.dao.impl;

import java.util.List;

import br.com.eventosbook.dao.DaoComentario;
import br.com.eventosbook.hibernate.util.ConnectionFactory;
import br.com.eventosbook.modelo.Comentario;

public class DaoComentarioImpl implements DaoComentario {
	
	private DaoComentarioImpl() {}
	private static DaoComentarioImpl aDAOComentario = new DaoComentarioImpl();

	public static DaoComentarioImpl getInstance(){
		if(DaoComentarioImpl.aDAOComentario == null){
			DaoComentarioImpl.aDAOComentario = new DaoComentarioImpl();
		}

		return DaoComentarioImpl.aDAOComentario;
	}


	@Override
	public void incluir(Comentario pComentario) {
		// TODO Auto-generated method stub

	}
	
	public Comentario incluirRetornadoObjeto(Comentario pComentario) {
		Comentario retorno = new Comentario();
		try{
			ConnectionFactory.getInstace().getConnection().getTransaction().begin();
			retorno = ConnectionFactory.getInstace().getConnection().merge(pComentario);
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
	public void alterar(Comentario pComentario) {
		// TODO Auto-generated method stub

	}

	@Override
	public void excluir(Comentario pComentario) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Comentario> consultar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comentario getComentario(Comentario pComentario) {
		// TODO Auto-generated method stub
		return null;
	}

}
