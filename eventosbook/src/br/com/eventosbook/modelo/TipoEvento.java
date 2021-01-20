package br.com.eventosbook.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tipo_evento", schema="eventosbook")
@SequenceGenerator(name = "eventosbook.sequencia_tipo_evento", sequenceName="eventosbook.sequencia_tipo_evento")
public class TipoEvento {
	
	/*Nome Entidade*/
	public static final String NM_ENTIDADE = "tipo_evento";
	public static final String NM_SCHEMA_ENTIDADE = "eventosbook.tipo_evento";
	

	/*Nm Colunas*/
	public static final String NM_COL_CODIGO = "id_tipo_evento";
	
	public TipoEvento() {
		
	}
	
	public TipoEvento(int pCodigo) {
		this.codigo = pCodigo;
	}
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator= "eventosbook.sequencia_tipo_evento")
	@Column(name = NM_COL_CODIGO)
	private Integer codigo;
	
	@Column(name = "descricao", nullable = false, unique = true)
	private String descricao;
	
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
}
