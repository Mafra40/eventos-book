package br.com.eventosbook.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import br.com.eventosbook.constante.Constantes;
import br.com.eventosbook.dao.DaoEndereco;
import br.com.eventosbook.hibernate.util.ConnectionFactory;
import br.com.eventosbook.modelo.Endereco;

public class DaoEnderecoImpl implements DaoEndereco {

	@Override
	public void incluir(Endereco pEndereco) {
		// TODO Auto-generated method stub

	}

	@Override
	public void alterar(Endereco pEndereco) {
		// TODO Auto-generated method stub

	}

	@Override
	public void excluir(Endereco pEndereco) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Endereco> consultar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Endereco getEndereco(Endereco pEndereco) {
		Endereco retorno = new Endereco();

		try{

			if(pEndereco !=null){

				String sql = "FROM " + Constantes.PATH_PROJECT + ".modelo.Endereco WHERE 1=1";

				if(pEndereco.getCodigo() != null){
					sql += " AND id_endereco =:id";
				}



				TypedQuery<Endereco> q = ConnectionFactory.getInstace().getConnection().createQuery(sql, Endereco.class);

				if(pEndereco.getCodigo() != null){
					q.setParameter("id", pEndereco.getCodigo());
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
