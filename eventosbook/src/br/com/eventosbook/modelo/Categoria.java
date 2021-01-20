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

/**Entidade de categoria dos fornecedores.
 * 
 * @author rodrigo.leite
 *
 */

@Entity
@Table(name="categoria", schema="eventosbook")
@SequenceGenerator(name = "eventosbook.sequencia_categoria", sequenceName="eventosbook.sequencia_categoria")
public class Categoria {
	
	/**Paramentros de entidade **/
	public static final String NM_SCHEMA_ENTIDADE = "eventosbook.categoria";
	public static final String NM_ENTIDADE_FC = "fornecedor_categoria";
	public static final String NM_SCHEMA_ENTIDADE_FC = "eventosbook.fornecedor_categoria";
	public static final String NM_COL_CODIGO = "id_categoria";
	public static final String NM_COL_FC_FK_CATEGORIA = "fk_categoria";
	
	public Categoria(){
		
	}
	
	public Categoria(Integer pCodigo) {
		this.codigo = pCodigo; 
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="eventosbook.sequencia_categoria")
	@Column(name = "id_categoria")
	private Integer codigo;
	
	@Column(name="descricao", nullable = false, unique = true)
	private String descricao;
	
	@OneToMany
	@JoinColumn(name = "fk_categoria")
	private List<SubCategoria> colecaoSubCategoria;

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

	public List<SubCategoria> getColecaoSubCategoria() {
		return colecaoSubCategoria;
	}

	public void setColecaoSubCategoria(List<SubCategoria> colecaoSubCategoria) {
		this.colecaoSubCategoria = colecaoSubCategoria;
	}
	
	
	
}
