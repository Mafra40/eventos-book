package br.com.eventosbook.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.eventosbook.constante.Constantes;
import br.com.eventosbook.fachada.EventoServico;
import br.com.eventosbook.fachada.FornecedorServico;
import br.com.eventosbook.fachada.ImagemServico;
import br.com.eventosbook.fachada.OrcamentoServico;
import br.com.eventosbook.modelo.Evento;
import br.com.eventosbook.modelo.Fornecedor;
import br.com.eventosbook.modelo.Imagem;
import br.com.eventosbook.modelo.Orcamento;
import br.com.eventosbook.modelo.Usuario;

/** Classe controladora de requisição dos orçamentos.
 * 
 * @author rodrigo.leite
 *
 */

@Controller
@RequestMapping(Constantes.LINK_ORCAMENTO_CONTROLADOR)
public class OrcamentoControlador {
	
	
	/**Solicitar um orçamento.
	 * 
	 * @return
	 */
	@RequestMapping("/"+Constantes.LINK_SOLICITAR_ORCAMENTO)
	public String solicitarOrcamento(HttpSession pSession, 
			@RequestParam("idFornecedor") String idFornecedor,
			@RequestParam("idEvento") String idEvento, RedirectAttributes pRedirectAttributes ){
		
		Evento evento = new Evento();
		Fornecedor fornecedor = new Fornecedor();
		
		if ( idEvento != null && !idEvento.equals("")){
			evento.setCodigo(Integer.valueOf(idEvento));
		}
		evento = EventoServico.getInstance().consultarEventoPorObjeto(evento);
		
		fornecedor.setCodigo(Integer.valueOf(idFornecedor));
		fornecedor = FornecedorServico.getInstance().ConsultarFornecedorPorObjeto(fornecedor);
		
		OrcamentoServico.getInstance().solicitarOrcamento(evento, fornecedor , pRedirectAttributes);
		
		return Constantes.NM_REDIRECT + Constantes.LINK_EXIBIR_ORCAMENTO;
	}
	
	/**Lista todos os orçamentos
	 * 
	 * @return
	 */
	@RequestMapping("/"+Constantes.LINK_EXIBIR_ORCAMENTO)
	public String exibirOrcamentos(HttpSession pSession , ModelMap pModel){
		//Contratante contratante = new Contratante();
		Orcamento orcamento = new Orcamento();
		
		//TODO ver uma forma de consultar o orcamento pegando o evento e o contratante.
		//TODO Consultar a avaliação e comentário de cada um...
		Evento evento = new Evento();
		evento.setCodigo(2);
		
		Usuario usuario = (Usuario) pSession.getAttribute(Constantes.CONTEXTO_USUARIO_LOGADO);
		//contratante = ContratanteServico.getInstance().consultarContratantePorUsuario(usuario);
		evento = EventoServico.getInstance().consultarEventoPorObjeto(evento);
		
		orcamento.setEvento(evento);
		List<Orcamento> listOrcamento =  OrcamentoServico.getInstance().consultarOrcamentosPorContratante(orcamento);
		
	    pModel.addAttribute(Constantes.NM_ATR_MODEL_CONTRATANTE_FORNECEDOR, listOrcamento);
	    
	    
	  //FIXME ISSO AQUI VAI SER TROCADO POR SqlResultSetMapping (pesquisa/melhorias).
	    List<Imagem> arrImagem = new ArrayList<Imagem>();
	    
	    for (int i = 0; i < listOrcamento.size(); i++) {
	    	Imagem img = new Imagem();
	    	img.setImagemPrincipal(Constantes.SIGLA_AFIRMACAO);
	    	img.setUsuario(listOrcamento.get(i).getFornecedor().getUsuario());
	    	img = ImagemServico.getInstance().consultarImagemPrincipalPorFornecedor(img);
	    	if (img != null){
	    		arrImagem.add(img);
	    		img = null;
			}
	    }
	    
	    if(arrImagem.size() > 0){
	    	pModel.addAttribute(Constantes.NM_ATR_MODEL_IMAGEM, arrImagem);
	    }
	    
	    return Constantes.NM_JSP_MEU_ORCAMENTO;
	}
	
	
	
}
