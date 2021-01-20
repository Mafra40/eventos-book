package br.com.eventosbook.rn;

import javax.servlet.http.HttpSession;

import br.com.eventosbook.constante.Constantes;
import br.com.eventosbook.excecao.ExecaoUsuarioNaoEncontrado;
import br.com.eventosbook.modelo.Usuario;
import br.com.eventosbook.util.BibliotecaEmail;
import br.com.eventosbook.util.BibliotecaFuncao;
import br.com.eventosbook.util.BibliotecaUrl;

public class RnRecuperarContaUsuario {

	private static RnRecuperarContaUsuario aRnRecuperarContaUsuario = new RnRecuperarContaUsuario();

	public static RnRecuperarContaUsuario getInstance(){
		if(RnRecuperarContaUsuario.aRnRecuperarContaUsuario == null){
			RnRecuperarContaUsuario.aRnRecuperarContaUsuario = new RnRecuperarContaUsuario();
		}

		return RnRecuperarContaUsuario.aRnRecuperarContaUsuario;
	}

	public String executar(Usuario pUsuario, HttpSession pSession) throws ExecaoUsuarioNaoEncontrado, Exception{
		
		
		
		Usuario usuario = RnConsultarUsuarioPorObjeto.getInstance().executar(pUsuario);

		if(usuario == null){
			throw new ExecaoUsuarioNaoEncontrado();
		}

		String novaSenha = BibliotecaFuncao.gerarCodigoAlfaNumerico(Constantes.TAMANHO_SENHA_USUARIO);

		usuario.setSenha(BibliotecaFuncao.criptografarPalavra(novaSenha));

		RnAlterarUsuario.getInstance().executar(usuario);

		this.enviarEmail(pUsuario, novaSenha);
		pSession.setAttribute(Constantes.CONTEXTO_USUARIO_LOGADO, usuario);
		return "redirect:" + Constantes.LINK_ALTERACAO_SENHA;


		
	}


	private void enviarEmail(Usuario pUsuario, String novaSenha){
		BibliotecaEmail.getInstancia().processarEmailAlteracaoSenha(pUsuario, novaSenha);

	}


}
