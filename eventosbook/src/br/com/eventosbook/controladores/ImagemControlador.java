package br.com.eventosbook.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.eventosbook.constante.Constantes;
import br.com.eventosbook.fachada.UploadServico;
import br.com.eventosbook.modelo.Imagem;
import br.com.eventosbook.util.BibliotecaUrl;

@Controller
@RequestMapping(Constantes.LINK_IMAGEM_CONTROLADOR)
public class ImagemControlador {
	
	public static final String NM_PARAM_ID_IMAGEM = "cdImagem";
	
	 
	 /**Efetua o procesamento de por uma imagem principal.
	  * 
	  * @param cdImagem
	  * @return
	  */
	 @RequestMapping(value="/"+Constantes.LINK_EFETUAR_IMAGEM_PRINCIPAL, method = RequestMethod.GET)
	 public String processarImagemPrincipal(@RequestParam(NM_PARAM_ID_IMAGEM) String cdImagem){
		 
		 Imagem imagem = new Imagem();
		 imagem.setCodigo(Integer.valueOf(cdImagem));
		 UploadServico.getInstance().alteraImagemPrincipal(imagem);
		 
		 return BibliotecaUrl.getInstance().getRedirect(Constantes.LINK_FORNECEDOR_CONTROLADOR, Constantes.LINK_FORNECEDOR_GALERIA_IMAGENS);
		 
	 }

}