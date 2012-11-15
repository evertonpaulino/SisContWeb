package br.com.paulino.siscontweb.treelist;

import br.com.paulino.siscontweb.model.conexao.HibernateConnection;
import br.com.paulino.siscontweb.model.dao.PlanoDeContaDAO;


public class TreeListTest {

	public static void main(String[] args) {
		
		PlanoDeContaDAO dao = new PlanoDeContaDAO(HibernateConnection.getEntityManager());
		
		//List<Node> listPlanoDeConta = new ArrayList<Node>();
		//gerarListaDePlanoDeConta(listPlanoDeConta);
		//geraPai(dao.exibeTodasAsContas());
		
		TreeList treeList = new TreeList();
		
		treeList.addAll(dao.exibeTodasAsContas());
		
		System.out.println(treeList.getArrayRaiz());
	}

	/*private static void geraPai(List<PlanoDeConta> list){
		for(PlanoDeConta conta: list){
			StringTokenizer tokenizer = new StringTokenizer(conta.getPlc_conta_contabil(), ".");
			
			int tam = tokenizer.countTokens();
			int i = 1;
			
			String concatenador = "";
			String result = null;
			
			while(tokenizer.hasMoreElements()){
				
				String tok = tokenizer.nextToken();
				
				if(i < tam){
					concatenador += tok + ".";
				}
				
				i++;
			}
			
			if(concatenador.length() > 0)
				result = concatenador.substring(0, concatenador.length() - 1);
			
			System.out.println(result);
		}
	}
	private static void gerarListaDePlanoDeConta(List<Node> listaPlanoDeConta) {
		
		PlanoDeConta contaNull = new PlanoDeConta();
		contaNull.setPlc_codg_reduzido(0);
		contaNull.setPlc_conta_contabil(null);
		contaNull.setPlc_descricao(null);
		
		PlanoDeConta conta1 = new PlanoDeConta();
		conta1.setPlc_codg_reduzido(1);
		conta1.setPlc_conta_contabil("1");
		conta1.setPlc_descricao("Caixa");
		
		//DefaultMutableTreeNode noValue1 = new DefaultMutableTreeNode(conta1);
		//DefaultMutableTreeNode noPai1 = new DefaultMutableTreeNode(contaNull);
		
		listaPlanoDeConta.add(new Node(conta1, contaNull));

		PlanoDeConta conta2 = new PlanoDeConta();
		conta2.setPlc_codg_reduzido(2);
		conta2.setPlc_conta_contabil("1.1");
		conta2.setPlc_descricao("Central");
		
		//DefaultMutableTreeNode noValue2 = new DefaultMutableTreeNode(conta2);
		//DefaultMutableTreeNode noPai2 = new DefaultMutableTreeNode(conta1);
		listaPlanoDeConta.add(new Node(conta2, conta1));

		PlanoDeConta conta3 = new PlanoDeConta();
		conta3.setPlc_codg_reduzido(3);
		conta3.setPlc_conta_contabil("1.2");
		conta3.setPlc_descricao("Caixa 2");

		//DefaultMutableTreeNode noValue3 = new DefaultMutableTreeNode(conta3);
		//DefaultMutableTreeNode noPai3 = new DefaultMutableTreeNode(conta1);
		listaPlanoDeConta.add(new Node(conta3, conta1));

		PlanoDeConta conta4 = new PlanoDeConta();
		conta4.setPlc_codg_reduzido(4);
		conta4.setPlc_conta_contabil("2");
		conta4.setPlc_descricao("Entrada");

		//DefaultMutableTreeNode noValue4 = new DefaultMutableTreeNode(conta4);
		//DefaultMutableTreeNode noPai4 = new DefaultMutableTreeNode(contaNull);
		listaPlanoDeConta.add(new Node(conta4, contaNull));

		PlanoDeConta conta5 = new PlanoDeConta();
		conta5.setPlc_codg_reduzido(5);
		conta5.setPlc_conta_contabil("2.3");
		conta5.setPlc_descricao("Aluguel");

		//DefaultMutableTreeNode noValue5 = new DefaultMutableTreeNode(conta5);
		//DefaultMutableTreeNode noPai5 = new DefaultMutableTreeNode(conta4);
		listaPlanoDeConta.add(new Node(conta5, conta4));

		PlanoDeConta conta6 = new PlanoDeConta();
		conta6.setPlc_codg_reduzido(6);
		conta6.setPlc_conta_contabil("2.4");
		conta6.setPlc_descricao("Investimento");

		//DefaultMutableTreeNode noValue6 = new DefaultMutableTreeNode(conta6);
		//DefaultMutableTreeNode noPai6 = new DefaultMutableTreeNode(conta4);
		listaPlanoDeConta.add(new Node(conta6, conta4));
		
		PlanoDeConta conta7 = new PlanoDeConta();
		conta7.setPlc_codg_reduzido(7);
		conta7.setPlc_conta_contabil("3");
		conta7.setPlc_descricao("Saida");

		//DefaultMutableTreeNode noValue7 = new DefaultMutableTreeNode(conta7);
		//DefaultMutableTreeNode noPai7 = new DefaultMutableTreeNode(contaNull);
		listaPlanoDeConta.add(new Node(conta7, contaNull));

		PlanoDeConta conta8 = new PlanoDeConta();
		conta8.setPlc_codg_reduzido(8);
		conta8.setPlc_conta_contabil("2.4.5");
		conta8.setPlc_descricao("Renda Fixa");

		//DefaultMutableTreeNode noValue8 = new DefaultMutableTreeNode(conta8);
		//DefaultMutableTreeNode noPai8 = new DefaultMutableTreeNode(conta6);
		listaPlanoDeConta.add(new Node(conta8, conta6));

		PlanoDeConta conta9 = new PlanoDeConta();
		conta9.setPlc_codg_reduzido(9);
		conta9.setPlc_conta_contabil("2.4.6");
		conta9.setPlc_descricao("Renda Variavel");

		//DefaultMutableTreeNode noValue9 = new DefaultMutableTreeNode(conta9);
		//DefaultMutableTreeNode noPai9 = new DefaultMutableTreeNode(conta6);
		listaPlanoDeConta.add(new Node(conta9, conta6));

		PlanoDeConta conta10 = new PlanoDeConta();
		conta10.setPlc_codg_reduzido(10);
		conta10.setPlc_conta_contabil("2.4.7");
		conta10.setPlc_descricao("Caixa");

		//DefaultMutableTreeNode noValue10 = new DefaultMutableTreeNode(conta10);
		//DefaultMutableTreeNode noPai10 = new DefaultMutableTreeNode(conta6);
		listaPlanoDeConta.add(new Node(conta10, conta6));

		PlanoDeConta conta14 = new PlanoDeConta();
		conta14.setPlc_codg_reduzido(14);
		conta14.setPlc_conta_contabil("4");
		conta14.setPlc_descricao("Poupança");
		
		//DefaultMutableTreeNode noValue15 = new DefaultMutableTreeNode(conta14);
		//DefaultMutableTreeNode noPai15 = new DefaultMutableTreeNode(contaNull);
		listaPlanoDeConta.add(new Node(conta14, contaNull));

		PlanoDeConta conta11 = new PlanoDeConta();
		conta11.setPlc_codg_reduzido(11);
		conta11.setPlc_conta_contabil("4.5");
		conta11.setPlc_descricao("Poupex");

		//DefaultMutableTreeNode noValue11 = new DefaultMutableTreeNode(conta11);
		//DefaultMutableTreeNode noPai11 = new DefaultMutableTreeNode(conta14);
		listaPlanoDeConta.add(new Node(conta11, conta14));

		PlanoDeConta conta12 = new PlanoDeConta();
		conta12.setPlc_codg_reduzido(12);
		conta12.setPlc_conta_contabil("4.6");
		conta12.setPlc_descricao("Poupança Ouro");

		//DefaultMutableTreeNode noValue12 = new DefaultMutableTreeNode(conta12);
		//DefaultMutableTreeNode noPai12 = new DefaultMutableTreeNode(conta14);
		listaPlanoDeConta.add(new Node(conta12, conta14));

		PlanoDeConta conta13 = new PlanoDeConta();
		conta13.setPlc_codg_reduzido(13);
		conta13.setPlc_conta_contabil("4.6.5");
		conta13.setPlc_descricao("Longo Prazo");

		//DefaultMutableTreeNode noValue13 = new DefaultMutableTreeNode(conta13);
		//DefaultMutableTreeNode noPai13 = new DefaultMutableTreeNode(conta14);
		listaPlanoDeConta.add(new Node(conta13, conta14));

		PlanoDeConta conta15 = new PlanoDeConta();
		conta15.setPlc_codg_reduzido(15);
		conta15.setPlc_conta_contabil("5");
		conta15.setPlc_descricao("Salario");

		//DefaultMutableTreeNode noValue14 = new DefaultMutableTreeNode(conta15);
		//DefaultMutableTreeNode noPai14 = new DefaultMutableTreeNode(contaNull);
		listaPlanoDeConta.add(new Node(conta15, contaNull));

	}*/
}
