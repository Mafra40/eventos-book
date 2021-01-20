package br.com.eventosbook.modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public abstract class EntidadeAtualizaTimestamp {
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_criacao", nullable = false)
	private Date dataCriacao;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_ult_atualizacao")
	private Date dataAtualizacao;
	
	@PrePersist
	protected void onCreate(){
		dataCriacao = dataAtualizacao = new Date();
	}
	
	@PreUpdate
	protected void onUpdate(){
		dataAtualizacao = new Date();
	}

}
