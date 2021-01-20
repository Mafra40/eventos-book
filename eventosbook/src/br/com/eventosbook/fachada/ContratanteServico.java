package br.com.eventosbook.fachada;

import java.util.List;

import javax.persistence.NoResultException;
import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.eventosbook.dao.impl.DaoEventoImpl;
import br.com.eventosbook.excecao.ExcecaoUsuarioNaoEncontrado;
import br.com.eventosbook.modelo.CheckList;
import br.com.eventosbook.modelo.Contratante;
import br.com.eventosbook.modelo.Evento;
import br.com.eventosbook.modelo.Fornecedor;
import br.com.eventosbook.modelo.MeuFornecedor;
import br.com.eventosbook.modelo.TipoEvento;
import br.com.eventosbook.modelo.Usuario;
import br.com.eventosbook.pojo.Formulario;
import br.com.eventosbook.pojo.FormularioContratante;
import br.com.eventosbook.rn.RnAlterarCheckList;
import br.com.eventosbook.rn.RnAlterarContratante;
import br.com.eventosbook.rn.RnAlterarEvento;
import br.com.eventosbook.rn.RnAvaliarFornecedor;
import br.com.eventosbook.rn.RnConsultarContratantePorObjeto;
import br.com.eventosbook.rn.RnConsultarContratantePorUsuario;
import br.com.eventosbook.rn.RnConsultarEvento;
import br.com.eventosbook.rn.RnConsultarEventoPorContratante;
import br.com.eventosbook.rn.RnConsultarFornecedor;
import br.com.eventosbook.rn.RnConsultarFornecedorPorItem;
import br.com.eventosbook.rn.RnConsultarItemCheckListPorEvento;
import br.com.eventosbook.rn.RnConsultarMeuFornecedorPorContratante;
import br.com.eventosbook.rn.RnConsultarMeuFornecedorPorObjeto;
import br.com.eventosbook.rn.RnConsultarTipoEvento;
import br.com.eventosbook.rn.RnDetalharEvento;
import br.com.eventosbook.rn.RnIncluirContratante;
import br.com.eventosbook.rn.RnIncluirEvento;
import br.com.eventosbook.rn.RnRemoverEvento;
import br.com.eventosbook.rn.consultas.filtro.FiltroConsultarFornecedor;
import br.com.eventosbook.rn.consultas.filtro.FiltroConsultarMeuFornecedorPorContratante;

public class ContratanteServico {
	
	private ContratanteServico() {}
	
	private static ContratanteServico aContratanteServico = new ContratanteServico();
	
	public static ContratanteServico getInstance(){
		if(ContratanteServico.aContratanteServico == null){
			ContratanteServico.aContratanteServico = new ContratanteServico();
		}
		
		return ContratanteServico.aContratanteServico;
	}
	
	/**Incluir contratante
	 * 
	 * @param pFormulario
	 * @return
	 * @throws ExcecaoUsuarioNaoEncontrado
	 * @throws Exception
	 */
	public String incluirContratante(FormularioContratante pFormulario, HttpSession pSession) throws ExcecaoUsuarioNaoEncontrado, Exception{
		return RnIncluirContratante.getInstance().executar(pFormulario, pSession);
	}
	
	/**Alterar
	 * 
	 * @param pFormulario
	 * @param pModel
	 * @param pSession
	 * @param pRedirectAttributes
	 * @return
	 * @throws Exception
	 */
	public String alterarContratante(FormularioContratante pFormulario, ModelMap pModel, HttpSession pSession , RedirectAttributes pRedirectAttributes) throws Exception{
		return RnAlterarContratante.getInstance().executar(pFormulario, pModel, pSession, pRedirectAttributes);
	}
	
	/**Consulta
	 * 
	 * @param pContratante
	 * @return
	 */
	public Contratante consultarContratantePorObjeto(Contratante pContratante){
		return RnConsultarContratantePorObjeto.getInstance().executar(pContratante);
	}
	
	/**Pesquisa o contratante pelo usuario.
	 * 
	 * @param pUsuario
	 * @return
	 */
	public Contratante consultarContratantePorUsuario(Usuario pUsuario){
		return RnConsultarContratantePorUsuario.getInstance().executar(pUsuario);
	}


	public List<TipoEvento> consultarTipoEvento() {
		return RnConsultarTipoEvento.getInstance().executar();
	}
	
	public String incluirEvento(Formulario pFormulario, HttpSession pSession){
		return RnIncluirEvento.getInstance().executar(pFormulario, pSession);
	}
	
	/**Consulta uma lista de eventos pertecente ao contratante pEvento.contratante
	 * 
	 * @param pEvento
	 * @return
	 */
	public List<Evento> consultarEvento(Evento pEvento){
		return RnConsultarEvento.getInstance().executar(pEvento);
	}
	
	public List<Evento> consultarEventoPorContratante(HttpSession pHttpSession){
		return RnConsultarEventoPorContratante.getInstance().executar(pHttpSession);
	}
	
	public Evento cosultarEventoPorObjeto(Evento pEvento){
		return DaoEventoImpl.getInstance().getEvento(pEvento);
	}
	
	public Evento detalharEvento(int id, HttpSession pSession) throws NoResultException, Exception{
		return RnDetalharEvento.getInstance().executar(id, pSession);
	}
	
	public String alterarEvento(Formulario pFormulario, HttpSession pSession) throws Exception{
		return RnAlterarEvento.getInstance().executar(pFormulario, pSession);
	}
	
	public String removerEvento(int id, HttpSession pSession){
		return RnRemoverEvento.getInstance().executar(id, pSession);
	}
	
	public List<CheckList> consultarItemCheckListPorEvento(int id, HttpSession pSession){
		return RnConsultarItemCheckListPorEvento.getInstance().executar(id, pSession);
	}
	
	public List<Fornecedor> consultarFornecedorPorItem(Integer idCategoria, Integer idSubCategoria, HttpSession pSession){
		return RnConsultarFornecedorPorItem.getInstance().executar(idCategoria, idSubCategoria, pSession);
	}

	public String marcarDesmarcarItemChecklist(Integer id){
		return RnAlterarCheckList.getInstance().executar(id);	
	}
	
	public MeuFornecedor consultarMeusFornecedoresPorObjeto(Integer id){
		return RnConsultarMeuFornecedorPorObjeto.getInstance().executar(id);
	}
	
	public ModelAndView avaliarFornecedor(Formulario pFormulario){
		return RnAvaliarFornecedor.getInstance().executar(pFormulario);
	}
	
	
	/**Método que retorn uma lista de meus fornecedores passando filtro como paramentro.
	 * 
	 * @param pFiltroConsultarMeuFornecedorPorContratante
	 * @return
	 */
	public List<MeuFornecedor> consultarMeuFornecedorPorContratante(FiltroConsultarMeuFornecedorPorContratante pFiltroConsultarMeuFornecedorPorContratante){
		return RnConsultarMeuFornecedorPorContratante.getInstance().executar(pFiltroConsultarMeuFornecedorPorContratante);
		
	}

	
	/**Método que retorna uma lista de fornecedores filtrados.
	 * 
	 * @param pFiltro
	 * @return
	 */
	public List<FiltroConsultarFornecedor> consultarFornecedor(FiltroConsultarFornecedor pFiltro){
		return RnConsultarFornecedor.getInstance().executar(pFiltro);
	}
}
