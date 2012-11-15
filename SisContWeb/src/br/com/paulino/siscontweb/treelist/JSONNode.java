package br.com.paulino.siscontweb.treelist;

import org.json.JSONObject;

import br.com.paulino.siscontweb.model.pojo.PlanoDeConta;

public class JSONNode{

	private PlanoDeConta conta;
	private JSONObject jsonConta;

	public PlanoDeConta getConta() {
		return conta;
	}

	public void setConta(PlanoDeConta conta) {
		this.conta = conta;
	}

	public JSONObject getJsonConta() {
		return jsonConta;
	}

	public void setJsonConta(JSONObject jsonConta) {
		this.jsonConta = jsonConta;
	}

	@Override
	public boolean equals(Object obj) {
		
		JSONNode node = (JSONNode) obj;
		
		if(conta.getPlc_conta_contabil().equals(node.getConta().getPlc_conta_contabil()))
			return true;
		
		return false;
	}
	
	
}
