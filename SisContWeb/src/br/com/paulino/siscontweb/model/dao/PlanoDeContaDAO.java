package br.com.paulino.siscontweb.model.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.paulino.siscontweb.model.pojo.PlanoDeConta;

public class PlanoDeContaDAO extends GenericDAO<PlanoDeConta>{

	public PlanoDeContaDAO(EntityManager em) {
		super(em);
	}
	
	public void insereConta(PlanoDeConta planoDeConta) {
		insert(planoDeConta);
	}

	public void editaConta(PlanoDeConta planoDeConta) {
		edit(planoDeConta);
	}

	public void deletaConta(Integer plc_codg_reduzido) {
		delete(PlanoDeConta.class, plc_codg_reduzido);
	}

	public List<PlanoDeConta> exibeTodasAsContas() {
		return exibeTodasAsInformacaoDaTabela("PlanoDeConta");
	}
	
	public PlanoDeConta buscaPlanoDeConta(int codigoReduzido){
		String sql = " from PlanoDeConta p " +
					 "where p.plc_codg_reduzido = " + codigoReduzido;
					
		return	(PlanoDeConta) getEntityManager().createQuery(sql).getSingleResult();
	}
}
