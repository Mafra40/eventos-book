package br.com.eventosbook.rn;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import br.com.eventosbook.constante.Constantes;
import br.com.eventosbook.dao.impl.DaoCheckListImpl;
import br.com.eventosbook.dao.impl.DaoEventoImpl;
import br.com.eventosbook.modelo.CheckList;
import br.com.eventosbook.modelo.Evento;
import br.com.eventosbook.rn.consultas.ConsultarCheckListPorEvento;
import br.com.eventosbook.util.BibliotecaUrl;

public class RnRemoverEvento {
	
	private RnRemoverEvento() {}

	private static RnRemoverEvento aRnRemoverEvento = new RnRemoverEvento();

	public static RnRemoverEvento getInstance(){
		if(RnRemoverEvento.aRnRemoverEvento == null){
			RnRemoverEvento.aRnRemoverEvento = new RnRemoverEvento();
		}

		return RnRemoverEvento.aRnRemoverEvento;
	}
	
	public String executar(int id, HttpSession pSession){
		List<CheckList> listaCheckList = new ArrayList<CheckList>();
		Evento evento = new Evento();
		evento.setCodigo(id);
		evento = DaoEventoImpl.getInstance().getEvento(evento);
		listaCheckList = ConsultarCheckListPorEvento.getInstance().consultar(evento);
		
		for (int i = 0; i < listaCheckList.size(); i++) {
			DaoCheckListImpl.getInstance().excluir(listaCheckList.get(i));
		}
	
		DaoEventoImpl.getInstance().excluir(evento);
		
		return BibliotecaUrl.getInstance().getRedirect(Constantes.LINK_CONTRATANTE_CONTROLADOR, Constantes.LINK_MEU_EVENTO);
		
	}

}
