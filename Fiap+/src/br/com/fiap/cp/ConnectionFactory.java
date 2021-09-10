package br.com.fiap.cp;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class ConnectionFactory {

	public static Connection getConnetion() throws SQLException {
		
		String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";
		String user = "rm86675";
		String password = "071201";
		Connection connection = DriverManager.getConnection(url, user, password);
	
		return connection;
	}
	

}
