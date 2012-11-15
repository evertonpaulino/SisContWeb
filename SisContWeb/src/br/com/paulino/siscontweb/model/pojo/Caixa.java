package br.com.paulino.siscontweb.model.pojo;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "caixa")
public class Caixa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cx_sequencial;
	private Date cx_data_abertura;
	private Date cx_data_fechamento;
	private BigDecimal cx_saldo_abertura;
	private BigDecimal cx_saldo_fechamento;
	private BigDecimal cx_saldo_geral;
	
	public Integer getSequencial() {
		return cx_sequencial;
	}

	public void setSequencial(Integer sequencial) {
		this.cx_sequencial = sequencial;
	}

	public Date getDataDeAbertura() {
		return cx_data_abertura;
	}

	public void setDataDeAbertura(Date cx_data_abertura) {
		this.cx_data_abertura = cx_data_abertura;
	}

	public Date getDataDeFechamento() {
		return cx_data_fechamento;
	}

	public void setDataDeFechamento(Date dataDeFechamento) {
		this.cx_data_fechamento = dataDeFechamento;
	}

	public BigDecimal getSaldoDeAbertura() {
		return cx_saldo_abertura;
	}

	public void setSaldoDeAbertura(BigDecimal cx_saldo_abertura) {
		this.cx_saldo_abertura = cx_saldo_abertura;
	}

	public BigDecimal getSaldoDeFechamento() {
		return cx_saldo_fechamento;
	}

	public void setSaldoDeFechamento(BigDecimal saldoDeFechamento) {
		this.cx_saldo_fechamento = saldoDeFechamento;
	}

	public BigDecimal getSaldoGeral() {
		return cx_saldo_geral;
	}

	public void setSaldoGeral(BigDecimal saldoGeral) {
		this.cx_saldo_geral = saldoGeral;
	}

}
