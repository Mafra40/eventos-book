package br.com.eventosbook.rn;

import br.com.eventosbook.dao.impl.DaoImagemImpl;
import br.com.eventosbook.modelo.Imagem;

public class RnRemoverImagem {
	
	private RnRemoverImagem() {}

	private static RnRemoverImagem aRnRemoverImagem = new RnRemoverImagem();

	public static RnRemoverImagem getInstance(){
		if(RnRemoverImagem.aRnRemoverImagem == null){
			RnRemoverImagem.aRnRemoverImagem = new RnRemoverImagem();
		}

		return RnRemoverImagem.aRnRemoverImagem;
	}
	
	public String executar(Imagem pImagem){
		
		DaoImagemImpl.getInstance().excluir(pImagem);
		
		return "";
		
	}

}
