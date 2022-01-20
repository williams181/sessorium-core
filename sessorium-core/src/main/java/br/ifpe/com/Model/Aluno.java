package br.ifpe.com.Model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.ifpe.com.Enumeration.CategoriaPcd;

@Entity
public class Aluno extends Pessoa {

	@NotEmpty(message = "Preencimento obrigatório")
	private String matricula;

	@NotNull
	private boolean pcd;

	@Enumerated(EnumType.STRING)
	private CategoriaPcd categoriaPcd;

	public boolean isPcd() {
		return pcd;
	}

	public void setPcd(boolean pcd) {
		this.pcd = pcd;
	}

	public CategoriaPcd getCategoriaPcd() {
		return categoriaPcd;
	}

	public void setCategoriaPcd(CategoriaPcd categoriaPcd) {
		this.categoriaPcd = categoriaPcd;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	public Aluno(Integer codigo, String nome, String email, String telefone, String cpf, LocalDate dataNascimento,
			Endereco endereco, @NotEmpty(message = "Preencimento obrigatório") String matricula, @NotNull boolean pcd,
			CategoriaPcd categoriaPcd) {
		super(codigo, nome, email, telefone, cpf, dataNascimento, endereco);
		this.matricula = matricula;
		this.pcd = pcd;
		this.categoriaPcd = categoriaPcd;
	}

	public Aluno() {

	}

}