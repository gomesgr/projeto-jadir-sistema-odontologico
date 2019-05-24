package br.edu.unicid.bean;

import java.sql.Date;

// TODO implementar dados necessarios para a construcao do programa
public class Paciente 
{
	private Integer id;
	private String nome;
	private String cpf;
	private Date dtNasc;
	private String telefone;
	private String email;
	private String cidade;
	private String uf;
	private Endereco end;
	private String bairro;
	private String histDoencas;
	private String login;
	private String senha;
	private Boolean sms;
	
	public Paciente(Integer id, String nome, String cpf, Date dtNasc, String telefone, String email, String cidade, String uf,
			Endereco end, String bairro, String histDoencas, String login, String senha, Boolean sms) 
	{
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.dtNasc = dtNasc;
		this.telefone = telefone;
		this.email = email;
		this.cidade = cidade;
		this.uf = uf;
		this.end = end;
		this.bairro = bairro;
		this.histDoencas = histDoencas;
		this.login = login;
		this.senha = senha;
		this.sms = sms;
	}
	
	public Integer getIdPaciente() {
		return id;
	}

	public void setIdPaciente(Integer id) {
		this.id = id;
	}

	public Date getDtNascPaciente() {
		return dtNasc;
	}

	public void setDtNascPaciente(Date dtNasc) {
		this.dtNasc = dtNasc;
	}

	public String getTelefonePaciente() {
		return telefone;
	}

	public void setTelefonePaciente(String telefone) {
		this.telefone = telefone;
	}

	public String getEmailPaciente() {
		return email;
	}

	public void setEmailPaciente(String email) {
		this.email = email;
	}

	public String getCidadePaciente() {
		return cidade;
	}

	public void setCidadePaciente(String cidade) {
		this.cidade = cidade;
	}

	public String getUfPaciente() {
		return uf;
	}

	public void setUfPaciente(String uf) {
		this.uf = uf;
	}

	public Endereco getEndPaciente() {
		return end;
	}

	public void setEndPaciente(Endereco end) {
		this.end = end;
	}

	public String getBairroPaciente() {
		return bairro;
	}

	public void setBairroPaciente(String bairro) {
		this.bairro = bairro;
	}

	public String getHistDoencasPaciente() {
		return histDoencas;
	}

	public void setHistDoencasPaciente(String histDoencas) {
		this.histDoencas = histDoencas;
	}

	public Boolean getSmsPaciente() {
		return sms;
	}

	public void setSmsPaciente(Boolean sms) {
		this.sms = sms;
	}

	public String getCpfPaciente() {
		return cpf;
	}

	public void setCpfPaciente(String cpf) {
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
