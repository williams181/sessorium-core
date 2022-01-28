package br.ifpe.com.Model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotEmpty;

@Embeddable
public class Cidade {

	@Column(name = "cidade")
	private String nome;

	@NotEmpty(message = "Preencimento obrigatório")
	private String uf; 

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public Cidade(String nome, @NotEmpty(message = "Preencimento obrigatório") String uf) {
		super();
		this.nome = nome;
		this.uf = uf;
	}

	public Cidade() {

	}

}
