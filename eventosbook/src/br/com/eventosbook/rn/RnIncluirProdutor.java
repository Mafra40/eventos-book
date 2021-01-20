package br.com.eventosbook.rn;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import br.com.eventosbook.constante.Constantes;
import br.com.eventosbook.dao.impl.DaoProdutorImpl;
import br.com.eventosbook.modelo.Categoria;
import br.com.eventosbook.modelo.Endereco;
import br.com.eventosbook.modelo.Produtor;
import br.com.eventosbook.modelo.Situacao;
import br.com.eventosbook.modelo.Telefone;
import br.com.eventosbook.modelo.TipoUsuario;
import br.com.eventosbook.modelo.Usuario;
import br.com.eventosbook.pojo.FormularioFornecedor;
import br.com.eventosbook.util.BibliotecaFuncao;

public class RnIncluirProdutor {
	
private static RnIncluirProdutor aRnIncluirProdutor = new RnIncluirProdutor();
	
	public static RnIncluirProdutor getInstance(){
		if(RnIncluirProdutor.aRnIncluirProdutor == null){
			RnIncluirProdutor.aRnIncluirProdutor = new RnIncluirProdutor();
		}
		
		return RnIncluirProdutor.aRnIncluirProdutor;
	}
	
	
	public String executar(FormularioFornecedor pFormulario, HttpSession pSession){
		
		if(!pFormulario.getSenha().equals(pFormulario.getConfirmSenha())){
			return "redirect:" + Constantes.LINK_CADASTRO_USUARIO_SEM_SUCESSO;
		}
		
		try {

			Produtor produtor = new Produtor();
			Usuario usuario = new Usuario();
			Categoria categ = new Categoria(Integer.valueOf(pFormulario.getValorSelect()));
			Endereco endereco = new Endereco();
			List<Endereco> colecaoEndereco = new ArrayList<Endereco>();
			Telefone telefone = new Telefone();
			List<Telefone> colecaoTelefone = new ArrayList<Telefone>();
			
			colecaoEndereco.add(endereco);
			colecaoTelefone.add(telefone);
			
			produtor.setNome(pFormulario.getNome());
			produtor.setNumeroDocumento(pFormulario.getNumeroDocumento());
			produtor.setHorarioAtendimento(pFormulario.getHorarioAtendimento());
			produtor.setCategoriaFornecedor(categ);
			
			TipoUsuario tipoUsuario = new TipoUsuario(Constantes.SIGLA_TIPO_USUARIO_PRODUTOR);
			tipoUsuario = RnConsultarTipoUsuarioPorObjeto.getInstance().executar(tipoUsuario);
			
			Situacao situacao = new Situacao(Constantes.SIGLA_SITUACAO_USUARIO_ATIVO.toString());
			situacao = RnConsultarSituacaoPorObjeto.getInstance().executar(situacao);

			usuario.setEmail(pFormulario.getEmail());
			usuario.setSenha(BibliotecaFuncao.criptografarPalavra(pFormulario.getSenha()));
			usuario.setDataCricacao(BibliotecaFuncao.getDataAtual());
			usuario.setDataUltimaAutenticacao(BibliotecaFuncao.getDataAtual());
			usuario.setSituacao(situacao);
			usuario.setTipoUsuario(tipoUsuario);
			usuario.setColecaoEndereco(colecaoEndereco);
			usuario.setColecaoTelefone(colecaoTelefone);
			
			produtor.setUsuario(usuario);
			
			DaoProdutorImpl.getInstance().incluir(produtor);
			

			RnProcessarEmailCadastro.getInstance().executar(usuario);
						
			return RnValidarUsuarioNoCadastro.getInstance().executar(usuario, pSession);
	
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:" + Constantes.LINK_CADASTRO_USUARIO_SEM_SUCESSO;
		}		
	}

}
