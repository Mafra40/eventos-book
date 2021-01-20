package br.com.eventosbook.modelo;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;


@Entity
@Table(name="usuario", schema="eventosbook")
@SequenceGenerator(name = "eventosbook.sequencia_usuario", sequenceName="eventosbook.sequencia_usuario")
public class Usuario{
	
	/*Nome Entidade*/
	public static final String NM_ENTIDADE = "usuario";
	public static final String NM_SCHEMA_ENTIDADE = "eventosbook.usuario";
	
	/*Nm Colunas*/
	public static final String NM_COL_CODIGO = "id_usuario";
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator = "eventosbook.sequencia_usuario")
	@Column(name="id_usuario")
	private Integer codigo;

	@Column(name="email", unique = true, nullable = false)
	private String email;
	
	@Column(name="senha", nullable = false)
	private String senha;
	
	@Transient
	private String novaSenha;
	
	@Transient
	private String palavraPasse;
	
	@ManyToOne
	@JoinColumn(name="fk_situacao")
	private Situacao situacao;
	
	@ManyToOne
	@JoinColumn(name="fk_tipo_usuario")
	private TipoUsuario tipoUsuario;
	
	@Column(name="data_criacao")
	@Temporal(TemporalType.DATE)
	private Calendar dataCricacao;
	
	@Column(name="data_ult_acesso", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataUltimaAutenticacao;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="fk_usuario" , insertable=true, updatable=true, nullable = false)
	private List<Endereco> colecaoEndereco;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_usuario" , insertable=true, updatable=true, nullable = false)
	private List<Telefone> colecaoTelefone;
	
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		if (email != null){
		this.email = email.toLowerCase();
		}
	}
	
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	
	public Situacao getSituacao() {
		return situacao;
	}
	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}
	
	public Calendar getDataCricacao() {
		return dataCricacao;
	}
	public void setDataCricacao(Calendar dataCricacao) {
		this.dataCricacao = dataCricacao;
	}

	public Calendar getDataUltimaAutenticacao() {
		return dataUltimaAutenticacao;
	}
	public void setDataUltimaAutenticacao(Calendar dataUltimaAutenticacao){
		this.dataUltimaAutenticacao = dataUltimaAutenticacao;
	}
	
	public List<Endereco> getColecaoEndereco() {
		return colecaoEndereco;
	}
	public void setColecaoEndereco(List<Endereco> colecaoEndereco) {
		this.colecaoEndereco = colecaoEndereco;
	}
	public List<Telefone> getColecaoTelefone() {
		return colecaoTelefone;
	}
	public void setColecaoTelefone(List<Telefone> colecaoTelefone) {
		this.colecaoTelefone = colecaoTelefone;
	}
	public String getNovaSenha() {
		return novaSenha;
	}
	public void setNovaSenha(String novaSenha) {
		this.novaSenha = novaSenha;
	}
	
	public String getPalavraPasse() {
		return palavraPasse;
	}
	public void setPalavraPasse(String palavraPasse) {
		this.palavraPasse = palavraPasse;
	}


}
