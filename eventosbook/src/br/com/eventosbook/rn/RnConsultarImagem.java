package br.com.eventosbook.rn;

import java.util.ArrayList;

import br.com.eventosbook.dao.impl.DaoImagemImpl;
import br.com.eventosbook.modelo.Imagem;

public class RnConsultarImagem {
	
	private RnConsultarImagem() {}

	private static RnConsultarImagem aRnConsultarImagem = new RnConsultarImagem();

	public static RnConsultarImagem getInstance(){
		if(RnConsultarImagem.aRnConsultarImagem == null){
			RnConsultarImagem.aRnConsultarImagem = new RnConsultarImagem();
		}

		return RnConsultarImagem.aRnConsultarImagem;
	}
	
	
	public ArrayList<Imagem> executar(Imagem pImagem){
		return (ArrayList<Imagem>) DaoImagemImpl.getInstance().consultar(pImagem);
	}
}
