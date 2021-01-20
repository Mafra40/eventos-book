package br.com.eventosbook.dao;

import java.util.List;

import br.com.eventosbook.modelo.Endereco;

public interface DaoEndereco {
	public void incluir(Endereco pEndereco);
	public void alterar(Endereco pEndereco);
	public void excluir(Endereco pEndereco);
	public List<Endereco>consultar();
	public Endereco getEndereco(Endereco pEndereco);
}
