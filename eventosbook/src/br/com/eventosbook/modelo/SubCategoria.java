package br.com.eventosbook.modelo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "subcategoria",  schema="eventosbook")
@SequenceGenerator(name = "eventosbook.sequencia_subcategoria", sequenceName="eventosbook.sequencia_subcategoria")
public class SubCategoria {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator = "eventosbook.sequencia_subcategoria")
	@Column(name = "id_subcategoria")
	private Integer codigo;
	
	@Column(name = "descricao", unique = true)
	private String descricao;
	
	@OneToMany
	@JoinColumn(name = "fk_subcategoria")
	private List<Item> colecaoItem;

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

	public List<Item> getColecaoItem() {
		return colecaoItem;
	}

	public void setColecaoItem(List<Item> colecaoItem) {
		this.colecaoItem = colecaoItem;
	}
	
	


}
