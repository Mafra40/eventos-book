package br.com.eventosbook.rn;

import br.com.eventosbook.dao.impl.DaoEventoImpl;
import br.com.eventosbook.modelo.Evento;

/**RN que implementa a consulta de 1 evento passando um objeto.
 * 
 * @author rodrigo.leite
 *
 */
public class RnConsultarEventoPorObjeto {
	
private static RnConsultarEventoPorObjeto aRnConsultarEventoPorObjeto = new RnConsultarEventoPorObjeto();
	
	public static RnConsultarEventoPorObjeto getInstance(){
		if(RnConsultarEventoPorObjeto.aRnConsultarEventoPorObjeto == null){
			RnConsultarEventoPorObjeto.aRnConsultarEventoPorObjeto = new RnConsultarEventoPorObjeto();
		}
		
		return RnConsultarEventoPorObjeto.aRnConsultarEventoPorObjeto;
	}
	
	
	public Evento executar(Evento pEvento){
		return DaoEventoImpl.getInstance().getEvento(pEvento);
	}

}
