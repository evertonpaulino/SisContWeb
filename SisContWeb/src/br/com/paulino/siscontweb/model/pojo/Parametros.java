package br.com.paulino.siscontweb.model.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Parametros {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer parmsCodg;
	private Integer parmsStatusCaixa;

	public Integer getParmsCodg() {
		return parmsCodg;
	}

	public void setParmsCodg(Integer parmsCodg) {
		this.parmsCodg = parmsCodg;
	}

	public Integer getParmsStatusCaixa() {
		return parmsStatusCaixa;
	}

	public void setParmsStatusCaixa(Integer parmsStatusCaixa) {
		this.parmsStatusCaixa = parmsStatusCaixa;
	}

}
