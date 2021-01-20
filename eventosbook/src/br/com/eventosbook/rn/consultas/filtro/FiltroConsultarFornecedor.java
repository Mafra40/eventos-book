package br.com.eventosbook.rn.consultas.filtro;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import br.com.eventosbook.modelo.Cidade;
import br.com.eventosbook.modelo.Endereco;
import br.com.eventosbook.modelo.Fornecedor;
import br.com.eventosbook.modelo.Imagem;

/**
 * 
 * @author Mafra
 * @see br.com.eventosbook.rn.consultas.ConsultarFornecedor
 */

@Entity
public class FiltroConsultarFornecedor {
	
	/**Atributos de Filtro**/
	
	@Id
	@Column(name=Fornecedor.NM_COL_CODIGO)
	private Integer codigoFornecedor;
	@Transient
	private boolean isCodigoFornecedorAlterado;
	@Column(name=Fornecedor.NM_COL_HORARIO)
	private String horario;
	@Transient
	private boolean isHorarioAlterado;
	@Column(name=Fornecedor.NM_COL_NOME)
	private String nomeFornecedor;
	@Transient
	private boolean isNomeFornecedorAlterado;
	@Column(name=Fornecedor.NM_COL_NUMERO_DOCUMENTO)
	private String numeroDoc;
	@Transient
	private boolean isNumeroDocAlterado;
	@Column(name=Fornecedor.NM_COL_FK_USUARIO)
	private Integer fkUsuario;
	@Transient
	private boolean isFkUsuarioAlterado;
	
	@Column(name=Endereco.NM_COL_BAIRRO)
	private String bairro;
	@Transient
	private boolean isBairroAlterado;
	
	@Column(name=Cidade.NM_COL_DESCRICAO)
	private String cidade;
	@Transient
	private boolean isCidadeAlterado;
	
	@Column(name=Imagem.NM_COL_CAMINHO)
	private String imagem;
	@Transient
	private boolean isImagemAlterado;
	
	@Transient
	private Integer cdCategoria;
	@Transient
	private boolean isCategoriaAlterado;
	
	
	@Transient
	private Integer totalAvaliacao;
	@Column(name=Fornecedor.NM_COL_NOTA)
	private Double notaFinal;
	@Transient
	private String notaFinalHtml;
	@Transient
	private Date dtUltAvaliacao;
	
	
	/*Ordenação*/
	@Transient
	private String ordenacao;
	@Transient
	private boolean isOrdenacaoAlterado;
	
	public Integer getCdCategoria() {
		return cdCategoria;
	}
	public void setCdCategoria(Integer pCdCategoria) {
		this.isCategoriaAlterado = true;
		this.cdCategoria = pCdCategoria;
	}
	public boolean isCategoriaAlterado() {
		return isCategoriaAlterado;
	}
	
	public String getOrdenacao() {
		return ordenacao;
	}
	public void setOrdenacao(String ordenacao) {
		this.ordenacao = ordenacao;
		this.isOrdenacaoAlterado = true;
	}
	public boolean isOrdenacaoAlterado() {
		return isOrdenacaoAlterado;
	}
	public void setOrdenacaoAlterado(boolean isOrdenacaoAlterado) {
		this.isOrdenacaoAlterado = isOrdenacaoAlterado;
	}
	public Integer getCodigoFornecedor() {
		return codigoFornecedor;
	}
	public void setCodigoFornecedor(Integer codigoFornecedor) {
		this.codigoFornecedor = codigoFornecedor;
	}
	public boolean isCodigoFornecedorAlterado() {
		return isCodigoFornecedorAlterado;
	}
	public void setCodigoFornecedorAlterado(boolean isCodigoFornecedorAlterado) {
		this.isCodigoFornecedorAlterado = isCodigoFornecedorAlterado;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	public boolean isHorarioAlterado() {
		return isHorarioAlterado;
	}
	public void setHorarioAlterado(boolean isHorarioAlterado) {
		this.isHorarioAlterado = isHorarioAlterado;
	}
	public String getNomeFornecedor() {
		return nomeFornecedor;
	}
	public void setNomeFornecedor(String nomeFornecedor) {
		this.nomeFornecedor = nomeFornecedor;
	}
	public boolean isNomeFornecedorAlterado() {
		return isNomeFornecedorAlterado;
	}
	public void setNomeFornecedorAlterado(boolean isNomeFornecedorAlterado) {
		this.isNomeFornecedorAlterado = isNomeFornecedorAlterado;
	}
	public String getNumeroDoc() {
		return numeroDoc;
	}
	public void setNumeroDoc(String numeroDoc) {
		this.numeroDoc = numeroDoc;
	}
	public boolean isNumeroDocAlterado() {
		return isNumeroDocAlterado;
	}
	public void setNumeroDocAlterado(boolean isNumeroDocAlterado) {
		this.isNumeroDocAlterado = isNumeroDocAlterado;
	}
	public Integer getFkUsuario() {
		return fkUsuario;
	}
	public void setFkUsuario(Integer fkUsuario) {
		this.fkUsuario = fkUsuario;
	}
	public boolean isFkUsuarioAlterado() {
		return isFkUsuarioAlterado;
	}
	public void setFkUsuarioAlterado(boolean isFkUsuarioAlterado) {
		this.isFkUsuarioAlterado = isFkUsuarioAlterado;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public boolean isBairroAlterado() {
		return isBairroAlterado;
	}
	public void setBairroAlterado(boolean isBairroAlterado) {
		this.isBairroAlterado = isBairroAlterado;
	}
	public void setCategoriaAlterado(boolean isCategoriaAlterado) {
		this.isCategoriaAlterado = isCategoriaAlterado;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getImagem() {
		return imagem;
	}
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	public Integer getTotalAvaliacao() {
		return totalAvaliacao;
	}
	public void setTotalAvaliacao(Integer totalAvaliacao) {
		this.totalAvaliacao = totalAvaliacao;
	}
	public Double getNotaFinal() {
		return notaFinal;
	}
	public void setNotaFinal(Double notaFinal) {
		this.notaFinal = notaFinal;
	}
	public Date getDtUltAvaliacao() {
		return dtUltAvaliacao;
	}
	public void setDtUltAvaliacao(Date dtUltAvaliacao) {
		this.dtUltAvaliacao = dtUltAvaliacao;
	}
	public String getNotaFinalHtml() {
		return notaFinalHtml;
	}
	public void setNotaFinalHtml(String notaFinalHtml) {
		this.notaFinalHtml = notaFinalHtml;
	}
	
	
	
	
	
	
	
	
	
}
