package br.com.eventosbook.rn;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import br.com.eventosbook.constante.Constantes;
import br.com.eventosbook.dao.impl.DaoFornecedorImpl;
import br.com.eventosbook.excecao.ExcecaoUsuarioJaCadastrado;
import br.com.eventosbook.modelo.Categoria;
import br.com.eventosbook.modelo.Endereco;
import br.com.eventosbook.modelo.Fornecedor;
import br.com.eventosbook.modelo.Situacao;
import br.com.eventosbook.modelo.Telefone;
import br.com.eventosbook.modelo.TipoUsuario;
import br.com.eventosbook.modelo.Usuario;
import br.com.eventosbook.pojo.FormularioFornecedor;
import br.com.eventosbook.util.BibliotecaFuncao;
import br.com.eventosbook.util.BibliotecaUrl;

public class RnIncluirFornecedor {

	private static RnIncluirFornecedor aRnIncluirFornecedor = new RnIncluirFornecedor();

	public static RnIncluirFornecedor getInstance(){
		if(RnIncluirFornecedor.aRnIncluirFornecedor == null){
			RnIncluirFornecedor.aRnIncluirFornecedor = new RnIncluirFornecedor();
		}

		return RnIncluirFornecedor.aRnIncluirFornecedor;
	}

	public String executar(FormularioFornecedor pFormulario, HttpSession pSession) throws ExcecaoUsuarioJaCadastrado, Exception{
		
		Usuario usuario = new Usuario();
		usuario.setEmail(pFormulario.getEmail());

		Usuario usuarioExiste = RnConsultarUsuarioPorObjeto.getInstance().executar(usuario);

		if(usuarioExiste !=null){
			throw new ExcecaoUsuarioJaCadastrado(usuarioExiste);
		}


		if(!pFormulario.getSenha().equals(pFormulario.getConfirmSenha())){
			return BibliotecaUrl.getInstance().getRedirect(Constantes.LINK_USUARIO_CONTROLADOR, Constantes.LINK_CADASTRO_USUARIO_SEM_SUCESSO);
		}

		Categoria categoria = new Categoria(Integer.valueOf(pFormulario.getValorSelect()));
		categoria = RnConsultarCategoriaPorObjeto.getInstance().executar(categoria);

		//Se o Fornecedor escolher a opção de Produtor de Eventos, chama a RN responsável pelo Cadastro dos Produtores de Eventos!
		if(categoria.getDescricao().equalsIgnoreCase("PRODUTOR")){
			return RnIncluirProdutor.getInstance().executar(pFormulario, pSession);
		}


		Fornecedor fornecedor = new Fornecedor();

		Endereco endereco = new Endereco();
		List<Endereco> colecaoEndereco = new ArrayList<Endereco>();
		Telefone telefone = new Telefone();
		List<Telefone> colecaoTelefone = new ArrayList<Telefone>();

		Situacao situacao = new Situacao(Constantes.SIGLA_SITUACAO_USUARIO_ATIVO.toString());
		situacao = RnConsultarSituacaoPorObjeto.getInstance().executar(situacao);


		TipoUsuario tipoUsuario = new TipoUsuario(Constantes.SIGLA_TIPO_USUARIO_FORNECEDOR);

		tipoUsuario = RnConsultarTipoUsuarioPorObjeto.getInstance().executar(tipoUsuario);

		usuario.setSenha(BibliotecaFuncao.criptografarPalavra(pFormulario.getSenha()));
		usuario.setSituacao(situacao);
		usuario.setTipoUsuario(tipoUsuario);
		usuario.setDataCricacao(BibliotecaFuncao.getDataAtual());
		usuario.setDataUltimaAutenticacao(BibliotecaFuncao.getDataAtual());

		colecaoEndereco.add(endereco);

		usuario.setColecaoEndereco(colecaoEndereco);

		colecaoTelefone.add(telefone);
		usuario.setColecaoTelefone(colecaoTelefone);
		List<Categoria> arrCategoria = new ArrayList<Categoria>();

		arrCategoria.add(categoria);

		fornecedor.setCategoria(arrCategoria);
		fornecedor.setNome(pFormulario.getNome());
		fornecedor.setHorarioAtendimento(pFormulario.getHorarioAtendimento());
		fornecedor.setNumeroDocumento(pFormulario.getNumeroDocumento());
		fornecedor.setUsuario(usuario);
		fornecedor.setNota(0.0);

		DaoFornecedorImpl.getInstance().incluir(fornecedor);
		
		//FIXME REMOVER BARRA DE COMENTARIO!!! MASSA DE TESTE
		//RnProcessarEmailCadastro.getInstance().executar(usuario);
		return RnValidarUsuarioNoCadastro.getInstance().executar(usuario, pSession);


	}

}
