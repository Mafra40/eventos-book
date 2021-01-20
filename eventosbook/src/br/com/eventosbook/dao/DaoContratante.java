package br.com.eventosbook.dao;

import java.util.List;

import br.com.eventosbook.modelo.Contratante;

public interface DaoContratante {
	
	public void incluir(Contratante pContratante) throws Exception;
	public void alterar(Contratante pContratante);
	public void excluir(Contratante pContratante);
	public List<Contratante>consultar();
	public Contratante getContratante(Contratante pContratante);

}
