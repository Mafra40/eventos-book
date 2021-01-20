package br.com.eventosbook.interceptador;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import br.com.eventosbook.constante.Constantes;
import br.com.eventosbook.modelo.Usuario;

public class VerificaUsuarioInterceptador extends HandlerInterceptorAdapter {

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object controller) throws Exception{
		
		String uri = request.getRequestURI();
		
		//Links de perfil público
		if(uri.endsWith(Constantes.LINK_LOGIN) || 
				uri.endsWith(Constantes.LINK_EFETUAR_LOGIN) || 
				uri.endsWith(Constantes.LINK_LOGIN_INVALIDO) ||
				uri.endsWith(Constantes.LINK_RECUPERACAO_CONTA) ||
				uri.endsWith(Constantes.LINK_EFETUAR_RECUPERACAO_CONTA) ||
				uri.endsWith(Constantes.LINK_CADASTRAR_CONTRATANTE) ||
				uri.endsWith(Constantes.LINK_EFETUAR_CADASTRO_CONTRATANTE) ||
				uri.endsWith(Constantes.LINK_CADASTRAR_FORNECEDOR) ||
				uri.endsWith(Constantes.LINK_EFETUAR_CADASTRO_FORNECEDOR) ||
				uri.endsWith(Constantes.LINK_CADASTRO_USUARIO_COM_SUCESSO) ||
				uri.endsWith(Constantes.LINK_CADASTRO_USUARIO_SEM_SUCESSO) ||
				uri.contains(Constantes.LINK_FORNECEDOR_REMOVER_IMAGENS) ||
				uri.contains(Constantes.LINK_FORNECEDOR_EFETUAR_INCLUSAO_IMAGEM) ||
				uri.contains(Constantes.LINK_EMAIL_CONFIRMACAO)|| 
				uri.contains(Constantes.LINK_SAIR)||
				uri.contains(Constantes.LINK_USUARIO_RECUPERADO_COM_SUCESSO)||
				uri.contains(Constantes.URL_CAMINHO_IMAGEM) ||
				uri.contains("resources")){
			return true;
		}

		if(request.getSession().getAttribute(Constantes.CONTEXTO_USUARIO_LOGADO)!=null){
			Usuario usuarioLogado = new Usuario();
			usuarioLogado = (Usuario) request.getSession().getAttribute(Constantes.CONTEXTO_USUARIO_LOGADO);

			if(usuarioLogado.getTipoUsuario().getSigla() == Constantes.SIGLA_TIPO_USUARIO_CONTRATANTE){

				//Mapeia todas as URL's que pertence ao CONTRATANTE.
				if(uri.endsWith(Constantes.LINK_HOME_CONTRATANTE)){
					return true;
				} else if(uri.endsWith(Constantes.LINK_AREA_CONTRATANTE)){
					return true;
				} else if(uri.endsWith(Constantes.LINK_ALTERACAO_SENHA)){
					return true;
				} else if(uri.endsWith(Constantes.LINK_EFETUAR_ALTERACAO_SENHA)){
					return true;
				}else if(uri.endsWith(Constantes.LINK_ALTERACAO_CONTRATANTE)){
					return true;
				}else if(uri.endsWith(Constantes.LINK_EFETUAR_ALTERACAO_CONTRATANTE)){
					return true;
				}else if(uri.endsWith(Constantes.LINK_MEU_EVENTO)){
					return true;
				}else if(uri.endsWith(Constantes.LINK_CADASTRAR_EVENTO)){
					return true;
				}else if(uri.endsWith(Constantes.LINK_EFETUAR_CADASTRO_EVENTO)){
					return true;
				}else if(uri.endsWith(Constantes.LINK_ALTERACAO_EVENTO)){
					return true;
				}else if(uri.endsWith(Constantes.LINK_EFETUAR_ALTERACAO_EVENTO)){
					return true;
				}else if(uri.endsWith(Constantes.LINK_REMOVER_EVENTO)){
					return true;
				}else if(uri.endsWith(Constantes.LINK_ALTERACAO_SENHAS_USUARIOS)){
					return true;
				}else if(uri.endsWith(Constantes.LINK_EFETUAR_ALTERACAO_SENHAS_USUARIO)){
					return true;
				}else{
		 			response.sendRedirect(Constantes.LINK_LOGIN_INVALIDO);
					return false;
				}
			}
			
			
			//Mapeia todas as URL's que pertence ao FORNECEDOR.
			if(usuarioLogado.getTipoUsuario().getSigla() == Constantes.SIGLA_TIPO_USUARIO_FORNECEDOR){
				

				if(uri.endsWith(Constantes.LINK_HOME_FORNECEDOR)){
					return true;
				} else if(uri.endsWith(Constantes.LINK_AREA_FORNECEDOR)){
					return true;
				} else if(uri.endsWith(Constantes.LINK_ALTERACAO_SENHA)){
					return true;
				} else if(uri.endsWith(Constantes.LINK_EFETUAR_ALTERACAO_SENHA)){
					return true;
				} else if(uri.endsWith(Constantes.LINK_ALTERACAO_FORNECEDOR)){
					return true;
				} else if(uri.endsWith(Constantes.LINK_EFETUAR_ALTERACAO_FORNECEDOR)){
					return true;
				}else if(uri.endsWith(Constantes.LINK_ALTERACAO_SENHAS_USUARIOS)){
					return true;
				}else if(uri.endsWith(Constantes.LINK_EFETUAR_ALTERACAO_SENHAS_USUARIO)){
					return true;
				}else if(uri.endsWith(Constantes.LINK_FORNECEDOR_IMAGENS)){
					return true;
				}else if(uri.endsWith(Constantes.LINK_FORNECEDOR_REMOVER_IMAGENS)){
					return true;
				}else if(uri.endsWith(Constantes.LINK_FORNECEDOR_EFETUAR_INCLUSAO_IMAGEM)){
					return true;
				}else if(uri.endsWith(Constantes.LINK_UPLOAD_FOTO_IMAGEM)){
					return true;
				}else if(uri.endsWith(Constantes.LINK_FORNECEDOR_GALERIA_IMAGENS)){
					return true;
				}else {
					response.sendRedirect(Constantes.LINK_LOGIN_INVALIDO);
					return false;
				}
			}
			
			//Mapeia todas as URL's que pertence ao PRODUTOR.
			if(usuarioLogado.getTipoUsuario().getSigla() == Constantes.SIGLA_TIPO_USUARIO_PRODUTOR){
				if(uri.endsWith(Constantes.LINK_HOME_PRODUTOR)){
					return true;
				} else if(uri.endsWith(Constantes.LINK_AREA_PRODUTOR)){
					return true;
				} else if(uri.endsWith(Constantes.LINK_ALTERACAO_SENHA)){
					return true;
				} else if(uri.endsWith(Constantes.LINK_EFETUAR_ALTERACAO_SENHA)){
					return true;
				} else {
					response.sendRedirect(Constantes.LINK_LOGIN_INVALIDO);
					return false;
				}
			}

 		} else {
 			response.sendRedirect(Constantes.LINK_LOGIN_INVALIDO);
 			return false;
 		}
		
		return false;

	}
	
}
