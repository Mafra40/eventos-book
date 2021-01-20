package br.com.eventosbook.dao;

import java.util.List;

import br.com.eventosbook.modelo.Cidade;

public interface DaoCidade {
	public void incluir(Cidade pCidade);
	public void alterar(Cidade pCidade);
	public void excluir(Cidade pCidade);
	public List<Cidade>consultar();
	public Cidade getCidade(Cidade pCidade);


}
