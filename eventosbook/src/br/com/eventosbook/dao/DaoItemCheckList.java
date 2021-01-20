package br.com.eventosbook.dao;

import java.util.List;

import br.com.eventosbook.modelo.Item;

public interface DaoItemCheckList {

	public void incluir(Item pItemCheckList);
	public void alterar(Item pItemCheckList);
	public void excluir(Item pItemCheckList);
	public List<Item>consultar();
	public Item getItemCheckList(Item pItemCheckList);
}
