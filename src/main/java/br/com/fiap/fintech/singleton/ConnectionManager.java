package br.com.fiap.fintech.singleton;

import br.com.fiap.fintech.jdbc.OracleConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager implements OracleConnection {

	private static ConnectionManager connectionManager;
	private Connection connection;
	
	private ConnectionManager() {
		
	}
	
	public static ConnectionManager getInstance() {
		if(connectionManager == null) {
			connectionManager = new ConnectionManager();
		}
		return connectionManager;
	}
	
	public Connection getConnection() {
		try {
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("Conectado ao Oracle DB com sucesso!");
			return connection;
		} catch(SQLException e) {
			System.err.println("Erro ao conectar no Oracle DB.");
			e.printStackTrace();
			return null;
		} 
	}
}
