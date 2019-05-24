package br.edu.unicid.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import br.edu.unicid.bean.Paciente;
import br.edu.unicid.util.ConnectionFactory;

// TODO implementar dados necessarios para a construcao do programa
public class PacienteDAO 
{
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public int salvar(Paciente paciente) {
		try {
			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement("INSERT INTO paciente "
					+ "(nome, cpf, data_nascimento, telefone, sexo, email, "
					+ "cidade, uf, endereco_residencial, cep, bairro, "
					+ "num_residencia, historico_doencas, login, senha, sms"
					+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"); 
			ps.setString(1, paciente.getNomePaciente());
			int ret = ps.executeUpdate();
			ConnectionFactory.close(conn, ps);
			return ret;
		} catch (SQLException | ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar o paciente: " + 
				e.getLocalizedMessage() , "Erro de Inclusão", 
				JOptionPane.ERROR_MESSAGE);
		}
		return 0;
	}
	
	public int remover (Paciente paciente) {
		try {
			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement("DELETE FROM paciente WHERE cpf = ?");
			int ret = ps.executeUpdate();
			ConnectionFactory.close(conn, ps);
			return ret;
		} catch (SQLException | ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Erro ao remover o paciente: " + 
					e.getLocalizedMessage() , "Erro de Remoção", 
					JOptionPane.ERROR_MESSAGE);
		}
		return 0;
	}
	
	public int alterar (Paciente paciente) {
		try {
			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement("UPDATE paciente SET");
			int ret = ps.executeUpdate();
			ConnectionFactory.close(conn, ps);
			return ret;
		} catch (SQLException | ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Erro ao alterar o paciente: " +
					e.getLocalizedMessage() , "Erro de alteração", 
					JOptionPane.ERROR_MESSAGE);
		}
		return 0;
	}
	
	public List<Paciente> listarTodos() {
		try {
			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement("SELECT * FROM paciente");
			rs = ps.executeQuery(); 
			
			List<Paciente> pacientes = new LinkedList<>();
			// TODO completar mais tarde
			while (rs.next()) {
				pacientes.add(
					new Paciente()
				);
			}
			ConnectionFactory.close(conn, ps, rs);
			return pacientes;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, 
					"Erro ao listar todos os pacientes: " + 
					e.getLocalizedMessage() , "Erro de Listagem 1", 
					JOptionPane.ERROR_MESSAGE);
		}
		return null;
	}
	
	public Paciente listarUnico(Integer cpf) {
		try {
			// code here
			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement("SELECT * FROM paciente WHERE id = ?");
			ps.setInt(1, cpf);
			ResultSet rs = ps.executeQuery();
			ps.executeUpdate();
		} catch (SQLException | ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Erro ao listar o paciente: " +
					e.getLocalizedMessage() , "Erro de Listagem 2", 
					JOptionPane.ERROR_MESSAGE);
		}
		return null;
	}
}
