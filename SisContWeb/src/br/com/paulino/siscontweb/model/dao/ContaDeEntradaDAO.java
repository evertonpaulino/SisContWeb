package br.com.paulino.siscontweb.model.dao;

import javax.persistence.EntityManager;

import br.com.paulino.siscontweb.model.pojo.ContaDeEntrada;

public class ContaDeEntradaDAO extends GenericDAO<ContaDeEntrada>{

	public ContaDeEntradaDAO(EntityManager em) {
		super(em);
	}
	
	public void insereConta(ContaDeEntrada conta){
		insert(conta);
	}
	
	public void editaConta(ContaDeEntrada conta){
		edit(conta);
	}
	
	public void deletaConta(Integer conta){
		delete(ContaDeEntrada.class, conta);
	}
	
}
