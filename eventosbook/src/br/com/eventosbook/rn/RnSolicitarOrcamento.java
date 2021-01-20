package br.com.eventosbook.rn;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.eventosbook.constante.ConstantesMsgSistema;
import br.com.eventosbook.dao.impl.DaoOrcamentoImpl;
import br.com.eventosbook.modelo.Evento;
import br.com.eventosbook.modelo.Fornecedor;
import br.com.eventosbook.modelo.Orcamento;
import br.com.eventosbook.util.BibliotecaEmail;
import br.com.eventosbook.util.BibliotecaFuncao;

/**Classe que representa regra de negócio de solicitação de orçamento do contratante e o fornecedor.
 * 
 * @author Mafra
 *
 */
public class RnSolicitarOrcamento {
	
	private RnSolicitarOrcamento() {}

	private static RnSolicitarOrcamento aRnSolicitarOrcamento = new RnSolicitarOrcamento();

	public static RnSolicitarOrcamento getInstance(){
		if(RnSolicitarOrcamento.aRnSolicitarOrcamento == null){
			RnSolicitarOrcamento.aRnSolicitarOrcamento = new RnSolicitarOrcamento();
		}

		return RnSolicitarOrcamento.aRnSolicitarOrcamento;
	}
	
	
	public void executar(Evento pEvento, Fornecedor pFornecedor , RedirectAttributes pRedirectAttributes){
		String htmlMsg = "";
		String assuntoMsg = "Eventosbook - Solicitação de Orçamento ";
		String cdOrcamento = "";

		Orcamento contraFornecedor = new Orcamento();
		contraFornecedor.setEvento(pEvento);
		contraFornecedor.setFornecedor(pFornecedor);
		
		if(DaoOrcamentoImpl.getInstance().getContratanteFornecedor(contraFornecedor) == null){

			contraFornecedor.setDataHora(BibliotecaFuncao.getDataHoraAtual());

			try {
				DaoOrcamentoImpl.getInstance().incluir(contraFornecedor);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			cdOrcamento = contraFornecedor.getCodigo().toString();

			htmlMsg = "<html>"
					+ "<meta http-equiv='Content-Type' content='text/html;charset=ISO-8859-1'>"
					+ "<meta charset='UTF-8'>"
					+ "<body>"
					+ "<p>Olá, "+ pFornecedor.getNome() +"</p>"
					+ "<p>O Contratante <strong>" + pEvento.getContratante().getNome() +"</strong> está solicitando um orçamento com você, não perca tempo!</p>"
					+ "<p>Código da Solicitação: "+ cdOrcamento+" </p>"
					+ "<p>E-mail do solicitante: <a href='mailto:"+pEvento.getContratante().getUsuario().getEmail()+"'><strong>"+ pEvento.getContratante().getUsuario().getEmail() +"</strong></a></p>"
					+ "<br/>"
					+ ""
					+ "<body>"
					+ "</html>";

			assuntoMsg += cdOrcamento;

			BibliotecaEmail.getInstancia().processarEmail(htmlMsg, pFornecedor.getUsuario().getEmail(), assuntoMsg);
			
			pRedirectAttributes.addFlashAttribute("msg", ConstantesMsgSistema.MSG_TELA_ORCAMENTO_01);
			

		}else {
			pRedirectAttributes.addFlashAttribute("msg", "<div class='alert alert-danger alert-dismissable'> <button type='button' class='close' data-dismiss='alert' aria-hidden='true'></button><strong> Fornecedor já incluso na lista de meus orçamentos </strong></div>");
		}
		
		
	}

}
