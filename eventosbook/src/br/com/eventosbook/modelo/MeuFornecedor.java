package br.com.eventosbook.modelo;

import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**Classe Representante da tabela do banco de dados meus_fornecedores
 * 
 * @author rodrigo.leite
 *
 */
@Entity
@Table(name="meus_fornecedores", schema="eventosbook")
@SequenceGenerator(name = "eventosbook.sequencia_meus_fornecedores", sequenceName="eventosbook.sequencia_meus_fornecedores")
public class MeuFornecedor {
	
	/**Paramentros de entidade **/
	public static final String NM_ENT_MEU_FORNECEDOR = "meus_fornecedores";
	public static final String NM_SCHEMA_ENTIDADE = "eventosbook.meus_fornecedores";
	
	public static final String NM_COL_CODIGO = "id_meus_fornecedores";
	public static final String NM_COL_FK_FORNECEDOR = "fk_fornecedor";
	public static final String NM_COL_FK_EVENTO = "fk_evento";
	public static final String NM_COL_DATA_INCLUSAO = "data_inclusao";
	public static final String NM_COL_FK_AVALIACAO = "fk_avaliacao";
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator ="eventosbook.sequencia_meus_fornecedores")
	@Column(name = NM_COL_CODIGO)
	private Integer codigo;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = NM_COL_FK_FORNECEDOR, nullable = false)
	private Fornecedor fornecedor;
	
	@ManyToOne
	@JoinColumn(name = NM_COL_FK_EVENTO, nullable = false)
	private Evento evento;
	
	@Column(name=NM_COL_DATA_INCLUSAO)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataInclusao;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = NM_COL_FK_AVALIACAO, nullable = true)
	private Avaliacao avaliacao;
	
	@Transient
	String[] adicionais;
	
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public Date getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(Date dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

	public Avaliacao getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(Avaliacao avaliacao) {
		this.avaliacao = avaliacao;
	}

	
	
	

}
