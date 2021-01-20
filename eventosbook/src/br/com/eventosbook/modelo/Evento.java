package br.com.eventosbook.modelo;

import java.util.Calendar;
import java.util.Date;
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
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="evento", schema="eventosbook")
@SequenceGenerator(name = "eventosbook.sequencia_evento", sequenceName="eventosbook.sequencia_evento")
public class Evento {
	
	public static final String CONSULTAR_EVENTO_POR_CONTRATANTE = "Evento.CONSULTAR_EVENTO_POR_CONTRATANTE"; 
	public static final String DETALHAR_EVENTO_POR_CONTRATANTE = "Evento.DETALHAR_EVENTO_POR_CONTRATANTE";
	
	/*Nome entidade*/
	public static final String NM_SCHEMA_ENTIDADE = "eventosbook.evento";
	public static final String NM_ENTIDADE = "evento";
			
	public static final String NM_COL_CODIGO = "id_evento";
	public static final String NM_FK_CODIGO_TIPO_EVENTO = "fk_tipo_evento";
	public static final String NM_FK_CODIGO_CONTRATANTE = "fk_contratante";
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "eventosbook.sequencia_evento")
	@Column(name = NM_COL_CODIGO)
	private Integer codigo;

	@Column(name="descricao")
	private String descricao;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_criacao")
	private Calendar dataCriacao;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_ult_atualizacao")
	private Calendar dataUltimaAtualizacao;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "data_evento", nullable = false)
	private Calendar dataEvento;

	@Temporal(TemporalType.TIME)
	@Column(name = "horario_evento", nullable = false)
	private Date horarioEvento;
	
	
	@ManyToOne
	@JoinColumn(name=NM_FK_CODIGO_TIPO_EVENTO, nullable = false)
	private TipoEvento tipoEvento;
	
	@ManyToOne
	@JoinColumn(name = NM_FK_CODIGO_CONTRATANTE, nullable = false)
	private Contratante contratante;
	
	@ManyToMany
	@JoinTable(schema = "eventosbook", name = "checklist", joinColumns = {@JoinColumn(name="fk_evento")},
			inverseJoinColumns = {@JoinColumn(name = "fk_item")})
	private List<Item>colecaoItem;

	public List<Item> getColecaoItem() {
		return colecaoItem;
	}

	public void setColecaoItem(List<Item> colecaoItem) {
		this.colecaoItem = colecaoItem;
	}

	public Contratante getContratante() {
		return contratante;
	}

	public void setContratante(Contratante contratante) {
		this.contratante = contratante;
	}

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

	public Calendar getDataEvento() {
		return dataEvento;
	}

	public void setDataEvento(Calendar dataEvento) {
		this.dataEvento = dataEvento;
	}

	public Date getHorarioEvento() {
		return horarioEvento;
	}

	public void setHorarioEvento(Date horarioEvento) {
		this.horarioEvento = horarioEvento;
	}

	public TipoEvento getTipoEvento() {
		return tipoEvento;
	}

	public void setTipoEvento(TipoEvento tipoEvento) {
		this.tipoEvento = tipoEvento;
	}
	
	public Calendar getDataCriacao() {
		return dataCriacao;
	}
	
	@PrePersist
	public void setDataCriacao() {
		this.dataCriacao = Calendar.getInstance();
	}

	public Calendar getDataUltimaAtualizacao() {
		return dataUltimaAtualizacao;
	}
	
	@PreUpdate
	public void setDataUltimaAtualizacao() {
		this.dataUltimaAtualizacao  = Calendar.getInstance();
	}
	
	

}
