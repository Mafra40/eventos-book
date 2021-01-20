package br.com.eventosbook.fachada;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import br.com.eventosbook.dao.impl.DaoUsuarioImpl;
import br.com.eventosbook.excecao.ExcecaoPalavraPasseIncorreta;
import br.com.eventosbook.excecao.ExcecaoSenhasDiferentes;
import br.com.eventosbook.excecao.ExecaoUsuarioNaoEncontrado;
import br.com.eventosbook.modelo.Estado;
import br.com.eventosbook.modelo.Situacao;
import br.com.eventosbook.modelo.TipoUsuario;
import br.com.eventosbook.modelo.Usuario;
import br.com.eventosbook.rn.RnAlterarSenhaUsuario;
import br.com.eventosbook.rn.RnAlterarUsuario;
import br.com.eventosbook.rn.RnConsultarSituacaoPorObjeto;
import br.com.eventosbook.rn.RnConsultarTipoUsuarioPorObjeto;
import br.com.eventosbook.rn.RnIncluirEstado;
import br.com.eventosbook.rn.RnIncluirSituacao;
import br.com.eventosbook.rn.RnIncluirTipoUsuario;
import br.com.eventosbook.rn.RnIncluirUsuario;
import br.com.eventosbook.rn.RnRecuperarContaUsuario;
import br.com.eventosbook.rn.RnValidaAutenticacaoUsuarioPorEmail;
import br.com.eventosbook.rn.RnValidarUsuario;

public class UsuarioServico {
	
	private UsuarioServico() {}
	
	private static UsuarioServico aUsuarioServico = new UsuarioServico();
	
	public static UsuarioServico getInstance(){
		if(UsuarioServico.aUsuarioServico == null){
			UsuarioServico.aUsuarioServico = new UsuarioServico();
		}
		
		return UsuarioServico.aUsuarioServico;
	}
	
	public void incluirUsuario(Usuario pUsuario){
		RnIncluirUsuario.getInstance().executar(pUsuario);
	}
	
	public List<Usuario> consultarUsuarios(){
		return (ArrayList<Usuario>) DaoUsuarioImpl.getInstance().consultar();
	}
	
	public Usuario consultarUsuario(Usuario pUsuario){
		return DaoUsuarioImpl.getInstance().getUsuario(pUsuario);
	}
	
	public void incluirSituacaoUsuario(Situacao pSituacao){
		RnIncluirSituacao.getInstance().executar(pSituacao);
	}
	
	public Situacao consultarSituacaoUsuarioPorObjeto(Situacao pSituacao){
		return RnConsultarSituacaoPorObjeto.getInstance().executar(pSituacao);
	}

	public void incuirEstado(Estado pEstado) {
		RnIncluirEstado.getInstance().executar(pEstado);
		
	}

	public void incluirTipoUsuario(TipoUsuario pTipoUsuario) {
		RnIncluirTipoUsuario.getInstance().executar(pTipoUsuario);
		
	}
	
	public TipoUsuario consultarTipoUsuarioPorObjeto(TipoUsuario pTipoUsuario){
		return RnConsultarTipoUsuarioPorObjeto.getInstance().executar(pTipoUsuario);

	}
	
	public String validarUsuario(Usuario pUsuario, HttpSession pSession) throws ExecaoUsuarioNaoEncontrado{
		
		return RnValidarUsuario.getInstance().executar(pUsuario, pSession);
		
	}
	
	public String recuperarContaUsuario(Usuario pUsuario, HttpSession pSession) throws ExecaoUsuarioNaoEncontrado, Exception{
		return RnRecuperarContaUsuario.getInstance().executar(pUsuario, pSession);
		
	}
	
	public String alterarSenhaUsuario(Usuario pUsuario, HttpSession pSession) throws ExcecaoPalavraPasseIncorreta, ExcecaoSenhasDiferentes, Exception{
		
		return RnAlterarSenhaUsuario.getInstance().executar(pUsuario, pSession);
		
	}
	
	
	public String validarAutenticacaoPorEmail(String pCodigoAtivacao, int pCodigoUsuario, HttpSession pSession) throws Exception{
		return RnValidaAutenticacaoUsuarioPorEmail.getInstance().executar(pCodigoAtivacao, pCodigoUsuario, pSession);
		
	}
	
	
	public void alterarUsuario(Usuario pUsuario){
		 RnAlterarUsuario.getInstance().executar(pUsuario);
	}
}
