package br.com.eventosbook.rn;

import java.util.List;

import br.com.eventosbook.dao.impl.DaoCidadeImpl;
import br.com.eventosbook.modelo.Cidade;

public class RnConsultarCidade {
	
	private RnConsultarCidade() {}

	private static RnConsultarCidade aRnConsultarCidade = new RnConsultarCidade();

	public static RnConsultarCidade getInstance(){
		if(RnConsultarCidade.aRnConsultarCidade == null){
			RnConsultarCidade.aRnConsultarCidade = new RnConsultarCidade();
		}

		return RnConsultarCidade.aRnConsultarCidade;
	}
	
	
	public List<Cidade> executar(){
		return DaoCidadeImpl.getInstance().consultar();
	}
}
