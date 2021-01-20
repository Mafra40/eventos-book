package br.com.eventosbook.rn;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.eventosbook.constante.Constantes;
import br.com.eventosbook.constante.ConstantesMsgSistema;
import br.com.eventosbook.dao.impl.DaoContratanteImpl;
import br.com.eventosbook.modelo.Cidade;
import br.com.eventosbook.modelo.Contratante;
import br.com.eventosbook.modelo.Endereco;
import br.com.eventosbook.modelo.Estado;
import br.com.eventosbook.modelo.Telefone;
import br.com.eventosbook.modelo.Usuario;
import br.com.eventosbook.pojo.FormularioContratante;
import br.com.eventosbook.util.BibliotecaFuncao;
import br.com.eventosbook.util.BibliotecaUrl;

public class RnAlterarContratante {

	private RnAlterarContratante() {}

	private static RnAlterarContratante aRnAlterarContratante = new RnAlterarContratante();

	public static RnAlterarContratante getInstance(){
		if(RnAlterarContratante.aRnAlterarContratante == null){
			RnAlterarContratante.aRnAlterarContratante = new RnAlterarContratante();
		}

		return RnAlterarContratante.aRnAlterarContratante;
	}
	
	
	public String executar(FormularioContratante pFormulario, ModelMap pModel, HttpSession pSession , RedirectAttributes pRedirectAttributes) throws Exception{
		
		
		Usuario usuario  = new Usuario();
		List<Telefone> lTelefone;
		Telefone telefone;
		Endereco endereco;
		Contratante contratanteCpfAlterado = new Contratante();
		Contratante contratanteAnterior = new Contratante();
		Calendar dtNascimento;
		Cidade cidade = null;
		Estado estado = null;

		
		contratanteAnterior.setCodigo(Integer.valueOf(pFormulario.getIdContratante()));
		contratanteAnterior = RnConsultarContratantePorObjeto.getInstance().executar(contratanteAnterior);
		usuario = contratanteAnterior.getUsuario();
		contratanteAnterior.setCpf(pFormulario.getCPF());
		
		contratanteCpfAlterado.setCpf(pFormulario.getCPF());
		
		
		if (contratanteAnterior.getCpf() == null  ){
			contratanteAnterior.setCpf("");
		}
	 
		if ( !contratanteAnterior.getCpf().equals(contratanteCpfAlterado.getCpf())){ //verifica se é o mesmo.
				Contratante contratanteCpfEmUso = RnConsultarContratantePorObjeto.getInstance().executar(contratanteCpfAlterado); 
			if ( contratanteCpfEmUso != null){ 
			
				throw new Exception("CPF EM USO");
			}
		}
		
	
	    dtNascimento = BibliotecaFuncao.getStringComoData(pFormulario.getDataNascimento());
	    contratanteAnterior.setDataNascimento(dtNascimento);
	    contratanteAnterior.setCpf(contratanteCpfAlterado.getCpf());
	    
		//QTD máxima telefone = 3
		//Se evoluir fazer de modo interativo e não usar o pFormulario.
		//Ou adicionar interativamente dentro do próprio pFormulario
		lTelefone = new ArrayList<Telefone>();
		if(!pFormulario.getTelefone1().equals("")){
			telefone = new Telefone();
			telefone.setTelefone(pFormulario.getTelefone1().trim());
			telefone.setCodigo(pFormulario.getIdTelefone1().equals("")?null:Integer.valueOf(pFormulario.getIdTelefone1()));
			telefone.setContato("Sem contato");
			telefone.setUsuario(contratanteAnterior.getUsuario());
			lTelefone.add(telefone);
		}
		
		if(!pFormulario.getTelefone2().equals("")){
			telefone = new Telefone();
			telefone.setTelefone(pFormulario.getTelefone2().trim());
			telefone.setCodigo(pFormulario.getIdTelefone2().equals("")?null:Integer.valueOf(pFormulario.getIdTelefone2()));
		    telefone.setContato("Sem contato");
		    telefone.setUsuario(contratanteAnterior.getUsuario());
			lTelefone.add(telefone);
		}
		
		if(!pFormulario.getTelefone3().equals("")){
			telefone = new Telefone();
			telefone.setTelefone(pFormulario.getTelefone3().trim());
			telefone.setCodigo(pFormulario.getIdTelefone3().equals("")?null:Integer.valueOf(pFormulario.getIdTelefone3()));
			telefone.setContato("Sem contato");
			telefone.setUsuario(contratanteAnterior.getUsuario());
			lTelefone.add(telefone);
		}
		
		
		List<Telefone> arrTelefoneAlterado = contratanteAnterior.getUsuario().getColecaoTelefone() ;
		for (int i = 0; i < lTelefone.size(); i++) {
			boolean igual = false;
			for (int j = 0; j < arrTelefoneAlterado.size(); j++) {
				
				if(lTelefone.get(i).getCodigo() != null) { //altera os iguais.
					if(lTelefone.get(i).getCodigo().equals(arrTelefoneAlterado.get(j).getCodigo())){
						arrTelefoneAlterado.get(j).setTelefone(lTelefone.get(i).getTelefone());
						arrTelefoneAlterado.get(j).setContato(lTelefone.get(i).getContato());
						arrTelefoneAlterado.get(j).setUsuario(contratanteAnterior.getUsuario());
						igual = true;
					}
				}
				
			}
			//Se o index do array I(codigo) for diferente de todos. Adiciona no array J
			if (igual == false){
				arrTelefoneAlterado.add(lTelefone.get(i));
			}
			
		}
		
		//alterar telefone
		contratanteAnterior.getUsuario().setColecaoTelefone(arrTelefoneAlterado);
		
		//altera endereço
		endereco = contratanteAnterior.getUsuario().getColecaoEndereco().get(0);
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
		contratanteAnterior.getUsuario().getColecaoEndereco().get(0).setCidade(cidade);
		contratanteAnterior.getUsuario().getColecaoEndereco().get(0).getCidade().setEstado(estado);

		//altera contratante
		contratanteAnterior.setNome(pFormulario.getNome());
		contratanteAnterior.setSexo(pFormulario.getSexo());
		contratanteAnterior.setCodigo(Integer.valueOf(pFormulario.getIdContratante()));
		contratanteAnterior.setUsuario(usuario);
		
		
		
		
		DaoContratanteImpl.getInstance().alterar(contratanteAnterior);
		pRedirectAttributes.addFlashAttribute("msg", ConstantesMsgSistema.MSG_CONTRA_ALTERADO_SUCESSO);
		
		return  BibliotecaUrl.getInstance().getRedirect(Constantes.LINK_CONTRATANTE_CONTROLADOR, Constantes.LINK_HOME_CONTRATANTE);
	}
}
