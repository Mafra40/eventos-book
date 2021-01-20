package br.com.eventosbook.rn.consultas;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import br.com.eventosbook.hibernate.util.ConnectionFactory;
import br.com.eventosbook.modelo.Avaliacao;
import br.com.eventosbook.modelo.Contratante;
import br.com.eventosbook.modelo.Evento;
import br.com.eventosbook.modelo.Fornecedor;
import br.com.eventosbook.modelo.MeuFornecedor;
import br.com.eventosbook.modelo.TipoEvento;
import br.com.eventosbook.rn.consultas.filtro.FiltroConsultarMeuFornecedorPorContratante;

/**Classe que implementa consulta de retorno de meus forcedores para cada contratante cadastrado.
 * 
 * @author rodrigo.leite
 *
 */
public class ConsultarMeuFornecedorPorContratante {
	
	
	private static ConsultarMeuFornecedorPorContratante aConsultarMeuFornecedorPorContratante = new ConsultarMeuFornecedorPorContratante();

	public static ConsultarMeuFornecedorPorContratante getInstance(){
		if(ConsultarMeuFornecedorPorContratante.aConsultarMeuFornecedorPorContratante == null){
			ConsultarMeuFornecedorPorContratante.aConsultarMeuFornecedorPorContratante = new ConsultarMeuFornecedorPorContratante();
		}

		return ConsultarMeuFornecedorPorContratante.aConsultarMeuFornecedorPorContratante;
	}
	
	/*
	 * 
	 */
	public List<MeuFornecedor> consultar(FiltroConsultarMeuFornecedorPorContratante pFiltroConsultarMeuFornecedorPorContratante){
			
		List<MeuFornecedor> retorno = new ArrayList<MeuFornecedor>();
		

			if(pFiltroConsultarMeuFornecedorPorContratante !=null){
				int i = 0;
				StringBuilder sql = new StringBuilder("");
				StringBuilder sqlWhere = new StringBuilder("");
				StringBuilder sqlConector = new StringBuilder("");
				
				 sql.append("SELECT " 
						+ MeuFornecedor.NM_SCHEMA_ENTIDADE +"." +MeuFornecedor.NM_COL_CODIGO+ ", "
						+ MeuFornecedor.NM_SCHEMA_ENTIDADE +"." +MeuFornecedor.NM_COL_FK_FORNECEDOR+ ", "
						+ MeuFornecedor.NM_SCHEMA_ENTIDADE +"." +MeuFornecedor.NM_COL_FK_AVALIACAO+ ", "
						+ MeuFornecedor.NM_SCHEMA_ENTIDADE +"." +MeuFornecedor.NM_COL_FK_EVENTO+ ", "
						+ MeuFornecedor.NM_SCHEMA_ENTIDADE +"." +MeuFornecedor.NM_COL_DATA_INCLUSAO
						
						+" FROM "+MeuFornecedor.NM_SCHEMA_ENTIDADE

						+" LEFT JOIN " +Avaliacao.NM_SCHEMA_ENTIDADE+ " ON "+ MeuFornecedor.NM_SCHEMA_ENTIDADE +"." +MeuFornecedor.NM_COL_FK_AVALIACAO+ " = " + Avaliacao.NM_SCHEMA_ENTIDADE +"." +Avaliacao.NM_COL_CODIGO 
						+" INNER JOIN " +Evento.NM_SCHEMA_ENTIDADE+ " ON "+ MeuFornecedor.NM_SCHEMA_ENTIDADE +"." +MeuFornecedor.NM_COL_FK_EVENTO+ " = " + Evento.NM_SCHEMA_ENTIDADE +"." +Evento.NM_COL_CODIGO
						+" INNER JOIN " +Fornecedor.NM_SCHEMA_ENTIDADE+ " ON " + MeuFornecedor.NM_SCHEMA_ENTIDADE +"." +MeuFornecedor.NM_COL_FK_FORNECEDOR+ "  = " + Fornecedor.NM_SCHEMA_ENTIDADE +"." +Fornecedor.NM_COL_CODIGO
						+" INNER JOIN " +TipoEvento.NM_SCHEMA_ENTIDADE+ " ON " + Evento.NM_SCHEMA_ENTIDADE +"." +Evento.NM_FK_CODIGO_TIPO_EVENTO + " = " + TipoEvento.NM_SCHEMA_ENTIDADE +"." +TipoEvento.NM_COL_CODIGO
						+" INNER JOIN " +Contratante.NM_SCHEMA_ENTIDADE+ " ON "+ Evento.NM_SCHEMA_ENTIDADE +"." +Evento.NM_FK_CODIGO_CONTRATANTE + " = " + Contratante.NM_SCHEMA_ENTIDADE +"." +Contratante.NM_COL_CODIGO);
				
			

				if(pFiltroConsultarMeuFornecedorPorContratante.isCodigoContratanteAlterado()){
					i++;
					sqlWhere.append(sqlConector.toString() + Contratante.NM_SCHEMA_ENTIDADE +"."+ Contratante.NM_COL_CODIGO + " =:"+Contratante.NM_COL_CODIGO);
					sqlConector.append(" AND ");
				}
				
				if(pFiltroConsultarMeuFornecedorPorContratante.isAvaliacaoNotNullAlterado()){
					i++;
					sqlWhere.append(sqlConector.toString() + MeuFornecedor.NM_SCHEMA_ENTIDADE +"."+ MeuFornecedor.NM_COL_FK_AVALIACAO + " IS NULL");
					sqlConector.append(" AND ");
				}

				
				if (i > 0){
					//Constroe o where.
					sql.append(" WHERE " + sqlWhere.toString());
				}

				Query q = ConnectionFactory.getInstace().getConnection().createNativeQuery(sql.toString(), MeuFornecedor.class);


				if (i > 0){
					if(pFiltroConsultarMeuFornecedorPorContratante.isCodigoContratanteAlterado()){
						q.setParameter(Contratante.NM_COL_CODIGO, pFiltroConsultarMeuFornecedorPorContratante.getCodigoContratante());
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
