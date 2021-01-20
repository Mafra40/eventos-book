package br.com.eventosbook.rn.consultas;

import javax.persistence.Query;

import br.com.eventosbook.constante.sql.ConstantesSQL;
import br.com.eventosbook.hibernate.util.ConnectionFactory;
import br.com.eventosbook.modelo.Email;

public class ConsultarValidaCadastroUsuarioPorEmail {
	

	private static ConsultarValidaCadastroUsuarioPorEmail aConsultarValidaCadastroUsuarioPorEmail = new ConsultarValidaCadastroUsuarioPorEmail();

	public static ConsultarValidaCadastroUsuarioPorEmail getInstance(){
		if(ConsultarValidaCadastroUsuarioPorEmail.aConsultarValidaCadastroUsuarioPorEmail == null){
			ConsultarValidaCadastroUsuarioPorEmail.aConsultarValidaCadastroUsuarioPorEmail = new ConsultarValidaCadastroUsuarioPorEmail();
		}

		return ConsultarValidaCadastroUsuarioPorEmail.aConsultarValidaCadastroUsuarioPorEmail;
	}
	
	
	public Email consultar(String pCodigoAtivacao, int pCodigoUsuario){
		
		Email retorno = new Email();
		
		try {
			Query q = ConnectionFactory.getInstace().getConnection().createNativeQuery(ConstantesSQL.QUERY_CONSULTAR_VALIDA_CADASTRO_POR_EMAIL, Email.class);
			
			q.setParameter(1, pCodigoAtivacao);
			q.setParameter(2, pCodigoUsuario);
		
		retorno = (Email) q.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return retorno;
		
	}

}
