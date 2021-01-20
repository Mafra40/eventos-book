package br.com.eventosbook.fachada;

import br.com.eventosbook.modelo.Imagem;
import br.com.eventosbook.rn.RnAlterarImagem;
import br.com.eventosbook.rn.RnAlterarImagemPrincipal;
import br.com.eventosbook.rn.RnConsultarImagemPorObjeto;
import br.com.eventosbook.rn.RnIncluirImagem;
import br.com.eventosbook.rn.RnRemoverImagem;


/**Classe de serviço responsavel por todos os uploads. (IMAGEM e etc.)
 * Remoção e alteração de arquivos.
 * 
 * @author rodrigo.leite
 *
 */
public class UploadServico {

		
private UploadServico() {}
	
	private static UploadServico aUploadServico = new UploadServico();
	
	public static UploadServico getInstance(){
		if(UploadServico.aUploadServico == null){
			UploadServico.aUploadServico = new UploadServico();
		}
		
		return UploadServico.aUploadServico;
	}
	
	/**Incluir imagem e faz upload
	 * 
	 * @param pImagem
	 * @return
	 */
	public void IncluirImagem(Imagem pImagem){
		RnIncluirImagem.getInstance().execultar(pImagem);
	}
	
	/**Recupera a imagem.
	 * 
	 * @param pImagem
	 * @return
	 */
	public Imagem getImagem(Imagem pImagem){
		return RnConsultarImagemPorObjeto.getInstance().executar(pImagem);
	}
	
	/**Remove uma imagem do fornecedor.
	 * 
	 * @param pImagem
	 * @return
	 */
	public String removerImagem(Imagem pImagem){
		return RnRemoverImagem.getInstance().executar(pImagem);
	}
	
	
	/**Altera a imagem principal do fornecedor.
	 * 
	 * @param pImagem
	 */
	public void alteraImagemPrincipal(Imagem pImagem){
		 RnAlterarImagemPrincipal.getInstance().executar(pImagem);
		
	}
	
	/**Altera uma imagem.
	 * 
	 * @param pImagem
	 */
	public void alterarImagem(Imagem pImagem){
		RnAlterarImagem.getInstance().executar(pImagem);
	}
}
