package br.com.eventosbook.dao;

import java.util.List;

import br.com.eventosbook.modelo.Evento;

public interface DaoEvento {
	
	public void incluir(Evento pEvento);
	public void alterar(Evento pEvento);
	public void excluir(Evento pEvento);
	public List<Evento>consultar(Evento pFiltroEvento);
	public Evento getEvento(Evento pEvento);

}
