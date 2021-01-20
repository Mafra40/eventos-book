package br.com.eventosbook.dao;

import java.util.List;

import br.com.eventosbook.modelo.MeuFornecedor;
/**Classe de interface DAO
 * 
 * @author rodrigo.leite
 *
 */
public interface DaoMeuFornecedor {
	
	public void incluir(MeuFornecedor pMeuFornecedor) throws Exception;
	public void alterar(MeuFornecedor pMeuFornecedor);
	public void excluir(MeuFornecedor pMeuFornecedor);
	public List<MeuFornecedor>consultar(MeuFornecedor pFiltroMeuFornecedor);
	public MeuFornecedor getMeuFornecedor(MeuFornecedor pMeuFornecedor);

}
