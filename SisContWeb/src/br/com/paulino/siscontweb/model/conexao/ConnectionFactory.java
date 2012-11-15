package br.com.paulino.siscontweb.model.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private Connection conexao;

	public ConnectionFactory(String url, String user, String password) throws SQLException {

		String driverName = "org.gjt.mm.mysql.Driver";

		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			throw new SQLException("Nao foi possivel registrar o Driver do Banco.",e);
		}
		
		this.conexao = DriverManager.getConnection(url, user, password);
	}

	public Connection getConexao() {
		return conexao;
	}

	public boolean isConectado() throws SQLException {
		return !this.conexao.isClosed();
	}

	public void encerraConnection() throws SQLException {
		this.conexao.close();
	}
}
