package br.com.eventosbook.util;

import javax.mail.internet.AddressException;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

import br.com.eventosbook.constante.Constantes;
import br.com.eventosbook.modelo.Contratante;
import br.com.eventosbook.modelo.Fornecedor;
import br.com.eventosbook.modelo.Usuario;

/**Class Responsavel pelos envios de BibliotecaEmail.
 * 
 * @author Mafra
 *
 */
public class BibliotecaEmail {
	/*Configuração*/
	private static final String HOST = Constantes.EMAIL_HOST;
	private static final int PORTA = Constantes.EMAIL_PORTA; ; 
	private static final String REMETENTE = Constantes.EMAIL_REMETENTE;
	private static final String SENHA =  Constantes.EMAIL_SENHA;
	private static final Boolean SSL = Constantes.EMAIL_SSL;
	private static final Boolean DEBUG = Constantes.EMAIL_DEBUG; 


	/*constantes locais*/
	public static final String DESTINATARIO = "";
	public static final String SERVIDOR_LOCAL = "";


	public static final String MSG_CONFIRMACAO = "Bem vindo ao eventosbook! Clique no link abaixo para confirmar o seu email e finalizar o cadastro.";
	public static final String MSG_ALTERACAO_SENHA = "Alteração de senha efetuada com sucesso.";
	public static final String MSG_SOLICITACAO_ORCAMENTO = "Alteração de senha efetuada com sucesso.";

	private static BibliotecaEmail aEmail = new BibliotecaEmail();

	public static BibliotecaEmail getInstancia() {
		if (BibliotecaEmail.aEmail == null) {
			BibliotecaEmail.aEmail = new BibliotecaEmail();
		}

		return BibliotecaEmail.aEmail;
	}

	/**
	 *
	 * @param pDestinatario
	 * @param pRemetente
	 * @param pAssunto
	 * @param pMensagem
	 */
	public String processarEmailConfirmacao(Usuario pUsuario) throws Exception {
		String retorno = null;
		try {


			HtmlEmail email = new HtmlEmail();
			String htmlMsg = "";
			String codigoAtivacao = "?cdAtv=";
			String idUsuario = "&idU=";
			String urlCompleta = "";
			String assunto = "Confirmação de Cadastro - Eventosbook";
			String codigo = BibliotecaFuncao.gerarCodigoAlfaNumerico(20);
			
			codigoAtivacao += codigo;
			idUsuario += pUsuario.getCodigo(); 
			urlCompleta = Constantes.URL_CAMINHO_ABSOLUTO + Constantes.LINK_EMAIL_CONFIRMACAO + codigoAtivacao + idUsuario;
			urlCompleta = urlCompleta.trim();
			htmlMsg = "<html> <meta http-equiv='Content-Type' content='text/html;charset=ISO-8859-1'> <meta charset='UTF-8'><body> <p>Olá,"+ pUsuario.getEmail() +"</p>"
					+"<p> "+ MSG_CONFIRMACAO + "</p> <br/> <span><a href='"+ urlCompleta +"'>"+ urlCompleta +"</a></span><body></html>";

			email.setHostName(HOST);
			email.setSmtpPort(PORTA);
			email.setDebug(DEBUG);
			email.setAuthentication(REMETENTE, SENHA);
			email.setSSLOnConnect(SSL);
			email.setFrom(REMETENTE); //remetente
			email.setSubject(assunto);
			email.setHtmlMsg(htmlMsg);
			email.addTo(pUsuario.getEmail()); //destinatário
			email.send();
	
			retorno = codigo;

		} catch (EmailException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return retorno;

	}

	/**Email de alteração de senha.
	 * 
	 * @param pUsuario
	 * @param pSenhaDescriptada a senha não deve ser criptrografada, por que ela vai se mostrada ao usuário.
	 */
	public void processarEmailAlteracaoSenha(Usuario pUsuario, String pSenhaDescriptada) {
		try {
			HtmlEmail email = new HtmlEmail();
			String htmlMsg = "";
			String assunto = "Alteração de senha - Eventosbook";

			htmlMsg = "<html>"
					+ "<meta http-equiv='Content-Type' content='text/html;charset=ISO-8859-1'>"
					+ "<meta charset='UTF-8'>"
					+ "<body>"
					+ "<p>Olá,"+ pUsuario.getEmail() +"</p>"
					+ "<p> "+ MSG_ALTERACAO_SENHA + "</p>"
					+ "<p>Palavra Passe: <strong>"+ pSenhaDescriptada +"</strong> </p>"
					+ "<br/>"
					+ ""
					+ "<body>"
					+ "</html>";


			email.setHostName(HOST);
			email.setSmtpPort(PORTA);
			email.setDebug(DEBUG);
			email.setAuthentication(REMETENTE, SENHA);
			email.setSSLOnConnect(SSL);
			email.setFrom(REMETENTE); //remetente
			email.setSubject(assunto);
			email.setHtmlMsg(htmlMsg);
			email.addTo(pUsuario.getEmail()); //destinatário
			email.send();

		} catch (EmailException e) {
			System.out.print(e);
		}

	}
	/**Não se deve usar este método.
	 * @deprecated
	 * @param pContratante
	 * @param pFornecedor
	 */
	public void processarEmailSolicitacaoOrcamento(Contratante pContratante, Fornecedor pFornecedor ) {
		HtmlEmail email = new HtmlEmail();
		String htmlMsg = "";
		String assunto = "Solicitação de Orçamento - Eventosbook";
		try {
			htmlMsg = "<html>"
					+ "<meta http-equiv='Content-Type' content='text/html;charset=ISO-8859-1'>"
					+ "<meta charset='UTF-8'>"
					+ "<body>"
					+ "<p>Olá,"+ pFornecedor.getNome() +"</p>"
					+ "<p>O Contratante <strong>" + pContratante.getNome() +"</strong> está solicitando um orçamento com você, não perca tempo!</p>"
					+ "<p>ID Solicitação: </p>"
					+ "<p>Telefone:  </p>"
					+ "<br/>"
					+ ""
					+ "<body>"
					+ "</html>";


			email.setHostName(HOST);
			email.setSmtpPort(PORTA);
			email.setDebug(DEBUG);
			email.setAuthentication(REMETENTE, SENHA);
			email.setSSLOnConnect(SSL);
			email.setFrom(REMETENTE); //remetente
			email.setSubject(assunto);
			email.setHtmlMsg(htmlMsg);
			email.addTo(pFornecedor.getUsuario().getEmail()); //destinatário
			email.send();

		} catch (EmailException e) {
			System.out.print(e);
		}

	}


	/**Método genérico para envios de email.
	 * 
	 * @param pHtmlMsg O conteúdo da mensagem devem conter tags html
	 * @param pEmailDestinatario
	 * @param pAssunto
	 */
	public void processarEmail(String pHtmlMsg, String pEmailDestinatario , String pAssunto) {
		try {
			HtmlEmail email = new HtmlEmail();


			if (pHtmlMsg != null && pEmailDestinatario != null && pAssunto!= null){

				email.setHostName(HOST);
				email.setSmtpPort(PORTA);
				email.setDebug(DEBUG);
				email.setAuthentication(REMETENTE, SENHA);
				email.setSSLOnConnect(SSL);
				email.setFrom(REMETENTE);
				email.setSubject(pAssunto);
				email.setHtmlMsg(pHtmlMsg);
				email.addTo(pEmailDestinatario);
				email.send();

			}

		} catch (EmailException e) {
			System.out.print(e);
		}catch (Exception e){
			System.out.print(e);
		}

	}

	public static void main(String[] args) throws EmailException, AddressException {

		BibliotecaEmail.getInstancia().processarEmail(null,null,null);
		BibliotecaEmail.getInstancia().processarEmail("OLá Aqui é um teste! ÇaCou ? @#1", "rodrigojmafra@gmail.com", "E-mail de teste çolado!");


	}

}
