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
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
/**
 * @author Andre
 * Entidade refenrente aos ITENS da Categoria ou SubCategoria
 */
@Entity
@Table(name="item", schema="eventosbook")
@SequenceGenerator(name = "eventosbook.sequencia_item", sequenceName="eventosbook.sequencia_item")
public class Item {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="eventosbook.sequencia_item")
	@Column(name="id_item")
	private Integer codigo;
	
	@Column(name = "descricao", nullable = false)
	private String descricao;
	
	@ManyToMany
	@JoinTable(schema = "eventosbook", name = "item_tipo_evento", joinColumns = {@JoinColumn(name="fk_item")}, 
													inverseJoinColumns = {@JoinColumn(name = "fk_tipo_evento")})
	private List<TipoEvento> colecaoTipoEvento;
	
	@ManyToOne
	@JoinColumn(name = "fk_categoria")
	private Categoria categoria;
	
	@ManyToOne
	@JoinColumn(name = "fk_subcategoria")
	private SubCategoria subCategoria;
	
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

	public List<TipoEvento> getColecaoTipoEvento() {
		return colecaoTipoEvento;
	}

	public void setColecaoTipoEvento(List<TipoEvento> colecaoTipoEvento) {
		this.colecaoTipoEvento = colecaoTipoEvento;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public SubCategoria getSubCategoria() {
		return subCategoria;
	}

	public void setSubCategoria(SubCategoria subCategoria) {
		this.subCategoria = subCategoria;
	}
	
	

}
