package br.com.eventosbook.rn;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import br.com.eventosbook.modelo.Categoria;
import br.com.eventosbook.modelo.Fornecedor;
import br.com.eventosbook.modelo.Item;
import br.com.eventosbook.modelo.SubCategoria;
import br.com.eventosbook.rn.consultas.ConsultarFornecedor;
import br.com.eventosbook.rn.consultas.ConsultarFornecedorPorItem;
import br.com.eventosbook.rn.consultas.filtro.FiltroConsultarFornecedor;

/*
 * Consulta fornecedores para cada item do check list.
 */
public class RnConsultarFornecedor {

private static RnConsultarFornecedor aRnConsultarFornecedor = new RnConsultarFornecedor();
	
	
	public static RnConsultarFornecedor getInstance(){
		if(RnConsultarFornecedor.aRnConsultarFornecedor == null){
			RnConsultarFornecedor.aRnConsultarFornecedor = new RnConsultarFornecedor();
		}
		
		return RnConsultarFornecedor.aRnConsultarFornecedor;
	}
	
	
	public List<FiltroConsultarFornecedor> executar(FiltroConsultarFornecedor pFiltro){
		
		return ConsultarFornecedor.getInstance().consultar(pFiltro);
	}
}
