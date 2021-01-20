package br.com.eventosbook.rn;

import br.com.eventosbook.dao.impl.DaoMeuFornecedorImpl;
import br.com.eventosbook.modelo.Evento;
import br.com.eventosbook.modelo.Fornecedor;
import br.com.eventosbook.modelo.MeuFornecedor;
import br.com.eventosbook.util.BibliotecaFuncao;


/**Classe que representa regra de negócio de addicionar o fornecerdor ao meus fornecedores do contratante.
 * 
 * @author rodrigo.leite
 *
 */
public class RnAdicionarAosMeusFornecedores {
	
private static RnAdicionarAosMeusFornecedores aRnAdicionarAosMeusFornecedores = new RnAdicionarAosMeusFornecedores();
	
	public static RnAdicionarAosMeusFornecedores getInstance(){
		if(RnAdicionarAosMeusFornecedores.aRnAdicionarAosMeusFornecedores == null){
			RnAdicionarAosMeusFornecedores.aRnAdicionarAosMeusFornecedores = new RnAdicionarAosMeusFornecedores();
		}
		
		return RnAdicionarAosMeusFornecedores.aRnAdicionarAosMeusFornecedores;
	}
	
	/**
	 * 
	 * @param pFornecedor
	 * @param pEvento
	 * @return
	 */
	public void executar(Fornecedor pFornecedor , Evento pEvento){
		

		MeuFornecedor mFornecedor = new MeuFornecedor();
		mFornecedor.setFornecedor(pFornecedor);
		mFornecedor.setEvento(pEvento);
		mFornecedor.setDataInclusao(BibliotecaFuncao.getDataHoraAtual());
		
		//TODO IMPEDIR QUE O MESMO FORNECEDOR SEJA INCLUIDO 2 VEZES PARA O MESMO EVENTO.
		
		try {
			DaoMeuFornecedorImpl.getInstance().incluir(mFornecedor);
		} catch (Exception e) {
			//TODO NECESSITA DE CLASSE DE EXCEÇÃO
			e.printStackTrace();
		}
		
	}

}
