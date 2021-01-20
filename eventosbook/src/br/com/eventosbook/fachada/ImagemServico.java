package br.com.eventosbook.fachada;

import java.util.ArrayList;

import br.com.eventosbook.modelo.Imagem;
import br.com.eventosbook.rn.RnConsultarImagem;
import br.com.eventosbook.rn.RnConsultarImagemPrincipalPorFornecedor;

public class ImagemServico {
	
	
private static ImagemServico aImagemServico = new ImagemServico();
	
	public static ImagemServico getInstance(){
		if(ImagemServico.aImagemServico == null){
			ImagemServico.aImagemServico = new ImagemServico();
		}
		
		return ImagemServico.aImagemServico;
	}
	
	
	/**
	 * 
	 * @param pImagem
	 * @return
	 */
	public ArrayList<Imagem>consultarImagem(Imagem pImagem){

		return RnConsultarImagem.getInstance().executar(pImagem);
	}
	
	
	/**
	 * 
	 * @param pImagem
	 * @return
	 */
	public Imagem consultarImagemPrincipalPorFornecedor(Imagem pImagem){
		return RnConsultarImagemPrincipalPorFornecedor.getInstance().executar(pImagem);
		
	}
}
