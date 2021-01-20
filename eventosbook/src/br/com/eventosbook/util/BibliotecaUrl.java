package br.com.eventosbook.util;

import br.com.eventosbook.constante.Constantes;


/**Classe responsavel pela geração de url do sistema, evitar erros de url mal formada.
 * 
 * @author rodrigo.leite
 *
 */
public class BibliotecaUrl {
	
private static BibliotecaUrl aBibliotecaUrl = new BibliotecaUrl();
    
    
    public static BibliotecaUrl getInstance() {
		if (BibliotecaUrl.aBibliotecaUrl == null) {
			BibliotecaUrl.aBibliotecaUrl = new BibliotecaUrl();
		}

		return BibliotecaUrl.aBibliotecaUrl;
	}
    
    /**Retorna a url completa do controlador e seu método.
     * 
     * @param pNomeControlador
     * @param pNomeMetodo
     * @return
     */
    public String getUrl(String pNomeControlador , String pNomeMetodo){
    	return Constantes.URL_CAMINHO_ABSOLUTO + pNomeControlador + Constantes.URL_CAMPO_SEPARADOR + pNomeMetodo;
    }
    
    /**redireciona padrão Spring
     * 
     * @param pNomeControlador
     * @param pNomeMetodo
     * @return
     */
    public String getRedirect(String pNomeControlador , String pNomeMetodo){
    	return Constantes.NM_REDIRECT + Constantes.URL_CAMPO_SEPARADOR + pNomeControlador + Constantes.URL_CAMPO_SEPARADOR + pNomeMetodo;
    }

}
