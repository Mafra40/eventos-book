package br.com.eventosbook.rn;

import br.com.eventosbook.modelo.Fornecedor;
import br.com.eventosbook.modelo.Usuario;
import br.com.eventosbook.rn.consultas.ConsultarFornecedorPorUsuario;

public class RnConsultarFornecedorPorUsuario {
	
	private RnConsultarFornecedorPorUsuario() {}

	private static RnConsultarFornecedorPorUsuario aRnConsultarContratanePorUsuario = new RnConsultarFornecedorPorUsuario();

	public static RnConsultarFornecedorPorUsuario getInstance(){
		if(RnConsultarFornecedorPorUsuario.aRnConsultarContratanePorUsuario == null){
			RnConsultarFornecedorPorUsuario.aRnConsultarContratanePorUsuario = new RnConsultarFornecedorPorUsuario();
		}

		return RnConsultarFornecedorPorUsuario.aRnConsultarContratanePorUsuario;
	}
	
	public Fornecedor executar(Usuario pUsuario){
		return ConsultarFornecedorPorUsuario.getInstance().consultar(pUsuario);
	}

}
