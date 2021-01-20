package br.com.eventosbook.excecao;

import br.com.eventosbook.modelo.Usuario;

public class ExcecaoUsuarioJaCadastrado extends Exception {
	
	public ExcecaoUsuarioJaCadastrado(Usuario pUsuario) {
		super("O usuario"+pUsuario.getEmail()+"Já está cadastrado");
	}

}
