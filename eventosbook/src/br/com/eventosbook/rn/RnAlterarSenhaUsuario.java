package br.com.eventosbook.rn;

import javax.servlet.http.HttpSession;

import br.com.eventosbook.constante.Constantes;
import br.com.eventosbook.excecao.ExcecaoContextoUsuarioInvalido;
import br.com.eventosbook.excecao.ExcecaoPalavraPasseIncorreta;
import br.com.eventosbook.excecao.ExcecaoSenhasDiferentes;
import br.com.eventosbook.modelo.Usuario;
import br.com.eventosbook.util.BibliotecaFuncao;
import br.com.eventosbook.util.BibliotecaUrl;
import br.com.eventosbook.util.BibliotecaValidacao;

public class RnAlterarSenhaUsuario {
	
private static RnAlterarSenhaUsuario aRnAlterarSenhaUsuario = new RnAlterarSenhaUsuario();
	
	public static RnAlterarSenhaUsuario getInstance(){
		if(RnAlterarSenhaUsuario.aRnAlterarSenhaUsuario == null){
			RnAlterarSenhaUsuario.aRnAlterarSenhaUsuario = new RnAlterarSenhaUsuario();
		}
		
		return RnAlterarSenhaUsuario.aRnAlterarSenhaUsuario;
	}
	
	
	public String executar(Usuario pUsuario, HttpSession pSession) throws ExcecaoPalavraPasseIncorreta, ExcecaoSenhasDiferentes, ExcecaoContextoUsuarioInvalido{
		
		BibliotecaValidacao.getInstance().validaContextoUsuario(pSession);
		
		String palavraPasse = BibliotecaFuncao.criptografarPalavra(pUsuario.getPalavraPasse());
		Usuario usuarioAserAlterado = (Usuario) pSession.getAttribute(Constantes.CONTEXTO_USUARIO_LOGADO);
		usuarioAserAlterado = RnConsultarUsuarioPorObjeto.getInstance().executar(usuarioAserAlterado);
		
		
		
		if(!palavraPasse.equals(usuarioAserAlterado.getSenha())){
			throw new ExcecaoPalavraPasseIncorreta(usuarioAserAlterado);
		}
		
		boolean isSenhaValida = BibliotecaValidacao.getInstance().validarSenha(pUsuario.getSenha(), pUsuario.getNovaSenha());
			
		if(isSenhaValida){
			usuarioAserAlterado.setNovaSenha(pUsuario.getNovaSenha());
			usuarioAserAlterado.setPalavraPasse(pUsuario.getPalavraPasse());
			usuarioAserAlterado.setSenha(BibliotecaFuncao.criptografarPalavra(pUsuario.getSenha()));
			RnAlterarUsuario.getInstance().executar(usuarioAserAlterado);
			
		} else {
			throw new ExcecaoSenhasDiferentes();
		}
		
		return  BibliotecaUrl.getInstance().getRedirect(Constantes.LINK_USUARIO_CONTROLADOR, Constantes.LINK_USUARIO_RECUPERADO_COM_SUCESSO);
		
	}

	
}
