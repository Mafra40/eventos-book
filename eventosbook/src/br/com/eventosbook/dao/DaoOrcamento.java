package br.com.eventosbook.dao;

import java.util.List;

import br.com.eventosbook.modelo.Orcamento;

public interface DaoOrcamento {

	
	public void incluir(Orcamento pOrcamento) throws Exception;
	public void alterar(Orcamento pOrcamento);
	public void excluir(Orcamento pOrcamento);
	public List<Orcamento>consultar(Orcamento pFiltroOrcamento);
	public Orcamento getContratanteFornecedor(Orcamento pOrcamento);
	
}
