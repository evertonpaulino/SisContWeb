package br.com.paulino.siscontweb.model.dao;

import java.util.List;

import javax.persistence.EntityManager;

public class GenericDAO<T> {
	
	private EntityManager entityManager;
	
	public GenericDAO(EntityManager em) {
		setEntityManager(em);
	}
	
	public void insert(T objeto){
		getEntityManager().persist(objeto);
	}
	
	public void edit(T objeto){
		getEntityManager().merge(objeto);
	}
	
	public void delete(Class<T> C, Integer sequencial){
		T objeto;
		objeto = getEntityManager().find(C, sequencial);
		getEntityManager().remove(objeto);
	}
	
	@SuppressWarnings("unchecked")
	public List<T> exibeTodasAsInformacaoDaTabela(String tabela) {
		return getEntityManager().createQuery("from " + tabela).getResultList();
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
