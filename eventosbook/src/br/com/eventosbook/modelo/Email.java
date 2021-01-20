package br.com.eventosbook.modelo;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="email", schema="eventosbook")
@SequenceGenerator(name = "eventosbook.sequencia_email", sequenceName="eventosbook.sequencia_email")
public class Email {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator = "eventosbook.sequencia_email")
	@Column(name="id_email")
	private Integer codigo;
	
	
	@Column(name = "ativo", nullable = false)
	private Character ativo;
	
	@Column(name="chave", nullable = false)
	private String chave;
	
	@Column(name="data_criacao", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataCriacao;
	
	@OneToOne
	@JoinColumn(name = "fk_usuario")
	private Usuario usuario;


	public Integer getCodigo() {
		return codigo;
	}


	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}


	public String getChave() {
		return chave;
	}


	public void setChave(String chave) {
		this.chave = chave;
	}


	public Calendar getDataCriacao() {
		return dataCriacao;
	}


	public void setDataCriacao(Calendar dataCriacao) {
		this.dataCriacao = dataCriacao;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public Character getAtivo() {
		return ativo;
	}


	public void setAtivo(Character ativo) {
		this.ativo = ativo;
	}
	

	
}
