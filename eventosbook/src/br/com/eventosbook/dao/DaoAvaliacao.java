package br.com.eventosbook.dao;

import java.util.List;

import br.com.eventosbook.modelo.Avaliacao;

public interface DaoAvaliacao {
	
	public void incluir(Avaliacao pAvaliacao);
	public void alterar(Avaliacao pAvaliacao);
	public void excluir(Avaliacao pAvaliacao);
	public List<Avaliacao>consultar();
	public Avaliacao getAvaliacao(Avaliacao pAvaliacao);

}
