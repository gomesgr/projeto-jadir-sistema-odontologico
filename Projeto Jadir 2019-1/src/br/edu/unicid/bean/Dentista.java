package br.edu.unicid.bean;

// TODO implementar dados necessarios para a construcao do programa
public class Dentista 
{
	private Integer id;
	private String nome;
	private Integer cro;
	private String telefone;
	
	public Dentista(Integer id, String nome, Integer cro, String telefone)
	{
		this.id = id;aaaa
		this.nome = nome;
		this.cro = cro;
		this.telefone = telefone;
	}
	
	public Integer getCroDentista() {
		return cro;
	}

	public void setCroDentista(Integer cro) {
		this.cro = cro;
	}

	public String getTelefoneDentista() {
		return telefone;
	}

	public void setTelefoneDentista(String telefone) {
		this.telefone = telefone;
	}

	public Integer getIdDentista() {
		return id;
	}

	public void setIdDentista(Integer cpf) {
		this.id = cpf;
	}

	public String getNomeDentista() {
		return nome;
	}

	public void setNomeDentista(String nome) {
		this.nome = nome;
	}
}
