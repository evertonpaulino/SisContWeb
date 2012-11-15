package br.com.paulino.siscontweb.test;

import br.com.paulino.siscontweb.model.conexao.HibernateConnection;
import br.com.paulino.siscontweb.model.dao.PlanoDeContaDAO;
import br.com.paulino.siscontweb.model.pojo.PlanoDeConta;

public class PlanoDeContaTest {

	public static void main(String[] args) {
		PlanoDeContaDAO dao = new PlanoDeContaDAO(HibernateConnection.getEntityManager());

		PlanoDeConta conta = new PlanoDeConta();
		//conta.setPlc_codg_reduzido(1000);
		conta.setPlc_conta_contabil("88");
		conta.setPlc_conta_pai("8");
		conta.setPlc_descricao("Teste Nova Conta");
		
		System.out.println("insere");
		dao.insereConta(conta);
		
		System.out.println("edita");
		dao.editaConta(conta);

		System.out.println("busca");
		dao.exibeTodasAsContas();
	}
}
