package br.com.eventosbook.fachada;

import java.util.List;

import br.com.eventosbook.modelo.Cidade;
import br.com.eventosbook.modelo.Estado;
import br.com.eventosbook.rn.RnConsultarCidadePorEstado;

public class EstadoServico {
	
private EstadoServico() {}
	
	private static EstadoServico aEstadoServico = new EstadoServico();
	
	public static EstadoServico getInstance(){
		if(EstadoServico.aEstadoServico == null){
			EstadoServico.aEstadoServico = new EstadoServico();
		}
		
		return EstadoServico.aEstadoServico;
	}
	
	/**Consulta todos as cidades de um estado indicado.
	 * 
	 * @param pEstado
	 * @return
	 */
	public List<Cidade> consultarCidadePorEstado(Estado pEstado){
		return RnConsultarCidadePorEstado.getInstance().executar(pEstado);
	}

}
