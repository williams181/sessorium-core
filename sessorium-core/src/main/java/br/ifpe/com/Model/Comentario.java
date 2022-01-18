package br.ifpe.com.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class Comentario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;

	@NotEmpty(message = "Preencimento obrigatório")
	private String titulo;

	@NotEmpty(message = "Preencimento obrigatório")
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

	public Comentario(Integer codigo, @NotEmpty(message = "Preencimento obrigatório") String titulo,
			@NotEmpty(message = "Preencimento obrigatório") String conteudo) {
		super();
		this.codigo = codigo;
		this.titulo = titulo;
		this.conteudo = conteudo;
	}

	public Comentario() {

	}
}
