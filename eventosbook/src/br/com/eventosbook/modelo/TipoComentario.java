package br.com.eventosbook.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="tipo_comentario", schema="eventosbook")
@SequenceGenerator(name = "eventosbook.tipo_comentario", sequenceName="eventosbook.tipo_comentario")
public class TipoComentario {
	
	/**Paramentros de entidade **/
	public static final String NM_ENTIDADE = "tipo_comentario";
	public static final String NM_SCHEMA_ENTIDADE = "eventosbook.tipo_comentario";
	
	public static final String NM_COL_CODIGO = "id_tipo_comentario";
	public static final String NM_COL_DESCRICAO = "descricao";
	public static final String NM_COL_SIGLAO = "sigla";
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "eventosbook.tipo_comentario")
	@Column(name = NM_COL_CODIGO)
	private Integer codigo;
	
	@Column(name = NM_COL_DESCRICAO)
	private String descricao; 
	
	@Column(name = NM_COL_SIGLAO, length = 1)
	private String sigla;

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

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	
	
	

}
