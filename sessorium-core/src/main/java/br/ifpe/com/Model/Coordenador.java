package br.ifpe.com.Model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Coordenador extends Pessoa {

	@Enumerated(EnumType.STRING)
	private Formacao formacao;

	@OneToOne
	@JoinColumn(name = "curso_id")
	private Curso curso;

	@ManyToOne
	@JoinColumn(name = "instituto_id")
	private Instituicao instituto;

	public Formacao getFormacao() {
		return formacao;
	}

	public void setFormacao(Formacao formacao) {
		this.formacao = formacao;
	}

	public Instituicao getInstituto() {
		return instituto;
	}

	public void setInstituto(Instituicao instituto) {
		this.instituto = instituto;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

}
