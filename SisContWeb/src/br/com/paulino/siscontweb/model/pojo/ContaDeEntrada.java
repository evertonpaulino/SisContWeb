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
@Table(name = "conta_entrada")
public class ContaDeEntrada {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ce_sequencial;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "plc_codg_reduzido")
	private PlanoDeConta plc_codg_reduzido;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "ne_sequencial")
	private NotaDeEntrada ne_sequencial;

	private BigDecimal ce_valor;

	public Integer getSequencial() {
		return ce_sequencial;
	}

	public void setSequencial(Integer sequencial) {
		this.ce_sequencial = sequencial;
	}

	public PlanoDeConta getConta() {
		return plc_codg_reduzido;
	}

	public void setConta(PlanoDeConta conta) {
		this.plc_codg_reduzido = conta;
	}

	public NotaDeEntrada getNota() {
		return ne_sequencial;
	}

	public void setNota(NotaDeEntrada nota) {
		this.ne_sequencial = nota;
	}

	public BigDecimal getValor() {
		return ce_valor;
	}

	public void setValor(BigDecimal valor) {
		this.ce_valor = valor;
	}

}
