package br.ifpe.com.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Comentario {

	@Id
	private Integer codigo;

	private String titulo;

	private String conteudo;

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

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public Comentario() {

	}
}
