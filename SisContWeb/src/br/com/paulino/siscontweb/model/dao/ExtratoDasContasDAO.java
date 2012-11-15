package br.com.paulino.siscontweb.model.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;


import br.com.paulino.siscontweb.model.pojo.ExtratoDaConta;
import br.com.paulino.siscontweb.model.pojo.ExtratoDeMovimento;

public class ExtratoDasContasDAO extends GenericDAO<ExtratoDaConta>{

	public ExtratoDasContasDAO(EntityManager em) {
		super(em);
	}

	@SuppressWarnings("unchecked")
	public List<ExtratoDaConta> exibeTodasContasDeEntrada(){
		
		String sql = "select new br.com.paulino.model.pojo.ExtratoDaConta (p.plc_codg_reduzido," +
					 "       p.plc_conta_contabil," +
					 "       p.plc_descricao," +
					 "       sum(c.ce_valor))" +
					 "  from ContaDeEntrada as c," +
					 "       PlanoDeConta as p," +
					 "       NotaDeEntrada as n" +
					 " where c.plc_codg_reduzido = p.plc_codg_reduzido" +
					 "   and c.ne_sequencial = n.ne_sequencial" +
					 " group by p.plc_codg_reduzido";
		
		return getEntityManager().createQuery(sql).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<ExtratoDaConta> exibeContasDeEntradaDoPeriodo(Date inicio, Date fim){
		
		SimpleDateFormat formataData = new SimpleDateFormat("yyyy-MM-dd");
		
		String sql = "select p.plc_codg_reduzido," +
					 "       p.plc_conta_contabil," +
					 "       p.plc_descricao," +
					 "       sum(c.valor) as valor_da_conta" +
					 "  from ContaDeEntrada c," +
					 "       PlanoDeConta p," +
					 "       NotaDeEntrada n" +
					 " where c.plc_codg_reduzido = p.plc_codg_reduzido" +
					 "   and c.ne_sequencial = n.ne_sequencial" +
					 "   and n.ne_data_emissao between '" + formataData.format(inicio) + "' and " + formataData.format(inicio) + 
					 " group by p.plc_codg_reduzido";
		
		return getEntityManager().createQuery(sql).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<ExtratoDaConta> exibeTodasContasDeSaida(){
		
		String sql = "select new br.com.paulino.model.pojo.ExtratoDaConta (p.plc_codg_reduzido," +
					 "       p.plc_conta_contabil," +
					 "       p.plc_descricao," +
					 "       sum(c.cs_valor))" +
					 "  from ContaDeSaida as c," +
					 "       PlanoDeConta as p," +
					 "       NotaDeSaida as n" +
					 " where c.plc_codg_reduzido = p.plc_codg_reduzido" +
					 "   and c.ns_sequencial = n.ns_sequencial" +
					 " group by p.plc_codg_reduzido";
		
		return getEntityManager().createQuery(sql).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<ExtratoDeMovimento> exibeMovimentosDaConta(){
		
		List<ExtratoDeMovimento> listaDeMovimento = new ArrayList<ExtratoDeMovimento>();
		
		String sqlEntrada = "select new br.com.paulino.model.pojo.ExtratoDeMovimento ('Entrada'," +
							 "		 ne.ne_data_emissao," +
							 "		 ne.ne_descricao," +
							 "		 ce.plc_codg_reduzido," +
							 "       ce.ce_valor)" +
							 "	from ContaDeEntrada as ce," +
							 "       NotaDeEntrada as ne" +
							 " where ce.ne_sequencial = ne.ne_sequencial" +
							 "   and ne.ne_data_emissao between '2012-04-01' and '2012-04-30'" ;
		
		listaDeMovimento.addAll(getEntityManager().createQuery(sqlEntrada).getResultList());
		
		String sqlSaida = 	"select new br.com.paulino.model.pojo.ExtratoDeMovimento ('Saida'," +
							 "		 ns.ns_data_emissao," +
							 "		 ns.ns_descricao," +
							 "		 cs.plc_codg_reduzido," +
							 "       cs.cs_valor)" +
							 "	from ContaDeSaida as cs," +
							 "       NotaDeSaida as ns" +
							 " where cs.ns_sequencial = ns.ns_sequencial" +
							 "   and ns.ns_data_emissao between '2012-04-01' and '2012-04-30'" ;
		
		listaDeMovimento.addAll(getEntityManager().createQuery(sqlSaida).getResultList());
		
		Collections.sort(listaDeMovimento);
		
		return listaDeMovimento;
	}

}