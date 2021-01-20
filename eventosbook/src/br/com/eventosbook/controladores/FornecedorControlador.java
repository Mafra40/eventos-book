
package br.com.eventosbook.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.eventosbook.constante.Constantes;
import br.com.eventosbook.excecao.ExcecaoUsuarioJaCadastrado;
import br.com.eventosbook.fachada.EstadoServico;
import br.com.eventosbook.fachada.FornecedorServico;
import br.com.eventosbook.fachada.ImagemServico;
import br.com.eventosbook.fachada.UploadServico;
import br.com.eventosbook.modelo.Categoria;
import br.com.eventosbook.modelo.Cidade;
import br.com.eventosbook.modelo.Endereco;
import br.com.eventosbook.modelo.Estado;
import br.com.eventosbook.modelo.Fornecedor;
import br.com.eventosbook.modelo.Imagem;
import br.com.eventosbook.modelo.Telefone;
import br.com.eventosbook.modelo.Usuario;
import br.com.eventosbook.pojo.FormularioFornecedor;
import br.com.eventosbook.pojo.TipoFile;
import br.com.eventosbook.rn.RnConsultarCategoria;
import br.com.eventosbook.rn.RnConsultarEstado;
import br.com.eventosbook.rn.consultas.filtro.FiltroConsultarAvaliacaoComentFornecedor;
import br.com.eventosbook.rn.consultas.filtro.FiltroConsultarQtdAvaliacoesFornecedor;
import br.com.eventosbook.util.BibliotecaHtml;
import br.com.eventosbook.util.BibliotecaUrl;

@Controller
@RequestMapping(Constantes.LINK_FORNECEDOR_CONTROLADOR)
public class FornecedorControlador {
	
	public static final String NM_MODEL_ATR_CONTRATANTE = "contratante";
	public static final String NM_MODEL_ATR_ENDERECO = "endereco";
	public static final String NM_MODEL_ATR_TELEFONE = "telefone";
	public static final String NM_MODEL_ATR_CIDADE = "cidade";
	public static final String NM_MODEL_ATR_ESTADO = "estado";
	public static final String NM_MODEL_ATR_SELECT_SEXO = "slSexo";
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping("/"+Constantes.LINK_CADASTRAR_FORNECEDOR)
	public ModelAndView getCadastrarFornecedor(){
		ModelAndView retorno = new ModelAndView(Constantes.NM_JSP_CADASTRAR_FORNECEDOR);
		
		try{
			List<Categoria> lista = new ArrayList<Categoria>();
			lista = FornecedorServico.getInstance().consultarCategoria();
			retorno.addObject("listaCategoriaFornecedor", lista);
			
		}catch(Exception e){
			e.printStackTrace();
			
		}
		
		return retorno;
	}
	
	
	/**
	 * 
	 * @param pFormulario
	 * @param pRedirAttribute
	 * @return
	 */
	@RequestMapping("/"+Constantes.LINK_EFETUAR_CADASTRO_FORNECEDOR)
	public String getEfetuarCadastroFornecedor(FormularioFornecedor pFormulario, RedirectAttributes pRedirAttribute, HttpSession pSession){
		String retorno = null ;
		if(pFormulario.getNome()== null || pFormulario.getNome().equals("")){
			pRedirAttribute.addFlashAttribute("campoNomeVazio", true);

			retorno = BibliotecaUrl.getInstance().getRedirect(Constantes.LINK_FORNECEDOR_CONTROLADOR, Constantes.LINK_CADASTRAR_FORNECEDOR);
		}
		
		if(pFormulario.getEmail() == null || pFormulario.getEmail().equals("")){
			pRedirAttribute.addFlashAttribute("campoEmailVazio", true);

			retorno = BibliotecaUrl.getInstance().getRedirect(Constantes.LINK_FORNECEDOR_CONTROLADOR, Constantes.LINK_CADASTRAR_FORNECEDOR);
		}
		
		if(pFormulario.getSenha() == null || pFormulario.getSenha().equals("")){
			pRedirAttribute.addFlashAttribute("campoSenhaVazio", true);

			retorno = BibliotecaUrl.getInstance().getRedirect(Constantes.LINK_FORNECEDOR_CONTROLADOR, Constantes.LINK_CADASTRAR_FORNECEDOR);
		}
		
		if(pFormulario.getConfirmSenha() == null || pFormulario.getConfirmSenha().equals("")){
			pRedirAttribute.addFlashAttribute("campoConfirmSenhaVazio", true);

			retorno = BibliotecaUrl.getInstance().getRedirect(Constantes.LINK_FORNECEDOR_CONTROLADOR, Constantes.LINK_CADASTRAR_FORNECEDOR);
		}
		
		if(pFormulario.getNumeroDocumento() == null || pFormulario.getNumeroDocumento().equals("")){
			pRedirAttribute.addFlashAttribute("campoNumDocumentoVazio", true);

			retorno = BibliotecaUrl.getInstance().getRedirect(Constantes.LINK_FORNECEDOR_CONTROLADOR, Constantes.LINK_CADASTRAR_FORNECEDOR);
		}
		
		if(pFormulario.getValorSelect() == null || pFormulario.getValorSelect().equals("")){
			pRedirAttribute.addFlashAttribute("selectAreaAtuacaoVazio", true);

			retorno = BibliotecaUrl.getInstance().getRedirect(Constantes.LINK_FORNECEDOR_CONTROLADOR, Constantes.LINK_CADASTRAR_FORNECEDOR);
		}
		
		if(!pFormulario.getSenha().equals(pFormulario.getConfirmSenha())){
			pRedirAttribute.addFlashAttribute("senhasDiferentes", true);

			retorno = BibliotecaUrl.getInstance().getRedirect(Constantes.LINK_FORNECEDOR_CONTROLADOR, Constantes.LINK_CADASTRAR_FORNECEDOR);
		}
		
		if(retorno == null){
			try {
				retorno = FornecedorServico.getInstance().incluirFornecedor(pFormulario, pSession);	
			} catch (ExcecaoUsuarioJaCadastrado e) {
				
				pRedirAttribute.addFlashAttribute("usuarioJaCadastrado", true);
				
				retorno = BibliotecaUrl.getInstance().getRedirect(Constantes.LINK_FORNECEDOR_CONTROLADOR, Constantes.LINK_CADASTRAR_FORNECEDOR);
				
			} catch (Exception e) {
				pRedirAttribute.addFlashAttribute("erroInesperado", true);
				pRedirAttribute.addFlashAttribute("erro", e);
				
				retorno = BibliotecaUrl.getInstance().getRedirect(Constantes.LINK_FORNECEDOR_CONTROLADOR, Constantes.LINK_CADASTRAR_FORNECEDOR);
			}
			 
		}
		return retorno;
	}
	
	/**
	 * 
	 * @param pSession
	 * @param pRequest
	 * @param pModel
	 * @param pRedirectAttributes
	 * @return
	 */
	@RequestMapping("/"+Constantes.LINK_HOME_FORNECEDOR)
	public String getHomeFornecedor(HttpSession pSession, HttpServletRequest pRequest, Model pModel, RedirectAttributes pRedirectAttributes){
		return Constantes.NM_JSP_HOME_FORNECEDOR;
	}
	
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(Constantes.LINK_AREA_FORNECEDOR)
	public String getAreaFornecedor(){
		return Constantes.NM_JSP_AREA_FORNECEDOR;
	}
	
	
	/**P�gina de altera��o
	 * 
	 * @param pModel
	 * @param pSession
	 * @return
	 */
	@RequestMapping("/"+Constantes.LINK_ALTERACAO_FORNECEDOR)
	public String getAlteracaoFornecedor(ModelMap pModelMap, Model pModel, HttpSession pSession){
		
		
		Usuario usuario;
		List<Cidade> lCidade;
		List<Estado> lEstado;
		List<Telefone> lTelefone;
		Endereco endereco = null;	
		Estado estado = null;
		List<Categoria> listCategoria;
		Categoria categoria;
		
		Fornecedor fornecedor = new Fornecedor();
		
		usuario = (Usuario) pSession.getAttribute(Constantes.CONTEXTO_USUARIO_LOGADO);
		fornecedor = FornecedorServico.getInstance().ConsultarFornecedorPorUsuario(usuario);
		/* Prepara formul�rio de exibi��o */
		usuario = fornecedor.getUsuario();
		pModel.addAttribute(Constantes.NM_ATR_MODEL_FORNECEDOR, fornecedor);
	
		endereco = usuario.getColecaoEndereco().iterator().next() ;
		pModel.addAttribute(Constantes.NM_ATR_MODEL_ENDERECO, endereco);
		
		lTelefone = usuario.getColecaoTelefone();//telefones
		pModel.addAttribute(Constantes.NM_ATR_MODEL_TELEFONE, lTelefone);
		
		//categorias do fornecedor
		categoria = fornecedor.getCategoria().get(0);
		pModel.addAttribute("fornecedor_categoria", categoria);
		
		//categorias disponiveis
		listCategoria = RnConsultarCategoria.getInstance().executar();
		pModel.addAttribute(Constantes.NM_ATR_MODEL_CATEGORIA, listCategoria);
		
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
		
		return Constantes.NM_JSP_ALTERACAO_FORNECEDOR;
	}
	
	/**Processar Altera��o do fornecedor.
	 * 
	 * @param pFormulario
	 * @param pModel
	 * @param pSession
	 * @param pRedirectAttributes
	 * @return
	 */
	
	@RequestMapping("/"+Constantes.LINK_EFETUAR_ALTERACAO_FORNECEDOR)
	public String processarAlteracaoFornecedor(FormularioFornecedor pFormulario, ModelMap pModel, HttpSession pSession , RedirectAttributes pRedirectAttributes){
		return FornecedorServico.getInstance().alterarFornecedor(pFormulario, pModel, pSession, pRedirectAttributes);
	}
	
	/**P�gina de upload de imagens
	 * 
	 * @param pFormulario
	 * @param pModel
	 * @param pSession
	 * @param pRedirectAttributes
	 * @return
	 */
	@RequestMapping("/"+Constantes.LINK_FORNECEDOR_IMAGENS)
	public String exibirPaginaGaleriaImagens(FormularioFornecedor pFormulario, ModelMap pModel, HttpSession pSession , RedirectAttributes pRedirectAttributes){
		return Constantes.NM_JSP_GALERIA_FORNECEDOR;
	}
	
	/**Exibe o menu de imagens do fornecedor.
	 * 
	 * @param pSession
	 * @param pModel
	 * @return
	 */
	@RequestMapping("/"+Constantes.LINK_FORNECEDOR_GALERIA_IMAGENS)
	public String exibirGaleriaImagens(HttpSession pSession, ModelMap pModel){
		
		Usuario usuarioLogado =(Usuario) pSession.getAttribute(Constantes.CONTEXTO_USUARIO_LOGADO);
		Imagem img = new Imagem();
		img.setUsuario(usuarioLogado);
		
		ArrayList<Imagem> arrImagem = ImagemServico.getInstance().consultarImagem(img);
		pModel.addAttribute(Constantes.NM_ATR_MODEL_IMAGEM, arrImagem );
		return Constantes.NM_JSP_IMAGEM_GALERIA_FORNECEDOR;
	}
	
	
	/**Incluir imagem fornecedor.
	 * 
	 * @param pSession
	 * @return
	 */
	@RequestMapping("/"+Constantes.LINK_FORNECEDOR_EFETUAR_INCLUSAO_IMAGEM)
	public String efetuarInclusaoImagem(HttpSession pSession){
		
		ArrayList<TipoFile> arrTipoFile;
		Imagem imagem;
		Usuario usuarioLogado;
		
		arrTipoFile =(ArrayList<TipoFile>) pSession.getAttribute(Constantes.NM_ATT_ARR_IMAGENS);
		usuarioLogado =(Usuario) pSession.getAttribute(Constantes.CONTEXTO_USUARIO_LOGADO);
		
		if( arrTipoFile != null){
			for (int i = 0; i < arrTipoFile.size(); i++) {
				imagem = new Imagem();
				imagem.setCaminho(arrTipoFile.get(i).getCaminho());
				imagem.setImagemPrincipal("N");
				imagem.setTitulo(arrTipoFile.get(i).getNome());
				imagem.setUsuario(usuarioLogado);
				
				UploadServico.getInstance().IncluirImagem(imagem); 
			}
			
			pSession.removeAttribute(Constantes.NM_ATT_ARR_IMAGENS);
			
			return  BibliotecaUrl.getInstance().getRedirect(Constantes.LINK_FORNECEDOR_CONTROLADOR, Constantes.LINK_FORNECEDOR_GALERIA_IMAGENS);
		}else {
			
			return BibliotecaUrl.getInstance().getRedirect(Constantes.LINK_FORNECEDOR_CONTROLADOR, Constantes.LINK_FORNECEDOR_IMAGENS);
		}
		
	}
	
	/** Controlador de remo��o de imagem do fornecedor.
	 * 
	 * @param pSession
	 * @param pModel
	 * @param cdImagem
	 * @return
	 */
	@RequestMapping("/"+Constantes.LINK_FORNECEDOR_REMOVER_IMAGENS)
	public String efetuarExclusaoImagem(HttpSession pSession, ModelMap pModel , 
			@RequestParam(value = "cdImagem") String cdImagem){
		
		Imagem img = new Imagem();
		img.setCodigo(Integer.valueOf(cdImagem));
		
		img = UploadServico.getInstance().getImagem(img);
			UploadServico.getInstance().removerImagem(img);
			
		return BibliotecaUrl.getInstance().getRedirect(Constantes.LINK_FORNECEDOR_CONTROLADOR, Constantes.LINK_FORNECEDOR_GALERIA_IMAGENS);
	}
	
	/**Exibe tela de detalhamento do fornecedor.
	 * 
	 * @param pSession
	 * @param pModelMap
	 * @param idFornecedor
	 * @return
	 */
	@RequestMapping(value="/"+Constantes.LINK_FORNECEDOR_DETALHAMENTO, method = RequestMethod.GET)
	public  String exibirDetalhamento(HttpSession pSession, ModelMap pModelMap,
			@RequestParam("idFornecedor") String idFornecedor ){
		
		String notaFinalHtml;
		Fornecedor fornecedor = new Fornecedor();
		Endereco endereco = new Endereco();
		ArrayList<Imagem> listImagem = null;
		ArrayList<String> comentarios = new ArrayList<String>();
		List<FiltroConsultarAvaliacaoComentFornecedor> listComentario = new ArrayList<FiltroConsultarAvaliacaoComentFornecedor>();
		FiltroConsultarAvaliacaoComentFornecedor filtroComentario = new FiltroConsultarAvaliacaoComentFornecedor();
		FiltroConsultarQtdAvaliacoesFornecedor fitlroQtdAval = new FiltroConsultarQtdAvaliacoesFornecedor();
		String qtdAvaliacoes = "";
		
		/*Regra de Exibi��o*/
		
		fornecedor.setCodigo(Integer.valueOf(idFornecedor));
	    fornecedor = FornecedorServico.getInstance().ConsultarFornecedorPorObjeto(fornecedor);
	    
	    filtroComentario.setCodigoFornecedor(fornecedor.getCodigo());
	    filtroComentario.setLimit("2");
	    listComentario = FornecedorServico.getInstance().consultarAvaliacaoComentarioFornecedor(filtroComentario);
	    filtroComentario.setLimitAlterado(false);
	    
	    fitlroQtdAval.setCdFornecedor(fornecedor.getCodigo());
	    
	    qtdAvaliacoes =String.valueOf(FornecedorServico.getInstance().consultarQtdAvaliacaoFornecedor(fitlroQtdAval));
	    
	    comentarios = BibliotecaHtml.getInstance().montarSessaoComentarios(listComentario , false);
	    
	    
	    listImagem =  ImagemServico.getInstance().consultarImagem(new Imagem(fornecedor.getUsuario()));
		
	    endereco = fornecedor.getUsuario().getColecaoEndereco().iterator().next() ;
	    
	    notaFinalHtml = BibliotecaHtml.getInstance().getAvaliacao(fornecedor.getNota());
	    
	    pModelMap.addAttribute(Constantes.NM_ATR_MODEL_ENDERECO, endereco);
	    pModelMap.addAttribute(Constantes.NM_ATR_MODEL_FORNECEDOR, fornecedor);
	    pModelMap.addAttribute(Constantes.NM_ATR_MODEL_IMAGEM, listImagem);
	    pModelMap.addAttribute("idEvento", pSession.getAttribute("idEvento"));
	    pModelMap.addAttribute(Constantes.NM_ATR_MODEL_COMENTARIO, comentarios);
	    pModelMap.addAttribute(Constantes.NM_ATR_QTD_AVALIACOES, qtdAvaliacoes);
	    pModelMap.addAttribute("nota", notaFinalHtml);
		/*Fim Regra de Exibi��o*/
		
		return Constantes.NM_JSP_DETALHAMENTO_FORNECEDOR;
	}
	
	
	/**Exibe tela de todos os coment�rios referente ao fornecedor.
	 * 
	 * @param pSession
	 * @param pModelMap
	 * @param idFornecedor
	 * @return
	 */
	@RequestMapping(value="/"+Constantes.LINK_VIZUALIZAR_TOTAL_AVALIACOES, method = RequestMethod.GET)
	public String exibirAvaliacoes(HttpSession pSession, ModelMap pModelMap,
			@RequestParam("idFornecedor") String idFornecedor){
		
		String notaFinalHtml;
		String qtdEstrelasHtml;
		Fornecedor fornecedor = new Fornecedor();
		Endereco endereco = new Endereco();
		ArrayList<String> comentarios = new ArrayList<String>();
		List<FiltroConsultarAvaliacaoComentFornecedor> listComentario = new ArrayList<FiltroConsultarAvaliacaoComentFornecedor>();
		FiltroConsultarAvaliacaoComentFornecedor filtroComentario = new FiltroConsultarAvaliacaoComentFornecedor();
		FiltroConsultarQtdAvaliacoesFornecedor fitlroQtdAval = new FiltroConsultarQtdAvaliacoesFornecedor();
		String qtdAvaliacoes = "";
		
		fornecedor.setCodigo(Integer.valueOf(idFornecedor));
	    fornecedor = FornecedorServico.getInstance().ConsultarFornecedorPorObjeto(fornecedor);
	    
	    filtroComentario.setCodigoFornecedor(fornecedor.getCodigo());
	    listComentario = FornecedorServico.getInstance().consultarAvaliacaoComentarioFornecedor(filtroComentario);
	    
	    fitlroQtdAval.setCdFornecedor(fornecedor.getCodigo());
	    
	    endereco = fornecedor.getUsuario().getColecaoEndereco().iterator().next() ;
	    
	    comentarios = BibliotecaHtml.getInstance().montarSessaoComentarios(listComentario, true);
	    qtdAvaliacoes =String.valueOf(FornecedorServico.getInstance().consultarQtdAvaliacaoFornecedor(fitlroQtdAval));
	    
	    notaFinalHtml = BibliotecaHtml.getInstance().getAvaliacaoSemEstrelas(fornecedor.getNota());
	    qtdEstrelasHtml = BibliotecaHtml.getInstance().getQtdEstrelas(fornecedor.getNota());
	    
	    pModelMap.addAttribute(Constantes.NM_ATR_MODEL_FORNECEDOR, fornecedor);
	    pModelMap.addAttribute(Constantes.NM_ATR_MODEL_ENDERECO, endereco);
	    pModelMap.addAttribute(Constantes.NM_ATR_MODEL_COMENTARIO, comentarios);
	    pModelMap.addAttribute(Constantes.NM_ATR_QTD_AVALIACOES, qtdAvaliacoes);
	    pModelMap.addAttribute("nota", notaFinalHtml);
	    pModelMap.addAttribute("estrelas", qtdEstrelasHtml);
		return Constantes.NM_JSP_AVALIACOES;
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
