package br.com.paulino.siscontweb.model.pojo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "nota_entrada")
public class NotaDeEntrada {

	@Id
	@GeneratedValue()
	private Integer ne_sequencial;
	private String ne_descricao;
	private Date ne_data_emissao;
	private BigDecimal ne_valor;
	private String ne_status;

	@OneToMany(mappedBy="ne_sequencial", cascade=CascadeType.ALL)
	private Set<ContaDeEntrada> contasDeEntrada = new HashSet<ContaDeEntrada>();
	
	@OneToMany(mappedBy="ns_sequencial", cascade=CascadeType.ALL)
	private Set<ContaDeSaida> contasDeSaida = new HashSet<ContaDeSaida>();

	public Integer getNe_sequencial() {
		return ne_sequencial;
	}

	public void setNe_sequencial(Integer ne_sequencial) {
		this.ne_sequencial = ne_sequencial;
	}

	public String getNe_descricao() {
		return ne_descricao;
	}

	public void setNe_descricao(String ne_descricao) {
		this.ne_descricao = ne_descricao;
	}

	public Date getNe_data_emissao() {
		return ne_data_emissao;
	}

	public void setNe_data_emissao(Date ne_data_emissao) {
		this.ne_data_emissao = ne_data_emissao;
	}

	public BigDecimal getNe_valor() {
		return ne_valor;
	}

	public void setNe_valor(BigDecimal ne_valor) {
		this.ne_valor = ne_valor;
	}

	public String getNe_status() {
		return ne_status;
	}

	public void setNe_status(String ne_status) {
		this.ne_status = ne_status;
	}

	public Set<ContaDeEntrada> getContasDeEntrada() {
		return contasDeEntrada;
	}

	public void setContasDeEntrada(Set<ContaDeEntrada> contasDeEntrada) {
		this.contasDeEntrada = contasDeEntrada;
	}

	public Set<ContaDeSaida> getContasDeSaida() {
		return contasDeSaida;
	}

	public void setContasDeSaida(Set<ContaDeSaida> contasDeSaida) {
		this.contasDeSaida = contasDeSaida;
	}

}
