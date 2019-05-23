package br.edu.unicid.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public static Connection getConnection() throws SQLException {
		Class.forName("");
		
		String url = "jdbc:mysql://localhost:3306";
		String usr = "admin";
		String pass = "";
		
		// Retorna a conexao com MYSQL de acordo com url, usuario e sua senha
		return DriverManager.getConnection(url, usr, pass);
	}
	
	public static void close (Connection conn, PreparedStatement ps, ResultSet rs) 
		close(conn, ps);
		try {
			rs.close();
		} catch (SQLException e) {
			
		}
	}
	
	public static void close (Connection conn, PreparedStatement ps) {
		close(conn);
		try {
			ps.close();
		} catch (SQLException e) {
			
		}
	}
	
	public static void close (Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			
		}
	}
}
