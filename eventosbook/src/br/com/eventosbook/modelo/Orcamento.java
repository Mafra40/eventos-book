
package br.com.eventosbook.modelo;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="orcamentos", schema="eventosbook")
@SequenceGenerator(name = "eventosbook.sequencia_orcamento", sequenceName="eventosbook.sequencia_orcamento")
public class Orcamento {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="eventosbook.sequencia_orcamento")
	@Column(name="id_orcamentos")
	private Integer codigo;
	
	@OneToOne
	@JoinColumn(name="fk_evento")
	private Evento evento;
	
	@OneToOne
	@JoinColumn(name="fk_fornecedor")
	private Fornecedor fornecedor;
		
	
	@Column(name="data_solicitacao")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataHora;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public Date getDataHora() {
		return dataHora;
	}

	public void setDataHora(Date pDataHora) {
		dataHora = pDataHora;
	}
	
	
}
