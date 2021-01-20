package br.com.eventosbook.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="funcao_sistema", schema="eventosbook")
@SequenceGenerator(name = "eventosbook.sequencia_funcao_sistema", sequenceName="eventosbook.sequencia_funcao_sistema")
public class FuncaoSistema {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="eventosbook.sequencia_funcao_sistema")
	@Column(name="id_funcao_sistema")
	private Integer codigo;
	
	@Column(name = "descricao", unique = true, nullable = false)
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
