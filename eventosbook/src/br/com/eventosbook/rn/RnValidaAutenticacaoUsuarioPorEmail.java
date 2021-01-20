package br.com.eventosbook.rn;

import javax.servlet.http.HttpSession;

import br.com.eventosbook.constante.Constantes;
import br.com.eventosbook.modelo.Usuario;
import br.com.eventosbook.util.BibliotecaUrl;

public class RnValidaAutenticacaoUsuarioPorEmail {
	
	private static RnValidaAutenticacaoUsuarioPorEmail aRnValidaAutenticacaoUsuarioPorEmail = new RnValidaAutenticacaoUsuarioPorEmail();

	public static RnValidaAutenticacaoUsuarioPorEmail getInstance(){
		if(RnValidaAutenticacaoUsuarioPorEmail.aRnValidaAutenticacaoUsuarioPorEmail == null){
			RnValidaAutenticacaoUsuarioPorEmail.aRnValidaAutenticacaoUsuarioPorEmail = new RnValidaAutenticacaoUsuarioPorEmail();
		}

		return RnValidaAutenticacaoUsuarioPorEmail.aRnValidaAutenticacaoUsuarioPorEmail;
	}
	
	
	
	public String executar(String pCodigoAtivacao, int pCodigoUsuario, HttpSession pSession) throws Exception{
		String retorno = null;
		
		Usuario usuario = RnProcessarAutenticacaoPorEmail.getInstance().executar(pCodigoAtivacao, pCodigoUsuario);
		
		
		if(usuario != null){
			pSession.setAttribute(Constantes.CONTEXTO_USUARIO_LOGADO, usuario);
			if(usuario.getTipoUsuario().getSigla() == Constantes.SIGLA_TIPO_USUARIO_CONTRATANTE){
				retorno = BibliotecaUrl.getInstance().getRedirect(Constantes.LINK_CONTRATANTE_CONTROLADOR, Constantes.LINK_HOME_CONTRATANTE);
			}
			
			if(usuario.getTipoUsuario().getSigla() == Constantes.SIGLA_TIPO_USUARIO_FORNECEDOR){
				retorno = BibliotecaUrl.getInstance().getRedirect(Constantes.LINK_FORNECEDOR_CONTROLADOR, Constantes.LINK_HOME_FORNECEDOR);
			}
			
			if(usuario.getTipoUsuario().getSigla() == Constantes.SIGLA_TIPO_USUARIO_PRODUTOR){
				retorno = BibliotecaUrl.getInstance().getRedirect(Constantes.LINK_PRODUTOR_CONTROLADOR, Constantes.LINK_HOME_PRODUTOR);
			}
			/*
			if(usuario.getTipoUsuario().getSigla() == Constantes.SIGLA_TIPO_USUARIO_ADMINISTRADOR){
				return "redirect:" + Constantes.LINK_HOME_ADMINISTRADOR;
			} Ainda vai ser implementado*/
			
		} else {
			retorno = Constantes.NM_JSP_CADASTRO_USUARIO_SEM_SUCESSO;
		}
		
		
		
		return retorno;
	}

}
