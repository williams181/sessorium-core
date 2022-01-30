package br.ifpe.com.Model;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import br.ifpe.com.Enumerated.UF;

@Embeddable
public class Cidade {

	private String municipio;

	@Enumerated(EnumType.STRING)
	private UF uf;
	
	

	public String getMunicipio() {
		return municipio;
	}



	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}



	public UF getUf() {
		return uf;
	}



	public void setUf(UF uf) {
		this.uf = uf;
	}



	public Cidade(String municipio, UF uf) {
		super();
		this.municipio = municipio;
		this.uf = uf;
	}



	public Cidade() {

	}

}
