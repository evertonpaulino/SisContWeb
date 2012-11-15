package br.com.paulino.siscontweb.model.pojo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "caixa_saida")
public class CaixaDeSaida implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "cx_sequencial")
	private Caixa cx_sequencial;
	
	@Id
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "ns_sequencial")
	private NotaDeSaida ns_sequencial;

	public Caixa getCx_sequencial() {
		return cx_sequencial;
	}

	public void setCx_sequencial(Caixa cx_sequencial) {
		this.cx_sequencial = cx_sequencial;
	}

	public NotaDeSaida getNs_sequencial() {
		return ns_sequencial;
	}

	public void setNs_sequencial(NotaDeSaida ns_sequencial) {
		this.ns_sequencial = ns_sequencial;
	}

}
