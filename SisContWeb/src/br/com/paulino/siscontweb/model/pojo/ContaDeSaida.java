package br.com.paulino.siscontweb.model.pojo;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "conta_saida")
public class ContaDeSaida {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer cs_sequencial;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "plc_codg_reduzido")
	private PlanoDeConta plc_codg_reduzido;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ns_sequencial")
	private NotaDeSaida ns_sequencial;

	private BigDecimal cs_valor;

	public Integer getSequencial() {
		return cs_sequencial;
	}

	public void setSequencial(Integer sequencial) {
		this.cs_sequencial = sequencial;
	}

	public PlanoDeConta getConta() {
		return plc_codg_reduzido;
	}

	public void setConta(PlanoDeConta conta) {
		this.plc_codg_reduzido = conta;
	}

	public NotaDeSaida getNota() {
		return ns_sequencial;
	}

	public void setNota(NotaDeSaida nota) {
		this.ns_sequencial = nota;
	}

	public BigDecimal getValor() {
		return cs_valor;
	}

	public void setValor(BigDecimal valor) {
		this.cs_valor = valor;
	}

}
