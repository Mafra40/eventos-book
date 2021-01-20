package br.com.eventosbook.rn;

import br.com.eventosbook.constante.Constantes;
import br.com.eventosbook.dao.impl.DaoEmailImpl;
import br.com.eventosbook.modelo.Email;
import br.com.eventosbook.modelo.Usuario;
import br.com.eventosbook.util.BibliotecaEmail;
import br.com.eventosbook.util.BibliotecaFuncao;

public class RnProcessarEmailCadastro {

private static RnProcessarEmailCadastro aRnProcessarEmailCadastro = new RnProcessarEmailCadastro();
	
	public static RnProcessarEmailCadastro getInstance(){
		if(RnProcessarEmailCadastro.aRnProcessarEmailCadastro == null){
			RnProcessarEmailCadastro.aRnProcessarEmailCadastro = new RnProcessarEmailCadastro();
		}
		
		return RnProcessarEmailCadastro.aRnProcessarEmailCadastro;
	}
	
	public void executar(Usuario pUsuario) throws Exception{
		Email senhaCodigoAtivacao = new Email();
		String codigoAtivacao = BibliotecaEmail.getInstancia().processarEmailConfirmacao(pUsuario);
		
		Usuario usuario = RnConsultarUsuarioPorObjeto.getInstance().executar(pUsuario);

		senhaCodigoAtivacao.setChave(codigoAtivacao);
		senhaCodigoAtivacao.setDataCriacao(BibliotecaFuncao.getDataAtual());
		senhaCodigoAtivacao.setUsuario(usuario);
		senhaCodigoAtivacao.setAtivo(Constantes.SIGLA_SITUACAO_USUARIO_ATIVO);
		DaoEmailImpl.getInstance().incluir(senhaCodigoAtivacao);
		
	}
}
