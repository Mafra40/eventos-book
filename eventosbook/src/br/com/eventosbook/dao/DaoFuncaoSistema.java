package br.com.eventosbook.dao;

import java.util.List;

import br.com.eventosbook.modelo.FuncaoSistema;

public interface DaoFuncaoSistema {
	

	public void incluir(FuncaoSistema pFuncaoSistema);
	public void alterar(FuncaoSistema pFuncaoSistema);
	public void excluir(FuncaoSistema pFuncaoSistema);
	public List<FuncaoSistema>consultar();
	public FuncaoSistema getFuncaoSistema(FuncaoSistema pFuncaoSistema);

}
