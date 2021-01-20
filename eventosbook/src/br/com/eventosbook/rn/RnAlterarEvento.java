package br.com.eventosbook.rn;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import br.com.eventosbook.constante.Constantes;
import br.com.eventosbook.dao.impl.DaoEventoImpl;
import br.com.eventosbook.modelo.Contratante;
import br.com.eventosbook.modelo.Evento;
import br.com.eventosbook.modelo.Item;
import br.com.eventosbook.modelo.TipoEvento;
import br.com.eventosbook.modelo.Usuario;
import br.com.eventosbook.pojo.Formulario;
import br.com.eventosbook.util.BibliotecaFuncao;
import br.com.eventosbook.util.BibliotecaUrl;

public class RnAlterarEvento {
	
	private RnAlterarEvento() {}

	private static RnAlterarEvento aRnAlterarEvento = new RnAlterarEvento();

	public static RnAlterarEvento getInstance(){
		if(RnAlterarEvento.aRnAlterarEvento == null){
			RnAlterarEvento.aRnAlterarEvento = new RnAlterarEvento();
		}

		return RnAlterarEvento.aRnAlterarEvento;
	}
	
	
	
	public String executar(Formulario pFormulario, HttpSession pSession) throws Exception{
		
		Evento evento = new Evento();
		
		Usuario usuario = (Usuario) pSession.getAttribute(Constantes.CONTEXTO_USUARIO_LOGADO);
		
		Contratante contratante = RnConsultarContratantePorUsuario.getInstance().executar(usuario);
		TipoEvento  tipoEvento = new TipoEvento(Integer.parseInt(pFormulario.getValorSelect()));
		List<Item> listaItem = new ArrayList<Item>();
		
		tipoEvento = RnConsultarTipoEventoPorObjeto.getInstance().executar(tipoEvento);
		listaItem = RnConsultarItemCheckListPorTipoEvento.getInstance().executar(tipoEvento);
		
		
		evento.setCodigo(new Integer(pFormulario.getCodigo()));
		evento.setDescricao(pFormulario.getNome());
		
		evento.setTipoEvento(tipoEvento);
		evento.setDataEvento(BibliotecaFuncao.formatarData(pFormulario.getData(), Constantes.MASCARA_DATA_PT_BR));
		evento.setHorarioEvento(BibliotecaFuncao.formatarHora(pFormulario.getHora(), Constantes.MASCARA_HORA_MINUTO));
		evento.setContratante(contratante);
		evento.setDataCriacao();
		evento.setColecaoItem(listaItem);
		DaoEventoImpl.getInstance().alterar(evento);
		
		return BibliotecaUrl.getInstance().getRedirect(Constantes.LINK_CONTRATANTE_CONTROLADOR, Constantes.LINK_MEU_EVENTO);
		
	}

}
