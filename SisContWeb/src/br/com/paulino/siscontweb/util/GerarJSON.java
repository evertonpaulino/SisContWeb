package br.com.paulino.siscontweb.util;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import br.com.paulino.siscontweb.model.pojo.NotaDeEntrada;

public class GerarJSON {

	public JSONObject criaDataGridDaNotaDeEntrada(List<NotaDeEntrada> lista) throws JSONException{
		
		JSONArray arrayLinhas = new JSONArray();
		
		for (NotaDeEntrada notaDeEntrada : lista) {
			
			JSONObject notaJSON = new JSONObject();
			
			notaJSON.put("sequencial", notaDeEntrada.getNe_sequencial());
			notaJSON.put("descricao", notaDeEntrada.getNe_descricao());
			notaJSON.put("dataEmissao", notaDeEntrada.getNe_data_emissao());
			notaJSON.put("valor", notaDeEntrada.getNe_valor());
			notaJSON.put("status", notaDeEntrada.getNe_status());
			
			arrayLinhas.put(notaJSON);
		}
		
		JSONObject notaDataGrid = new JSONObject();
		
		notaDataGrid.put("total", lista.size());
		notaDataGrid.put("rows", arrayLinhas);
		
		return notaDataGrid;
	}

}
