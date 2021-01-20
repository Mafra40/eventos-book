package br.com.eventosbook.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import br.com.eventosbook.constante.Constantes;
import br.com.eventosbook.dao.DaoMeuFornecedor;
import br.com.eventosbook.hibernate.util.ConnectionFactory;
import br.com.eventosbook.modelo.MeuFornecedor;

public class DaoMeuFornecedorImpl implements DaoMeuFornecedor {

	private static DaoMeuFornecedorImpl aDaoMeuFornecedorImpl = new DaoMeuFornecedorImpl();

	public static DaoMeuFornecedorImpl getInstance(){
		if(DaoMeuFornecedorImpl.aDaoMeuFornecedorImpl == null){
			DaoMeuFornecedorImpl.aDaoMeuFornecedorImpl = new DaoMeuFornecedorImpl();
		}

		return DaoMeuFornecedorImpl.aDaoMeuFornecedorImpl;
	}

	@Override
	public void incluir(MeuFornecedor pMeuFornecedor) throws Exception {

		try{
			ConnectionFactory.getInstace().getConnection().getTransaction().begin();
			ConnectionFactory.getInstace().getConnection().persist(pMeuFornecedor);
			ConnectionFactory.getInstace().getConnection().getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();

			ConnectionFactory.getInstace().getConnection().getTransaction().rollback();

		} finally{
			ConnectionFactory.getInstace().getCloseConnection();

		}

	}

	@Override
	public void alterar(MeuFornecedor pMeuFornecedor) {
		
		try{
			ConnectionFactory.getInstace().getConnection().getTransaction().begin();
			ConnectionFactory.getInstace().getConnection().merge(pMeuFornecedor);
			ConnectionFactory.getInstace().getConnection().getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();

			ConnectionFactory.getInstace().getConnection().getTransaction().rollback();

		} finally{
			ConnectionFactory.getInstace().getCloseConnection();

		}
	}

	@Override
	public void excluir(MeuFornecedor pMeuFornecedor) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<MeuFornecedor> consultar(MeuFornecedor pFiltroMeuFornecedor) {
		List<MeuFornecedor> retorno = new ArrayList<MeuFornecedor>();

		try{

			if(pFiltroMeuFornecedor !=null){
				int i = 0;
				String sql = "FROM " + Constantes.PATH_PROJECT + ".modelo.MeuFornecedor";
				String sqlWhere = "";
				String sqlConector = "";

				if(pFiltroMeuFornecedor.getCodigo() != null){
					i++;
					sqlWhere += sqlConector + "id_meus_fornecedores =:id_meus_fornecedores";
					sqlConector = " AND ";
				}

				if(pFiltroMeuFornecedor.getEvento() != null && pFiltroMeuFornecedor.getEvento().getCodigo() != null){
					i++;
					sqlWhere += sqlConector + "fk_evento =:fk_evento";
					sqlConector = " AND ";
				}

				if(pFiltroMeuFornecedor.getFornecedor() != null && pFiltroMeuFornecedor.getFornecedor().getCodigo() != null){
					i++;
					sqlWhere += sqlConector + "fk_fornecedor =:fk_fornecedor";
					sqlConector = " AND ";
				}


				if (i > 0){
					//Constroe o where.
					sql = sql + " WHERE " + sqlWhere;
				}

				TypedQuery<MeuFornecedor> q = ConnectionFactory.getInstace().getConnection().createQuery(sql, MeuFornecedor.class);


				if (i > 0){
					if(pFiltroMeuFornecedor.getCodigo() != null){
						q.setParameter("id_meus_fornecedores", pFiltroMeuFornecedor.getCodigo());
					}
				}

				if (i > 0){
					if(pFiltroMeuFornecedor.getEvento() != null && pFiltroMeuFornecedor.getEvento().getCodigo() != null){
						q.setParameter("fk_evento", pFiltroMeuFornecedor.getEvento().getCodigo());
					}
				}

				if (i > 0){
					if(pFiltroMeuFornecedor.getFornecedor() != null && pFiltroMeuFornecedor.getFornecedor().getCodigo() != null){
						q.setParameter("fk_fornecedor", pFiltroMeuFornecedor.getFornecedor().getCodigo());
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
	public MeuFornecedor getMeuFornecedor(MeuFornecedor pMeuFornecedor) {
		MeuFornecedor retorno = new MeuFornecedor();

		try{

			if(pMeuFornecedor !=null){

				String sql = "FROM " + Constantes.PATH_PROJECT + ".modelo.MeuFornecedor WHERE 1=1";

				if(pMeuFornecedor.getCodigo() != null){
					sql += " AND id_meus_fornecedores =:id";
				}


				TypedQuery<MeuFornecedor> q = ConnectionFactory.getInstace().getConnection().createQuery(sql, MeuFornecedor.class);

				if(pMeuFornecedor.getCodigo() != null){
					q.setParameter("id", pMeuFornecedor.getCodigo());
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
