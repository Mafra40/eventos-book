package br.com.eventosbook.rn.consultas;

import javax.persistence.Query;

import br.com.eventosbook.hibernate.util.ConnectionFactory;
import br.com.eventosbook.modelo.Avaliacao;
import br.com.eventosbook.modelo.Comentario;
import br.com.eventosbook.modelo.Contratante;
import br.com.eventosbook.modelo.Evento;
import br.com.eventosbook.modelo.MeuFornecedor;
import br.com.eventosbook.modelo.TipoComentario;
import br.com.eventosbook.rn.consultas.filtro.FiltroConsultarQtdAvaliacoesFornecedor;

/**Classe de consulta.
 * 
 * @author rodrigo.leite
 *
 */
public class ConsultarQtdAvaliacoesFornecedor {
	

	private static ConsultarQtdAvaliacoesFornecedor aConsultarComentarioFornecedor = new ConsultarQtdAvaliacoesFornecedor();

	public static ConsultarQtdAvaliacoesFornecedor getInstance(){
		if(ConsultarQtdAvaliacoesFornecedor.aConsultarComentarioFornecedor == null){
			ConsultarQtdAvaliacoesFornecedor.aConsultarComentarioFornecedor = new ConsultarQtdAvaliacoesFornecedor();
		}

		return ConsultarQtdAvaliacoesFornecedor.aConsultarComentarioFornecedor;
	}
	
	
	public Integer consultar(FiltroConsultarQtdAvaliacoesFornecedor pFiltroConsultarQtdAvaliacoesFornecedor){
			int qtd = 0;
		
		

			if(pFiltroConsultarQtdAvaliacoesFornecedor !=null){
				int i = 0;
				StringBuilder sql = new StringBuilder("");
				StringBuilder sqlWhere = new StringBuilder("");
				StringBuilder sqlConector = new StringBuilder("");
				
				 sql.append("SELECT " 
						
						+ Avaliacao.NM_SCHEMA_ENTIDADE +"." +Avaliacao.NM_COL_CODIGO
						
						+" FROM "+Comentario.NM_SCHEMA_ENTIDADE
						
						+" INNER JOIN " +TipoComentario.NM_SCHEMA_ENTIDADE+ " ON " + TipoComentario.NM_SCHEMA_ENTIDADE +"." +TipoComentario.NM_COL_CODIGO+ "  = " + Comentario.NM_SCHEMA_ENTIDADE +"." +Comentario.NM_COL_FK_TIPO_COMENTARIO
						+" LEFT JOIN " +Avaliacao.NM_SCHEMA_ENTIDADE+ " ON " + Avaliacao.NM_SCHEMA_ENTIDADE +"." +Avaliacao.NM_COL_CODIGO+ "  = " + Comentario.NM_SCHEMA_ENTIDADE +"." +Comentario.NM_COL_FK_AVALIACAO
						+" INNER JOIN " +MeuFornecedor.NM_SCHEMA_ENTIDADE+ " ON " + MeuFornecedor.NM_SCHEMA_ENTIDADE +"." +MeuFornecedor.NM_COL_FK_AVALIACAO+ "  = " + Avaliacao.NM_SCHEMA_ENTIDADE +"." +Avaliacao.NM_COL_CODIGO
						+" INNER JOIN " +Evento.NM_SCHEMA_ENTIDADE+ " ON " + MeuFornecedor.NM_SCHEMA_ENTIDADE +"." +MeuFornecedor.NM_COL_FK_EVENTO+ "  = " + Evento.NM_SCHEMA_ENTIDADE +"." +Evento.NM_COL_CODIGO
						+" INNER JOIN " +Contratante.NM_SCHEMA_ENTIDADE+ " ON " + Evento.NM_SCHEMA_ENTIDADE +"." +Evento.NM_FK_CODIGO_CONTRATANTE+ "  = " + Contratante.NM_SCHEMA_ENTIDADE +"." +Contratante.NM_COL_CODIGO
						 );
				
				
				if(pFiltroConsultarQtdAvaliacoesFornecedor.isCdFornecedorAlterado()){
					i++;
					sqlWhere.append(sqlConector.toString() + MeuFornecedor.NM_SCHEMA_ENTIDADE +"."+ MeuFornecedor.NM_COL_FK_FORNECEDOR + " =:"+MeuFornecedor.NM_COL_FK_FORNECEDOR);
					sqlConector.append(" AND ");
				}
				
				

				
				if (i > 0){
					//Constroe o where.
					sql.append(" WHERE " + sqlWhere.toString() + " GROUP BY "+ Avaliacao.NM_SCHEMA_ENTIDADE +"." +Avaliacao.NM_COL_CODIGO);
					
			
				}

				Query q = ConnectionFactory.getInstace().getConnection().createNativeQuery(sql.toString(), FiltroConsultarQtdAvaliacoesFornecedor.class);


				if (i > 0){
					if(pFiltroConsultarQtdAvaliacoesFornecedor.isCdFornecedorAlterado()){
						q.setParameter(MeuFornecedor.NM_COL_FK_FORNECEDOR, pFiltroConsultarQtdAvaliacoesFornecedor.getCdFornecedor());
					}



				}
				
				try{

				 qtd = q.getResultList().size();
				}catch(Exception e){
					e.printStackTrace();
					qtd = 0;
				}

			}

		
		return qtd;
		
	}
}
