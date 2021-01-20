package br.com.eventosbook.dao;

import java.util.List;

import br.com.eventosbook.modelo.CheckList;

public interface DaoCheckList {
	public void incluir(CheckList pCheckList);
	public CheckList alterar(CheckList pCheckList);
	public void excluir(CheckList pCheckList);
	public List<CheckList>consultar();
	public CheckList getCheckList(CheckList pCheckList);

}
