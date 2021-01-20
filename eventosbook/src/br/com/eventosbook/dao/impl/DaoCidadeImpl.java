package br.com.eventosbook.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import br.com.eventosbook.constante.Constantes;
import br.com.eventosbook.dao.DaoCidade;
import br.com.eventosbook.hibernate.util.ConnectionFactory;
import br.com.eventosbook.modelo.Cidade;

public class DaoCidadeImpl implements DaoCidade{
	
	public static final String order_by = "order by descricao asc";
	
	private DaoCidadeImpl() {}
	private static DaoCidadeImpl aDAOContratante = new DaoCidadeImpl();

	public static DaoCidadeImpl getInstance(){
		if(DaoCidadeImpl.aDAOContratante == null){
			DaoCidadeImpl.aDAOContratante = new DaoCidadeImpl();
		}
		
		return DaoCidadeImpl.aDAOContratante;
	}
	
	@Override
	public void incluir(Cidade pCidade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterar(Cidade pCidade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir(Cidade pCidade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Cidade> consultar() {
		List<Cidade> retorno = new ArrayList<Cidade>();
		try {
			
			String sql = "FROM " + Constantes.PATH_PROJECT + ".modelo.Cidade ";
			
			sql = sql + order_by;
			
			TypedQuery<Cidade> q = ConnectionFactory.getInstace().getConnection().createQuery(sql, Cidade.class);
			retorno = q.getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
			retorno = null;
		}
		
		return retorno;
	}

	@Override
	public Cidade getCidade(Cidade pCidade) {
		// TODO Auto-generated method stub
		return null;
	}

}
