package br.edu.unicid.bean;

// TODO implementar dados necessarios para a construcao do programa
public class Paciente 
{
	private Integer cpf;
	private String nome;
	private String login;
	private String senha;
	
	public Paciente(Integer cpf, String nome, String login, String senha)
	{
		this.cpf = cpf;
		this.nome = nome;
		this.login = login;
		this.senha = senha;
	}

	public Integer getCpfPaciente() {
		return cpf;
	}

	public void setCpfPaciente(Integer cpf) {
		this.cpf = cpf;
	}

	public String getNomePaciente() {
		return nome;
	}

	public void setNomePaciente(String nome) {
		this.nome = nome;
	}

	public String getLoginPaciente() {
		return login;
	}

	public void setLoginPaciente(String login) {
		this.login = login;
	}

	public String getSenhaPaciente() {
		return senha;
	}

	public void setSenhaPaciente(String senha) {
		this.senha = senha;
	}
	
	
}
