package br.com.eventosbook.rn;

import java.util.ArrayList;
import java.util.List;

import br.com.eventosbook.constante.Constantes;
import br.com.eventosbook.fachada.ImagemServico;
import br.com.eventosbook.fachada.UploadServico;
import br.com.eventosbook.modelo.Imagem;

public class RnAlterarImagemPrincipal {

	private RnAlterarImagemPrincipal() {}

	private static RnAlterarImagemPrincipal aRnAlterarImagemPrincipal = new RnAlterarImagemPrincipal();

	public static RnAlterarImagemPrincipal getInstance(){
		if(RnAlterarImagemPrincipal.aRnAlterarImagemPrincipal == null){
			RnAlterarImagemPrincipal.aRnAlterarImagemPrincipal = new RnAlterarImagemPrincipal();
		}

		return RnAlterarImagemPrincipal.aRnAlterarImagemPrincipal;
	}
	
	
	public void executar (Imagem pImagem) {
		
		Imagem ImagemPrincipalAnterior = new Imagem();
		
		
		pImagem = UploadServico.getInstance().getImagem(pImagem);
		pImagem.setImagemPrincipal(Constantes.SIGLA_AFIRMACAO);
		
		ImagemPrincipalAnterior.setUsuario(pImagem.getUsuario());
		ImagemPrincipalAnterior.setImagemPrincipal(Constantes.SIGLA_AFIRMACAO);
		List<Imagem> arrImagem = new  ArrayList<Imagem>();
		arrImagem = ImagemServico.getInstance().consultarImagem(ImagemPrincipalAnterior);
		
		for (int i = 0; i < arrImagem.size(); i++) {
			arrImagem.get(i).setImagemPrincipal(Constantes.SIGLA_NEGACAO);
			UploadServico.getInstance().alterarImagem(arrImagem.get(i));
		}
		
		
		
		UploadServico.getInstance().alterarImagem(pImagem);

		
	}
	
}
