package br.ifpe.com.Model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;

import br.ifpe.com.Enumerated.Formacao;

@Entity
public class Coordenador extends Pessoa {
	
	private Curso curso;
	
	@Enumerated(EnumType.STRING)
	private Formacao formacao;

	@NotEmpty(message = "Preencimento obrigatório")
	private String instituto;
	
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

	public Formacao getFormacao() {
		return formacao;
	}

	public void setFormacao(Formacao formacao) {
		this.formacao = formacao;
	}

	public Coordenador(Integer codigo, @NotEmpty(message = "Preencimento obrigatório") String nome,
			@NotEmpty(message = "Preencimento obrigatório") String email,
			@NotEmpty(message = "Preencimento obrigatório") String telefone,
			@NotEmpty(message = "Preencimento obrigatório") String cpf, LocalDate dataNascimento, Endereco endereco,
			Curso curso, Formacao formacao, @NotEmpty(message = "Preencimento obrigatório") String instituto) {
		super(codigo, nome, email, telefone, cpf, dataNascimento, endereco);
		this.curso = curso;
		this.formacao = formacao;
		this.instituto = instituto;
	}

	public Coordenador() {

	}

}