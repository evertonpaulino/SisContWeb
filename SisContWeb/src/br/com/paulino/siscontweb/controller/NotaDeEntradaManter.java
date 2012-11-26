package br.com.paulino.siscontweb.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import br.com.paulino.siscontweb.model.conexao.HibernateConnection;
import br.com.paulino.siscontweb.model.dao.NotaDeEntradaDAO;
import br.com.paulino.siscontweb.model.pojo.NotaDeEntrada;
import br.com.paulino.siscontweb.util.GerarJSON;

public class NotaDeEntradaManter extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final int REQUISICAO_LISTAR_NOTAS = 1;
	private final int REQUISICAO_SALVAR_NOTAS = 2;
	private final int REQUISICAO_EDITAR_NOTAS = 3;
	private final int REQUISICAO_DELETAR_NOTAS = 4;
	
	NotaDeEntradaDAO dao = new NotaDeEntradaDAO(HibernateConnection.getEntityManager());
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		switch(redirecionar(req)){
			case REQUISICAO_LISTAR_NOTAS:
				listarNotas(req, resp);
				break;

			case REQUISICAO_SALVAR_NOTAS:
				salvarNotas(req, resp);
				break;
				
			case REQUISICAO_EDITAR_NOTAS:
				editarNotas(req, resp);
				break;
				
			case REQUISICAO_DELETAR_NOTAS:
				deletarNotas(req, resp);
				break;
		}
	}
	
	private int redirecionar(HttpServletRequest req) {
		if(req.getParameter("operacao").equals("listaNotas"))
			return REQUISICAO_LISTAR_NOTAS;
		else if(req.getParameter("operacao").equals("insert"))
			return REQUISICAO_SALVAR_NOTAS;
		else if(req.getParameter("operacao").equals("edit"))
			return REQUISICAO_SALVAR_NOTAS;
		else if(req.getParameter("operacao").equals("delete"))
			return REQUISICAO_DELETAR_NOTAS;

		return 0;
	}

	private void listarNotas(HttpServletRequest req, HttpServletResponse resp) {
		GerarJSON gerarJSON = new GerarJSON();
		
		JSONObject jsonNota = null;
		
		try {
			
			jsonNota = gerarJSON.criaDataGridDaNotaDeEntrada(dao.exibeTodasAsNotasDeEntrada());
			
		} catch (JSONException e) {
			e.printStackTrace();
		}

		resp.setContentType("application/json");
			  
		PrintWriter out;
		
		try {
			
			out = resp.getWriter();
			out.println(jsonNota);
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	private void salvarNotas(HttpServletRequest req, HttpServletResponse resp) {
		NotaDeEntrada entrada = new NotaDeEntrada();
		
		entrada.setNe_descricao(req.getParameter("descricao"));
		
		Date date = new Date(req.getParameter("dataEmissao"));
		entrada.setNe_data_emissao(date);
		
		entrada.setNe_valor(new BigDecimal(req.getParameter("valor")));
		entrada.setNe_status(req.getParameter("status"));
		
		dao.getEntityManager().getTransaction().begin();
		dao.insereNota(entrada);
		dao.getEntityManager().getTransaction().commit();
		
	}
	
	private void editarNotas(HttpServletRequest req, HttpServletResponse resp) {
		NotaDeEntrada entrada = new NotaDeEntrada();

		entrada.setNe_sequencial(Integer.parseInt(req.getParameter("sequencial")));

		entrada.setNe_descricao(req.getParameter("descricao"));
		
		Date date = new Date(req.getParameter("dataEmissao"));
		entrada.setNe_data_emissao(date);
		
		entrada.setNe_valor(new BigDecimal(req.getParameter("valor")));
		entrada.setNe_status(req.getParameter("status"));
		
		dao.getEntityManager().getTransaction().begin();
		dao.editaNota(entrada);
		dao.getEntityManager().getTransaction().commit();
	}

	private void deletarNotas(HttpServletRequest req, HttpServletResponse resp) {
		String param = req.getParameter("sequencial");
		int nota = Integer.parseInt(param);
		
		dao.getEntityManager().getTransaction().begin();
		dao.deletaNota(nota);
		dao.getEntityManager().getTransaction().commit();
		
		JSONObject jsonNota = new JSONObject();
		try {
			jsonNota.put("success", true);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		resp.setContentType("application/json");
		
		PrintWriter out;
		try {
			out = resp.getWriter();
			out.print(jsonNota);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}

