package br.com.eventosbook.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.eventosbook.constante.Constantes;

@Controller
public class ProdutorControlador {

	
	@RequestMapping("/"+Constantes.LINK_HOME_PRODUTOR)
	public String getHomeProdutor(){
		return Constantes.NM_JSP_HOME_PRODUTOR;
	}
	
	@RequestMapping(Constantes.LINK_AREA_PRODUTOR)
	public String getAreaProdutor(){
		return Constantes.NM_JSP_AREA_PRODUTOR;
	}
}
