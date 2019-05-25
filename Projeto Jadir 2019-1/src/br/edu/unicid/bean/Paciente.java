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
	private String sexo;
	private String email;
	private String cidade;
	private String uf;
	private Endereco end;
	private String bairro;
	private String histDoencas;
	private String login;
	private String senha;
	private Boolean sms;

	public Paciente(String nome, String cpf, Date dtNasc, String telefone, 
			String sexo, String email, String cidade,	String uf, Endereco end, 
			String bairro, String histDoencas, String login, String senha, 
			Boolean sms) {
		this.nome = nome;
		this.cpf = cpf;
		this.dtNasc = dtNasc;
		this.telefone = telefone;
		this.sexo = sexo;
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
	
	public Paciente(Integer id, String nome, String cpf, Date dtNasc, 
			String telefone, String sexo, String email, String cidade, String uf, 
			Endereco end, String bairro, String histDoencas, String login, 
			String senha, Boolean sms) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.dtNasc = dtNasc;
		this.telefone = telefone;
		this.sexo = sexo;
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

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDtNasc() {
		return dtNasc;
	}

	public void setDtNasc(Date dtNasc) {
		this.dtNasc = dtNasc;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public Endereco getEnd() {
		return end;
	}

	public void setEnd(Endereco end) {
		this.end = end;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getHistDoencas() {
		return histDoencas;
	}

	public void setHistDoencas(String histDoencas) {
		this.histDoencas = histDoencas;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Boolean getSms() {
		return sms;
	}

	public void setSms(Boolean sms) {
		this.sms = sms;
	}
}
