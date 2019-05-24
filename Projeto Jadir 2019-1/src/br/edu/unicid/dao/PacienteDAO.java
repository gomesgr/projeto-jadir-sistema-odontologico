package br.edu.unicid.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import br.edu.unicid.bean.Endereco;
import br.edu.unicid.bean.Paciente;
import br.edu.unicid.bean.Sexo;
import br.edu.unicid.util.ConnectionFactory;

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
			ps.setString(1, paciente.getNome());
			ps.setString(2, paciente.getCpf());
			ps.setDate(3, paciente.getDtNasc());
			ps.setString(4, paciente.getTelefone());
			ps.setString(5, paciente.getSexo().getSexo());
			ps.setString(6, paciente.getEmail());
			ps.setString(7, paciente.getCidade());
			ps.setString(8, paciente.getUf());
			ps.setString(9, paciente.getEnd().getLogradouro());
			ps.setString(10, paciente.getEnd().getCep());
			ps.setString(11, paciente.getBairro());
			ps.setString(12, paciente.getEnd().getNumeroCasa());
			ps.setString(13, paciente.getHistDoencas());
			ps.setString(14, paciente.getLogin());
			ps.setString(15, paciente.getSenha());
			ps.setBoolean(16, paciente.getSms());
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
			ps.setString(1, paciente.getCpf());
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
			ps = conn.prepareStatement("UPDATE paciente SET"
					+ "nome=?, cpf=?, data_nascimento=?, telefone=?, sexo=?,"
					+ "email=?, cidade=?, uf=?, endereco_residencial=?, cep=?"
					+ "bairro=?, num_residencia=?, historico_doencas=?, login=?"
					+ "senha=?, sms=? WHERE id=?");
			
			ps.setString(1, paciente.getNome()); 
			ps.setString(2, paciente.getCpf());
			ps.setDate(3, paciente.getDtNasc());
			ps.setString(4, paciente.getTelefone());
			ps.setString(5, paciente.getSexo().getSexo());
			ps.setString(6, paciente.getEmail());
			ps.setString(7, paciente.getCidade());
			ps.setString(8, paciente.getUf());
			ps.setString(9, paciente.getEnd().getLogradouro());
			ps.setString(10, paciente.getEnd().getCep());
			ps.setString(11, paciente.getBairro());
			ps.setString(12, paciente.getEnd().getNumeroCasa());
			ps.setString(13, paciente.getHistDoencas());
			ps.setString(14, paciente.getLogin());
			ps.setString(15, paciente.getSenha());
			ps.setBoolean(16, paciente.getSms());
			ps.setInt(17, paciente.getId());
			
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
				Endereco end = new Endereco(
						rs.getString("endereco_residencial"), 
						rs.getString("num_residencia"), rs.getString("cep"));
				pacientes.add(
					new Paciente(
							rs.getInt("id"),
							rs.getString("nome"),
							rs.getString("cpf"),
							rs.getDate("data_nascimento"),
							rs.getString("telefone"),
							rs.getString("sexo") == Sexo.MASCULINO.getSexo() ? 
									Sexo.MASCULINO : Sexo.FEMININO,
							rs.getString("email"),
							rs.getString("cidade"),
							rs.getString("uf"),
							end,
							rs.getString("bairro"),
							rs.getString("historico_doencas"),
							rs.getString("login"),
							rs.getString("senha"),
							rs.getBoolean("sms")
						)
				);
			}
			ConnectionFactory.close(conn, ps, rs);
			return pacientes;
		} catch (SQLException | ClassNotFoundException e) {
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
			ConnectionFactory.close(conn, ps, rs);
		} catch (SQLException | ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Erro ao listar o paciente: " +
					e.getLocalizedMessage() , "Erro de Listagem 2", 
					JOptionPane.ERROR_MESSAGE);
		}
		return null;
	}
}
