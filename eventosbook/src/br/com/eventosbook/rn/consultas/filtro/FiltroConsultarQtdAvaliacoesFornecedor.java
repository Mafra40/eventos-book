package br.com.eventosbook.rn.consultas.filtro;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import br.com.eventosbook.modelo.Avaliacao;


/**Filtro que retorna a quantidade total de avaliações de cada fornecedor
 * 
 * @author rodrigo.leite
 *@see br.com.eventosbook.rn.consultas.ConsultarQtdAvaliacoesFornecedor
 */

@Entity
public class FiltroConsultarQtdAvaliacoesFornecedor {
	
	@Id
	@Column(name=Avaliacao.NM_COL_CODIGO)
	private Integer cdAvaliacao;
	
	
	@Transient
	private Integer cdFornecedor;
	@Transient
	private boolean isCdFornecedorAlterado = false;
	
	@Transient
	private Integer aTotal;

	public Integer getCdAvaliacao() {
		return cdAvaliacao;
	}

	public void setCdAvaliacao(Integer cdAvaliacao) {
		this.cdAvaliacao = cdAvaliacao;
	}

	public Integer getaTotal() {
		return aTotal;
	}

	public void setaTotal(Integer aTotal) {
		this.aTotal = aTotal;
	}

	public Integer getCdFornecedor() {
		return cdFornecedor;
	}

	public void setCdFornecedor(Integer cdFornecedor) {
		this.cdFornecedor = cdFornecedor;
		this.setCdFornecedorAlterado(true);
	}

	public boolean isCdFornecedorAlterado() {
		return isCdFornecedorAlterado;
	}

	public void setCdFornecedorAlterado(boolean isCdFornecedorAlterado) {
		this.isCdFornecedorAlterado = isCdFornecedorAlterado;
	}
	
	
	
}
