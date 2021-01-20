package br.com.eventosbook.rn;

import br.com.eventosbook.dao.impl.DaoImagemImpl;
import br.com.eventosbook.modelo.Imagem;

public class RnConsultarImagemPorObjeto {
	
	private RnConsultarImagemPorObjeto() {}

	private static RnConsultarImagemPorObjeto aRnConsultarImagemPorObjeto = new RnConsultarImagemPorObjeto();

	public static RnConsultarImagemPorObjeto getInstance(){
		if(RnConsultarImagemPorObjeto.aRnConsultarImagemPorObjeto == null){
			RnConsultarImagemPorObjeto.aRnConsultarImagemPorObjeto = new RnConsultarImagemPorObjeto();
		}

		return RnConsultarImagemPorObjeto.aRnConsultarImagemPorObjeto;
	}
	
	
	public Imagem executar(Imagem pImagem){
		return DaoImagemImpl.getInstance().getImagem(pImagem);
	}

}
