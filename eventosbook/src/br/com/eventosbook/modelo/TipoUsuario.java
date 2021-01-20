package br.com.eventosbook.modelo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tipo_usuario", schema="eventosbook")
@SequenceGenerator(name = "eventosbook.sequencia_tipo_usuario", sequenceName="eventosbook.sequencia_tipo_usuario")
public class TipoUsuario {
	public TipoUsuario() {
		
	}
	public TipoUsuario(Character pSigla) {
		this.sigla = pSigla;
	}
	
	@Id
	@Column(name="id_tipo_usuario")

	@GeneratedValue(strategy=GenerationType.AUTO, generator = "eventosbook.sequencia_tipo_usuario")

	private Integer codigo;
	
	@Column(name="descricao", nullable = false, unique = true)
	private String descricao;
	
	@Column(name = "sigla", nullable = false, unique = true)
	private Character sigla;
	
	@ManyToMany
	@JoinTable(name = "eventosbook.usuario_funcao", joinColumns = {@JoinColumn(name = "fk_tipo_usuario")}, 
										 inverseJoinColumns={@JoinColumn(name="fk_funcao_sistema")}
	)
	private List<FuncaoSistema> colecaoFuncaoSistema;
	

	public List<FuncaoSistema> getColecaoFuncaoSistema() {
		return colecaoFuncaoSistema;
	}
	public void setColecaoFuncaoSistema(List<FuncaoSistema> colecaoFuncaoSistema) {
		this.colecaoFuncaoSistema = colecaoFuncaoSistema;
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
	
	public Character getSigla() {
		return sigla;
	}
	public void setSigla(Character sigla) {
		this.sigla = sigla;
	}

}
