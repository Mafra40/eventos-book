package br.com.eventosbook.fachada;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.eventosbook.excecao.ExcecaoUsuarioJaCadastrado;
import br.com.eventosbook.modelo.Categoria;
import br.com.eventosbook.modelo.Evento;
import br.com.eventosbook.modelo.Fornecedor;
import br.com.eventosbook.modelo.Usuario;
import br.com.eventosbook.pojo.FormularioFornecedor;
import br.com.eventosbook.rn.RnAdicionarAosMeusFornecedores;
import br.com.eventosbook.rn.RnAlterarFornecedor;
import br.com.eventosbook.rn.RnConsultarAvaliacaoComentFornecedor;
import br.com.eventosbook.rn.RnConsultarCategoria;
import br.com.eventosbook.rn.RnConsultarCategoriaFornecedor;
import br.com.eventosbook.rn.RnConsultarFornecedorPorObjeto;
import br.com.eventosbook.rn.RnConsultarFornecedorPorUsuario;
import br.com.eventosbook.rn.RnConsultarQtdAvaliacaoFornecedor;
import br.com.eventosbook.rn.RnIncluirFornecedor;
import br.com.eventosbook.rn.consultas.filtro.FiltroConsultarAvaliacaoComentFornecedor;
import br.com.eventosbook.rn.consultas.filtro.FiltroConsultarQtdAvaliacoesFornecedor;

public class FornecedorServico {
	

	private static FornecedorServico aFornecedorServico = new FornecedorServico();
	
	public static FornecedorServico getInstance(){
		if(FornecedorServico.aFornecedorServico == null){
			FornecedorServico.aFornecedorServico = new FornecedorServico();
		}
		
		return FornecedorServico.aFornecedorServico;
	}

	/**Incluir fornecedor.
	 * 
	 * @param pFormulario
	 * @return
	 * @throws ExcecaoUsuarioJaCadastrado
	 * @throws Exception
	 */
	public String incluirFornecedor(FormularioFornecedor pFormulario, HttpSession pSession)throws ExcecaoUsuarioJaCadastrado, Exception{
		return RnIncluirFornecedor.getInstance().executar(pFormulario, pSession);
	}
	
	public List<Categoria>listarCategoria(){
		
		return RnConsultarCategoriaFornecedor.getInstance().executar();
	}
	
	
	public Fornecedor ConsultarFornecedorPorObjeto(Fornecedor pFornecedor){
		return RnConsultarFornecedorPorObjeto.getInstance().executar(pFornecedor);
	}
	
	/**Consulta fornecedor pelo Usuário.
	 * 
	 * @param pUsuario
	 * @return
	 */
	public Fornecedor ConsultarFornecedorPorUsuario(Usuario pUsuario){
		return RnConsultarFornecedorPorUsuario.getInstance().executar(pUsuario);
	}
	
	/**Consultar todas as categorias de fornecedores.
	 * 
	 * @return
	 */
	public List<Categoria>consultarCategoria(){

		return RnConsultarCategoria.getInstance().executar();
	}
	
	/**Alterar um fornecedor
	 * 
	 * @param pFormulario
	 * @param pModel
	 * @param pSession
	 * @param pRedirectAttributes
	 * @return
	 */
	public String alterarFornecedor(FormularioFornecedor pFormulario, ModelMap pModel, HttpSession pSession , RedirectAttributes pRedirectAttributes){
		
		return RnAlterarFornecedor.getInstance().executar(pFormulario, pModel, pSession, pRedirectAttributes);
	}
	
	/**Adicionar 1 fornecedor aos meus fornecedores.
	 * 
	 * @param pFornecedor
	 * @param pEvento
	 * @return
	 */
	public void adicionarAosMeusFornecedores(Fornecedor pFornecedor , Evento pEvento){
		 RnAdicionarAosMeusFornecedores.getInstance().executar(pFornecedor, pEvento);
	}
	
	/**Consulta o todos os comentários referente ao fornecedor.
	 * 
	 * @param pFiltroConsultarComentarioFornecedor
	 * @return
	 */
	public List<FiltroConsultarAvaliacaoComentFornecedor> consultarAvaliacaoComentarioFornecedor(FiltroConsultarAvaliacaoComentFornecedor pFiltroConsultarComentarioFornecedor){
		return RnConsultarAvaliacaoComentFornecedor.getInstance().executar(pFiltroConsultarComentarioFornecedor);
	}
	
	
	/**Consulta a quantidade total de avaliações da cada fornecedor
	 * 
	 * @param pFiltroConsultarComentarioFornecedor
	 * @return
	 */
	public Integer consultarQtdAvaliacaoFornecedor(FiltroConsultarQtdAvaliacoesFornecedor pFiltroConsultarQtdAvaliacoesFornecedor){
		return RnConsultarQtdAvaliacaoFornecedor.getInstance().executar(pFiltroConsultarQtdAvaliacoesFornecedor);
	}
}
