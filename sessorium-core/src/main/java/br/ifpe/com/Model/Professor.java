package br.ifpe.com.Model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Professor extends Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codigo;

	private Curso curso;

	private Instituicao instituto;

	@Enumerated(EnumType.STRING)
	private Formacao formacao;

	private int siape;

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

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getSiape() {
		return siape;
	}

	public void setSiape(int siape) {
		this.siape = siape;
	}

}
