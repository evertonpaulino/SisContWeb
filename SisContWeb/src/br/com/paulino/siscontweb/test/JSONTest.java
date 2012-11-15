package br.com.paulino.siscontweb.test;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import br.com.paulino.siscontweb.model.pojo.PlanoDeConta;


public class JSONTest {

	public static void main(String[] args) {
		
		try {
			PlanoDeConta conta1 = new PlanoDeConta();
			conta1.setPlc_conta_contabil("1");
			conta1.setPlc_descricao("Entrada");
			
			JSONObject obj1 = new JSONObject();
		
			obj1.put("contaContabil", conta1.getPlc_conta_contabil());
			obj1.put("descricao", conta1.getPlc_descricao());
			
			PlanoDeConta conta2 = new PlanoDeConta();
			conta2.setPlc_conta_contabil("2");
			conta2.setPlc_descricao("Saida");
			
			JSONObject obj2 = new JSONObject();
		
			obj2.put("contaContabil", conta2.getPlc_conta_contabil());
			obj2.put("descricao", conta2.getPlc_descricao());
			
			JSONArray array = new JSONArray();
			
			array.put(obj1);
			array.put(obj2);

			System.out.println(array);
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
	}
	
}

