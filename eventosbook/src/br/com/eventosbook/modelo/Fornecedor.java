package br.com.eventosbook.modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name="fornecedor", schema="eventosbook")
@SequenceGenerator(name = "eventosbook.sequencia_fornecedor", sequenceName="eventosbook.sequencia_fornecedor")
public class Fornecedor{
	
	/*Nome Entidade*/
	public static final String NM_ENTIDADE = "fornecedor";
	public static final String NM_SCHEMA_ENTIDADE = "eventosbook.fornecedor";
	
	/*Nm Colunas*/
	public static final String NM_COL_CODIGO = "id_fornecedor";
	public static final String NM_COL_DESCRICAO = "descricao";
	public static final String NM_COL_NOME = "nome";
	public static final String NM_COL_NUMERO_DOCUMENTO = "numero_documento";
	public static final String NM_COL_HORARIO = "horario_atendimento";
	public static final String NM_COL_FK_USUARIO = "fk_usuario";
	public static final String NM_COL_FK_CATEGORIA = "fk_categoria";
	public static final String NM_COL_NOTA = "nota";
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator ="eventosbook.sequencia_fornecedor")
	@Column(name = NM_COL_CODIGO)
	private Integer codigo;
	
	@Column(name=NM_COL_NOME, nullable = false)
	private String nome;
	
	@Column(name=NM_COL_NUMERO_DOCUMENTO, unique = true, nullable = false)
	private String numeroDocumento;
	
	@Column(name=NM_COL_DESCRICAO , length=1000)
	private String descricao;
	
	@Column(name=NM_COL_HORARIO)
	private String horarioAtendimento;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = NM_COL_FK_USUARIO, nullable = false)
	private Usuario usuario;
	
	@ManyToMany
	@JoinTable(name = "eventosbook.fornecedor_categoria", joinColumns = {@JoinColumn(name="fk_fornecedor" , insertable=true, updatable=true) }, inverseJoinColumns = {@JoinColumn(name = "fk_categoria")})
	private List<Categoria>categoria;

	@Column(name=NM_COL_NOTA)	
	private Double nota;

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
		this.nome = nome;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getHorarioAtendimento() {
		return horarioAtendimento;
	}

	public void setHorarioAtendimento(String horarioAtendimento) {
		this.horarioAtendimento = horarioAtendimento;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Categoria> getCategoria() {
		return categoria;
	}

	public void setCategoria(List<Categoria> categoria) {
		this.categoria = categoria;
	}

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}

	
	
	
	
	
	

}
