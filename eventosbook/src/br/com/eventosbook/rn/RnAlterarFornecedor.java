package br.com.eventosbook.rn;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.eventosbook.constante.Constantes;
import br.com.eventosbook.constante.ConstantesMsgSistema;
import br.com.eventosbook.dao.impl.DaoFornecedorImpl;
import br.com.eventosbook.modelo.Categoria;
import br.com.eventosbook.modelo.Cidade;
import br.com.eventosbook.modelo.Endereco;
import br.com.eventosbook.modelo.Estado;
import br.com.eventosbook.modelo.Fornecedor;
import br.com.eventosbook.modelo.Telefone;
import br.com.eventosbook.modelo.Usuario;
import br.com.eventosbook.pojo.FormularioFornecedor;
import br.com.eventosbook.util.BibliotecaUrl;

public class RnAlterarFornecedor {

	private RnAlterarFornecedor() {}

	private static RnAlterarFornecedor aRnAlterarFornecedor = new RnAlterarFornecedor();

	public static RnAlterarFornecedor getInstance(){
		if(RnAlterarFornecedor.aRnAlterarFornecedor == null){
			RnAlterarFornecedor.aRnAlterarFornecedor = new RnAlterarFornecedor();
		}

		return RnAlterarFornecedor.aRnAlterarFornecedor;
	}
	
	
	public String executar(FormularioFornecedor pFormulario, ModelMap pModel, HttpSession pSession , RedirectAttributes pRedirectAttributes){
		
		
		Usuario usuario  = new Usuario();
		List<Telefone> lTelefone;
		Telefone telefone;
		Endereco endereco;
		Fornecedor fornecedorAnterior = new Fornecedor();
		String horarioAtendimento;
		Cidade cidade = null;
		Estado estado = null;
		
		fornecedorAnterior.setCodigo(Integer.valueOf(pFormulario.getIdFornecedor()));
		fornecedorAnterior = RnConsultarFornecedorPorObjeto.getInstance().executar(fornecedorAnterior);
		usuario = fornecedorAnterior.getUsuario();
		
		
		
		//QTD máxima telefone = 3
		//Se evoluir fazer de modo interativo e não usar o pFormulario.
		//Ou adicionar interativamente dentro do próprio pFormulario
		lTelefone = new ArrayList<Telefone>();
		if(!pFormulario.getTelefone1().equals("")){
			telefone = new Telefone();
			telefone.setTelefone(pFormulario.getTelefone1().trim());
			telefone.setCodigo(pFormulario.getIdTelefone1().equals("")?null:Integer.valueOf(pFormulario.getIdTelefone1()));
			telefone.setContato(pFormulario.getContato1());
			telefone.setUsuario(fornecedorAnterior.getUsuario());
			lTelefone.add(telefone);
		}
		
		if(!pFormulario.getTelefone2().equals("")){
			telefone = new Telefone();
			telefone.setTelefone(pFormulario.getTelefone2().trim());
			telefone.setCodigo(pFormulario.getIdTelefone2().equals("")?null:Integer.valueOf(pFormulario.getIdTelefone2()));
		    telefone.setContato(pFormulario.getContato2());
		    telefone.setUsuario(fornecedorAnterior.getUsuario());
			lTelefone.add(telefone);
		}
		
		if(!pFormulario.getTelefone3().equals("")){
			telefone = new Telefone();
			telefone.setTelefone(pFormulario.getTelefone3().trim());
			telefone.setCodigo(pFormulario.getIdTelefone3().equals("")?null:Integer.valueOf(pFormulario.getIdTelefone3()));
			telefone.setContato(pFormulario.getContato3());
			telefone.setUsuario(fornecedorAnterior.getUsuario());
			lTelefone.add(telefone);
		}
		
		
		
		List<Telefone> arrTelefoneAlterado = fornecedorAnterior.getUsuario().getColecaoTelefone() ;
		for (int i = 0; i < lTelefone.size(); i++) {
			boolean igual = false;
			for (int j = 0; j < arrTelefoneAlterado.size(); j++) {
				
				if(lTelefone.get(i).getCodigo() != null) { //altera os iguais.
					if(lTelefone.get(i).getCodigo().equals(arrTelefoneAlterado.get(j).getCodigo())){
						arrTelefoneAlterado.get(j).setTelefone(lTelefone.get(i).getTelefone());
						arrTelefoneAlterado.get(j).setContato(lTelefone.get(i).getContato());
						arrTelefoneAlterado.get(j).setUsuario(fornecedorAnterior.getUsuario());
						igual = true;
					}
				}
				
			}
			//Se o index do array I(codigo) for diferente de todos. Adiciona no array J
			if (igual == false){
				arrTelefoneAlterado.add(lTelefone.get(i));
			}
			
		}
		
		
		
		
		//altera categoria
		Categoria categoria = new Categoria();
		categoria.setCodigo(Integer.valueOf(pFormulario.getCategoria()));
		
		ArrayList<Categoria> arrCategoria = new ArrayList<Categoria>();
		arrCategoria.add(categoria);
		fornecedorAnterior.setCategoria(arrCategoria);
		
		//alterar telefone
		fornecedorAnterior.getUsuario().setColecaoTelefone(arrTelefoneAlterado);
		
		//altera endereço
		endereco = fornecedorAnterior.getUsuario().getColecaoEndereco().get(0);
		endereco.setBairro(pFormulario.getBairro());
		endereco.setCep(pFormulario.getCep());
		endereco.setLogradouro(pFormulario.getLogradouro());
		endereco.setComplemento(pFormulario.getComplemento());
		endereco.setNumero(pFormulario.getNumero());
		
		if(pFormulario.getCidade() != null && !pFormulario.getCidade().equals("0")){
			cidade = new Cidade(Integer.valueOf(pFormulario.getCidade()));
		}
		
		if(pFormulario.getEstado() != null && !pFormulario.getEstado().equals("0")){
			estado = new Estado(Integer.valueOf(pFormulario.getEstado()));
		}
		
		
		//altera cidade e estado.
		fornecedorAnterior.getUsuario().getColecaoEndereco().get(0).setCidade(cidade);
		fornecedorAnterior.getUsuario().getColecaoEndereco().get(0).getCidade().setEstado(estado);

		//altera fornecedor
		horarioAtendimento = pFormulario.getHorarioAtendimento();
	    fornecedorAnterior.setHorarioAtendimento(horarioAtendimento);
	    fornecedorAnterior.setNumeroDocumento(pFormulario.getNumeroDocumento());
		fornecedorAnterior.setNome(pFormulario.getNome());
		fornecedorAnterior.setDescricao(pFormulario.getDescricao());
		fornecedorAnterior.setCodigo(Integer.valueOf(pFormulario.getIdFornecedor()));
		fornecedorAnterior.setUsuario(usuario);

		
		
		
		DaoFornecedorImpl.getInstance().alterar(fornecedorAnterior);
		
		pRedirectAttributes.addFlashAttribute("msg", ConstantesMsgSistema.MSG_FORN_ALTERADO_SUCESSO);
		
		return BibliotecaUrl.getInstance().getRedirect(Constantes.LINK_FORNECEDOR_CONTROLADOR, Constantes.LINK_HOME_FORNECEDOR);
	}
}
