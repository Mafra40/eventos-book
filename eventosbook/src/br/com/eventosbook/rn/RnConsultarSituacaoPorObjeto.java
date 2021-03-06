package br.com.eventosbook.rn;

import br.com.eventosbook.dao.impl.DaoSituacaoImpl;
import br.com.eventosbook.modelo.Situacao;

public class RnConsultarSituacaoPorObjeto {
	
	private RnConsultarSituacaoPorObjeto() {}
	
	private static RnConsultarSituacaoPorObjeto aRnConsultarSituacaoPorObjeto = new RnConsultarSituacaoPorObjeto();
	
	public static RnConsultarSituacaoPorObjeto getInstance(){
		if(RnConsultarSituacaoPorObjeto.aRnConsultarSituacaoPorObjeto == null){
			RnConsultarSituacaoPorObjeto.aRnConsultarSituacaoPorObjeto = new RnConsultarSituacaoPorObjeto();
		}
		
		return RnConsultarSituacaoPorObjeto.aRnConsultarSituacaoPorObjeto;
	}
	
	public Situacao executar(Situacao pSituacao){
		
		return DaoSituacaoImpl.getInstance().getSituacao(pSituacao);
		
	}

}
