package br.ifpe.com.Model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.ifpe.com.Enumerated.Cor;

@Entity
public class Materia {

	@Id
	private Integer codigo;

	private String titulo;

	private String conteudo;

	@ManyToOne
	private Professor professor;

	@Enumerated(EnumType.STRING)
	private Cor cor;

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

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Cor getCor() {
		return cor;
	}

	public void setCor(Cor cor) {
		this.cor = cor;
	}

	public Materia(Integer codigo, String titulo, String conteudo, Professor professor, Cor cor) {
		super();
		this.codigo = codigo;
		this.titulo = titulo;
		this.conteudo = conteudo;
		this.professor = professor;
		this.cor = cor;
	}

	public Materia() {

	}

}