package br.com.eventosbook.dao;

import java.util.List;

import br.com.eventosbook.modelo.Email;

public interface DaoEmail {
	public void incluir(Email pEmail) throws Exception;
	public void alterar(Email pEmail)throws Exception;
	public void excluir(Email pEmail)throws Exception;
	public List<Email>consultar()throws Exception;
	public Email getEmail(Email pEmail)throws Exception;
}
