package br.com.eventosbook.rn.consultas;

import javax.persistence.TypedQuery;

import br.com.eventosbook.constante.Constantes;
import br.com.eventosbook.hibernate.util.ConnectionFactory;
import br.com.eventosbook.modelo.Contratante;


public class ConsultarContratante {
	

	private ConsultarContratante() {}
	
	private static ConsultarContratante aConsultarContratantePorUsuario = new ConsultarContratante();
	
	public static ConsultarContratante getInstance(){
		if(ConsultarContratante.aConsultarContratantePorUsuario == null){
			ConsultarContratante.aConsultarContratantePorUsuario = new ConsultarContratante();
		}
		
		return ConsultarContratante.aConsultarContratantePorUsuario;
	}
	
	public Contratante consultar (Contratante pContratante){
		Contratante retorno = new  Contratante();
		
		String sql = "FROM " + Constantes.PATH_PROJECT + ".modelo.Contratante";
		
		TypedQuery<Contratante> q = ConnectionFactory.getInstace().getConnection().createQuery(sql, Contratante.class);
		retorno = q.getSingleResult();
		
		return retorno;
	}

}
