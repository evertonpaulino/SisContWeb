package br.com.paulino.siscontweb.model.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.paulino.siscontweb.model.pojo.CaixaDeEntrada;

public class CaixaDeEntradaDAO extends GenericDAO<CaixaDeEntrada>{

	public CaixaDeEntradaDAO(EntityManager em) {
		super(em);
	}
	
	public List<CaixaDeEntrada> exibeTodasCaixaDeEntrada(){
		return exibeTodasAsInformacaoDaTabela("CaixaDeEntrada");
	}

}
