package br.ifpe.com.Model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import br.ifpe.com.Enumeration.Cor;

@Entity
public class Materia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;

	@NotEmpty(message = "Preencimento obrigatório")
	private String titulo;

	@NotEmpty(message = "Preencimento obrigatório")
	private String conteudo;

	@Enumerated(EnumType.STRING)
	private Cor cor;

	@ManyToOne
	private Professor professor;

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

	public Materia(Integer codigo, @NotEmpty(message = "Preencimento obrigatório") String titulo,
			@NotEmpty(message = "Preencimento obrigatório") String conteudo, Cor cor, Professor professor) {
		super();
		this.codigo = codigo;
		this.titulo = titulo;
		this.conteudo = conteudo;
		this.cor = cor;
		this.professor = professor;
	}

	public Cor getCor() {
		return cor;
	}

	public void setCor(Cor cor) {
		this.cor = cor;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Materia() {

	}

}