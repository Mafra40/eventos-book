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
@Table(name="comentario", schema="eventosbook")
@SequenceGenerator(name = "eventosbook.sequencia_comentario", sequenceName="eventosbook.sequencia_comentario")
public class Comentario {
	
	/**Paramentros de entidade **/
	public static final String NM_ENT_MEU_FORNECEDOR = "comentario";
	public static final String NM_SCHEMA_ENTIDADE = "eventosbook.comentario";
	
	public static final String NM_COL_CODIGO = "id_comentario";
	public static final String NM_COL_FK_TIPO_COMENTARIO = "fk_tipo_comentario";
	public static final String NM_COL_DESCRICAO = "descricao";
	public static final String NM_COL_FK_AVALIACAO = "fk_avaliacao";
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator = "eventosbook.sequencia_comentario")
	@Column(name=NM_COL_CODIGO)
	private Integer codigo;
	
	@Column(name = "descricao")
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name = NM_COL_FK_TIPO_COMENTARIO)
	private TipoComentario tipoComentario;
	
	@ManyToOne
	@JoinColumn(name = NM_COL_FK_AVALIACAO)
	private Avaliacao avalicacao;

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

	public TipoComentario getTipoComentario() {
		return tipoComentario;
	}

	public void setTipoComentario(TipoComentario tipoComentario) {
		this.tipoComentario = tipoComentario;
	}

	public Avaliacao getAvalicacao() {
		return avalicacao;
	}

	public void setAvalicacao(Avaliacao avalicacao) {
		this.avalicacao = avalicacao;
	}

}
