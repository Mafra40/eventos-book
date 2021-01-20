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

public class RnIncluirEvento {

	private static RnIncluirEvento aRnIncluirEvento = new RnIncluirEvento();

	public static RnIncluirEvento getInstance(){
		if(RnIncluirEvento.aRnIncluirEvento == null){
			RnIncluirEvento.aRnIncluirEvento = new RnIncluirEvento();
		}

		return RnIncluirEvento.aRnIncluirEvento;
	}
	
	public  String executar(Formulario pFormulario, HttpSession pSession){
		String retorno = null;
		
		Evento novoEvento = new Evento();
		Contratante contratante = new Contratante();
		Usuario usuario = (Usuario) pSession.getAttribute(Constantes.CONTEXTO_USUARIO_LOGADO);
		List<Item> listaItem = new ArrayList<Item>();
		
		try {
			TipoEvento tipoEvento = new TipoEvento(Integer.parseInt(pFormulario.getValorSelect()));
			
			tipoEvento = RnConsultarTipoEventoPorObjeto.getInstance().executar(tipoEvento);
			usuario = RnConsultarUsuarioPorObjeto.getInstance().executar(usuario);
			contratante = RnConsultarContratantePorUsuario.getInstance().executar(usuario);
			listaItem = RnConsultarItemCheckListPorTipoEvento.getInstance().executar(tipoEvento);
		
			novoEvento.setDescricao(pFormulario.getNome());
			novoEvento.setTipoEvento(tipoEvento);
			novoEvento.setDataEvento(BibliotecaFuncao.formatarData(pFormulario.getData(), Constantes.MASCARA_DATA_PT_BR));
			novoEvento.setHorarioEvento(BibliotecaFuncao.formatarHora(pFormulario.getHora(), Constantes.MASCARA_HORA_MINUTO));
			novoEvento.setContratante(contratante);
		
			novoEvento.setColecaoItem(listaItem);
			novoEvento = DaoEventoImpl.getInstance().incluirRetornandoObjeto(novoEvento);
			
			retorno = BibliotecaUrl.getInstance().getRedirect(Constantes.LINK_CONTRATANTE_CONTROLADOR, Constantes.LINK_CHECKLIST)+"?id="+novoEvento.getCodigo();
			
		} catch (Exception e) {
			e.printStackTrace();
			retorno = BibliotecaUrl.getInstance().getRedirect(Constantes.LINK_CONTRATANTE_CONTROLADOR, Constantes.LINK_CADASTRAR_EVENTO);
		}
		
		return retorno;
		
	}


}
