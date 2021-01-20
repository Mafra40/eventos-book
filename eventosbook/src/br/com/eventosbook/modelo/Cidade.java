
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

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name="cidade", schema="eventosbook")
@SequenceGenerator(name = "eventosbook.sequencia_cidade", sequenceName="eventosbook.sequencia_cidade")
public class Cidade {
	
	/*Nome Entidade*/
	public static final String NM_ENTIDADE = "cidade";
	public static final String NM_SCHEMA_ENTIDADE = "eventosbook.cidade";
	
	/*Nm Colunas*/
	public static final String NM_COL_CODIGO = "id_cidade";
	public static final String NM_COL_DESCRICAO = "descricao";
	
	
	@JsonIgnore
	public Cidade(){
		
	}
	
	@JsonIgnore
	public  Cidade(Integer cdCidade) {
		this.codigo = cdCidade;
	}
	@Id
	@Column(name="id_cidade")
	@GeneratedValue(strategy = GenerationType.AUTO, generator="eventosbook.sequencia_cidade")
	private Integer codigo;
	
	@Column(name="descricao", nullable = false)
	private String descricao;
	
	@OneToOne
	@JoinColumn(name="fk_estado")
	private Estado estado;
	
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
	
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
}
