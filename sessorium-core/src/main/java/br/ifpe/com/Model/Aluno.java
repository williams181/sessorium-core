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
	private String obs;

	@NotEmpty(message = "Preencimento obrigatório")
	private String matricula;

	@NotNull
	private boolean pcd;

	@Enumerated(EnumType.STRING)
	private CategoriaPcd categoriaPcd;

	@NotEmpty(message = "Preencimento obrigatório")
	private String descricao;

//	private Pais pais;

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public boolean isPcd() {
		return pcd;
	}

	public void setPcd(boolean pcd) {
		this.pcd = pcd;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public CategoriaPcd getCategoriaPcd() {
		return categoriaPcd;
	}

	public void setCategoriaPcd(CategoriaPcd categoriaPcd) {
		this.categoriaPcd = categoriaPcd;
	}

//	public Pais getPais() {
//		return pais;
//	}
//
//	public void setPais(Pais pais) {
//		this.pais = pais;
//	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

//	public Aluno(Integer codigo, String nome, String email, String telefone, String cpf, LocalDate dataNascimento,
//			Endereco endereco, @NotEmpty(message = "Preencimento obrigatório") String obs,
//			@NotEmpty(message = "Preencimento obrigatório") String matricula, boolean pcd, CategoriaPcd categoriaPcd,
//			@NotEmpty(message = "Preencimento obrigatório") String descricao, Pais pais) {
//		super(codigo, nome, email, telefone, cpf, dataNascimento, endereco);
//		this.obs = obs;
//		this.matricula = matricula;
//		this.pcd = pcd;
//		this.categoriaPcd = categoriaPcd;
//		this.descricao = descricao;
//		this.pais = pais;
//	}

	public Aluno() {

	}

	public Aluno(Integer codigo, String nome, String email, String telefone, String cpf, LocalDate dataNascimento,
			Endereco endereco, @NotEmpty(message = "Preencimento obrigatório") String obs,
			@NotEmpty(message = "Preencimento obrigatório") String matricula, @NotNull boolean pcd,
			CategoriaPcd categoriaPcd, @NotEmpty(message = "Preencimento obrigatório") String descricao) {
		super(codigo, nome, email, telefone, cpf, dataNascimento, endereco);
		this.obs = obs;
		this.matricula = matricula;
		this.pcd = pcd;
		this.categoriaPcd = categoriaPcd;
		this.descricao = descricao;
	}

}
