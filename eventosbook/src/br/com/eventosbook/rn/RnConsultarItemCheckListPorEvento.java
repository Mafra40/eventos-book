package br.com.eventosbook.rn;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import br.com.eventosbook.modelo.CheckList;
import br.com.eventosbook.modelo.Evento;
import br.com.eventosbook.rn.consultas.ConsultarCheckListPorEvento;

public class RnConsultarItemCheckListPorEvento {
	
	private RnConsultarItemCheckListPorEvento() {}

	private static RnConsultarItemCheckListPorEvento aRnConsultarCheckListPorEvento = new RnConsultarItemCheckListPorEvento();

	public static RnConsultarItemCheckListPorEvento getInstance(){
		if(RnConsultarItemCheckListPorEvento.aRnConsultarCheckListPorEvento == null){
			RnConsultarItemCheckListPorEvento.aRnConsultarCheckListPorEvento = new RnConsultarItemCheckListPorEvento();
		}

		return RnConsultarItemCheckListPorEvento.aRnConsultarCheckListPorEvento;
	}
	
	public List<CheckList> executar(int id, HttpSession pSession){
		List<CheckList> listaItens = new ArrayList<CheckList>();
		Evento evento = new Evento();
		evento.setCodigo(id);
		
		listaItens = ConsultarCheckListPorEvento.getInstance().consultar(evento);
		
		return listaItens;
		
	}

}
