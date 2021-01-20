package br.com.eventosbook.rn;

import java.util.List;

import javax.servlet.http.HttpSession;

import br.com.eventosbook.constante.Constantes;
import br.com.eventosbook.fachada.ContratanteServico;
import br.com.eventosbook.modelo.Contratante;
import br.com.eventosbook.modelo.Evento;
import br.com.eventosbook.modelo.Usuario;
import br.com.eventosbook.rn.consultas.ConsultarEventoPorContratante;

public class RnConsultarEventoPorContratante {
	
private static RnConsultarEventoPorContratante aRnConsultarEventoContratante = new RnConsultarEventoPorContratante();
	
	public static RnConsultarEventoPorContratante getInstance(){
		if(RnConsultarEventoPorContratante.aRnConsultarEventoContratante == null){
			RnConsultarEventoPorContratante.aRnConsultarEventoContratante = new RnConsultarEventoPorContratante();
		}
		
		return RnConsultarEventoPorContratante.aRnConsultarEventoContratante;
	}
	
	public List<Evento> executar(HttpSession pHttpSession){
		Contratante contratante = new Contratante();
		Usuario usuario = (Usuario) pHttpSession.getAttribute(Constantes.CONTEXTO_USUARIO_LOGADO);

		contratante = ContratanteServico.getInstance().consultarContratantePorUsuario(usuario);
		return ConsultarEventoPorContratante.getInstance().consulta(contratante);
	}


}
