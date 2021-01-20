package br.com.eventosbook.rn;

import java.util.ArrayList;
import java.util.List;

import br.com.eventosbook.dao.impl.DaoEstadoImpl;
import br.com.eventosbook.modelo.Cidade;
import br.com.eventosbook.modelo.Estado;

public class RnConsultarCidadePorEstado {
	
	
	private RnConsultarCidadePorEstado() {}

	private static RnConsultarCidadePorEstado aRnConsultarCidadePorEstado = new RnConsultarCidadePorEstado();

	public static RnConsultarCidadePorEstado getInstance(){
		if(RnConsultarCidadePorEstado.aRnConsultarCidadePorEstado == null){
			RnConsultarCidadePorEstado.aRnConsultarCidadePorEstado = new RnConsultarCidadePorEstado();
		}

		return RnConsultarCidadePorEstado.aRnConsultarCidadePorEstado;
	}
	
	
	public List<Cidade> executar(Estado pEstado){
		List<Cidade> listCidade = null;
		Estado estado = null;
		
		estado = DaoEstadoImpl.getInstance().getEstado(pEstado);
		
		if (estado != null){
			listCidade = new ArrayList<Cidade>(estado.getColecaoCidade());		
		}
		return listCidade;
	}
}
