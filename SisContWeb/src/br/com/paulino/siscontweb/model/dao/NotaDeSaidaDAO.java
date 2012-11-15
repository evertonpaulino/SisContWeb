package br.com.paulino.siscontweb.model.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.paulino.siscontweb.model.pojo.ContaDeSaida;
import br.com.paulino.siscontweb.model.pojo.NotaDeSaida;

public class NotaDeSaidaDAO extends GenericDAO<NotaDeSaida>{

	public NotaDeSaidaDAO(EntityManager em) {
		super(em);
	}
	
	@Override
	public void insert(NotaDeSaida objeto) {
		super.insert(objeto);
	}
	
	@Override
	public void edit(NotaDeSaida objeto) {
		super.edit(objeto);
	}
	
	public void deleteNota(Integer nota) {
		super.delete(NotaDeSaida.class, nota);
	}
	
	public List<NotaDeSaida> exibeTodasAsNotasDeSaida() {
		return super.exibeTodasAsInformacaoDaTabela("NotaDeSaida");
	}

	@SuppressWarnings("unchecked")
	public List<ContaDeSaida> exibeContasDaNota(Integer nota){
		String sql = "  from ContaDeSaida c" +
					 " where c.ns_sequencial = " + nota;
		
		return getEntityManager().createQuery(sql).getResultList(); 
	}
}
