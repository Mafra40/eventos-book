package br.com.eventosbook.dao;

import java.util.List;

import br.com.eventosbook.modelo.TipoEvento;


public interface DaoTipoEvento {
	
	public void incluir(TipoEvento pTipoEvento);
	public void alterar(TipoEvento pTipoEvento);
	public void excluir(TipoEvento pTipoEvento);
	public List<TipoEvento>consultar();
	public TipoEvento getTipoEvento(TipoEvento pTipoEvento);

}
