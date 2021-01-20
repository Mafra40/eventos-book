package br.com.eventosbook.rn.consultas;

import javax.persistence.Query;

import br.com.eventosbook.constante.sql.ConstantesSQL;
import br.com.eventosbook.hibernate.util.ConnectionFactory;
import br.com.eventosbook.modelo.Contratante;
import br.com.eventosbook.modelo.Usuario;

public class ConsultarContratantePorUsuario {

	private ConsultarContratantePorUsuario() {}

	private static ConsultarContratantePorUsuario aConsultarContratanePorUsuario = new ConsultarContratantePorUsuario();

	public static ConsultarContratantePorUsuario getInstance(){
		if(ConsultarContratantePorUsuario.aConsultarContratanePorUsuario == null){
			ConsultarContratantePorUsuario.aConsultarContratanePorUsuario = new ConsultarContratantePorUsuario();
		}

		return ConsultarContratantePorUsuario.aConsultarContratanePorUsuario;
	}


	public Contratante consultar(Usuario pUsuario){

		Contratante retorno = new Contratante();

		try {

			Query q = ConnectionFactory.getInstace().getConnection().createNativeQuery(ConstantesSQL.QUERY_CONSULTAR_CONTRATANTE_POR_USUARIO, Contratante.class);

			q.setParameter(1, pUsuario.getCodigo());
			q.setParameter(2, pUsuario.getEmail());


			retorno = (Contratante) q.getSingleResult();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return retorno;

	}


}
