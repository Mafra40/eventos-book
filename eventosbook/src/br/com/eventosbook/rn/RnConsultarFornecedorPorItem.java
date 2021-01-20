package br.com.eventosbook.rn;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import br.com.eventosbook.modelo.Categoria;
import br.com.eventosbook.modelo.Fornecedor;
import br.com.eventosbook.modelo.Item;
import br.com.eventosbook.modelo.SubCategoria;
import br.com.eventosbook.rn.consultas.ConsultarFornecedorPorItem;


public class RnConsultarFornecedorPorItem {
	
	private static RnConsultarFornecedorPorItem aRnConsultarFornecedorPorItem = new RnConsultarFornecedorPorItem();
	
	
	public static RnConsultarFornecedorPorItem getInstance(){
		if(RnConsultarFornecedorPorItem.aRnConsultarFornecedorPorItem == null){
			RnConsultarFornecedorPorItem.aRnConsultarFornecedorPorItem = new RnConsultarFornecedorPorItem();
		}
		
		return RnConsultarFornecedorPorItem.aRnConsultarFornecedorPorItem;
	}
	
	public List<Fornecedor> executar(Integer idCategoria, Integer idSubCategoria, HttpSession pSession){
		List<Fornecedor> listaFornecedor = new ArrayList<Fornecedor>();
		Item item = new Item();
		Categoria categoria = new Categoria();
		SubCategoria subCategoria = new SubCategoria();
		categoria.setCodigo(idCategoria);
		subCategoria.setCodigo(idSubCategoria);
		
		item.setCategoria(categoria);
		item.setSubCategoria(subCategoria);
		
		listaFornecedor = ConsultarFornecedorPorItem.getInstance().consultar(item, null);
		return listaFornecedor;
	}

}
