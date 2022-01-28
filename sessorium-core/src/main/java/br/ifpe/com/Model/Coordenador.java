package br.ifpe.com.Model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;

@Entity
public class Coordenador extends Pessoa {

	@NotEmpty(message = "Preencimento obrigatório")
	private String formacao;

	private Curso curso;

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

	public Coordenador(Integer codigo, @NotEmpty(message = "Preencimento obrigatório") String nome,
			@NotEmpty(message = "Preencimento obrigatório") String email,
			@NotEmpty(message = "Preencimento obrigatório") String telefone,
			@NotEmpty(message = "Preencimento obrigatório") String cpf, LocalDate dataNascimento, Endereco endereco,
			String formacao, Curso curso, @NotEmpty(message = "Preencimento obrigatório") String instituto) {
		super(codigo, nome, email, telefone, cpf, dataNascimento, endereco);
		this.formacao = formacao;
		this.curso = curso;
		this.instituto = instituto;
	}

	public String getFormacao() {
		return formacao;
	}

	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}

	public Coordenador() {

	}

}