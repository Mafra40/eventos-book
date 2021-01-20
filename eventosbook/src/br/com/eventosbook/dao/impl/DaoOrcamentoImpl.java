package br.com.eventosbook.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import br.com.eventosbook.constante.Constantes;
import br.com.eventosbook.dao.DaoOrcamento;
import br.com.eventosbook.hibernate.util.ConnectionFactory;
import br.com.eventosbook.modelo.Orcamento;

public class DaoOrcamentoImpl implements DaoOrcamento {
	
	private DaoOrcamentoImpl() {}
	private static DaoOrcamentoImpl aDAOContratante = new DaoOrcamentoImpl();

	public static DaoOrcamentoImpl getInstance(){
		if(DaoOrcamentoImpl.aDAOContratante == null){
			DaoOrcamentoImpl.aDAOContratante = new DaoOrcamentoImpl();
		}
		
		return DaoOrcamentoImpl.aDAOContratante;
	}

	@Override
	public void incluir(Orcamento pOrcamento)
			throws Exception {

		try{
			ConnectionFactory.getInstace().getConnection().getTransaction().begin();
			ConnectionFactory.getInstace().getConnection().persist(pOrcamento);
			ConnectionFactory.getInstace().getConnection().getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			
			ConnectionFactory.getInstace().getConnection().getTransaction().rollback();
			
		} finally{
			ConnectionFactory.getInstace().getCloseConnection();

		}
		
	}

	@Override
	public void alterar(Orcamento pContratanteFornecedor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir(Orcamento pContratanteFornecedor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Orcamento> consultar(Orcamento pFiltroContratanteFornecedor) {
		List<Orcamento> retorno = new ArrayList<Orcamento>();

		try{

			if(pFiltroContratanteFornecedor !=null){
				int i = 0;
				String sql = "FROM " + Constantes.PATH_PROJECT + ".modelo.Orcamento";
				String sqlWhere = "";
				String sqlConector = "";

				if(pFiltroContratanteFornecedor.getCodigo() != null){
					i++;
					sqlWhere += sqlConector + "id_orcamentos =:id_orcamentos";
					sqlConector = " AND ";
				}
				
				if(pFiltroContratanteFornecedor.getEvento() != null && pFiltroContratanteFornecedor.getEvento().getCodigo() != null){
					i++;
					sqlWhere += sqlConector + "fk_evento =:fk_evento";
					sqlConector = " AND ";
				}
				
				if(pFiltroContratanteFornecedor.getFornecedor() != null && pFiltroContratanteFornecedor.getFornecedor().getCodigo() != null){
					i++;
					sqlWhere += sqlConector + "fk_fornecedor =:fk_fornecedor";
					sqlConector = " AND ";
				}

				
				if (i > 0){
					//Constroe o where.
					sql = sql + " WHERE " + sqlWhere;
				}

				TypedQuery<Orcamento> q = ConnectionFactory.getInstace().getConnection().createQuery(sql, Orcamento.class);


				if (i > 0){
					if(pFiltroContratanteFornecedor.getCodigo() != null){
						q.setParameter("id_orcamentos", pFiltroContratanteFornecedor.getCodigo());
					}
				}
				
				if (i > 0){
					if(pFiltroContratanteFornecedor.getEvento() != null && pFiltroContratanteFornecedor.getEvento().getCodigo() != null){
						q.setParameter("fk_evento", pFiltroContratanteFornecedor.getEvento().getCodigo());
					}
				}
				
				if (i > 0){
					if(pFiltroContratanteFornecedor.getFornecedor() != null && pFiltroContratanteFornecedor.getFornecedor().getCodigo() != null){
						q.setParameter("fk_fornecedor", pFiltroContratanteFornecedor.getFornecedor().getCodigo());
					}
				}



				retorno = q.getResultList();
			}

		}catch(Exception e){
			e.printStackTrace();
			retorno = null;
		}

		return retorno;
	}

	@Override
	public Orcamento getContratanteFornecedor(
			Orcamento pContratanteFornecedor) {
		Orcamento retorno = new Orcamento();
		
		try{

			if(pContratanteFornecedor !=null){
				int i = 0;
				String sql = "FROM " + Constantes.PATH_PROJECT + ".modelo.Orcamento";
				String sqlWhere = "";
				String sqlConector = "";

				if(pContratanteFornecedor.getCodigo() != null){
					i++;
					sqlWhere += sqlConector + "id_orcamentos =:id_orcamentos";
					sqlConector = " AND ";
				}
				
				if(pContratanteFornecedor.getEvento() != null && pContratanteFornecedor.getEvento().getCodigo() != null){
					i++;
					sqlWhere += sqlConector + "fk_evento =:fk_evento";
					sqlConector = " AND ";
				}
				
				if(pContratanteFornecedor.getFornecedor() != null && pContratanteFornecedor.getFornecedor().getCodigo() != null){
					i++;
					sqlWhere += sqlConector + "fk_fornecedor =:fk_fornecedor";
					sqlConector = " AND ";
				}

				
				if (i > 0){
					//Constroe o where.
					sql = sql + " WHERE " + sqlWhere;
				}

				TypedQuery<Orcamento> q = ConnectionFactory.getInstace().getConnection().createQuery(sql, Orcamento.class);


				if (i > 0){
					if(pContratanteFornecedor.getCodigo() != null){
						q.setParameter("id_orcamentos", pContratanteFornecedor.getCodigo());
					}
				}
				
				if (i > 0){
					if(pContratanteFornecedor.getEvento() != null && pContratanteFornecedor.getEvento().getCodigo() != null){
						q.setParameter("fk_evento", pContratanteFornecedor.getEvento().getCodigo());
					}
				}
				
				if (i > 0){
					if(pContratanteFornecedor.getFornecedor() != null && pContratanteFornecedor.getFornecedor().getCodigo() != null){
						q.setParameter("fk_fornecedor", pContratanteFornecedor.getFornecedor().getCodigo());
					}
				}



				retorno = q.getSingleResult();
			}

		}catch(Exception e){
			e.printStackTrace();
			retorno = null;
		}

		return retorno;
	}

}
