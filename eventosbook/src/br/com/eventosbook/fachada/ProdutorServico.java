package br.com.eventosbook.fachada;

import javax.servlet.http.HttpSession;

import br.com.eventosbook.pojo.FormularioFornecedor;
import br.com.eventosbook.rn.RnIncluirProdutor;

public class ProdutorServico {
private static ProdutorServico aProdutorServico = new ProdutorServico();
	
	public static ProdutorServico getInstance(){
		if(ProdutorServico.aProdutorServico == null){
			ProdutorServico.aProdutorServico = new ProdutorServico();
		}
		
		return ProdutorServico.aProdutorServico;
	}
	
	public String incluirProdutor(FormularioFornecedor pFormulario, HttpSession pSession){
		return RnIncluirProdutor.getInstance().executar(pFormulario, pSession);
	}

}
