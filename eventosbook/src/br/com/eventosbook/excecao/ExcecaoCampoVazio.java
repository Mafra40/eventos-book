package br.com.eventosbook.excecao;

public class ExcecaoCampoVazio extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExcecaoCampoVazio(String pCampo) {
		
		super("O campo "+pCampo+" está vazio");
	}

}
