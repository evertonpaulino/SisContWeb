package br.com.paulino.siscontweb.model.dao;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.paulino.siscontweb.model.pojo.ContaDeEntrada;
import br.com.paulino.siscontweb.model.pojo.NotaDeEntrada;
import br.com.paulino.siscontweb.model.pojo.PlanoDeConta;

public class NotaDeEntradaDAO extends GenericDAO<NotaDeEntrada> {

	public NotaDeEntradaDAO(EntityManager em) {
		super(em);
	}

	public void insereNota(NotaDeEntrada nota) {
		insert(nota);
	}

	public void editaNota(NotaDeEntrada nota) {
		edit(nota);
	}

	public void deletaNota(Integer nota) {
		delete(NotaDeEntrada.class, nota);
	}
	
	public List<NotaDeEntrada> exibeTodasAsNotasDeEntrada(){
		return exibeTodasAsInformacaoDaTabela("NotaDeEntrada");
	}
	
	@SuppressWarnings("unchecked")
	public List<ContaDeEntrada> exibeContasDaNota(Integer nota){
		String sql = "  from ContaDeEntrada c" +
					 " where c.ne_sequencial = " + nota;
		
		return getEntityManager().createQuery(sql).getResultList(); 
	}
	
	@SuppressWarnings("unchecked")
	public List<PlanoDeConta> exibeContasDaNotaDeEntrada(Integer nota){
		String sql = " select p.plc_codg_reduzido," +
					 "		  p.plc_conta_contabil," +
					 "		  p.plc_descricao," + 
					 "		  p.plc_tipo_conta" +
					 "   from ContaDeEntrada c, PlanoDeConta p " +
					 "  where c.ne_sequencial = p.plc_codg_reduzido";
					 //"    and c.nota = " + nota;
					 
		return getEntityManager().createQuery(sql).getResultList(); 
	}
	
	@SuppressWarnings("unchecked")
	public List<NotaDeEntrada> exibeNotasDoPeriodo(Date inicio, Date fim){
		
		SimpleDateFormat formataData = new SimpleDateFormat("yyyy-MM-dd");
		
		String sql = "  from NotaDeEntrada ne" +
				 	 " where ne.ne_data_emissao between '" + formataData.format(inicio) + "' and '"+ formataData.format(fim) + "'";

		return getEntityManager().createQuery(sql).getResultList();
	}
}
