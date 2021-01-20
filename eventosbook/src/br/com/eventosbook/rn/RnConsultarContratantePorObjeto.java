package br.com.eventosbook.rn;

import br.com.eventosbook.dao.impl.DaoContratanteImpl;
import br.com.eventosbook.modelo.Contratante;
/**
 * 
 * @author Mafra
 *
 */
public class RnConsultarContratantePorObjeto {
	
	private RnConsultarContratantePorObjeto() {}

	private static RnConsultarContratantePorObjeto aRnConsultarContratante = new RnConsultarContratantePorObjeto();

	public static RnConsultarContratantePorObjeto getInstance(){
		if(RnConsultarContratantePorObjeto.aRnConsultarContratante == null){
			RnConsultarContratantePorObjeto.aRnConsultarContratante = new RnConsultarContratantePorObjeto();
		}

		return RnConsultarContratantePorObjeto.aRnConsultarContratante;
	}
	
	
	public Contratante executar(Contratante pContratante){
		return DaoContratanteImpl.getInstance().getContratante(pContratante);
	}

}
