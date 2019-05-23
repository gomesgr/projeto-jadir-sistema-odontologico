package br.edu.unicid.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import br.edu.unicid.bean.Contato;
import br.edu.unicid.util.ConnectionFactory;

public class ContatoDAO {
	private Connection conn;
	private ResultSet rs;
	private PreparedStatement ps;
	
	public int salvar(Contato contato) {
		try {
			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement("INSERT INTO contato VALUES ()"); 
			int ret = ps.executeUpdate();
			ConnectionFactory.close(conn, ps);
			return ret;
		} catch (SQLException | ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar o contato: " +
					e.getLocalizedMessage() , "Erro de Inclusão", 
					JOptionPane.ERROR_MESSAGE);
		}
		return 0;
	}
	
	public int remover (Contato contato) {
		try {
			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement("DELETE FROM contato WHERE id = ?");
			int ret = ps.executeUpdate();
			ConnectionFactory.close(conn, ps);
			return ret;
		} catch (SQLException | ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Erro ao remover o contato: " + 
					e.getLocalizedMessage() , "Erro de Remoção", 
					JOptionPane.ERROR_MESSAGE);
		}
		return 0;
	}
	
	public int alterar (Contato contato) {
		try {
			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement("UPDATE contato SET");
			int ret = ps.executeUpdate();
			ConnectionFactory.close(conn, ps);
			return ret;
		} catch (SQLException | ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Erro ao alterar o contato: " +
					e.getLocalizedMessage() , "Erro de Alteração", 
					JOptionPane.ERROR_MESSAGE);
		}
		return 0;
	}
	
	public List<Contato> listarTodos() {
		try {
			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement("SELECT * FROM contato");
			rs = ps.executeQuery(); 
			
			List<Contato> contatos = new LinkedList<>();
			// TODO Completar mais tarde
			while (rs.next()) {
				contatos.add(
					new Contato()
				);
			}
			ConnectionFactory.close(conn, ps, rs);
			return contatos;
		} catch (SQLException | ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Erro ao listar os contatos: " 
					+ e.getLocalizedMessage() , "Erro de Listagem 1", 
					JOptionPane.ERROR_MESSAGE);
		}
		return null;
	}
	// TODO concluir implementacao mais tarde
	public Contato listarUnico(Integer id) {
		try {
			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement("SELECT * FROM contato WHERE id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			Contato c = new Contato();
			ConnectionFactory.close(conn, ps, rs);
			return c;
		} catch (SQLException | ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Erro ao listar o contato: " +
					e.getLocalizedMessage() , "Erro de Listagem 2", 
					JOptionPane.ERROR_MESSAGE);
		}
		return null;
	}
}
