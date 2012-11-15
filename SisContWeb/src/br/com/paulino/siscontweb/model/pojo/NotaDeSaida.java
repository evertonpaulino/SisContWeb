package br.com.paulino.siscontweb.model.pojo;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="nota_saida")
public class NotaDeSaida {

	@Id
	@GeneratedValue
	private Integer ns_sequencial;
	private String ns_descricao;
	private Date ns_data_emissao;
	private BigDecimal ns_valor;
	private String status;

	public Integer getNs_sequencial() {
		return ns_sequencial;
	}

	public void setNs_sequencial(Integer sequencial) {
		this.ns_sequencial = sequencial;
	}

	public String getNs_descricao() {
		return ns_descricao;
	}

	public void setNs_descricao(String descricao) {
		this.ns_descricao = descricao;
	}

	public Date getNs_data_emissao() {
		return ns_data_emissao;
	}

	public void setNs_data_emissao(Date dataDeEmissao) {
		this.ns_data_emissao = dataDeEmissao;
	}

	public BigDecimal getNs_valor() {
		return ns_valor;
	}

	public void setNs_valor(BigDecimal valor) {
		this.ns_valor = valor;
	}

	public String getNs_status() {
		return status;
	}

	public void setNs_status(String status) {
		this.status = status;
	}
	
}
