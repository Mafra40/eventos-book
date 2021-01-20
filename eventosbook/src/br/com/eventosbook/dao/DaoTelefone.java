package br.com.eventosbook.dao;

import java.util.List;

import br.com.eventosbook.modelo.Telefone;

public interface DaoTelefone {
	
	public void incluir(Telefone pTelefone);
	public void alterar(Telefone pTelefone);
	public void excluir(Telefone pTelefone);
	public List<Telefone>consultar();
	public Telefone getTelefone(Telefone pTelefone);

}
