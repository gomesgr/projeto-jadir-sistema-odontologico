package br.edu.unicid.bean;

public class Endereco {
	private String logradouro;
	private String numeroCasa;
	private Integer cep;
	
	public Endereco(String logradouro, String numeroCasa, Integer cep) {
		super();
		this.logradouro = logradouro;
		this.numeroCasa = numeroCasa;
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumeroCasa() {
		return numeroCasa;
	}

	public void setNumeroCasa(String numeroCasa) {
		this.numeroCasa = numeroCasa;
	}

	public Integer getCep() {
		return cep;
	}

	public void setCep(Integer cep) {
		this.cep = cep;
	}
	
	
}
