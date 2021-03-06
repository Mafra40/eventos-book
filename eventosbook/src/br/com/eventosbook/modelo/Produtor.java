package br.com.eventosbook.modelo;

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

@Entity
@Table(name="produtor", schema="eventosbook")
@SequenceGenerator(name = "eventosbook.sequencia_produtor", sequenceName="eventosbook.sequencia_produtor")
public class Produtor{
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="eventosbook.sequencia_produtor")
	@Column(name = "id_produtor")
	private Integer codigo;
	
	@Column(name="nome", nullable = false)
	private String nome;
	
	@Column(name="numero_documento", unique = true, nullable = false)
	private String numeroDocumento;
	
	@Column(name="descricao")
	private String descricao;
	
	@Column(name="horario_atendimento")
	private String horarioAtendimento;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_usuario", nullable = false)
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "fk_categoria", nullable = false)
	private Categoria categoria;

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

	public Categoria getCategoriaFornecedor() {
		return categoria;
	}

	public void setCategoriaFornecedor(Categoria categoria) {
		this.categoria= categoria;
	}
	
	
	
	
	


}
