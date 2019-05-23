package br.edu.unicid.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

// TODO implementar dados necessarios para a construcao do programa
public class DentistaDAO {
	private Connection conn;
	private ResultSet rs;
	private PrepareStatement ps;
	public int salvar(Dentista dentista) {
		try {
			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement("INSERT INTO dentista VALUES ()"); 
			// code here 
			ConnectionFactory.close(conn, ps);
			return ps.executeUpdate();
		} catch (SQLException e) {
			// code here
		}
		return 0;
	}
	
	public int remover (Dentista dentista) {
		try {
			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement("DELETE FROM dentista WHERE id = ?");
			// code here 
			ConnectionFactory.close(conn, ps);
			return ps.executeUpdate();
		} catch (SQLException e) {
			// code here
		}
		return 0;
	}
	
	public int alterar (Dentista dentista) {
		try {
			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement("UPDATE dentista SET");
			// code here 
			ConnectionFactory.close(conn, ps);
			return ps.executeUpdate();
		} catch (SQLException e) {
			// code here
		}
		return 0;
	}
	
	public List<Dentista> listarTodos() {
		try {
			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement("SELECT * FROM dentista");
			rs = ps.executeQuery(); 
			
			List<Dentista> dentistas = new LinkedList<>();
			// code here
			while (rs.next()) {
				dentistas.add(
					// values here
				);
			}
			ConnectionFactory.close(conn, ps, rs);
			return dentistas;
		} catch (SQLException e) {
			// code here
		}
		return null;
	}
	
	public Dentista listarUnico(Integer id) {
		try {
			// code here
			Connection conn = ConnectionFactory.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM dentista WHERE id = ?")
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			return ps.executeUpdate();
		} catch (SQLException e) {
			// code here
		}
	}
}