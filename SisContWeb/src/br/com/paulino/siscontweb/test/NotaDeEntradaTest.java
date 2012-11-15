package br.com.paulino.siscontweb.test;

import java.math.BigDecimal;
import java.util.Date;

import br.com.paulino.siscontweb.model.conexao.HibernateConnection;
import br.com.paulino.siscontweb.model.dao.NotaDeEntradaDAO;
import br.com.paulino.siscontweb.model.pojo.NotaDeEntrada;

public class NotaDeEntradaTest {

	public static void main(String[] args) {
		NotaDeEntradaDAO dao = new NotaDeEntradaDAO(HibernateConnection.getEntityManager());
		
		NotaDeEntrada entrada = new NotaDeEntrada();
		//entrada.setNe_sequencial(10);
		entrada.setNe_descricao("teste nota");
		entrada.setNe_data_emissao(new Date());
		entrada.setNe_status("novo");
		entrada.setNe_valor(new BigDecimal(100));
		
		System.out.println("insert");
		dao.insereNota(entrada);
		
		System.out.println("insert2");
		dao.getEntityManager().getTransaction().begin();

		dao.insert(entrada);
		dao.getEntityManager().getTransaction().commit();
		dao.getEntityManager().close();
	}
}
