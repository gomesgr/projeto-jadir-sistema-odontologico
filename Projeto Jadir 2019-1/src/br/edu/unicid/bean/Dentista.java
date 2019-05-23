package br.edu.unicid.bean;

// TODO implementar dados necessarios para a construcao do programa
public class Dentista 
{
	private Integer cpf;
	private String nome;
	
	public Dentista(Integer cpf, String nome)
	{
		this.cpf = cpf;
		this.nome = nome;
	}

	public Integer getCpfDentista() {
		return cpf;
	}

	public void setCpfDentista(Integer cpf) {
		this.cpf = cpf;
	}

	public String getNomeDentista() {
		return nome;
	}

	public void setNomeDentista(String nome) {
		this.nome = nome;
	}
}
