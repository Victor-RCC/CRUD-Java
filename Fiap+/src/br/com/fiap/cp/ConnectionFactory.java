package br.com.fiap.cp;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class ConnectionFactory {
	
	/**
	 * Classe respons�vel pela conex�o com o banco de dados.
	 *
	 * @return Connection - retorna uma conex�o com o banco de dados.
	 * @throws SQLException - caso a conex�o falhe.
	 */

	public static Connection getConnetion() throws SQLException {
	
		String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";
		String user = "";
		String password = "";
		Connection connection = DriverManager.getConnection(url, user, password);
	
		return connection;
	}
	

}
