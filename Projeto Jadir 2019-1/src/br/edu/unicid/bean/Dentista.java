package br.edu.unicid.bean;

public class Dentista 
{
	private Integer id;
	private String nome;
	private Integer cro;
	private String telefone;
	
	public Dentista(Integer id, String nome, Integer cro, String telefone)
	{
		this.id = id;
		this.nome = nome;
		this.cro = cro;
		this.telefone = telefone;
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

	public Integer getCro() {
		return cro;
	}

	public void setCro(Integer cro) {
		this.cro = cro;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}
