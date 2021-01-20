package br.com.eventosbook.rn;

import javax.servlet.http.HttpSession;

import br.com.eventosbook.constante.Constantes;
import br.com.eventosbook.excecao.ExecaoUsuarioNaoEncontrado;
import br.com.eventosbook.modelo.Usuario;
import br.com.eventosbook.util.BibliotecaFuncao;
import br.com.eventosbook.util.BibliotecaUrl;

public class RnValidarUsuario {
	
private static RnValidarUsuario aRnValidarUsuario = new RnValidarUsuario();
	
	public static RnValidarUsuario getInstance(){
		if(RnValidarUsuario.aRnValidarUsuario == null){
			RnValidarUsuario.aRnValidarUsuario = new RnValidarUsuario();
		}
		
		return RnValidarUsuario.aRnValidarUsuario;
	}
	
	public String executar(Usuario pUsuario, HttpSession pSession) throws ExecaoUsuarioNaoEncontrado{
		String retorno = null;
		String senha = BibliotecaFuncao.criptografarPalavra(pUsuario.getSenha());
		pUsuario.setSenha(senha);
		
		Usuario usuario = RnConsultarUsuarioPorObjeto.getInstance().executar(pUsuario);
		
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
			} Ainda irá vai ser implementado*/
			
		} else {
			retorno = BibliotecaUrl.getInstance().getRedirect(Constantes.LINK_USUARIO_CONTROLADOR, Constantes.LINK_LOGIN);
			throw new ExecaoUsuarioNaoEncontrado();		
		}
		
		return retorno;
	}

}
