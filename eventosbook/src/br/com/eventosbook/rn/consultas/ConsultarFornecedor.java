package br.com.eventosbook.rn.consultas;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import br.com.eventosbook.hibernate.util.ConnectionFactory;
import br.com.eventosbook.modelo.Categoria;
import br.com.eventosbook.modelo.Cidade;
import br.com.eventosbook.modelo.Endereco;
import br.com.eventosbook.modelo.Fornecedor;
import br.com.eventosbook.modelo.Imagem;
import br.com.eventosbook.modelo.Usuario;
import br.com.eventosbook.rn.consultas.filtro.FiltroConsultarFornecedor;

public class ConsultarFornecedor {
	

	private static ConsultarFornecedor aConsultarComentarioFornecedor = new ConsultarFornecedor();

	public static ConsultarFornecedor getInstance(){
		if(ConsultarFornecedor.aConsultarComentarioFornecedor == null){
			ConsultarFornecedor.aConsultarComentarioFornecedor = new ConsultarFornecedor();
		}

		return ConsultarFornecedor.aConsultarComentarioFornecedor;
	}
	
	
	public List<FiltroConsultarFornecedor> consultar(FiltroConsultarFornecedor pFiltroConsultarFornecedor){
			List<FiltroConsultarFornecedor> filtroResult = new ArrayList<FiltroConsultarFornecedor>();
		
		

			if(pFiltroConsultarFornecedor !=null){
				int i = 0;
				StringBuilder sql = new StringBuilder("");
				StringBuilder sqlWhere = new StringBuilder("");
				StringBuilder sqlConector = new StringBuilder("");
				StringBuilder sqlOrderby = new StringBuilder("");
				
				 sql.append("SELECT "
				 			+ Fornecedor.NM_SCHEMA_ENTIDADE + "." + Fornecedor.NM_COL_CODIGO+ ", "
				 			+ Fornecedor.NM_SCHEMA_ENTIDADE + "." + Fornecedor.NM_COL_HORARIO+ ", "
				 			+ Fornecedor.NM_SCHEMA_ENTIDADE + "." + Fornecedor.NM_COL_NOME+ ", "
				 			+ Fornecedor.NM_SCHEMA_ENTIDADE + "." + Fornecedor.NM_COL_NUMERO_DOCUMENTO+ ", "
				 			+ Fornecedor.NM_SCHEMA_ENTIDADE + "." + Fornecedor.NM_COL_FK_USUARIO+ ", "
				 			+ Fornecedor.NM_SCHEMA_ENTIDADE + "." + Fornecedor.NM_COL_NOTA+ ", "
				 			+ Endereco.NM_SCHEMA_ENTIDADE + "." + Endereco.NM_COL_BAIRRO+ ", "
				 			+ Cidade.NM_SCHEMA_ENTIDADE + "." + Cidade.NM_COL_DESCRICAO+ ", "
				 			+ Imagem.NM_SCHEMA_ENTIDADE + "." + Imagem.NM_COL_CAMINHO
						
						
						+" FROM "+Fornecedor.NM_SCHEMA_ENTIDADE
						+" INNER JOIN "+"eventosbook.fornecedor_categoria "+ "ON" +" eventosbook.fornecedor_categoria.fk_fornecedor = " + Fornecedor.NM_SCHEMA_ENTIDADE+"."+Fornecedor.NM_COL_CODIGO
						+" INNER JOIN " +Categoria.NM_SCHEMA_ENTIDADE+ " ON " + Categoria.NM_SCHEMA_ENTIDADE +"." +Categoria.NM_COL_CODIGO+ "  = " + Categoria.NM_SCHEMA_ENTIDADE_FC +"." +Categoria.NM_COL_FC_FK_CATEGORIA
						+" INNER JOIN " +Usuario.NM_SCHEMA_ENTIDADE+ " ON " + Usuario.NM_SCHEMA_ENTIDADE +"." +Usuario.NM_COL_CODIGO+ "  = " + Fornecedor.NM_SCHEMA_ENTIDADE +"." +Fornecedor.NM_COL_FK_USUARIO
						+" INNER JOIN " +Endereco.NM_SCHEMA_ENTIDADE+ " ON " + Endereco.NM_SCHEMA_ENTIDADE +"." +Endereco.NM_COL_FK_USUARIO+ "  = " + Fornecedor.NM_SCHEMA_ENTIDADE +"." +Fornecedor.NM_COL_FK_USUARIO
						+" INNER JOIN " +Cidade.NM_SCHEMA_ENTIDADE+ " ON " + Cidade.NM_SCHEMA_ENTIDADE +"." +Cidade.NM_COL_CODIGO+ "  = " + Endereco.NM_SCHEMA_ENTIDADE +"." +Endereco.NM_COL_FK_CIDADE
						+" LEFT JOIN " +Imagem.NM_SCHEMA_ENTIDADE+ " ON " + Imagem.NM_SCHEMA_ENTIDADE +"." +Imagem.NM_COL_FK_USUARIO+ "  = " + Fornecedor.NM_SCHEMA_ENTIDADE +"." +Fornecedor.NM_COL_FK_USUARIO
						 );

				
				if(pFiltroConsultarFornecedor.isCategoriaAlterado()){
					i++;
					sqlWhere.append(sqlConector.toString() + "eventosbook.fornecedor_categoria.fk_categoria =:fk_categoria");
					sqlConector.append(" AND ");
				}
				
				
				if(pFiltroConsultarFornecedor.isOrdenacaoAlterado()){
					sqlOrderby.append(" ORDER BY " + pFiltroConsultarFornecedor.getOrdenacao() + " ASC");
				}

				
				if (i > 0){
					//Constroe o where.
					sql.append(" WHERE " + sqlWhere.toString() + sqlOrderby );
					
			
				}

				Query q = ConnectionFactory.getInstace().getConnection().createNativeQuery(sql.toString(), FiltroConsultarFornecedor.class);


				if (i > 0){
					if(pFiltroConsultarFornecedor.isCategoriaAlterado()){
						q.setParameter("fk_categoria", pFiltroConsultarFornecedor.getCdCategoria());
					}



				}
				
				try{

					filtroResult = q.getResultList();
				}catch(Exception e){
					e.printStackTrace();
					filtroResult = null;
				}

			}

		
		return filtroResult;
		
	}

}
