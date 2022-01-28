package br.ifpe.com.Model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Aluno extends Pessoa {

	@NotEmpty(message = "Preencimento obrigatório")
	private String matricula;

	@NotNull
	private boolean pcd;

	private String categoriaPcd;

	public boolean isPcd() {
		return pcd;
	}

	public void setPcd(boolean pcd) {
		this.pcd = pcd;
	}

	public Aluno(Integer codigo, @NotEmpty(message = "Preencimento obrigatório") String nome,
			@NotEmpty(message = "Preencimento obrigatório") String email,
			@NotEmpty(message = "Preencimento obrigatório") String telefone,
			@NotEmpty(message = "Preencimento obrigatório") String cpf, LocalDate dataNascimento, Endereco endereco,
			@NotEmpty(message = "Preencimento obrigatório") String matricula, @NotNull boolean pcd,
			String categoriaPcd) {
		super(codigo, nome, email, telefone, cpf, dataNascimento, endereco);
		this.matricula = matricula;
		this.pcd = pcd;
		this.categoriaPcd = categoriaPcd;
	}

	public String getCategoriaPcd() {
		return categoriaPcd;
	}

	public void setCategoriaPcd(String categoriaPcd) {
		this.categoriaPcd = categoriaPcd;
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