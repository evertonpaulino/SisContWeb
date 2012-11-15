package br.com.paulino.siscontweb.model.pojo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "caixa_entrada")
public class CaixaDeEntrada implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne
	@JoinColumn(name = "cx_sequencial")
	private Caixa caixa;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "ne_sequencial")
	private NotaDeEntrada notaDeEntrada; 

	public Caixa getCaixa() {
		return caixa;
	}

	public void setCaixa(Caixa caixa) {
		this.caixa = caixa;
	}

	public NotaDeEntrada getNotaDeEntrada() {
		return notaDeEntrada;
	}

	public void setNotaDeEntrada(NotaDeEntrada notaDeEntrada) {
		this.notaDeEntrada = notaDeEntrada;
	}

}
