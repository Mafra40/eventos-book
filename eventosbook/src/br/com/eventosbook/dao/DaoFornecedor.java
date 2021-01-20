package br.com.eventosbook.dao;

import java.util.List;

import br.com.eventosbook.modelo.Fornecedor;

public interface DaoFornecedor {
	
	public void incluir(Fornecedor pFornecedor);
	public void alterar(Fornecedor pFornecedor);
	public void excluir(Fornecedor pFornecedor);
	public List<Fornecedor>consultar();
	public Fornecedor getFornecedor(Fornecedor pFornecedor);

}
