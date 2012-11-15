package br.com.paulino.siscontweb.model.pojo;

import java.math.BigDecimal;

public class ExtratoDaConta {

	private Integer plc_codg_reduzido;
	private String plc_conta_contabil;
	private String plc_descricao;
	private BigDecimal valor_da_conta;

	public ExtratoDaConta() {
	}
	
	
	public ExtratoDaConta(Integer plc_codg_reduzido, String plc_conta_contabil,	String plc_descricao, BigDecimal valor_da_conta) {
		super();
		this.plc_codg_reduzido = plc_codg_reduzido;
		this.plc_conta_contabil = plc_conta_contabil;
		this.plc_descricao = plc_descricao;
		this.valor_da_conta = valor_da_conta;
	}


	public Integer getPlc_codg_reduzido() {
		return plc_codg_reduzido;
	}

	public void setPlc_codg_reduzido(Integer plc_codg_reduzido) {
		this.plc_codg_reduzido = plc_codg_reduzido;
	}

	public String getPlc_conta_contabil() {
		return plc_conta_contabil;
	}

	public void setPlc_conta_contabil(String plc_conta_contabil) {
		this.plc_conta_contabil = plc_conta_contabil;
	}

	public String getPlc_descricao() {
		return plc_descricao;
	}

	public void setPlc_descricao(String pllc_descricao) {
		this.plc_descricao = pllc_descricao;
	}

	public BigDecimal getValor_da_conta() {
		return valor_da_conta;
	}

	public void setValor_da_conta(BigDecimal valor_da_conta) {
		this.valor_da_conta = valor_da_conta;
	}

}
