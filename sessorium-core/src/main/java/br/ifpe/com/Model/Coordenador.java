package br.ifpe.com.Model;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;

@Entity
public class Coordenador extends Pessoa {

	@NotEmpty(message = "Preencimento obrigatório")
	private String formacao;

	@NotEmpty(message = "Preencimento obrigatório")
	private String instituto;
	
	public String getInstituto() {
		return instituto;
	}

	public void setInstituto(String instituto) {
		this.instituto = instituto;
	}


	public Coordenador(Integer codigo, @NotEmpty(message = "Preencimento obrigatório") String nome,
			@NotEmpty(message = "Preencimento obrigatório") String email,
			@NotEmpty(message = "Preencimento obrigatório") String telefone,
			@NotEmpty(message = "Preencimento obrigatório") String cpf,
			@NotEmpty(message = "Preencimento obrigatório") String formacao,
			@NotEmpty(message = "Preencimento obrigatório") String instituto) {
		super(codigo, nome, email, telefone, cpf);
		this.formacao = formacao;
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