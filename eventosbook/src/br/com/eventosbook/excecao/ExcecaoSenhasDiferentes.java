package br.com.eventosbook.excecao;

public class ExcecaoSenhasDiferentes extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExcecaoSenhasDiferentes() {
		super("Senhas Diferentes");
	}

}
