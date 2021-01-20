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
@Table(name="checklist", schema="eventosbook")
@SequenceGenerator(name = "eventosbook.sequencia_checklist", sequenceName="eventosbook.sequencia_checklist")
public class CheckList {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator = "eventosbook.sequencia_checklist")
	@Column(name="id_checklist")
	private Integer codigo;
	
	@Column(name = "status", length = 1)
	private String status;
	
	@ManyToOne
	@JoinColumn(name = "fk_evento")
	private Evento evento;
	
	@ManyToOne
	@JoinColumn(name = "fk_item")
	private Item item;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String  status) {
		this.status = status;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

}
