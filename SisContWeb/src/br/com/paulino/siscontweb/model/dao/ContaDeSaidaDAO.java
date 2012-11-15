package br.com.paulino.siscontweb.model.dao;

import javax.persistence.EntityManager;

import br.com.paulino.siscontweb.model.pojo.ContaDeSaida;

public class ContaDeSaidaDAO extends GenericDAO<ContaDeSaida>{

	public ContaDeSaidaDAO(EntityManager em) {
		super(em);
	}
	
	public void insereConta(ContaDeSaida conta){
		insert(conta);
	}
	
	public void editaConta(ContaDeSaida conta){
		edit(conta);
	}
	
	public void deletaConta(Integer conta){
		delete(ContaDeSaida.class, conta);
	}

}
