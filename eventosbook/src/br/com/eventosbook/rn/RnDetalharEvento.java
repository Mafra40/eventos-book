package br.com.eventosbook.rn;

import javax.persistence.NoResultException;
import javax.servlet.http.HttpSession;

import br.com.eventosbook.constante.Constantes;
import br.com.eventosbook.modelo.Contratante;
import br.com.eventosbook.modelo.Evento;
import br.com.eventosbook.modelo.Usuario;
import br.com.eventosbook.rn.consultas.ConsultaDetalharEventoPorConstratante;

public class RnDetalharEvento {

	private static RnDetalharEvento aRnDetalharEvento = new RnDetalharEvento();

	public static RnDetalharEvento getInstance(){
		if(RnDetalharEvento.aRnDetalharEvento == null){
			RnDetalharEvento.aRnDetalharEvento = new RnDetalharEvento();
		}

		return RnDetalharEvento.aRnDetalharEvento;
	}
	
	
	public Evento executar(int id, HttpSession pSession) throws NoResultException, Exception{
		Evento evento = new Evento();
		
		Usuario usuarioLogado = (Usuario)pSession.getAttribute(Constantes.CONTEXTO_USUARIO_LOGADO);
		
		Contratante contratante = RnConsultarContratantePorUsuario.getInstance().executar(usuarioLogado);
		
		evento.setCodigo(id);
		evento.setContratante(contratante);
		evento = ConsultaDetalharEventoPorConstratante.getInstance().consulta(evento);
		
		return evento;
	}

}
