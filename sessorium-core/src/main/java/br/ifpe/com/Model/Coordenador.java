package br.ifpe.com.Model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

@Entity
public class Coordenador extends Pessoa {

	@NotNull
	@Enumerated(EnumType.STRING)
	private Formacao formacao;
	
	@NotNull
	private Curso curso;
	
	@NotNull
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
