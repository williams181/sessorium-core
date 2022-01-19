package br.ifpe.com.Dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;

import br.ifpe.com.Enumeration.Formacao;
import br.ifpe.com.Model.Curso;
import br.ifpe.com.Model.Endereco;
import br.ifpe.com.Model.Pessoa;

public class CoordenadorDTO extends Pessoa implements Serializable{

	private static final long serialVersionUID = -1505269222160294715L;

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

	public CoordenadorDTO(Integer codigo, String nome, String email, String telefone, String cpf, LocalDate dataNascimento,
			Endereco endereco, Formacao formacao, Curso curso,
			@NotEmpty(message = "Preencimento obrigatório") String instituto) {
		super(codigo, nome, email, telefone, cpf, dataNascimento, endereco);
		this.formacao = formacao;
		this.curso = curso;
		this.instituto = instituto;
	}

	public CoordenadorDTO() {

	}

}
