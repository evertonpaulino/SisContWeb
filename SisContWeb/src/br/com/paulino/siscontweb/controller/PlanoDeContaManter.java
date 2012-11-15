package br.com.paulino.siscontweb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import br.com.paulino.siscontweb.model.conexao.HibernateConnection;
import br.com.paulino.siscontweb.model.dao.PlanoDeContaDAO;
import br.com.paulino.siscontweb.model.pojo.PlanoDeConta;
import br.com.paulino.siscontweb.treelist.TreeList;

public class PlanoDeContaManter extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final int REQUISICAO_LISTA_CONTAS = 1;
	private final int REQUISICAO_SALVAR_CONTA = 2;
	private final int REQUISICAO_EDITAR_CONTA = 3;
	private final int REQUISICAO_EXCLUIR_CONTA = 4;
	
	PlanoDeContaDAO dao = new PlanoDeContaDAO(HibernateConnection.getEntityManager());
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		switch(redireciona(req)){
			case REQUISICAO_LISTA_CONTAS:
				listarContas(req, resp);
				break;
				
			case REQUISICAO_SALVAR_CONTA:
				salvarConta(req, resp);
				break;
			
			case REQUISICAO_EDITAR_CONTA:
				editarConta(req, resp);
				break;
				
			case REQUISICAO_EXCLUIR_CONTA:
				excluirConta(req, resp);
				break;
		}
	}

	private int redireciona(HttpServletRequest req) {
		if(req.getParameter("operacao").equals("listaConta"))
			return REQUISICAO_LISTA_CONTAS;
		else if(req.getParameter("operacao").equals("insert"))
			return REQUISICAO_SALVAR_CONTA;
		else if(req.getParameter("operacao").equals("edit"))
			return REQUISICAO_SALVAR_CONTA;
		else if(req.getParameter("operacao").equals("delete"))
			return REQUISICAO_EXCLUIR_CONTA;

		return 0;
	}

	private void listarContas(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		TreeList treeList = new TreeList();
		
		treeList.addAll(dao.exibeTodasAsContas());

		resp.setContentType("text/html");
		  
		PrintWriter out = resp.getWriter();

		out.println(treeList.getArrayRaiz());
	}

	private void salvarConta(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PlanoDeConta conta = new PlanoDeConta();
		
		conta.setPlc_conta_contabil(req.getParameter("contaContabil"));
		conta.setPlc_conta_pai(req.getParameter("contaPai"));
		conta.setPlc_descricao(req.getParameter("descricao"));
		
		dao.getEntityManager().getTransaction().begin();
		dao.insereConta(conta);
		
		JSONObject jsonConta = new JSONObject();

		try {
			jsonConta.put("codgReduzido", conta.getPlc_codg_reduzido());
			jsonConta.put("conta", conta.getPlc_conta_contabil());
			jsonConta.put("descricao", conta.getPlc_descricao());
			jsonConta.put("contaPai", conta.getPlc_conta_pai());
			jsonConta.put("contaPaiCodgReduzido", req.getParameter("contaPaiCodgReduzido"));
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		
		dao.getEntityManager().getTransaction().commit();

		resp.setContentType("application/json");
		  
		PrintWriter out = resp.getWriter();

		out.println(jsonConta);
	}

	private void editarConta(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PlanoDeConta conta = new PlanoDeConta();
		
		conta.setPlc_conta_contabil(req.getParameter("contaContabil"));
		conta.setPlc_conta_pai(req.getParameter("contaPai"));
		conta.setPlc_descricao(req.getParameter("descricao"));
		
		dao.getEntityManager().getTransaction().begin();
		dao.editaConta(conta);
		
		JSONObject jsonConta = new JSONObject();

		try {
			jsonConta.put("codgReduzido", conta.getPlc_codg_reduzido());
			jsonConta.put("conta", conta.getPlc_conta_contabil());
			jsonConta.put("descricao", conta.getPlc_descricao());
			jsonConta.put("contaPai", conta.getPlc_conta_pai());
			jsonConta.put("contaPaiCodgReduzido", req.getParameter("contaPaiCodgReduzido"));
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		
		dao.getEntityManager().getTransaction().commit();

		resp.setContentType("application/json");
		  
		PrintWriter out = resp.getWriter();

		out.println(jsonConta);
	}
	
	private void excluirConta(HttpServletRequest req, HttpServletResponse resp) {
		int conta = Integer.parseInt(req.getParameter("codgReduzido"));
		
		dao.getEntityManager().getTransaction().begin();
		dao.deletaConta(conta);
		dao.getEntityManager().getTransaction().commit();
	}

}
