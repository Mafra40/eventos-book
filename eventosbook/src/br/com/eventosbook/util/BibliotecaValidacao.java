package br.com.eventosbook.util;

import javax.servlet.http.HttpSession;

import br.com.eventosbook.constante.Constantes;
import br.com.eventosbook.excecao.ExcecaoContextoUsuarioInvalido;

public class BibliotecaValidacao {
	
	private BibliotecaValidacao() {}
	
	private static BibliotecaValidacao aBibliotecaValidacao = new BibliotecaValidacao();
	
	public static BibliotecaValidacao getInstance(){
		if(BibliotecaValidacao.aBibliotecaValidacao == null){
			BibliotecaValidacao.aBibliotecaValidacao = new BibliotecaValidacao();
		}
		
		return BibliotecaValidacao.aBibliotecaValidacao;
	}
	
	public boolean validarSenha(String pSenha, String pConfirmarSenha){
		if(pSenha.equals(pConfirmarSenha)){
			return true;
		} else {
			return false;
		}
	}
	
	
	public void validaContextoUsuario(HttpSession pSession) throws ExcecaoContextoUsuarioInvalido{
		if(pSession.getAttribute(Constantes.CONTEXTO_USUARIO_LOGADO) == null){
			throw new ExcecaoContextoUsuarioInvalido();
		}
	}
	
	

}
