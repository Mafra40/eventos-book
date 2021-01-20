package br.com.eventosbook.rn.consultas.filtro;

import java.util.Date;

/**
 * 
 * @author rodrigo.leite
 * @see br.com.eventosbook.rn.consultas.ConsultarMeuFornecedorPorContratante
 */
public class FiltroConsultarMeuFornecedorPorContratante {
	
	
	
	
	/**Atributos de Filtro**/
	public Integer codigoMeuFornecedor;
	public boolean isCodigoMeuFornecedorAlterado;
	
	public Integer codigoFornecedor;
	public boolean isCodigoFornecedorAlterado;
	
	public Integer codigoEvento;
	public String isCodigoEventoAlterado;
	
	public Date dataEvento;
	public boolean isDataEventoAlterado;
	
	public String descricaoEvento;
	public boolean isDescricaoEventoAlterado;
	
	public String descricaoTipoEvento;
	public boolean isDescricaoTipoEventoAlterado;
	
	public String nomeContratante;
	public boolean isDescricaoContratanteAlterado;
	
	public String nomeFornecedor;
	public boolean isNomeFornecedorAlterado;
	

	public Integer codigoContratante;
	public boolean isCodigoContratanteAlterado;
	
	public boolean isAvaliacaoNotNullAlterado;
	/**
	 * 
	 * @return
	 */
	public boolean isCodigoContratanteAlterado() {
		return isCodigoContratanteAlterado;
	}
	
	
	/**
	 * 
	 * @return
	 */
	public Integer getCodigoContratante() {
		return codigoContratante;
	}
	
	/**
	 * 
	 * @param codigoContratante
	 */
	public void setCodigoContratante(Integer codigoContratante) {
		this.isCodigoContratanteAlterado = true;
		this.codigoContratante = codigoContratante;
	}


	public boolean isAvaliacaoNotNullAlterado() {
		return isAvaliacaoNotNullAlterado;
	}


	public void setAvaliacaoNotNullAlterado(boolean isAvaliacaoNotNullAlterado) {
		this.isAvaliacaoNotNullAlterado = isAvaliacaoNotNullAlterado;
	}
	
	
	

	

}
