package br.com.eventosbook.modelo;

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
@Table(name="imagens", schema="eventosbook")
@SequenceGenerator(name = "eventosbook.sequencia_imagens", sequenceName="eventosbook.sequencia_imagens")
public class Imagem {

	/*Nome Entidade*/
	public static final String NM_ENTIDADE = "imagens";
	public static final String NM_SCHEMA_ENTIDADE = "eventosbook.imagens";
	
	/*Nm Colunas*/
	public static final String NM_COL_CODIGO = "id_imagens";
	public static final String NM_COL_CAMINHO = "caminho";
	public static final String NM_COL_FK_USUARIO = "fk_usuario";
	public static final String NM_COL_IMAGEM_PRINCIPAL = "imagem_principal";
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="eventosbook.sequencia_imagens")
	@Column(name="id_imagens")
	private Integer codigo;
	
	
	@Column(name="titulo")
	private String titulo;
	
	@Column(name="caminho")
	private String caminho;
	
	@Column(name="imagem_principal")
	private String imagemPrincipal;
	
	@ManyToOne()
	@JoinColumn(name = "fk_usuario", nullable = false)
	private Usuario usuario;
	
	
	

	public Imagem() {
		super();
	}


	public Imagem(Usuario usuario) {
		super();
		this.usuario = usuario;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getCaminho() {
		return caminho;
	}

	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}

	public String getImagem_principal() {
		return imagemPrincipal;
	}

	public void setImagemPrincipal(String pImagemPrincipal) {
		this.imagemPrincipal = pImagemPrincipal;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
	
}
