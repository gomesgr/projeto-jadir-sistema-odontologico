package br.edu.unicid.bean;

public class Contato {
    public enum Motivo{
        RECLAMACAO("Reclamação"), ELOGIO("Elogio"), CONTATO("Contato");

        private String motivo;

        private Motivo(String motivo) {
            this.motivo = motivo;
        }

        public String getMotivo() {
            return motivo;
        }
    }

    private String nome;
    private String email;
    private String assunto;
    private Motivo motivo;
    private String mensagem;

	public Contato(String nome, String email, String assunto, Motivo motivo, 
			String mensagem) {
		this.nome = nome;
		this.email = email;
		this.assunto = assunto;
		this.motivo = motivo;
		this.mensagem = mensagem;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAssunto() {
		return this.assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public Motivo getMotivo() {
		return this.motivo;
	}

	public void setMotivo(Motivo motivo) {
		this.motivo = motivo;
	}

	public String getMensagem() {
		return this.mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
}
