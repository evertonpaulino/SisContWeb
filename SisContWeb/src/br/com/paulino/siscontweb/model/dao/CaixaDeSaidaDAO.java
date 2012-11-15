package br.com.paulino.siscontweb.model.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.paulino.siscontweb.model.pojo.CaixaDeSaida;

public class CaixaDeSaidaDAO extends GenericDAO<CaixaDeSaida>{

	public CaixaDeSaidaDAO(EntityManager em) {
		super(em);
	}

	public List<CaixaDeSaida> exibeTodasCaixaDeSaida(){
		return exibeTodasAsInformacaoDaTabela("CaixaDeSaida");
	}
	
}
