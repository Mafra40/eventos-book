package br.com.eventosbook.dao;

import java.util.List;

import br.com.eventosbook.modelo.Usuario;

public interface DaoUsuario {
	
	public void incluir(Usuario pUsuario);
	public void alterar(Usuario pUsuario);
	public void excluir(Usuario pUsuario);
	public List<Usuario>consultar();
	public Usuario getUsuario(Usuario pUsuario);

}
