package br.ifpe.com.Model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import br.ifpe.com.Enumeration.UF;

@Embeddable
public class Cidade {

	@Column(name = "cidade")
	private String nome;

	@Enumerated(EnumType.STRING)
	private UF uf;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public UF getUf() {
		return uf;
	}

	public void setUf(UF uf) {
		this.uf = uf;
	}

	public Cidade(String nome, UF uf) {
		super();
		this.nome = nome;
		this.uf = uf;
	}

	public Cidade() {

	}

}
