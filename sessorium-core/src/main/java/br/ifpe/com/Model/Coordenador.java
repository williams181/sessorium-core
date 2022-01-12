package br.ifpe.com.Model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;

import br.ifpe.com.Enumeration.Formacao;

@Entity
public class Coordenador extends Pessoa {

	@Enumerated(EnumType.STRING)
	private Formacao formacao;

	private Curso curso;

	@NotEmpty(message = "Preencimento obrigatório")
	private String instituto;

	public Formacao getFormacao() {
		return formacao;
	}

	public void setFormacao(Formacao formacao) {
		this.formacao = formacao;
	}

	public String getInstituto() {
		return instituto;
	}

	public void setInstituto(String instituto) {
		this.instituto = instituto;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Coordenador(Integer codigo, String nome, String email, String telefone, String cpf, LocalDate dataNascimento,
			Endereco endereco, Formacao formacao, Curso curso,
			@NotEmpty(message = "Preencimento obrigatório") String instituto) {
		super(codigo, nome, email, telefone, cpf, dataNascimento, endereco);
		this.formacao = formacao;
		this.curso = curso;
		this.instituto = instituto;
	}

	public Coordenador() {

	}

}
