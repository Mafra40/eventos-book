package br.com.eventosbook.rn;

import br.com.eventosbook.dao.impl.DaoImagemImpl;
import br.com.eventosbook.modelo.Imagem;


/**RN que implementa a consulta de imagem principal de cada fornecedor.
 * 
 * @author rodrigo.leite
 *
 */
public class RnConsultarImagemPrincipalPorFornecedor {
	
private static RnConsultarImagemPrincipalPorFornecedor aRnConsultarImagemPrincipalPorFornecedor = new RnConsultarImagemPrincipalPorFornecedor();
	
	public static RnConsultarImagemPrincipalPorFornecedor getInstance(){
		if(RnConsultarImagemPrincipalPorFornecedor.aRnConsultarImagemPrincipalPorFornecedor == null){
			RnConsultarImagemPrincipalPorFornecedor.aRnConsultarImagemPrincipalPorFornecedor = new RnConsultarImagemPrincipalPorFornecedor();
		}
		
		return RnConsultarImagemPrincipalPorFornecedor.aRnConsultarImagemPrincipalPorFornecedor;
	}
	
	
	/**
	 * 
	 * @param pImagem
	 * @return
	 */
	public Imagem executar(Imagem pImagem){
		return	DaoImagemImpl.getInstance().getImagem(pImagem);
		
		 
	}

}
