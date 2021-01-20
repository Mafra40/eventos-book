package br.com.eventosbook.rn;

import br.com.eventosbook.dao.impl.DaoImagemImpl;
import br.com.eventosbook.modelo.Imagem;

public class RnAlterarImagem {

	private static RnAlterarImagem aRnAlterarImagem = new RnAlterarImagem();

	public static RnAlterarImagem getInstance(){
		if(RnAlterarImagem.aRnAlterarImagem == null){
			RnAlterarImagem.aRnAlterarImagem = new RnAlterarImagem();
		}

		return RnAlterarImagem.aRnAlterarImagem;
	}

	public void executar (Imagem pImagem) {

		DaoImagemImpl.getInstance().alterar(pImagem);


	}


}
