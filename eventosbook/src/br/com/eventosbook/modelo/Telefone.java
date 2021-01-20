package br.com.eventosbook.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="telefone", schema="eventosbook")
@SequenceGenerator(name = "eventosbook.sequencia_telefone", sequenceName="eventosbook.sequencia_telefone")
public class Telefone {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="eventosbook.sequencia_telefone")
	@Column(name="id_telefone")
	private Integer codigo;
	
	
	@Column(name="telefone")
	private String telefone;
	
	@Column(name="contato")
	private String contato;
	
	
	@OneToOne()
	@JoinColumn(name="fk_usuario", insertable=false, updatable=false)
	private Usuario usuario;
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getContato() {
		return contato;
	}
	public void setContato(String contato) {
		this.contato = contato;
	}
	
	public Usuario getUsuario() {
				return usuario;
			}
	
	public void setUsuario(Usuario usuario) {
				this.usuario = usuario;
			}
	
	

}
