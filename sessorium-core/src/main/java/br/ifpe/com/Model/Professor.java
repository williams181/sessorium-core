package br.ifpe.com.Model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.ifpe.com.Enumeration.Formacao;

@Entity
public class Professor extends Pessoa {

	private Curso curso;

	@NotEmpty(message = "Preencimento obrigatório")
	private String instituto;

	@Enumerated(EnumType.STRING)
	private Formacao formacao;

	@NotNull
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

	public int getSiape() {
		return siape;
	}

	public void setSiape(int siape) {
		this.siape = siape;
	}

	public String getInstituto() {
		return instituto;
	}

	public void setInstituto(String instituto) {
		this.instituto = instituto;
	}

	public Professor(Integer codigo, String nome, String email, String telefone, String cpf, LocalDate dataNascimento,
			Endereco endereco, Curso curso, @NotEmpty(message = "Preencimento obrigatório") String instituto,
			Formacao formacao, @NotNull int siape) {
		super(codigo, nome, email, telefone, cpf, dataNascimento, endereco);
		this.curso = curso;
		this.instituto = instituto;
		this.formacao = formacao;
		this.siape = siape;
	}

	public Professor() {

	}

}