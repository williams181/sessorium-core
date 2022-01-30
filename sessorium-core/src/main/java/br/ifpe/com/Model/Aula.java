package br.ifpe.com.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Aula {

	@Id
	private Integer codigo;

	private String titulo;

	private String link;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Aula() {

	}

}
