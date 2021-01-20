package br.com.eventosbook.rn.consultas.filtro;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**Classe de consulta que retorna uma lista de comentários relacionadas ao fornecedor.
 * 
 * @author rodrigo.leite
 *@see br.com.eventosbook.rn.consultas.ConsultarAvaliacaoComentFornecedor
 */


@Entity
		
public class FiltroConsultarAvaliacaoComentFornecedor {
	/**Atributos de Filtro**/
	@Id
	@Column(name="id_comentario")
	private Integer cdComentario;
	@Transient
	private Integer codigoFornecedor;
	@Transient
	private boolean isCdFornecedorAlterado;
	
	@Column(name="fk_tipo_comentario")
	private Integer tipoComentario;
	
	@Column(name="descricao")
	private String descricao;

	@Column(name="data_avaliacao")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataAvaliacao;
	
	@Column(name="id_avaliacao")
	private Integer cdAvaliacao;
	
	@Column(name="nome")
	private String nomeContratante;
	
	@Column(name="nota")
	private Double nota;
	
	@Transient
	private String limit;
	@Transient
	private boolean isLimitAlterado;
	
	@Transient
	private boolean count;
	@Transient
	private boolean isCountAlterado;
	
	/**Get e Set**/
	public Integer getCodigoFornecedor() {
		return codigoFornecedor;
	}
	public void setCodigoFornecedor(Integer pCodigoFornecedor) {
		this.setCdFornecedorAlterado(true);
		this.codigoFornecedor = pCodigoFornecedor;
		
	}
	public boolean isCdFornecedorAlterado() {
		return isCdFornecedorAlterado;
	}
	public void setCdFornecedorAlterado(boolean pBoleano) {
		this.isCdFornecedorAlterado = pBoleano;
	}
	public Integer getTipoComentario() {
		return tipoComentario;
	}
	public void setTipoComentario(Integer tipoComentario) {
		this.tipoComentario = tipoComentario;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Date getDataAvaliacao() {
		return dataAvaliacao;
	}
	public void setDataAvaliacao(Date dataAvaliacao) {
		this.dataAvaliacao = dataAvaliacao;
	}
	public String getNomeContratante() {
		return nomeContratante;
	}
	public void setNomeContratante(String nomeContratante) {
		this.nomeContratante = nomeContratante;
	}
	public Integer getCdComentario() {
		return cdComentario;
	}
	public void setCdComentario(Integer cdComentario) {
		this.cdComentario = cdComentario;
	}
	public Integer getCdAvaliacao() {
		return cdAvaliacao;
	}
	public void setCdAvaliacao(Integer cdAvaliacao) {
		this.cdAvaliacao = cdAvaliacao;
	}
	public Double getNota() {
		return nota;
	}
	public void setNota(Double nota) {
		this.nota = nota;
	}
	public String getLimit() {
		return limit;
	}
	public void setLimit(String limit) {
		this.setLimitAlterado(true);
		this.limit = limit;
	}
	public boolean isLimitAlterado() {
		return isLimitAlterado;
	}
	public void setLimitAlterado(boolean isLimitAlterado) {
		this.isLimitAlterado = isLimitAlterado;
	}
	public boolean isCount() {
		return count;
	}
	public void setCount(boolean count) {
		this.count = count;
	}
	public boolean isCountAlterado() {
		return isCountAlterado;
	}
	public void setCountAlterado(boolean isCountAlterado) {
		this.isCountAlterado = isCountAlterado;
	}
	
	
	
	
}
