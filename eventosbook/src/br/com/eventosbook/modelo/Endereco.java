package br.com.eventosbook.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="endereco", schema="eventosbook")
@SequenceGenerator(name = "eventosbook.sequencia_endereco", sequenceName="eventosbook.sequencia_endereco")
public class Endereco {
	
	
	/*Nome Entidade*/
	public static final String NM_ENTIDADE = "endereco";
	public static final String NM_SCHEMA_ENTIDADE = "eventosbook.endereco";
	
	/*Nm Colunas*/
	public static final String NM_COL_CODIGO = "id_endereco";
	public static final String NM_COL_BAIRRO = "bairro";
	public static final String NM_COL_FK_USUARIO = "fk_usuario";
	public static final String NM_COL_FK_CIDADE = "fk_cidade";
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="eventosbook.sequencia_endereco")
	@Column(name="id_endereco")
	private Integer codigo;
	
	@Column(name="descricao")
	private String descricao;
	
	@Column(name="numero")
	private String numero;
	
	@Column(name="cep")
	private String cep;
	
	@Column(name="complemento")
	private String complemento;
	
	@Column(name="logradouro")
	private String logradouro;
	
	@Column(name="bairro")
	private String bairro;
	
	@OneToOne
	@JoinColumn(name="fk_cidade")
	private Cidade cidade;
	
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	
	
	
	
	

}
