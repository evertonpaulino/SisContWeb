package br.com.paulino.siscontweb.model.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.paulino.siscontweb.model.pojo.Caixa;
import br.com.paulino.siscontweb.model.pojo.CaixaDeEntrada;
import br.com.paulino.siscontweb.model.pojo.CaixaDeSaida;

public class CaixaDAO extends GenericDAO<Caixa>{

	public CaixaDAO(EntityManager em) {
		super(em);
	}
	
	public List<Caixa> exibeTodosCaixa(){
		return exibeTodasAsInformacaoDaTabela("Caixa");
	}

	@SuppressWarnings("unchecked")
	public List<CaixaDeEntrada> exibeNotasDeEntradaDoCaixa(Integer sequencial) {
		String sql = " from CaixaDeEntrada c" +
					" where c.caixa = " + sequencial;
		
		List<CaixaDeEntrada> listaEntrada = getEntityManager().createQuery(sql).getResultList(); 
		
		return listaEntrada;
	}


	@SuppressWarnings("unchecked")
	public List<CaixaDeSaida> exibeNotasDeSaidaDoCaixa(Integer sequencial){
		String sql = " from CaixaDeSaida c" +
				" where c.cx_sequencial = " + sequencial;
		
		return getEntityManager().createQuery(sql).getResultList();
	}

}
