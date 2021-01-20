package br.com.eventosbook.modelo;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity

@Table(name="contratante", schema="eventosbook")
@SequenceGenerator(name = "eventosbook.sequencia_contratante", sequenceName="eventosbook.sequencia_contratante")
public class Contratante {
	
	/*Nome Entidade*/
	public static final String NM_ENT_CONTRATANTE = "contratante";
	public static final String NM_SCHEMA_ENTIDADE = "eventosbook.contratante";

	/*Colunas*/
	public static final String NM_COL_CODIGO = "id_contratante";
	public static final String NM_COL_NOME = "nome";
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "eventosbook.sequencia_contratante")
	@Column(name=NM_COL_CODIGO)
	private Integer codigo;
	
	@Column(name=NM_COL_NOME, nullable = false)
	private String nome;
	
	
	@Column(name="sexo" ,  nullable = true)
	private String sexo;
	
	@Temporal(TemporalType.DATE)
	@Column(name="data_nascimento")
	private Calendar dataNascimento;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="fk_usuario", nullable = false)
	private Usuario usuario;
	
	@Column(name="cpf", unique = true)
	private String cpf;	

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome.toUpperCase();
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo.toUpperCase();
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	

}
