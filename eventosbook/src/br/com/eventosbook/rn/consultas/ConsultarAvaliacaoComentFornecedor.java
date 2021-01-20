package br.com.eventosbook.rn.consultas;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import br.com.eventosbook.hibernate.util.ConnectionFactory;
import br.com.eventosbook.modelo.Avaliacao;
import br.com.eventosbook.modelo.Comentario;
import br.com.eventosbook.modelo.Contratante;
import br.com.eventosbook.modelo.Evento;
import br.com.eventosbook.modelo.MeuFornecedor;
import br.com.eventosbook.modelo.TipoComentario;
import br.com.eventosbook.rn.consultas.filtro.FiltroConsultarAvaliacaoComentFornecedor;

/**Classe de consulta.
 * 
 * @author rodrigo.leite
 *
 */

public class ConsultarAvaliacaoComentFornecedor {
	

	private static ConsultarAvaliacaoComentFornecedor aConsultarComentarioFornecedor = new ConsultarAvaliacaoComentFornecedor();

	public static ConsultarAvaliacaoComentFornecedor getInstance(){
		if(ConsultarAvaliacaoComentFornecedor.aConsultarComentarioFornecedor == null){
			ConsultarAvaliacaoComentFornecedor.aConsultarComentarioFornecedor = new ConsultarAvaliacaoComentFornecedor();
		}

		return ConsultarAvaliacaoComentFornecedor.aConsultarComentarioFornecedor;
	}
	

	/**
	 * 
	 * @param pFiltroConsultarComentarioFornecedor
	 * @return
	 */
	public List<FiltroConsultarAvaliacaoComentFornecedor> consultar(FiltroConsultarAvaliacaoComentFornecedor pFiltroConsultarComentarioFornecedor){
			
		List<FiltroConsultarAvaliacaoComentFornecedor> retorno = new ArrayList<FiltroConsultarAvaliacaoComentFornecedor>();
		

			if(pFiltroConsultarComentarioFornecedor !=null){
				int i = 0;
				StringBuilder sql = new StringBuilder("");
				StringBuilder sqlWhere = new StringBuilder("");
				StringBuilder sqlConector = new StringBuilder("");
				
				 sql.append("SELECT " 
						+ Comentario.NM_SCHEMA_ENTIDADE +"." +Comentario.NM_COL_CODIGO+ ", "
						+ Comentario.NM_SCHEMA_ENTIDADE +"." +Comentario.NM_COL_FK_TIPO_COMENTARIO+ ", "
						+ Comentario.NM_SCHEMA_ENTIDADE +"." +Comentario.NM_COL_DESCRICAO+ ", "
						+ Avaliacao.NM_SCHEMA_ENTIDADE +"." +Avaliacao.NM_COL_DATA_AVALIACAO+ ", "
						+ Avaliacao.NM_SCHEMA_ENTIDADE +"." +Avaliacao.NM_COL_CODIGO+ ", "
						+ Avaliacao.NM_SCHEMA_ENTIDADE +"." +Avaliacao.NM_COL_NOTA+ ", "
						+ Contratante.NM_SCHEMA_ENTIDADE +"." +Contratante.NM_COL_NOME
						
						+" FROM "+Comentario.NM_SCHEMA_ENTIDADE
						
						+" INNER JOIN " +TipoComentario.NM_SCHEMA_ENTIDADE+ " ON " + TipoComentario.NM_SCHEMA_ENTIDADE +"." +TipoComentario.NM_COL_CODIGO+ "  = " + Comentario.NM_SCHEMA_ENTIDADE +"." +Comentario.NM_COL_FK_TIPO_COMENTARIO
						+" LEFT JOIN " +Avaliacao.NM_SCHEMA_ENTIDADE+ " ON " + Avaliacao.NM_SCHEMA_ENTIDADE +"." +Avaliacao.NM_COL_CODIGO+ "  = " + Comentario.NM_SCHEMA_ENTIDADE +"." +Comentario.NM_COL_FK_AVALIACAO
						+" INNER JOIN " +MeuFornecedor.NM_SCHEMA_ENTIDADE+ " ON " + MeuFornecedor.NM_SCHEMA_ENTIDADE +"." +MeuFornecedor.NM_COL_FK_AVALIACAO+ "  = " + Avaliacao.NM_SCHEMA_ENTIDADE +"." +Avaliacao.NM_COL_CODIGO
						+" INNER JOIN " +Evento.NM_SCHEMA_ENTIDADE+ " ON " + MeuFornecedor.NM_SCHEMA_ENTIDADE +"." +MeuFornecedor.NM_COL_FK_EVENTO+ "  = " + Evento.NM_SCHEMA_ENTIDADE +"." +Evento.NM_COL_CODIGO
						+" INNER JOIN " +Contratante.NM_SCHEMA_ENTIDADE+ " ON " + Evento.NM_SCHEMA_ENTIDADE +"." +Evento.NM_FK_CODIGO_CONTRATANTE+ "  = " + Contratante.NM_SCHEMA_ENTIDADE +"." +Contratante.NM_COL_CODIGO
						 );
				
				
				if(pFiltroConsultarComentarioFornecedor.isCdFornecedorAlterado()){
					i++;
					sqlWhere.append(sqlConector.toString() + MeuFornecedor.NM_SCHEMA_ENTIDADE +"."+ MeuFornecedor.NM_COL_FK_FORNECEDOR + " =:"+MeuFornecedor.NM_COL_FK_FORNECEDOR);
					sqlConector.append(" AND ");
				}
				
				

				
				if (i > 0){
					//Constroe o where.
					sql.append(" WHERE " + sqlWhere.toString() + " ORDER BY eventosbook.avaliacao.data_avaliacao DESC ");
					
					if(pFiltroConsultarComentarioFornecedor.isLimitAlterado()){
						sql.append(" LIMIT " + pFiltroConsultarComentarioFornecedor.getLimit());
					}
				}

				Query q = ConnectionFactory.getInstace().getConnection().createNativeQuery(sql.toString(), FiltroConsultarAvaliacaoComentFornecedor.class);


				if (i > 0){
					if(pFiltroConsultarComentarioFornecedor.isCdFornecedorAlterado()){
						q.setParameter(MeuFornecedor.NM_COL_FK_FORNECEDOR, pFiltroConsultarComentarioFornecedor.getCodigoFornecedor());
					}



				}
				
				try{

				retorno = q.getResultList();
				}catch(Exception e){
					e.printStackTrace();
					retorno = null;
				}

			}

		
		return retorno;
		
	}

}
