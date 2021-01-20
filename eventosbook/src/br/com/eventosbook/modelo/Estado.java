package br.com.eventosbook.modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name="estado", schema="eventosbook")
@SequenceGenerator(name = "eventosbook.sequencia_estado", sequenceName="eventosbook.sequencia_estado")
public class Estado {
	public Estado(){

	}

	public Estado(Integer cdEstado) {
		this.codigo = cdEstado;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "eventosbook.sequencia_estado")
	@Column(name="id_estado")
	private Integer codigo;
	
	@Column(name="descricao", unique = true, nullable = false)
	private String descricao;
	
	@Column(name="sigla", length = 2, unique = true, nullable = false)
	private String sigla;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_estado")
	private List<Cidade> colecaoCidade;
	
	@JsonIgnore
	public List<Cidade> getColecaoCidade() {
		return colecaoCidade;
	}
	@JsonIgnore
	public void setColecaoCidade(List<Cidade> colecaoCidade) {
		this.colecaoCidade = colecaoCidade;
	}
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
		this.descricao = descricao.toUpperCase();
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla.toUpperCase();
	}
	
}
