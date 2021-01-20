package br.com.eventosbook.rn;

import javax.servlet.http.HttpSession;

import br.com.eventosbook.constante.Constantes;
import br.com.eventosbook.excecao.ExecaoUsuarioNaoEncontrado;
import br.com.eventosbook.modelo.Usuario;

public class RnValidarUsuarioNoCadastro {
	
private static RnValidarUsuarioNoCadastro aRnValidarUsuario = new RnValidarUsuarioNoCadastro();
	
	public static RnValidarUsuarioNoCadastro getInstance(){
		if(RnValidarUsuarioNoCadastro.aRnValidarUsuario == null){
			RnValidarUsuarioNoCadastro.aRnValidarUsuario = new RnValidarUsuarioNoCadastro();
		}
		
		return RnValidarUsuarioNoCadastro.aRnValidarUsuario;
	}
	
	public String executar(Usuario pUsuario, HttpSession pSession) throws ExecaoUsuarioNaoEncontrado{
		
		return "redirect:"+Constantes.LINK_USUARIO_CADASTRADO;
	}

}
