package br.com.eventosbook.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="situacao", schema="eventosbook")
@SequenceGenerator(name = "eventosbook.sequencia_situacao", sequenceName="eventosbook.sequencia_situacao")
public class Situacao {
	
	
	public Situacao() {
		
	}
	public Situacao(String pSigla) {
		this.sigla = pSigla;
	}
	
	public Situacao(Integer pCodigo) {
		this.codigo = pCodigo;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator = "eventosbook.sequencia_situacao")
	@Column(name="id_situacao")
	private Integer codigo;
	
	@Column(name="descricao", nullable = false, unique = true)
	private String descricao;
	
	@Column(name="sigla", nullable = false, unique = true)
	private String sigla;

	
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
		this.sigla = sigla;
	}
	
	

}
