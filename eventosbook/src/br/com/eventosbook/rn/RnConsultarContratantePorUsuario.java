package br.com.eventosbook.rn;

import br.com.eventosbook.modelo.Contratante;
import br.com.eventosbook.modelo.Usuario;
import br.com.eventosbook.rn.consultas.ConsultarContratantePorUsuario;

public class RnConsultarContratantePorUsuario {
	
	private RnConsultarContratantePorUsuario() {}

	private static RnConsultarContratantePorUsuario aRnConsultarContratanePorUsuario = new RnConsultarContratantePorUsuario();

	public static RnConsultarContratantePorUsuario getInstance(){
		if(RnConsultarContratantePorUsuario.aRnConsultarContratanePorUsuario == null){
			RnConsultarContratantePorUsuario.aRnConsultarContratanePorUsuario = new RnConsultarContratantePorUsuario();
		}

		return RnConsultarContratantePorUsuario.aRnConsultarContratanePorUsuario;
	}
	
	
	public Contratante executar(Usuario pUsuario){
		return ConsultarContratantePorUsuario.getInstance().consultar(pUsuario);
	}

}
