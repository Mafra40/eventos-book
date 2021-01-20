package br.com.eventosbook.rn;

import br.com.eventosbook.dao.impl.DaoImagemImpl;
import br.com.eventosbook.modelo.Imagem;

public class RnIncluirImagem {
	
	private RnIncluirImagem() {}

	private static RnIncluirImagem aRnIncluirImagem = new RnIncluirImagem();

	public static RnIncluirImagem getInstance(){
		if(RnIncluirImagem.aRnIncluirImagem == null){
			RnIncluirImagem.aRnIncluirImagem = new RnIncluirImagem();
		}

		return RnIncluirImagem.aRnIncluirImagem;
	}
	
	public void execultar(Imagem pImagem){
		DaoImagemImpl.getInstance().incluir(pImagem);
		
	}
}
