package br.com.eventosbook.pojo;


public class FormularioFornecedor extends Formulario {
	
	public FormularioFornecedor() {
		super();
	}
	
	private String idFornecedor;
	private Integer idCategoria;
	private Integer idSubCategoria;
	private String numeroDocumento;
	private String horarioAtendimento;
	private String descricao;
	private String categoria;
	private String subCategoria;
	private String sobre;
	
	
	
	public String getNumeroDocumento() {
		return numeroDocumento;
	}
	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	public String getHorarioAtendimento() {
		return horarioAtendimento;
	}
	public void setHorarioAtendimento(String horarioAtendimento) {
		this.horarioAtendimento = horarioAtendimento;
	}
	public String getSobre() {
		return sobre;
	}
	public void setSobre(String sobre) {
		this.sobre = sobre;
	}
	public String getIdFornecedor() {
		return idFornecedor;
	}
	public void setIdFornecedor(String idFornecedor) {
		this.idFornecedor = idFornecedor;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getSubCategoria() {
		return subCategoria;
	}
	public void setSubCategoria(String subCategoria) {
		this.subCategoria = subCategoria;
	}
	public Integer getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}
	public Integer getIdSubCategoria() {
		return idSubCategoria;
	}
	public void setIdSubCategoria(Integer idSubCategoria) {
		this.idSubCategoria = idSubCategoria;
	}

	
	
	
}
