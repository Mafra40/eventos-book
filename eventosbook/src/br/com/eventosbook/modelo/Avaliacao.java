package br.com.eventosbook.modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**Classe representante da tabela  avaliacao
 * 
 * @author rodrigo.leite
 *
 */
@Entity
@Table(name="avaliacao", schema="eventosbook")
@SequenceGenerator(name = "eventosbook.sequencia_avaliacao", sequenceName="eventosbook.sequencia_avaliacao")
public class Avaliacao {
	
	/*Nome Entidade*/
	public static final String NM_ENT_AVALIACAO = "avaliacao";
	public static final String NM_SCHEMA_ENTIDADE = "eventosbook.avaliacao";
	
	/*Nm Colunas*/
	public static final String NM_COL_CODIGO = "id_avaliacao";
	public static final String NM_COL_DATA_AVALIACAO = "data_avaliacao";
	public static final String NM_COL_NOTA = "nota";
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="eventosbook.sequencia_avaliacao")
	@Column(name=NM_COL_CODIGO)
	private Integer codigo;
	
	/**
	 * Nota que o Contratante dá para um fornecedor, essa nota pode ser de 1 a 5 (estrelas)
	 */
	@Column(name=NM_COL_NOTA)
	private Double nota;
	
	@Column(name="data_avaliacao")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataAvaliacao;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}

	public Date getDataAvaliacao() {
		return dataAvaliacao;
	}

	public void setDataAvaliacao(Date dataAvaliacao) {
		this.dataAvaliacao = dataAvaliacao;
	}
	
	
	

}
