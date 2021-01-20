package br.com.eventosbook.rn;

import br.com.eventosbook.modelo.Email;
import br.com.eventosbook.modelo.Usuario;
import br.com.eventosbook.rn.consultas.ConsultarValidaCadastroUsuarioPorEmail;

public class RnProcessarAutenticacaoPorEmail {
	private static RnProcessarAutenticacaoPorEmail aRnProcessarAutenticacaoPorEmail = new RnProcessarAutenticacaoPorEmail();

	public static RnProcessarAutenticacaoPorEmail getInstance(){
		if(RnProcessarAutenticacaoPorEmail.aRnProcessarAutenticacaoPorEmail == null){
			RnProcessarAutenticacaoPorEmail.aRnProcessarAutenticacaoPorEmail = new RnProcessarAutenticacaoPorEmail();
		}

		return RnProcessarAutenticacaoPorEmail.aRnProcessarAutenticacaoPorEmail;
	}
	
	
	public Usuario executar(String pCodigoAtivacao, int pCodigoUsuario){
	
		Email email = ConsultarValidaCadastroUsuarioPorEmail.getInstance().consultar(pCodigoAtivacao, pCodigoUsuario);
		
		Usuario retorno = email.getUsuario();
		
		return retorno;
		
	}
	

}
