package br.com.eventosbook.rn;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import br.com.eventosbook.constante.Constantes;
import br.com.eventosbook.dao.impl.DaoContratanteImpl;
import br.com.eventosbook.excecao.ExcecaoUsuarioJaCadastrado;
import br.com.eventosbook.modelo.Contratante;
import br.com.eventosbook.modelo.Endereco;
import br.com.eventosbook.modelo.Situacao;
import br.com.eventosbook.modelo.Telefone;
import br.com.eventosbook.modelo.TipoUsuario;
import br.com.eventosbook.modelo.Usuario;
import br.com.eventosbook.pojo.FormularioContratante;
import br.com.eventosbook.util.BibliotecaFuncao;
import br.com.eventosbook.util.BibliotecaUrl;


public class RnIncluirContratante {
	
	private static RnIncluirContratante aRnIncluirContratante = new RnIncluirContratante();
	
	public static RnIncluirContratante getInstance(){
		if(RnIncluirContratante.aRnIncluirContratante == null){
			RnIncluirContratante.aRnIncluirContratante = new RnIncluirContratante();
		}
		
		return RnIncluirContratante.aRnIncluirContratante;
	}
	
	public String executar(FormularioContratante pFormulario, HttpSession pSession) throws ExcecaoUsuarioJaCadastrado, Exception{
		
		if(!pFormulario.getSenha().equals(pFormulario.getConfirmSenha())){
			return BibliotecaUrl.getInstance().getRedirect(Constantes.LINK_USUARIO_CONTROLADOR, Constantes.LINK_CADASTRO_USUARIO_SEM_SUCESSO);
		}
		
		
			Contratante contratante = new Contratante();
			
			Usuario usuario = new Usuario();
			
			usuario.setEmail(pFormulario.getEmail());
			
			Usuario usuarioExiste = RnConsultarUsuarioPorObjeto.getInstance().executar(usuario);
			
			if(usuarioExiste !=null){
				throw new ExcecaoUsuarioJaCadastrado(usuarioExiste);
			}
			
			usuario.setSenha(BibliotecaFuncao.criptografarPalavra(pFormulario.getSenha()));
			
			TipoUsuario tpTipoUsuario = new TipoUsuario(Constantes.SIGLA_TIPO_USUARIO_CONTRATANTE);
			Situacao situacao = new Situacao(Constantes.SIGLA_SITUACAO_USUARIO_ATIVO.toString());
			
			tpTipoUsuario  = RnConsultarTipoUsuarioPorObjeto.getInstance().executar(tpTipoUsuario);
			situacao = RnConsultarSituacaoPorObjeto.getInstance().executar(situacao);
			
			usuario.setTipoUsuario(tpTipoUsuario);
			usuario.setSituacao(situacao);
			usuario.setDataCricacao(BibliotecaFuncao.getDataAtual());
			usuario.setDataUltimaAutenticacao(BibliotecaFuncao.getDataAtual());
			
			Endereco endereco = new Endereco();
			List<Endereco> listaEndereco = new ArrayList<Endereco>();
			listaEndereco.add(endereco);
			
			Telefone telefone = new Telefone();
			List<Telefone> listaTelefone= new ArrayList<Telefone>();
			listaTelefone.add(telefone);
			
			usuario.setColecaoEndereco(listaEndereco);
			usuario.setColecaoTelefone(listaTelefone);
			
			contratante.setUsuario(usuario);
			contratante.setNome(pFormulario.getNome());
						
			DaoContratanteImpl.getInstance().incluir(contratante);
			//FIXME REMOVER BARRA DE COMENTARIO!!! MASSA DE TESTE
			//RnProcessarEmailCadastro.getInstance().executar(usuario);
			
			return RnValidarUsuarioNoCadastro.getInstance().executar(usuario, pSession);
		
		
		
	}


}
