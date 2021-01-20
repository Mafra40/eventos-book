package br.com.eventosbook.rn.consultas;

import javax.persistence.Query;

import br.com.eventosbook.constante.sql.ConstantesSQL;
import br.com.eventosbook.hibernate.util.ConnectionFactory;
import br.com.eventosbook.modelo.Fornecedor;
import br.com.eventosbook.modelo.Usuario;

public class ConsultarFornecedorPorUsuario {

	private ConsultarFornecedorPorUsuario() {}

	private static ConsultarFornecedorPorUsuario aConsultarFornecedorPorUsuario = new ConsultarFornecedorPorUsuario();

	public static ConsultarFornecedorPorUsuario getInstance(){
		if(ConsultarFornecedorPorUsuario.aConsultarFornecedorPorUsuario == null){
			ConsultarFornecedorPorUsuario.aConsultarFornecedorPorUsuario = new ConsultarFornecedorPorUsuario();
		}

		return ConsultarFornecedorPorUsuario.aConsultarFornecedorPorUsuario;
	}


	public Fornecedor consultar(Usuario pUsuario){
		Fornecedor retorno = new Fornecedor();

		try {
			Query q = ConnectionFactory.getInstace().getConnection().createNativeQuery(ConstantesSQL.QUERY_CONSULTAR_FORNECEDOR_POR_USUARIO, Fornecedor.class);

			q.setParameter(1, pUsuario.getCodigo());
			q.setParameter(2, pUsuario.getEmail());

			retorno = (Fornecedor) q.getSingleResult();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return retorno;
	}


}
