package br.com.paulino.siscontweb.treelist;

import br.com.paulino.siscontweb.model.pojo.PlanoDeConta;

public class Node {

	private PlanoDeConta value;
	private PlanoDeConta pai;

	public Node() {
	}

	public Node(PlanoDeConta value, PlanoDeConta pai) {
		this.setValue(value);
		this.pai = pai;
	}

	public PlanoDeConta getValue() {
		return value;
	}

	public void setValue(PlanoDeConta value) {
		this.value = value;
	}

	public PlanoDeConta getPai() {
		return pai;
	}

	public void setPai(PlanoDeConta pai) {
		this.pai = pai;
	}

}
