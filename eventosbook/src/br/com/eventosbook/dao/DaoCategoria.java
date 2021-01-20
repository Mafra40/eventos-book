package br.com.eventosbook.dao;

import java.util.List;

import br.com.eventosbook.modelo.Categoria;

public interface DaoCategoria{
	public void incluir(Categoria pCategoria);
	public void alterar(Categoria pCategoria);
	public void excluir(Categoria pCategoria);
	public List<Categoria>consultar();
	public Categoria getCategoria(Categoria pCategoria);

}
