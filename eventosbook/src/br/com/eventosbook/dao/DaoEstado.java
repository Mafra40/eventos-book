package br.com.eventosbook.dao;

import java.util.List;

import br.com.eventosbook.modelo.Estado;

public interface DaoEstado {

	public abstract void incluir(Estado pEstado);

	public abstract void alterar(Estado pEstado);

	public abstract void excluir(Estado pEstado);

	public abstract List<Estado> consultar();

	public abstract Estado getEstado(Estado pEstado);

}