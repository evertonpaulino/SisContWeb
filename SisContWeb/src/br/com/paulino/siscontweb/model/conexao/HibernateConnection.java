package br.com.paulino.siscontweb.model.conexao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateConnection {

	public static final String NOME_DO_BANCO = "siscont";
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory(NOME_DO_BANCO);
	private static EntityManager entityManager;

	public HibernateConnection() {
		createConnection();
	}

	public static void createConnection() {
		entityManager = factory.createEntityManager();
	}

	public static EntityManager getEntityManager() {
		if (entityManager == null)
			createConnection();

		return entityManager;
	}

	public static void closeConnection() {
		entityManager.close();
	}

}
