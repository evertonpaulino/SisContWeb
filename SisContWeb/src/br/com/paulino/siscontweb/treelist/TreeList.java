package br.com.paulino.siscontweb.treelist;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import br.com.paulino.siscontweb.model.pojo.PlanoDeConta;

public class TreeList {

	private JSONArray arrayRaiz = new JSONArray();

	private void createTree(final List<PlanoDeConta> listaConta) {

		try {

			List<PlanoDeConta> listaAux = new ArrayList<PlanoDeConta>();
			listaAux.addAll(listaConta);

			List<JSONNode> listContaPai = new ArrayList<JSONNode>();

			JSONNode paiAux = null;

			int i = 0;

			JSONArray arrayChildren = new JSONArray();

			while (!listaAux.isEmpty()) {

				String auxContaPaiValue = listaAux.get(i).getPlc_conta_pai();
				
				if (auxContaPaiValue == null) {
					PlanoDeConta conta = listaAux.get(i);
					
					JSONObject children = new JSONObject();

					children.put("codgReduzido", conta.getPlc_codg_reduzido());
					children.put("conta", conta.getPlc_conta_contabil());
					children.put("descricao", conta.getPlc_descricao());

					this.getArrayRaiz().put(children);
					
					JSONNode jsonNode = new JSONNode();
					jsonNode.setConta(conta);
					jsonNode.setJsonConta(children);

					listContaPai.add(jsonNode);
					
					listaAux.remove(listaAux.get(i));
					i--;
				} else if (paiAux != null && auxContaPaiValue.equals(paiAux.getConta().getPlc_conta_contabil())) {
					PlanoDeConta conta = listaAux.get(i);

					JSONObject children = new JSONObject();

					children.put("codgReduzido", conta.getPlc_codg_reduzido());
					children.put("conta", conta.getPlc_conta_contabil());
					children.put("descricao", conta.getPlc_descricao());
					
					arrayChildren.put(children);

					JSONNode jsonNode = new JSONNode();
					jsonNode.setConta(conta);
					jsonNode.setJsonConta(children);
					
					listContaPai.add(jsonNode);
					
					listaAux.remove(listaAux.get(i));
					i--;
				}

				i++;

				if (listaAux.size() == i) {
					i = 0;

					if (!listContaPai.isEmpty()) {
						
						if(paiAux != null){
							paiAux.getJsonConta().put("children", arrayChildren);
							arrayChildren = new JSONArray();
						}
						
						paiAux = listContaPai.get(i);
						listContaPai.remove(i);
					}
				}
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}

	}

	public void addAll(List<PlanoDeConta> listConta) {
		createTree(listConta);
	}

	public JSONArray getArrayRaiz() {
		return arrayRaiz;
	}

}
