package br.com.eventosbook.dao;

import java.util.List;

import br.com.eventosbook.modelo.Produtor;

public interface DaoProdutor {
	
	public void incluir(Produtor pProdutor);
	public void alterar(Produtor pProdutor);
	public void excluir(Produtor pProdutor);
	public List<Produtor>consultar();
	public Produtor getProdutor(Produtor pProdutor);

}
