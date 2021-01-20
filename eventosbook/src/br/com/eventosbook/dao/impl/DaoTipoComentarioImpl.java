package br.com.eventosbook.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import br.com.eventosbook.constante.Constantes;
import br.com.eventosbook.dao.DaoTipoComentario;
import br.com.eventosbook.hibernate.util.ConnectionFactory;
import br.com.eventosbook.modelo.TipoComentario;

public class DaoTipoComentarioImpl implements DaoTipoComentario {

	private DaoTipoComentarioImpl() {}
	private static DaoTipoComentarioImpl aDAOTipoComentario = new DaoTipoComentarioImpl();

	public static DaoTipoComentarioImpl getInstance(){
		if(DaoTipoComentarioImpl.aDAOTipoComentario == null){
			DaoTipoComentarioImpl.aDAOTipoComentario = new DaoTipoComentarioImpl();
		}

		return DaoTipoComentarioImpl.aDAOTipoComentario;
	}


	@Override
	public void incluir(TipoComentario pTipoComentario) {
		// TODO Auto-generated method stub

	}

	@Override
	public void alterar(TipoComentario pTipoComentario) {
		// TODO Auto-generated method stub

	}

	@Override
	public void excluir(TipoComentario pTipoComentario) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<TipoComentario> consultar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TipoComentario getTipoComentario(TipoComentario pTipoComentario) {
		TipoComentario retorno = new TipoComentario();

		try {

			String sql = "FROM " + Constantes.PATH_PROJECT + ".modelo.TipoComentario WHERE 1=1 ";

			if(pTipoComentario.getCodigo() != null){
				sql+= " AND id_tipo_comentario =:id";
			}

			if(pTipoComentario.getDescricao() != null){
				sql+= " AND descricao =:descricao";
			}

			if(pTipoComentario.getSigla() != null){
				sql+= " AND sigla =:sigla";
			}

			TypedQuery<TipoComentario> q = ConnectionFactory.getInstace().getConnection().createQuery(sql, TipoComentario.class);

			if(pTipoComentario.getCodigo() != null){
				q.setParameter("id", pTipoComentario.getCodigo());
			}

			if(pTipoComentario.getDescricao() != null){
				q.setParameter("descricao", pTipoComentario.getDescricao());
			}
			if(pTipoComentario.getSigla() != null){
				q.setParameter("sigla", pTipoComentario.getSigla());
			}

			retorno = q.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			retorno = null;
		}

		return retorno;
	}

}
