package br.com.eventosbook.controladores;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.eventosbook.constante.Constantes;
import br.com.eventosbook.excecao.ExcecaoContextoUsuarioInvalido;
import br.com.eventosbook.excecao.ExcecaoPalavraPasseIncorreta;
import br.com.eventosbook.excecao.ExcecaoSenhasDiferentes;
import br.com.eventosbook.excecao.ExecaoUsuarioNaoEncontrado;
import br.com.eventosbook.fachada.UsuarioServico;
import br.com.eventosbook.modelo.Usuario;
import br.com.eventosbook.pojo.Formulario;
import br.com.eventosbook.util.BibliotecaFuncao;
import br.com.eventosbook.util.BibliotecaUrl;


@Controller
public class UsuarioControlador {

	/**P�gina de Login
	 * 
	 * @param pSession
	 * @param pRedirectAttributes
	 * @return
	 */
	@RequestMapping("")
	public String getLogin(HttpSession pSession, RedirectAttributes pRedirectAttributes){
		return Constantes.NM_JSP_LOGIN ;
		
	}
	
	
	
	
	/**Logout
	 * 
	 * @param pSession
	 * @param pRedirectAttributes
	 * @return
	 */
	@RequestMapping("/"+Constantes.LINK_SAIR)
	public String getSair(HttpSession pSession, RedirectAttributes pRedirectAttributes){
		
		pSession.removeAttribute(Constantes.CONTEXTO_USUARIO_LOGADO);
		pRedirectAttributes.addFlashAttribute("logout", true);
		
		
		return "redirect:" + Constantes.LINK_LOGIN;
	}
	
	/**
	 * 
	 * @param pSession
	 * @param pRedirectAttributes
	 * @return
	 */
	@RequestMapping("/"+Constantes.LINK_LOGIN_INVALIDO)
	public String getLoginInvalido(HttpSession pSession, RedirectAttributes pRedirectAttributes){
		pSession.removeAttribute(Constantes.CONTEXTO_USUARIO_LOGADO);
		pRedirectAttributes.addFlashAttribute("loginInvalido", true);
		
		return Constantes.NM_JSP_LOGIN;
	}
	
	/**Efetuar login
	 * 
	 * @param pFormulario
	 * @param pRedirectAttributes
	 * @param pSession
	 * @return
	 */
	@RequestMapping("/"+Constantes.LINK_EFETUAR_LOGIN)
	public String getEfetuarlogin(Formulario pFormulario, RedirectAttributes pRedirectAttributes, HttpSession pSession){
		
		if(pFormulario.getEmail() == null || pFormulario.getEmail().equals("")){
			pRedirectAttributes.addFlashAttribute("campoEmailVazio", true);
			return Constantes.LINK_LOGIN;
			
		}
		
		if(pFormulario.getSenha() == null || pFormulario.getSenha().equals("")){
			pRedirectAttributes.addFlashAttribute("campoSenhaVazio", true);
			return Constantes.LINK_LOGIN;
		}
		
		Usuario usuario = new Usuario();
		usuario.setEmail(pFormulario.getEmail());
		usuario.setSenha(pFormulario.getSenha());

		try {
			return UsuarioServico.getInstance().validarUsuario(usuario, pSession);
		} catch (ExecaoUsuarioNaoEncontrado e) {
			pRedirectAttributes.addFlashAttribute("usuarioNaoEncontrado", true);
			e.printStackTrace();
			return "redirect:"+Constantes.LINK_LOGIN_INVALIDO;
			
		}
		
	}

	/**Atlera��o de Senha
	 * 
	 * @return
	 */
	@RequestMapping("/"+Constantes.LINK_ALTERACAO_SENHA)
	public String getAlteracaoSenha(){
		return Constantes.NM_JSP_ALTERACAO_SENHA;
	}
	
	/**P�gina de Recupera��o de Conta
	 * 
	 * @return
	 */
	@RequestMapping("/"+Constantes.LINK_RECUPERACAO_CONTA)
	public String getRecuperacaoConta(){
		return Constantes.NM_JSP_RECUPERACAO_CONTA;
	}
	
	/** Efetua recupera��o de conta.
	 * 
	 * @param pUsuario
	 * @param pRedirectAttributes
	 * @param pSession
	 * @return
	 */
	@RequestMapping("/"+Constantes.LINK_EFETUAR_RECUPERACAO_CONTA)
	public String getEfetuarRecuperacaoConta(Usuario pUsuario, RedirectAttributes pRedirectAttributes, HttpSession pSession){
		
		String retorno = null;
		
		try {
			retorno = UsuarioServico.getInstance().recuperarContaUsuario(pUsuario, pSession);
			
			
		} catch (ExecaoUsuarioNaoEncontrado e) {
			pRedirectAttributes.addFlashAttribute("usuarioNaoEncontrado", true);
			retorno = "redirect:"+Constantes.LINK_RECUPERACAO_CONTA;
			e.printStackTrace();
		} catch (Exception e) {
			pRedirectAttributes.addFlashAttribute("erroInesperado", true);
			retorno = "redirect:"+Constantes.LINK_RECUPERACAO_CONTA;
			e.printStackTrace();
		}
		
		return retorno;
	}
	
	/**Efetua altera��o de senha.
	 * 
	 * @param pUsuario
	 * @param pRedirectAttributes
	 * @param pSession
	 * @return
	 */
	@RequestMapping("/"+Constantes.LINK_EFETUAR_ALTERACAO_SENHA)
	public String getEfetuarAlteracaoSenha(Usuario pUsuario, RedirectAttributes pRedirectAttributes, HttpSession pSession){
		String retorno = null;
		
		
		if(pUsuario.getSenha() == null || pUsuario.getSenha().equals("")){
			retorno = Constantes.LINK_ALTERACAO_SENHA;
		}
		
		if(pUsuario.getNovaSenha() == null || pUsuario.getNovaSenha().equals("")){
			retorno = Constantes.LINK_ALTERACAO_SENHA;
		}
		
		if(retorno == null){
			
			try {
				
				retorno =  UsuarioServico.getInstance().alterarSenhaUsuario(pUsuario, pSession);
				
			} catch (ExcecaoContextoUsuarioInvalido e) {
				retorno = Constantes.LINK_LOGIN_INVALIDO;
				e.printStackTrace();
			} catch (ExcecaoPalavraPasseIncorreta e) {
				pRedirectAttributes.addFlashAttribute("palavraPasseIncorreta", true);
				retorno = Constantes.LINK_ALTERACAO_SENHA;
				e.printStackTrace();
			} catch (ExcecaoSenhasDiferentes e) {
				pRedirectAttributes.addFlashAttribute("senhasDiferentes", true);
				retorno = Constantes.LINK_ALTERACAO_SENHA;
				e.printStackTrace();
			} catch (Exception e) {
				pRedirectAttributes.addFlashAttribute("erroInesperado", true);
				retorno = Constantes.LINK_ALTERACAO_SENHA;
				e.printStackTrace();
			}
			
		}
		
		return retorno;
	}
	
	/**
	 * 
	 * @param pRedirectAttributes
	 * @return
	 */
	@RequestMapping("/"+Constantes.LINK_USUARIO_RECUPERADO_COM_SUCESSO)
	public String getUsuarioRecuperadoComSucesso(RedirectAttributes pRedirectAttributes){
		pRedirectAttributes.addFlashAttribute("senhaAlterada", true);
		return Constantes.NM_REDIRECT +  Constantes.LINK_LOGIN;
	}
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping("/"+Constantes.LINK_CADASTRO_USUARIO_COM_SUCESSO)
	public String getUsuarioCadastradoComSucesso(){
		return Constantes.NM_REDIRECT + Constantes.NM_JSP_CADASTRO_USUARIO_COM_SUCESSO;
	}
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping("/"+Constantes.LINK_CADASTRO_USUARIO_SEM_SUCESSO)
	public String getUsuarioCadastradoSemSucesso(){
		return Constantes.NM_REDIRECT + Constantes.NM_JSP_CADASTRO_USUARIO_SEM_SUCESSO;
	}
	
	/**Autentica��o por email;
	 * 
	 * @param cdAtv
	 * @param idU
	 * @param pSession
	 * @return
	 */
	@RequestMapping("/"+Constantes.LINK_EMAIL_CONFIRMACAO)
	public String getAutenticacaoPorEmail(String cdAtv, String idU, HttpSession pSession){
		String retorno = null;
	
		try {
			retorno = UsuarioServico.getInstance().validarAutenticacaoPorEmail(cdAtv, Integer.parseInt(idU), pSession);
		} catch (Exception e) {
			retorno = Constantes.NM_JSP_CADASTRO_USUARIO_SEM_SUCESSO;
			e.printStackTrace();
			
		}
	
		return retorno;
		
	}
	
	/**P�gina de altera��o de senhas
	 * 
	 * @return
	 */
	@RequestMapping("/"+Constantes.LINK_ALTERACAO_SENHAS_USUARIOS)
	public String exibirAlteracaoSenhasUsuarios(HttpSession pSession, HttpServletRequest pRequest, Model pModel){
		
	
		Usuario usuario = (Usuario) pSession.getAttribute(Constantes.CONTEXTO_USUARIO_LOGADO);
		 
		if (usuario.getTipoUsuario().getSigla().equals(Constantes.SIGLA_TIPO_USUARIO_CONTRATANTE)){
			return Constantes.NM_JSP_ALTERACAO_SENHA_CONTRATANTE;
		}else if(usuario.getTipoUsuario().getSigla().equals(Constantes.SIGLA_TIPO_USUARIO_FORNECEDOR)){
			return Constantes.NM_JSP_ALTERACAO_SENHA_FORNECEDOR;
		}
		
		return "";
		
	}
	
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping("/"+Constantes.LINK_EFETUAR_ALTERACAO_SENHAS_USUARIO)
	public String efetuarAlteracaoSenhasUsuarios(Formulario pFormulario, HttpSession pSession , RedirectAttributes pRedirect){
		
		Usuario usuario = (Usuario) pSession.getAttribute(Constantes.CONTEXTO_USUARIO_LOGADO);
		String novaSenha = "";
		String senhaAtual = "";
		
		novaSenha = BibliotecaFuncao.criptografarPalavra(pFormulario.getSenha());
		senhaAtual = BibliotecaFuncao.criptografarPalavra(pFormulario.getSenhaAtual());
		
		if (senhaAtual.equals(usuario.getSenha())){
			usuario.setSenha(novaSenha);
			UsuarioServico.getInstance().alterarUsuario(usuario);
			pRedirect.addFlashAttribute("msg", "<div  class='alert alert-success alert-dismissable'><button type='button' class='close' data-dismiss='alert' aria-hidden='true'></button> Senha Alterada com sucesso </div>");
			
			if (usuario.getTipoUsuario().getSigla().equals(Constantes.SIGLA_TIPO_USUARIO_CONTRATANTE)){
				return Constantes.NM_REDIRECT + Constantes.LINK_ALTERACAO_SENHAS_USUARIOS;
			}else if(usuario.getTipoUsuario().getSigla().equals(Constantes.SIGLA_TIPO_USUARIO_FORNECEDOR)){
				return Constantes.NM_REDIRECT + Constantes.LINK_ALTERACAO_SENHAS_USUARIOS;
			}
		}else {
			pRedirect.addFlashAttribute("msg", "<div  class='alert alert-danger alert-dismissable'><button type='button' class='close' data-dismiss='alert' aria-hidden='true'></button>Falha ao processar altera��o. Verifique se a senha antiga est� correta.</div>");
		}
		
		
		return Constantes.NM_REDIRECT + Constantes.LINK_ALTERACAO_SENHAS_USUARIOS;
	}
	

}
