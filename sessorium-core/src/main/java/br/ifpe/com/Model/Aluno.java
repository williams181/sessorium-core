package br.ifpe.com.Model;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;

@Entity
public class Aluno extends Pessoa {

	@NotEmpty(message = "Preencimento obrigatório")
	private String matricula;

	public Aluno(Integer codigo, @NotEmpty(message = "Preencimento obrigatório") String nome,
			@NotEmpty(message = "Preencimento obrigatório") String email,
			@NotEmpty(message = "Preencimento obrigatório") String telefone,
			@NotEmpty(message = "Preencimento obrigatório") String cpf,
			@NotEmpty(message = "Preencimento obrigatório") String matricula) {
		super(codigo, nome, email, telefone, cpf);
		this.matricula = matricula;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Aluno() {

	}

}