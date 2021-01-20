package br.com.eventosbook.excecao;

public class ExecaoUsuarioNaoEncontrado extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExecaoUsuarioNaoEncontrado() {
		super("Usuário não encotrado");
	}

}
