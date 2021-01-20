package br.com.eventosbook.excecao;

import br.com.eventosbook.modelo.Usuario;

public class ExcecaoPalavraPasseIncorreta extends Exception {
	
	public ExcecaoPalavraPasseIncorreta(Usuario pUsuario) {
		super("A PALAVRA-PASSE do usu�rio"+pUsuario.getEmail()+"est� incorreta.");
	}

}
