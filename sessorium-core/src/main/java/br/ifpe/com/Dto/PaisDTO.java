package br.ifpe.com.Dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import br.ifpe.com.Model.Endereco;
import br.ifpe.com.Model.Pessoa;

public class PaisDTO extends Pessoa implements Serializable {

	private static final long serialVersionUID = -3382629362903163832L;
	@NotNull
	private boolean tutor;

	public boolean isTutor() {
		return tutor;
	}

	public void setTutor(boolean tutor) {
		this.tutor = tutor;
	}

	public PaisDTO(Integer codigo, String nome, String email, String telefone, String cpf, LocalDate dataNascimento,
			Endereco endereco, @NotNull boolean tutor) {
		super(codigo, nome, email, telefone, cpf, dataNascimento, endereco);
		this.tutor = tutor;
	}

	public PaisDTO() {

	}

}
