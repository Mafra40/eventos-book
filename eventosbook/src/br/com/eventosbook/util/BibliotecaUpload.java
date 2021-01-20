package br.com.eventosbook.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.util.FileCopyUtils;

import br.com.eventosbook.constante.Constantes;
import br.com.eventosbook.modelo.Usuario;
import br.com.eventosbook.pojo.TipoFile;

/**
 * *//**Classe responsável por fazer donwload de arquivos.
 * 
 * @author Mafra
 *
 */
 
public class BibliotecaUpload {
		
	 private static BibliotecaUpload aBibliotecaUpload = new BibliotecaUpload();
	 
	 private File aFile;
	 private int codCriado = 1; //criado com sucesso.
	 private int codJaExiste = 2;
	 private int codNaoCriado = 3;
	
	  /**Singleton.
	   * 
	   * @return
	   */
	 public static BibliotecaUpload getInstance() {
	        if (BibliotecaUpload.aBibliotecaUpload == null) {
	            BibliotecaUpload.aBibliotecaUpload = new BibliotecaUpload();
	        }

	        return BibliotecaUpload.aBibliotecaUpload;
	    }
	 
	 
	 public TipoFile uploadImagens(HttpSession pSession ,TipoFile pTipoFile , Usuario pUsuarioLogado) throws IOException , Exception{
		 
		 ArrayList<TipoFile> arrTipoFile;
		 String pathUsuario = "";
		 String localUpload = "";
		 String localUrlPublica = "";
		 
		 
		 arrTipoFile =(ArrayList<TipoFile>) pSession.getAttribute(Constantes.NM_ATT_ARR_IMAGENS);
		 
		 localUpload = Constantes.UPLOAD_PATH;
		 pathUsuario = localUpload+ Constantes.CAMPO_SEPARADOR_UP +pUsuarioLogado.getEmail().substring(0,4) + pUsuarioLogado.getCodigo();
		 localUrlPublica = Constantes.URL_CONTEXTO + Constantes.URL_CAMINHO_IMAGEM + Constantes.CAMPO_SEPARADOR_UP + pUsuarioLogado.getEmail().substring(0,4) + pUsuarioLogado.getCodigo();
		 
		 if (arrTipoFile == null){
				 arrTipoFile  = new ArrayList<TipoFile>();
				 pTipoFile.setNome("fotoGaleria_"+BibliotecaFuncao.gerarCodigoAlfaNumerico(8));
				 localUrlPublica += Constantes.CAMPO_SEPARADOR_UP + pTipoFile.getNome()+".jpg";
				 localUpload = pathUsuario + Constantes.CAMPO_SEPARADOR_UP + pTipoFile.getNome()+".jpg";
				 pTipoFile.setCaminho(localUrlPublica);
				 pTipoFile.setaCaminhoPath(localUpload);
				 arrTipoFile.add(pTipoFile);
				 pSession.setAttribute(Constantes.NM_ATT_ARR_IMAGENS, arrTipoFile);
			 }else {
				 pTipoFile.setNome("fotoGaleria_"+ BibliotecaFuncao.gerarCodigoAlfaNumerico(8));
				 localUrlPublica += Constantes.CAMPO_SEPARADOR_UP + pTipoFile.getNome()+".jpg";
				 localUpload = pathUsuario + Constantes.CAMPO_SEPARADOR_UP + pTipoFile.getNome()+".jpg";
				 pTipoFile.setCaminho(localUrlPublica);
				 pTipoFile.setaCaminhoPath(localUpload);
				 arrTipoFile.add(pTipoFile);
				 pSession.setAttribute(Constantes.NM_ATT_ARR_IMAGENS, arrTipoFile);
		 }
		 
		
		 
		 
		 //Cria diretório root de upload
		 int codStatus = criarDiretorio(Constantes.UPLOAD_PATH);
		 if( codStatus == this.codCriado || codStatus == this.codJaExiste ){
			 	
			 //cria a pasta do usuário.
			 codStatus = criarDiretorio(pathUsuario);
			 if( codStatus == this.codCriado || codStatus == this.codJaExiste ){
				 
					 FileCopyUtils.copy(pTipoFile.getBytes(), new FileOutputStream(pTipoFile.getaCaminhoPath()));
			 }else {//se não for criado. levanta exceção
				 
			 }
		 }else {//se não for criado. levanta exceção
			 
		 }
		  
	
		 return pTipoFile;
	 }
	 
	 
	 /**
	  * 
	  * @param pLocal
	  * @return
	  */
	 public int criarDiretorio(String pLocal) throws Exception{
		 this.aFile = new File(pLocal);
		 boolean isDiretorioCriado = false;
		 
		
		 if(!aFile.exists()) { //verifica se já existe um diretório criado.
			 isDiretorioCriado = aFile.mkdir(); //cria diretório
			 if(isDiretorioCriado){
				 return this.codCriado; //1
			 }
		 }else {
			 return this.codJaExiste; //2
		 }
		 return this.codNaoCriado; //3
	 }
	 

}
