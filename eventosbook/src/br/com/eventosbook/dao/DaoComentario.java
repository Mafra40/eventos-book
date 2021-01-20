package br.com.eventosbook.dao;

import java.util.List;

import br.com.eventosbook.modelo.Comentario;

public interface DaoComentario {
	public void incluir(Comentario pComentario);
	public void alterar(Comentario pComentario);
	public void excluir(Comentario pComentario);
	public List<Comentario>consultar();
	public Comentario getComentario(Comentario pComentario);


}
