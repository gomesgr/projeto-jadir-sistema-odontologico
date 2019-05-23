package br.edu.unicid.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import br.com.unicid.util.ConnectionFactory;
import br.edu.unicid.bean.Paciente;

// TODO implementar dados necessarios para a construcao do programa
public class PacienteDAO 
{
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	private Paciente paciente;
	
	public int salvar(Paciente paciente) {
		try {
			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement("INSERT INTO paciente VALUES ()"); 
			// code here 
			ConnectionFactory.close(conn, ps);
			return ps.executeUpdate();
		} catch (SQLException e) {
			// code here
		}
		return 0;
	}
	
	public int remover (Paciente paciente) {
		try {
			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement("DELETE FROM paciente WHERE cpf = ?");
			// code here 
			ConnectionFactory.close(conn, ps);
			return ps.executeUpdate();
		} catch (SQLException e) {
			// code here
		}
		return 0;
	}
	
	public int alterar (Paciente paciente) {
		try {
			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement("UPDATE paciente SET");
			// code here 
			ConnectionFactory.close(conn, ps);
			return ps.executeUpdate();
		} catch (SQLException e) {
			// code here
		}
		return 0;
	}
	
	public List<Paciente> listarTodos() {
		try {
			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement("SELECT * FROM paciente");
			rs = ps.executeQuery(); 
			
			List<Paciente> pacientes = new LinkedList<>();
			// code here
			while (rs.next()) {
				pacientes.add(
					// values here
				);
			}
			ConnectionFactory.close(conn, ps, rs);
			return pacientes;
		} catch (SQLException e) {
			// code here
		}
		return null;
	}
	
	public void listarUnico(Integer cpf) {
		try {
			// code here
			Connection conn = ConnectionFactory.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM paciente WHERE id = ?");
			ps.setInt(1, cpf);
			ResultSet rs = ps.executeQuery();
			ps.executeUpdate();
		} catch (SQLException e) {
			// code here
		}
	}
}
