package br.ifpe.com.Model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class Pais extends Pessoa {

	@NotNull
	private boolean tutor;

	public boolean isTutor() {
		return tutor;
	}

	public void setTutor(boolean tutor) {
		this.tutor = tutor;
	}

	public Pais(Integer codigo, String nome, String email, String telefone, String cpf, LocalDate dataNascimento,
			Endereco endereco, @NotNull boolean tutor) {
		super(codigo, nome, email, telefone, cpf, dataNascimento, endereco);
		this.tutor = tutor;
	}

	public Pais() {

	}

}
