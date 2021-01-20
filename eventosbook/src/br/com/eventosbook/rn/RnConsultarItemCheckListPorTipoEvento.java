package br.com.eventosbook.rn;

import java.util.List;

import br.com.eventosbook.modelo.Item;
import br.com.eventosbook.modelo.TipoEvento;
import br.com.eventosbook.rn.consultas.ConsultarItemCheckListPorTipoEvento;

public class RnConsultarItemCheckListPorTipoEvento {
	
	private static RnConsultarItemCheckListPorTipoEvento aRnConsultarItemCheckList = new RnConsultarItemCheckListPorTipoEvento();

	public static RnConsultarItemCheckListPorTipoEvento getInstance(){
		if(RnConsultarItemCheckListPorTipoEvento.aRnConsultarItemCheckList == null){
			RnConsultarItemCheckListPorTipoEvento.aRnConsultarItemCheckList = new RnConsultarItemCheckListPorTipoEvento();
		}

		return RnConsultarItemCheckListPorTipoEvento.aRnConsultarItemCheckList;
	}
	
	public List<Item> executar(TipoEvento pTipoEvento){
		return ConsultarItemCheckListPorTipoEvento.getInstance().consultar(pTipoEvento);
		
	}

}
