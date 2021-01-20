package br.com.eventosbook.dao;

import java.util.List;

import br.com.eventosbook.modelo.TipoUsuario;

public interface DaoTipoUsuario {
	
	public void incluir(TipoUsuario pTipoUsuario);
	public void alterar(TipoUsuario pTipoUsuario);
	public void excluir(TipoUsuario pTipoUsuario);
	public List<TipoUsuario>consultar();
	public TipoUsuario getTipoUsuario(TipoUsuario pTipoUsuario);

}
