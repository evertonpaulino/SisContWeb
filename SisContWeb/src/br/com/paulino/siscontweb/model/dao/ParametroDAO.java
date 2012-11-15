package br.com.paulino.siscontweb.model.dao;

import javax.persistence.EntityManager;

import br.com.paulino.siscontweb.model.pojo.Parametros;

public class ParametroDAO extends GenericDAO<Parametros>{

	public ParametroDAO(EntityManager em) {
		super(em);
	}
	
	public Parametros buscaParametros(){
		String sql = " from Parametros p";
					
		return	(Parametros) getEntityManager().createQuery(sql).getSingleResult();
	}


}
