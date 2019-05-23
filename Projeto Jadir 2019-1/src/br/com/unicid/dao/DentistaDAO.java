package br.com.unicid.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

// TODO implementar dados necessarios para a construcao do programa
public class DentistaDAO {
	public int salvar(Dentista dentista) {
		try (Connection conn = ConnectionFactory.getConnection();
			PreparedStatement ps = conn.prepareStatement("INSERT INTO dentista VALUES ()"); 
			) {
			// code here 
			return ps.executeUpdate();
		} catch (SQLException e) {
			// code here
		}
		return 0;
	}
	
	public int remover (Dentista dentista) {
		try (Connection conn = ConnectionFactory.getConnection();
			PreparedStatement ps = conn.prepareStatement("DELETE FROM dentista WHERE id = ?"); 
			) {
			// code here 
			ps.setInt(1, dentista.getId())
			return ps.executeUpdate();
		} catch (SQLException e) {
			// code here
		}
		return 0;
	}
	
	public int alterar (Dentista dentista) {
		try (Connection conn = ConnectionFactory.getConnection();
			PreparedStatement ps = conn.prepareStatement("UPDATE dentista SET"); 
			) {
			// code here 
			return ps.executeUpdate();
		} catch (SQLException e) {
			// code here
		}
		return 0;
	}
	
	public List<Dentista> listarTodos() {
		try (Connection conn = ConnectionFactory.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM dentista")
			ResultSet rs = ps.executeQuery(); 
			) {
			List<Dentista> dentistas = new LinkedList<>();
			// code here
			while (rs.next()) {
				dentistas.add(
					// values here
				);
			}
		} catch (SQLException e) {
			// code here
		}
	}
	
	public Dentista listarUnico(Integer id) {
		try (Connection conn = ConnectionFactory.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM dentista WHERE id = ?")
			) {
			// code here
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			return ps.executeUpdate();
		} catch (SQLException e) {
			// code here
		}
	}
}