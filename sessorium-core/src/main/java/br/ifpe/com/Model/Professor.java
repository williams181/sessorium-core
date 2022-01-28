package br.ifpe.com.Model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;

@Entity
public class Professor extends Pessoa {

	private Curso curso;

	@NotEmpty(message = "Preencimento obrigatório")
	private String instituto;

	@NotEmpty(message = "Preencimento obrigatório")
	private String formacao;

	@NotEmpty(message = "Preencimento obrigatório")
	private String siape;


	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public String getFormacao() {
		return formacao;
	}

	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}

	public String getSiape() {
		return siape;
	}

	public void setSiape(String siape) {
		this.siape = siape;
	}

	public Professor(Integer codigo, @NotEmpty(message = "Preencimento obrigatório") String nome,
			@NotEmpty(message = "Preencimento obrigatório") String email,
			@NotEmpty(message = "Preencimento obrigatório") String telefone,
			@NotEmpty(message = "Preencimento obrigatório") String cpf, LocalDate dataNascimento, Endereco endereco,
			Curso curso, @NotEmpty(message = "Preencimento obrigatório") String instituto,
			@NotEmpty(message = "Preencimento obrigatório") String formacao,
			@NotEmpty(message = "Preencimento obrigatório") String siape) {
		super(codigo, nome, email, telefone, cpf, dataNascimento, endereco);
		this.curso = curso;
		this.instituto = instituto;
		this.formacao = formacao;
		this.siape = siape;
	}

	public String getInstituto() {
		return instituto;
	}

	public void setInstituto(String instituto) {
		this.instituto = instituto;
	}

	public Professor() {

	}

}