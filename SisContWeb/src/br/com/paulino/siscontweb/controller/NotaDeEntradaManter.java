package br.com.paulino.siscontweb.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Hibernate;

import br.com.paulino.siscontweb.model.conexao.HibernateConnection;
import br.com.paulino.siscontweb.model.dao.NotaDeEntradaDAO;

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
		if(req.getParameter("operacao").equals("listaConta"))
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
		dao.exibeTodasAsNotasDeEntrada();
	}
	
	private void editarNotas(HttpServletRequest req, HttpServletResponse resp) {
		
	}

	private void salvarNotas(HttpServletRequest req, HttpServletResponse resp) {
		
	}

	private void deletarNotas(HttpServletRequest req, HttpServletResponse resp) {
	
	}
}

