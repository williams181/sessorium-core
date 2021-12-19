package br.ifpe.com.Model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Professor extends Pessoa {

	@ManyToOne
	@JoinColumn(name = "curso_id")
	private Curso curso;

	@ManyToOne
	@JoinColumn(name = "instituto_id")
	private Instituicao instituto;
	
	@OneToMany
	private List<Materia> materias;

	@Enumerated(EnumType.STRING)
	private Formacao formacao;

	private int siape;
	
	@ManyToOne
	private Escola escola;

	public Formacao getFormacao() {
		return formacao;
	}

	public void setFormacao(Formacao formacao) {
		this.formacao = formacao;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Instituicao getInstituto() {
		return instituto;
	}

	public void setInstituto(Instituicao instituto) {
		this.instituto = instituto;
	}

	public int getSiape() {
		return siape;
	}

	public void setSiape(int siape) {
		this.siape = siape;
	}

	public Escola getEscola() {
		return escola;
	}

	public void setEscola(Escola escola) {
		this.escola = escola;
	}

	public List<Materia> getMaterias() {
		return materias;
	}

	public void setMaterias(List<Materia> materias) {
		this.materias = materias;
	}
	
}
