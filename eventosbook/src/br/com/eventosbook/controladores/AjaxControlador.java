package br.com.eventosbook.controladores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import br.com.eventosbook.constante.Constantes;
import br.com.eventosbook.fachada.EstadoServico;
import br.com.eventosbook.fachada.UploadServico;
import br.com.eventosbook.modelo.Cidade;
import br.com.eventosbook.modelo.Estado;
import br.com.eventosbook.modelo.Imagem;
import br.com.eventosbook.modelo.Usuario;
import br.com.eventosbook.pojo.TipoFile;
import br.com.eventosbook.rn.RnValidarDocumentoEmUso;
import br.com.eventosbook.util.BibliotecaUpload;


/**Controlador reponsavel por todas as requisições ajax do sistema.
 * 
 * 
 * @author rodrigo.leite
 *
 */
@Controller
@RequestMapping(Constantes.LINK_AJAX_CONTROLADOR)
public class AjaxControlador {
	
	/**
	 * Paramentro vindo do campo select estado.
	 */
	public static final String NM_PARAM_ID_ESTADO = "id_estado";
	
	
	/**
	 * Paramentro vindo do campo número documento do fornecedor /contrantate
	 */
	public static final String NM_PARAM_NUM_DOCUMENTO = "numeroDocumento";
	
	/**Faz o upload temporário das imagens de cada usuario.
	 * 
	 * @param pMultipartRequest
	 * @param pSession
	 * @return JSON
	 * @throws IOException
	 */
		@RequestMapping(value="/"+Constantes.LINK_UPLOAD_FOTO_IMAGEM, method = { RequestMethod.GET, RequestMethod.POST})
	    public @ResponseBody String upload(MultipartHttpServletRequest pMultipartRequest, HttpSession pSession) throws IOException , Exception {
	 
	        //1. Recupera o arquivo file.
	         Iterator<String> itr =  pMultipartRequest.getFileNames();
	         MultipartFile multipartFile = null;
	         TipoFile tipoFile;
	         boolean isError = false;
	         Usuario usuarioLogado = new Usuario();
	         usuarioLogado = (Usuario) pSession.getAttribute(Constantes.CONTEXTO_USUARIO_LOGADO);
	         
	         
	          //2. pega cada arquivo a cada requisição.
	         while(itr.hasNext()){
	        	 multipartFile = pMultipartRequest.getFile(itr.next()); 
	        	 tipoFile = new TipoFile();
	        	 tipoFile.setBytes(multipartFile.getBytes());
	        	 tipoFile.setNome(multipartFile.getName());
	    		 tipoFile.setSize(multipartFile.getSize());
	    		 tipoFile.setType(multipartFile.getContentType());
	    		 try {
	    		 tipoFile = BibliotecaUpload.getInstance().uploadImagens(pSession,tipoFile, usuarioLogado);
	    		 }catch (Exception e){
	    			 isError = true;
	    		 }
	    		 
	    		 if (!isError){
	    			 Imagem imagem = new Imagem();
	    			 imagem = new Imagem();
	 				 imagem.setCaminho(tipoFile.getCaminho());
	 				 imagem.setImagemPrincipal("N");
	 				 imagem.setTitulo(tipoFile.getNome());
	 				 imagem.setUsuario(usuarioLogado);
	    			 UploadServico.getInstance().IncluirImagem(imagem); 
	    			 
	    		 }
	    		 
	    		
	         }
	         
	         if (!isError){
	        	 return "true";
	         }
	        return "false";
	    }
		
		
		
		
		
		/**Retorna a lista de cidades no formato Json de acordo com o estado.
		 * 
		 * @param idEstado
		 * @return
		 * @throws JsonGenerationException
		 * @throws JsonMappingException
		 * @throws IOException
		 */
		@RequestMapping(value="/"+Constantes.LINK_CONSULTA_CIDADES_ESTADO, method = RequestMethod.GET)
		public @ResponseBody String getCidadeJson(@RequestParam(NM_PARAM_ID_ESTADO) String idEstado) throws JsonGenerationException, JsonMappingException, IOException{
			 
			String json = "";
			Estado estado = new Estado();
			ObjectMapper mapper = new ObjectMapper();
			List<Cidade> listCidade = null;
			
			estado.setCodigo(Integer.valueOf(idEstado));
			listCidade = new ArrayList<Cidade>(EstadoServico.getInstance().consultarCidadePorEstado(estado));
	        json = mapper.writeValueAsString(listCidade);
			
			return json;
		}
		
		
		/**
		 * 
		 * @param numerDocumento
		 * @param idEntidade
		 * @return FALSO se não existir, TRUE se existir.
		 * @throws JsonGenerationException
		 * @throws JsonMappingException
		 * @throws IOException
		 */
		@RequestMapping(value="/"+Constantes.LINK_CONSULTA_DOCUMENTO, method = RequestMethod.GET)
		public @ResponseBody String getDocumentoJson(@RequestParam(NM_PARAM_NUM_DOCUMENTO) String numerDocumento , 
													 @RequestParam("idEntidade") String idEntidade,
													 @RequestParam("tipoEntidade") String tipoEntidade) throws JsonGenerationException, JsonMappingException, IOException{
			 
			String json = "";
			
			if (numerDocumento == null || numerDocumento.equals("")){
				return "false";
			}
			
			return json= RnValidarDocumentoEmUso.getInstance().executar(tipoEntidade, numerDocumento, idEntidade);
		}


}
