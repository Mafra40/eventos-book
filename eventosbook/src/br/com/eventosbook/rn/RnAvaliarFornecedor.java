package br.com.eventosbook.rn;

import org.springframework.web.servlet.ModelAndView;

import br.com.eventosbook.constante.Constantes;
import br.com.eventosbook.constante.ConstantesMsgSistema;
import br.com.eventosbook.dao.impl.DaoAvaliacaoImpl;
import br.com.eventosbook.dao.impl.DaoComentarioImpl;
import br.com.eventosbook.dao.impl.DaoMeuFornecedorImpl;
import br.com.eventosbook.dao.impl.DaoTipoComentarioImpl;
import br.com.eventosbook.excecao.ExcecaoCampoVazio;
import br.com.eventosbook.modelo.Avaliacao;
import br.com.eventosbook.modelo.Comentario;
import br.com.eventosbook.modelo.MeuFornecedor;
import br.com.eventosbook.modelo.TipoComentario;
import br.com.eventosbook.pojo.Formulario;
import br.com.eventosbook.util.BibliotecaFuncao;
import br.com.eventosbook.util.BibliotecaUrl;

public class RnAvaliarFornecedor {

	private static RnAvaliarFornecedor aRnAvaliarFornecedor = new RnAvaliarFornecedor();

	public static RnAvaliarFornecedor getInstance(){
		if(RnAvaliarFornecedor.aRnAvaliarFornecedor == null){
			RnAvaliarFornecedor.aRnAvaliarFornecedor = new RnAvaliarFornecedor();
		}

		return RnAvaliarFornecedor.aRnAvaliarFornecedor;
	}

	public ModelAndView executar(Formulario pFormulario){
		ModelAndView retorno = new ModelAndView();
		try {
			
			if(pFormulario.getCampoComentarioPositivo().equals("") && pFormulario.getCampoComentarioNegativo().equals("")){
				retorno.addObject("msg", ConstantesMsgSistema.MSG_TELA_AVALIAR_FORNECEDOR_CAMPO_COMENTARIO);
				throw new ExcecaoCampoVazio("Comentario");
			}
			
			
			if(pFormulario.getValorAvaliacao() == null ){
				retorno.addObject("campoAvaliacao", ConstantesMsgSistema.MSG_TELA_AVALIAR_FORNECEDOR_CAMPO_AVALIACAO);
				throw new ExcecaoCampoVazio("Avaliação");
			}
			
			
			Avaliacao novaAvaliacao = new Avaliacao();
			novaAvaliacao.setDataAvaliacao(BibliotecaFuncao.getDataHoraAtual());
			novaAvaliacao.setNota(Double.parseDouble(pFormulario.getValorAvaliacao()));
			novaAvaliacao = DaoAvaliacaoImpl.getInstance().incluirRetornadoObjeto(novaAvaliacao);

			
			
			MeuFornecedor meuFornecedor = new MeuFornecedor();

			meuFornecedor.setCodigo(Integer.parseInt(pFormulario.getCodigo()));
			meuFornecedor = DaoMeuFornecedorImpl.getInstance().getMeuFornecedor(meuFornecedor);
			
			
			
			
			if(pFormulario.getCampoComentarioPositivo()!=null && !pFormulario.getCampoComentarioPositivo().equals("")){
				Comentario novoComentario = new Comentario();
				novoComentario.setAvalicacao(novaAvaliacao);
				
				TipoComentario tipoComentario = new TipoComentario();
				tipoComentario.setSigla(Constantes.SIGLA_TIPO_COMENTARIO_POSITIVO);
				tipoComentario = DaoTipoComentarioImpl.getInstance().getTipoComentario(tipoComentario);
				novoComentario.setDescricao(pFormulario.getCampoComentarioPositivo());
				novoComentario.setTipoComentario(tipoComentario);
				

				novoComentario = DaoComentarioImpl.getInstance().incluirRetornadoObjeto(novoComentario);

				meuFornecedor.setAvaliacao(novoComentario.getAvalicacao());

				DaoMeuFornecedorImpl.getInstance().alterar(meuFornecedor);

			}

			if(pFormulario.getCampoComentarioNegativo()!=null && !pFormulario.getCampoComentarioNegativo().equals("")){
				Comentario novoComentario = new Comentario();
				novoComentario.setAvalicacao(novaAvaliacao);
				
				TipoComentario tipoComentario = new TipoComentario();
				tipoComentario.setSigla(Constantes.SIGLA_TIPO_COMENTARIO_NEGATIVO);
				tipoComentario = DaoTipoComentarioImpl.getInstance().getTipoComentario(tipoComentario);
				novoComentario.setDescricao(pFormulario.getCampoComentarioNegativo());
				novoComentario.setTipoComentario(tipoComentario);

				novoComentario = DaoComentarioImpl.getInstance().incluirRetornadoObjeto(novoComentario);

				meuFornecedor.setAvaliacao(novoComentario.getAvalicacao());

				DaoMeuFornecedorImpl.getInstance().alterar(meuFornecedor);
			}
			
			retorno.setViewName(BibliotecaUrl.getInstance().getRedirect(Constantes.LINK_CONTRATANTE_CONTROLADOR, Constantes.LINK_EXIBIR_MEUS_FORNECEDORES));
			retorno.addObject("msg", ConstantesMsgSistema.MSG_TELA_MEUS_FORNECEDORES_AVALIADO_SUCESSO);
		} catch (ExcecaoCampoVazio e) {
			retorno.setViewName(Constantes.NM_JSP_AVALIAR_FORNECEDOR);
			
			e.printStackTrace();
			
		} catch (Exception e) {
			retorno.setViewName(BibliotecaUrl.getInstance().getRedirect(Constantes.LINK_CONTRATANTE_CONTROLADOR, Constantes.LINK_EXIBIR_MEUS_FORNECEDORES));
			retorno.addObject("msg", ConstantesMsgSistema.MSG_TELA_MEUS_FORNECEDORES_AVALIADO_FALHA);
			e.printStackTrace();
		}
		
		return retorno;


	}
}
