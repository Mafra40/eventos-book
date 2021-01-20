package br.com.eventosbook.rn.consultas;

import br.com.eventosbook.modelo.Situacao;

public class ConsultaSituacao {
	
	private ConsultaSituacao() {}
	
	private static ConsultaSituacao aConsultaSituacao = new ConsultaSituacao();
	
	public ConsultaSituacao getInstance(){
		if(ConsultaSituacao.aConsultaSituacao == null){
			ConsultaSituacao.aConsultaSituacao = new ConsultaSituacao();
		}
		
		return ConsultaSituacao.aConsultaSituacao;
	}
	
	
	public Situacao consultar(){
		return null;
	}

}
