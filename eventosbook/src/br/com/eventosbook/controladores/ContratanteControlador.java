package br.com.eventosbook.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.eventosbook.constante.Constantes;
import br.com.eventosbook.constante.ConstantesMsgSistema;
import br.com.eventosbook.excecao.ExcecaoUsuarioJaCadastrado;
import br.com.eventosbook.fachada.ContratanteServico;
import br.com.eventosbook.fachada.EstadoServico;
import br.com.eventosbook.fachada.EventoServico;
import br.com.eventosbook.fachada.FornecedorServico;
import br.com.eventosbook.fachada.ImagemServico;
import br.com.eventosbook.modelo.CheckList;
import br.com.eventosbook.modelo.Cidade;
import br.com.eventosbook.modelo.Contratante;
import br.com.eventosbook.modelo.Endereco;
import br.com.eventosbook.modelo.Estado;
import br.com.eventosbook.modelo.Evento;
import br.com.eventosbook.modelo.Fornecedor;
import br.com.eventosbook.modelo.Imagem;
import br.com.eventosbook.modelo.MeuFornecedor;
import br.com.eventosbook.modelo.Telefone;
import br.com.eventosbook.modelo.TipoEvento;
import br.com.eventosbook.modelo.Usuario;
import br.com.eventosbook.pojo.Formulario;
import br.com.eventosbook.pojo.FormularioContratante;
import br.com.eventosbook.pojo.FormularioFornecedor;
import br.com.eventosbook.rn.RnConsultarEstado;
import br.com.eventosbook.rn.RnIncluirContratante;
import br.com.eventosbook.rn.consultas.filtro.FiltroConsultarFornecedor;
import br.com.eventosbook.rn.consultas.filtro.FiltroConsultarMeuFornecedorPorContratante;
import br.com.eventosbook.rn.consultas.filtro.FiltroConsultarQtdAvaliacoesFornecedor;
import br.com.eventosbook.util.BibliotecaHtml;
import br.com.eventosbook.util.BibliotecaTipoSelect;
import br.com.eventosbook.util.BibliotecaUrl;


@Controller
@RequestMapping(Constantes.LINK_CONTRATANTE_CONTROLADOR)
public class ContratanteControlador {

	/**Constantes do controlador
	 * 
	 * @return
	 */
	
	public static final String NM_MODEL_ATR_CONTRATANTE = "contratante";
	public static final String NM_MODEL_ATR_ENDERECO = "endereco";
	public static final String NM_MODEL_ATR_TELEFONE = "telefone";
	public static final String NM_MODEL_ATR_CIDADE = "cidade";
	public static final String NM_MODEL_ATR_ESTADO = "estado";
	public static final String NM_MODEL_ATR_SELECT_SEXO = "slSexo";
	
	@RequestMapping("/"+Constantes.LINK_CADASTRAR_CONTRATANTE)
	public String getCadastrarContratante(){
		return Constantes.NM_JSP_CADASTRAR_CONTRATANTE;
	}

	@RequestMapping("/"+Constantes.LINK_EFETUAR_CADASTRO_CONTRATANTE)
	public String getEfetuarCadastroContratante(FormularioContratante pFormulario, RedirectAttributes pRedirAttribute, HttpSession pSession){
		String retorno = null ;
		if(pFormulario.getNome()== null || pFormulario.getNome().equals("")){
			pRedirAttribute.addFlashAttribute("campoNomeVazio", true);

			retorno = BibliotecaUrl.getInstance().getRedirect(Constantes.LINK_CONTRATANTE_CONTROLADOR, Constantes.LINK_CADASTRAR_CONTRATANTE);
		}

		if(pFormulario.getEmail() == null || pFormulario.getEmail().equals("")){
			pRedirAttribute.addFlashAttribute("campoEmailVazio", true);

			retorno = BibliotecaUrl.getInstance().getRedirect(Constantes.LINK_CONTRATANTE_CONTROLADOR, Constantes.LINK_CADASTRAR_CONTRATANTE);
		}

		if(pFormulario.getSenha() == null || pFormulario.getSenha().equals("")){
			pRedirAttribute.addFlashAttribute("campoSenhaVazio", true);

			retorno = BibliotecaUrl.getInstance().getRedirect(Constantes.LINK_CONTRATANTE_CONTROLADOR, Constantes.LINK_CADASTRAR_CONTRATANTE);
		}

		if(pFormulario.getConfirmSenha() == null || pFormulario.getConfirmSenha().equals("")){
			pRedirAttribute.addFlashAttribute("campoConfirmSenhaVazio", true);

			retorno = BibliotecaUrl.getInstance().getRedirect(Constantes.LINK_CONTRATANTE_CONTROLADOR, Constantes.LINK_CADASTRAR_CONTRATANTE);
		}


		if(!pFormulario.getSenha().equals(pFormulario.getConfirmSenha())){
			pRedirAttribute.addFlashAttribute("senhasDiferentes", true);

			retorno = BibliotecaUrl.getInstance().getRedirect(Constantes.LINK_CONTRATANTE_CONTROLADOR, Constantes.LINK_CADASTRAR_CONTRATANTE);
		}

		if(retorno == null){
			try {
				retorno = RnIncluirContratante.getInstance().executar(pFormulario, pSession);
			} catch (ExcecaoUsuarioJaCadastrado e) {
				
				pRedirAttribute.addFlashAttribute("usuarioJaCadastrado", true);
				
				retorno = BibliotecaUrl.getInstance().getRedirect(Constantes.LINK_CONTRATANTE_CONTROLADOR, Constantes.LINK_CADASTRAR_CONTRATANTE);
				
			} catch (Exception e) {
				pRedirAttribute.addFlashAttribute("erroInesperado", true);
				pRedirAttribute.addFlashAttribute("erro", e);
				
				retorno = BibliotecaUrl.getInstance().getRedirect(Constantes.LINK_CONTRATANTE_CONTROLADOR, Constantes.LINK_CADASTRAR_CONTRATANTE);
			}
		}
				
		return retorno;

	}


	@RequestMapping("/"+Constantes.LINK_HOME_CONTRATANTE)
	public ModelAndView getHomeContratante(HttpSession pSession){
		ModelAndView retorno = new ModelAndView(Constantes.NM_JSP_HOME_CONTRATANTE);

		List<Evento> lista = new ArrayList<Evento>();
		lista = ContratanteServico.getInstance().consultarEventoPorContratante(pSession);
		retorno.addObject("listaEventos", lista);
		return retorno;
	}

	@RequestMapping("/"+Constantes.LINK_AREA_CONTRATANTE)
	public String getAreaContratante(){
		return Constantes.NM_JSP_AREA_CONTRATANTE;
	}

	@RequestMapping("/"+Constantes.LINK_ALTERACAO_CONTRATANTE)
	public String getAlteracaoContratante(ModelMap pModel, HttpSession pSession){

		//Recupera o Usuario pela session, Depois consultar contratate por usuario e setar os dados no campo do formulario.
		//Poderia tbm usar o ModeAndView.
		
		Usuario usuario;
		List<Cidade> lCidade;
		List<Estado> lEstado;
		List<Telefone> lTelefone;
		Endereco endereco = null;	
		Estado estado = null;
		Contratante contratante = new Contratante();
		usuario = (Usuario) pSession.getAttribute(Constantes.CONTEXTO_USUARIO_LOGADO);

		contratante = ContratanteServico.getInstance().consultarContratantePorUsuario(usuario);

		/* Prepara formul�rio de exibi��o */
		usuario = contratante.getUsuario();
		pModel.addAttribute(NM_MODEL_ATR_CONTRATANTE, contratante);

		endereco = usuario.getColecaoEndereco().iterator().next();
		pModel.addAttribute(NM_MODEL_ATR_ENDERECO, endereco);
		lTelefone = usuario.getColecaoTelefone();//telefones
		pModel.addAttribute(NM_MODEL_ATR_TELEFONE, lTelefone);

		//select sexo
		BibliotecaTipoSelect slSexo = new BibliotecaTipoSelect();
		slSexo.add("MASCULINO", "M", "Masculino");
		slSexo.add("FEMININO", "F", "Feminino");
		slSexo.setSelecionado(contratante.getSexo());

		pModel.addAttribute(NM_MODEL_ATR_SELECT_SEXO, slSexo.getColecao());

		//estados
		lEstado = RnConsultarEstado.getInstance().executar();
		pModel.addAttribute(NM_MODEL_ATR_ESTADO, lEstado);
		
		if (endereco.getCidade() != null){
			estado = endereco.getCidade().getEstado();
		}
		
		if(estado != null){
			//cidades
			lCidade = EstadoServico.getInstance().consultarCidadePorEstado(endereco.getCidade().getEstado());
			pModel.addAttribute(NM_MODEL_ATR_CIDADE, lCidade);
			
		}
		
		
		/*Fim prepara*/

		return Constantes.NM_JSP_ALTERACAO_CONTRATANTE;
	}

	
	@RequestMapping("/"+Constantes.LINK_EFETUAR_ALTERACAO_CONTRATANTE)
	public String processarAlteracao(FormularioContratante pFormulario, ModelMap pModel, HttpSession pSession , RedirectAttributes pRedirectAttributes) throws Exception{
		
		return ContratanteServico.getInstance().alterarContratante(pFormulario, pModel, pSession, pRedirectAttributes);
	}
	
	@RequestMapping("/"+Constantes.LINK_MEU_EVENTO)
	public ModelAndView getMeusEventos(HttpSession pSession){
		ModelAndView retorno = new ModelAndView(Constantes.NM_JSP_MEU_EVENTO);

		List<Evento> lista = new ArrayList<Evento>();
		lista = ContratanteServico.getInstance().consultarEventoPorContratante(pSession);
		retorno.addObject("listaEventos", lista);
		
		return retorno;

	}

	@RequestMapping("/"+Constantes.LINK_CADASTRAR_EVENTO)
	public ModelAndView  getCadastrarEventos(){
		ModelAndView mv = new ModelAndView(Constantes.NM_JSP_CADASTRAR_EVENTO);
		List<TipoEvento> lista = new ArrayList<TipoEvento>();
		lista = ContratanteServico.getInstance().consultarTipoEvento();
		mv.addObject("listaTipoEvento", lista);
		return mv;
	}

	@RequestMapping("/"+Constantes.LINK_EFETUAR_CADASTRO_EVENTO)
	public String getEfetuarCadastroEvento(Formulario pFormulario, RedirectAttributes pRedirAttribute, HttpSession pSession){

		String retorno = null;

		if(pFormulario.getNome() == null || pFormulario.getNome().equals("")){
			pRedirAttribute.addFlashAttribute("campoNomeVazio", true);
			retorno = "redirect:" + Constantes.LINK_CADASTRAR_EVENTO;
		}

		if(pFormulario.getValorSelect() == null || pFormulario.getValorSelect().equals("")){
			pRedirAttribute.addFlashAttribute("campoSelectVazio", true);
			retorno = "redirect:" + Constantes.LINK_CADASTRAR_EVENTO;
		}

		if(pFormulario.getData() == null || pFormulario.getData().equals("")){
			pRedirAttribute.addFlashAttribute("campoDataVazio", true);
			retorno = "redirect:" + Constantes.LINK_CADASTRAR_EVENTO;
		}

		if(pFormulario.getHora() == null || pFormulario.getHora().equals("")){
			pRedirAttribute.addFlashAttribute("campoHoraVazio", true);
			retorno = "redirect:" + Constantes.LINK_CADASTRAR_EVENTO;
		}

		if(retorno == null){
			retorno = ContratanteServico.getInstance().incluirEvento(pFormulario, pSession);
		}

		return retorno;
	}

	@RequestMapping("/"+Constantes.LINK_ALTERACAO_EVENTO)
	public ModelAndView getAlterarEvento(Integer id, HttpSession pSession){
		ModelAndView mv = new ModelAndView();
		try{
			Evento evento = new Evento();
			evento = ContratanteServico.getInstance().detalharEvento(id, pSession);
	
			List<TipoEvento> lista = new ArrayList<TipoEvento>();
			lista = ContratanteServico.getInstance().consultarTipoEvento();
	
			mv.setViewName(Constantes.NM_JSP_ALTERACAO_EVENTO);
			mv.addObject("id", id);
			mv.addObject("evento", evento);
			mv.addObject("listaTipoEvento", lista);
		}catch(Exception e){
			mv.setViewName(Constantes.NM_JSP_LOGIN_INVALIDO);
		}

		return mv;
	}
	
	@RequestMapping("/"+Constantes.LINK_EFETUAR_ALTERACAO_EVENTO)
	public String getEfetuarAlteracaoEvento(Formulario pFormulario, RedirectAttributes pRedirAttribute, HttpSession pSession){
		
		String retorno = null;
		

		try {
			if(pFormulario.getNome() == null || pFormulario.getNome().equals("")){
				pRedirAttribute.addFlashAttribute("campoNomeVazio", true);
				retorno = "redirect:" + Constantes.LINK_ALTERACAO_EVENTO+"?id="+pFormulario.getCodigo();
			}

			if(pFormulario.getValorSelect() == null || pFormulario.getValorSelect().equals("")){
				pRedirAttribute.addFlashAttribute("campoSelectVazio", true);
				retorno = "redirect:" + Constantes.LINK_ALTERACAO_EVENTO+"?id="+pFormulario.getCodigo();
			}

			if(pFormulario.getData() == null || pFormulario.getData().equals("")){
				pRedirAttribute.addFlashAttribute("campoDataVazio", true);
				retorno = "redirect:" + Constantes.LINK_ALTERACAO_EVENTO+"?id="+pFormulario.getCodigo();
			}

			if(pFormulario.getHora() == null || pFormulario.getHora().equals("")){
				pRedirAttribute.addFlashAttribute("campoHoraVazio", true);
				retorno = "redirect:" + Constantes.LINK_ALTERACAO_EVENTO+"?id="+pFormulario.getCodigo();
			}

			if(retorno == null){
				retorno = ContratanteServico.getInstance().alterarEvento(pFormulario, pSession);
			}

			
		} catch (Exception e) {
			e.printStackTrace();
			retorno = "redirect:" + Constantes.LINK_ALTERACAO_EVENTO;
		}
		return retorno;
	}
	
	@RequestMapping("/"+Constantes.LINK_REMOVER_EVENTO)
	public String getRemoverEvento(int id, HttpSession pSession){
		return ContratanteServico.getInstance().removerEvento(id, pSession);
	}
	
	
	@RequestMapping("/"+Constantes.LINK_CHECKLIST)
	public ModelAndView getCheckList(int id, HttpSession pSession){
		ModelAndView retorno = new ModelAndView(Constantes.NM_JSP_CHECKLIST);

		List<CheckList> lista = new ArrayList<CheckList>();
		lista = ContratanteServico.getInstance().consultarItemCheckListPorEvento(id, pSession);
		retorno.addObject("listaItens", lista);
		
		pSession.setAttribute("idEvento", lista.get(0).getEvento().getCodigo());
		return retorno;
	}
	
	/**Fornecedor Parametrizado
	 * 
	 * @param idCategoria
	 * @param idSubCategoria
	 * @param pSession
	 * @return
	 */
	@RequestMapping("/"+Constantes.LINK_FORNECEDOR_PARAMETRIZADO)
	public ModelAndView getFornecedor(Integer idCategoria, Integer idSubCategoria, HttpSession pSession){
		ModelAndView retorno = new ModelAndView(Constantes.NM_JSP_FORNECEDOR_PARAMETRIZADO);
		FiltroConsultarFornecedor filtroF = new FiltroConsultarFornecedor();
		FiltroConsultarQtdAvaliacoesFornecedor filtroQtd = new FiltroConsultarQtdAvaliacoesFornecedor();
		
		filtroF.setCdCategoria(idCategoria);
	
		List<FiltroConsultarFornecedor> filtroResultado;
		filtroResultado = ContratanteServico.getInstance().consultarFornecedor(filtroF);
		
		//seta o total de avalia��es de cada fornecedor
		for (int i = 0; i < filtroResultado.size(); i++) {
			filtroQtd.setCdFornecedor(filtroResultado.get(i).getCodigoFornecedor());
			filtroResultado.get(i).setTotalAvaliacao(FornecedorServico.getInstance().consultarQtdAvaliacaoFornecedor(filtroQtd));
			filtroResultado.get(i).setNotaFinalHtml(BibliotecaHtml.getInstance().getAvaliacao(filtroResultado.get(i).getNotaFinal()));
		}
		
		
		
		retorno.addObject("idCategoria", idCategoria);
		retorno.addObject("idSubCategoria", idSubCategoria);
		retorno.addObject("listaFornecedores", filtroResultado);
		return retorno;
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/"+Constantes.LINK_MARCAR_DESMARCAR_ITEM_CHECKLIST)
	public String getMarcarDesmarcarItemChecklist(Integer id){
		return ContratanteServico.getInstance().marcarDesmarcarItemChecklist(id);
	}
	
	
	/**
	 * 
	 * @param idMeuFornecedor
	 * @return
	 */
	@RequestMapping("/"+Constantes.LINK_AVALIAR_FORNECEDOR)
	public ModelAndView getAvaliarFornecedor(Integer idMeuFornecedor){
		ModelAndView retorno = new ModelAndView(Constantes.NM_JSP_AVALIAR_FORNECEDOR);
		MeuFornecedor meuFornecedor = new MeuFornecedor();
		
		meuFornecedor = ContratanteServico.getInstance().consultarMeusFornecedoresPorObjeto(idMeuFornecedor);
		
		retorno.addObject("meuFornecedor", meuFornecedor);
		
		return retorno;
	}
	
	
	@RequestMapping("/"+Constantes.LINK_EFETUAR_AVALIACAO_FORNECEDOR)
	public ModelAndView getEfetuarAvaliacaoFornecedor(Formulario pFormulario, RedirectAttributes pRedirectAttributes){
		ModelAndView retorno = new ModelAndView();
			retorno = ContratanteServico.getInstance().avaliarFornecedor(pFormulario);
		return retorno;
		
		
	}
	
	/**Adiciona o fornecedor aos meus fornecedores
	 * 
	 * @return
	 */
	@RequestMapping("/"+Constantes.LINK_ADD_MEUS_FORNECEDORES)
	public String adicionarMeusFornecedores(HttpSession pSession , ModelMap pModel, RedirectAttributes pRedirAttribute,
			@RequestParam(value = "idFornecedor") String idFornecedor,
			@RequestParam(value = "idEvento" , required= false) String idEvento){
		
		Evento evento = new Evento();
		Fornecedor fornecedor = new Fornecedor();
		
		evento.setCodigo(Integer.valueOf(idEvento));
		evento = EventoServico.getInstance().consultarEventoPorObjeto(evento);
		
		fornecedor.setCodigo(Integer.valueOf(idFornecedor));
		fornecedor = FornecedorServico.getInstance().ConsultarFornecedorPorObjeto(fornecedor);
		
		FornecedorServico.getInstance().adicionarAosMeusFornecedores(fornecedor , evento);
		
		pRedirAttribute.addFlashAttribute("msg", ConstantesMsgSistema.MSG_TELA_MEUS_FORNECEDORES_INCLUIDO.replace(ConstantesMsgSistema.campoSubtituido, fornecedor.getNome()));
		
		
		return BibliotecaUrl.getInstance().getRedirect(Constantes.LINK_CONTRATANTE_CONTROLADOR, Constantes.LINK_EXIBIR_MEUS_FORNECEDORES);
	}
	
	/**Exibie p�gina de Meus Fornecedores
	 * 
	 * @return
	 */
	@RequestMapping("/"+Constantes.LINK_EXIBIR_MEUS_FORNECEDORES)
	public String exibirMeusFornecedores(HttpSession pSession , ModelMap pModel){
		
		
		
		Contratante contratante = new Contratante();
		List<MeuFornecedor> arrMFornecedor;
		
		Usuario usuario = (Usuario) pSession.getAttribute(Constantes.CONTEXTO_USUARIO_LOGADO);
		contratante = ContratanteServico.getInstance().consultarContratantePorUsuario(usuario);
		
		FiltroConsultarMeuFornecedorPorContratante filtro = new FiltroConsultarMeuFornecedorPorContratante();
		filtro.setCodigoContratante(contratante.getCodigo());
		filtro.setAvaliacaoNotNullAlterado(true);
		
		arrMFornecedor = ContratanteServico.getInstance().consultarMeuFornecedorPorContratante(filtro);
		
		//FIXME ISSO AQUI VAI SER TROCADO POR SqlResultSetMapping (pesquisa/melhorias).
		List<Imagem> arrImagem = new ArrayList<Imagem>();
	    
	    for (int i = 0; i < arrMFornecedor.size(); i++) {
	    	Imagem img = new Imagem();
	    	img.setImagemPrincipal(Constantes.SIGLA_AFIRMACAO);
	    	img.setUsuario(arrMFornecedor.get(i).getFornecedor().getUsuario());
	    	img = ImagemServico.getInstance().consultarImagemPrincipalPorFornecedor(img);
	    	if (img != null){
	    		arrImagem.add(img);
	    		img = null;
			}
	    	
	    	
	    	
	    	
	    }
	    
	    if(arrImagem.size() > 0){
	    	pModel.addAttribute(Constantes.NM_ATR_MODEL_IMAGEM, arrImagem);
	    }
		
		
		pModel.addAttribute(Constantes.NM_ATR_MODEL_MEUS_FORNECEDORES, arrMFornecedor);
		
		return Constantes.NM_JSP_MEUS_FORNECEDORES;
	}
	
	@RequestMapping("/"+Constantes.LINK_BUSCAR_FORNECEDOR)
	public String getBuscarFornecedor(){
		return Constantes.NM_JSP_BUSCAR_FORNECEDOR;
		
	}
	
	@RequestMapping("/"+Constantes.LINK_EFETUAR_ORDENACAO_FORNECEDOR)
	public String getEfetuarOrdenacaoFornecedor(FormularioFornecedor pFormulario,  RedirectAttributes pRedirAttribute){
		
		List<Fornecedor> listaFornecedor = new ArrayList<Fornecedor>();
		
		//listaFornecedor = RnEfetuarOrdenacaoFornecedor.getInstance().executar(pFormulario);
		
		pRedirAttribute.addFlashAttribute("listaFornecedores", listaFornecedor);
		pRedirAttribute.addFlashAttribute("idSubCategoria", pFormulario.getIdCategoria());
		pRedirAttribute.addFlashAttribute("listaFornecedores", pFormulario.getIdSubCategoria());
	
		
		 return BibliotecaUrl.getInstance().getRedirect(Constantes.LINK_CONTRATANTE_CONTROLADOR, Constantes.LINK_FORNECEDOR_PARAMETRIZADO);
	}
	
	/**Logout
	 * 
	 * @param pSession
	 * @param pRedirectAttributes
	 * @return
	 */
	@RequestMapping("/"+Constantes.LINK_USUARIO_CADASTRADO)
	public String getUsuarioCadastrado(HttpSession pSession, RedirectAttributes pRedirectAttributes){
		
		pSession.removeAttribute(Constantes.CONTEXTO_USUARIO_LOGADO);
		pRedirectAttributes.addFlashAttribute("usuarioCadastrado", true);
		
		
		return "redirect:" + Constantes.LINK_LOGIN;
	}
	
	
}
