package br.com.eventosbook.rn;

import java.util.List;

import br.com.eventosbook.dao.impl.DaoEstadoImpl;
import br.com.eventosbook.modelo.Estado;

public class RnConsultarEstado {
	
	private RnConsultarEstado() {}

	private static RnConsultarEstado aRnConsultarEstado = new RnConsultarEstado();

	public static RnConsultarEstado getInstance(){
		if(RnConsultarEstado.aRnConsultarEstado == null){
			RnConsultarEstado.aRnConsultarEstado = new RnConsultarEstado();
		}

		return RnConsultarEstado.aRnConsultarEstado;
	}
	
	
	public List<Estado> executar(){
		return DaoEstadoImpl.getInstance().consultar();
	}

}
