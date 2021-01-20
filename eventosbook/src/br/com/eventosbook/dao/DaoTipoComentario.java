package br.com.eventosbook.dao;

import java.util.List;

import br.com.eventosbook.modelo.TipoComentario;

public interface DaoTipoComentario {
	public void incluir(TipoComentario pTipoComentario);
	public void alterar(TipoComentario pTipoComentario);
	public void excluir(TipoComentario pTipoComentario);
	public List<TipoComentario>consultar();
	public TipoComentario getTipoComentario(TipoComentario pTipoComentario);

}
