package br.com.eventosbook.fachada;

import java.util.List;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.eventosbook.modelo.Orcamento;
import br.com.eventosbook.modelo.Evento;
import br.com.eventosbook.modelo.Fornecedor;
import br.com.eventosbook.rn.RnConsultarOrcamentosPorContratante;
import br.com.eventosbook.rn.RnSolicitarOrcamento;
/**Classe respovel pelos serviços em relação ao Contratante e Fornecedor.
 * 
 * @author Mafra
 *
 */
public class OrcamentoServico {
	
private OrcamentoServico() {}
	
	private static OrcamentoServico aContratanteFornecedorServico = new OrcamentoServico();
	
	public static OrcamentoServico getInstance(){
		if(OrcamentoServico.aContratanteFornecedorServico == null){
			OrcamentoServico.aContratanteFornecedorServico = new OrcamentoServico();
		}
		
		return OrcamentoServico.aContratanteFornecedorServico;
	}
	
	
	/**Insere um orçamento em relação ao fornecedor.
	 * 
	 * @param pContratante
	 * @param pFornecedor
	 */
	public void solicitarOrcamento(Evento pEvento, Fornecedor pFornecedor , RedirectAttributes pRedirectAttributes){
		RnSolicitarOrcamento.getInstance().executar(pEvento, pFornecedor , pRedirectAttributes);
	}
	
	
	/**Consulta Orçamentos de um contratante.
	 * 
	 * @param pContratante
	 * @param pFornecedor
	 */
	public  List<Orcamento> consultarOrcamentosPorContratante(Orcamento pOrcamento){
		return RnConsultarOrcamentosPorContratante.getInstance().executar(pOrcamento);
	}

}
