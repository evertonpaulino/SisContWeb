package br.com.paulino.siscontweb.model.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class ExtratoDeMovimento implements Comparable<ExtratoDeMovimento>{

	private String tipoNota;
	private Date dataEmissao;
	private String descricaoNota;
	private PlanoDeConta planoConta;
	private BigDecimal valorConta;

	public ExtratoDeMovimento() {
	}
	
	public ExtratoDeMovimento(String tipoNota, Date dataEmissao, String descricaoNota, PlanoDeConta planoConta, BigDecimal valorConta) {
		super();
		this.tipoNota = tipoNota;
		this.dataEmissao = dataEmissao;
		this.descricaoNota = descricaoNota;
		this.planoConta = planoConta;
		this.valorConta = valorConta;
	}

	public String getTipoNota() {
		return tipoNota;
	}


	public void setTipoNota(String tipoNota) {
		this.tipoNota = tipoNota;
	}


	public Date getDataEmissao() {
		return dataEmissao;
	}


	public void setDataEmissao(Date dataEmissao) {
		this.dataEmissao = dataEmissao;
	}


	public String getDescricaoNota() {
		return descricaoNota;
	}


	public void setDescricaoNota(String descricaoNota) {
		this.descricaoNota = descricaoNota;
	}


	public PlanoDeConta getPlanoConta() {
		return planoConta;
	}


	public void setPlanoConta(PlanoDeConta planoConta) {
		this.planoConta = planoConta;
	}


	public BigDecimal getValorConta() {
		return valorConta;
	}


	public void setValorConta(BigDecimal valorConta) {
		this.valorConta = valorConta;
	}


	@Override
	public int compareTo(ExtratoDeMovimento o) {
		if(dataEmissao.compareTo(o.dataEmissao) > 0){
			return 1;
		}
		
		if(dataEmissao.compareTo(o.dataEmissao) < 0){
			return -1;
		}
		
		return 0;
	}

}
