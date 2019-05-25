package br.edu.unicid.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import br.edu.unicid.bean.Dentista;
import br.edu.unicid.util.ConnectionFactory;

public class DentistaDAO {
	private Connection conn;
	private ResultSet rs;
	private PreparedStatement ps;
	
	public int salvar(Dentista dentista) {
		try {
			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement("INSERT INTO dentista (Nome, CRO, Telefone) VALUES (?,?,?)"); 
			// code here 
			ps.setString(1, dentista.getNome());
			ps.setInt(2, dentista.getCro());
			ps.setString(3, dentista.getTelefone());
			int ret = ps.executeUpdate();
			ConnectionFactory.close(conn, ps);
			return ret;
		} catch (SQLException | ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar o dentista: " +
					e.getLocalizedMessage() , "Erro de Inclusão", 
					JOptionPane.ERROR_MESSAGE);
		}
		return 0;
	}
	
	public int remover (Dentista dentista) {
		try {
			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement("DELETE FROM dentista WHERE id = ?");
			int ret = ps.executeUpdate();
			ConnectionFactory.close(conn, ps);
			return ret;
		} catch (SQLException | ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Erro ao remover o dentista: " + 
					e.getLocalizedMessage() , "Erro de Remoção", 
					JOptionPane.ERROR_MESSAGE);
		}
		return 0;
	}
	
	public int alterar (Dentista dentista) {
		try {
			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement("UPDATE dentista SET");
			int ret = ps.executeUpdate();
			ConnectionFactory.close(conn, ps);
			return ret;
		} catch (SQLException | ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Erro ao alterar o dentista: " +
					e.getLocalizedMessage() , "Erro de Alteração", 
					JOptionPane.ERROR_MESSAGE);
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
					new Dentista(
							rs.getInt("id"),
							rs.getString("nome"),
							rs.getInt("cro"),
							rs.getString("telefone"))
				);
			}
			ConnectionFactory.close(conn, ps, rs);
			return dentistas;
		} catch (SQLException | ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Erro ao listar os dentistas: " 
					+ e.getLocalizedMessage() , "Erro de Listagem 1", 
					JOptionPane.ERROR_MESSAGE);
		}
		return null;
	}
	// TODO concluir implementacao mais tarde
	public Dentista listarUnico(Integer id) {
		try {
			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement("SELECT * FROM dentista WHERE id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			ps.executeUpdate();
			ConnectionFactory.close(conn, ps, rs);
		} catch (SQLException | ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Erro ao listar o dentista: " +
					e.getLocalizedMessage() , "Erro de Listagem 2", 
					JOptionPane.ERROR_MESSAGE);
		}
		
		return null;
	}
}