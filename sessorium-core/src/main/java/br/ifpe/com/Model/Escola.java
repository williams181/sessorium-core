package br.ifpe.com.Model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;

@Entity
public class Escola {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;

	@NotEmpty(message = "Preencimento obrigatório")
	private String nome;

	@NotEmpty(message = "Preencimento obrigatório")
	private String cnpj;

	@OneToOne
	@JoinColumn(name = "endereco_id")
	private Endereco endereco;

	@NotEmpty(message = "Preencimento obrigatório")
	private String telefone;

	@NotEmpty(message = "Preencimento obrigatório")
	private String categoriaEscola; 

	@OneToMany
	private List<Professor> Professores;

	@OneToMany
	private List<Turma> turmas;

	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getCategoriaEscola() {
		return categoriaEscola;
	}

	public void setCategoriaEscola(String categoriaEscola) {
		this.categoriaEscola = categoriaEscola;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public List<Professor> getProfessores() {
		return Professores;
	}

	public void setProfessores(List<Professor> professores) {
		Professores = professores;
	}

	public Escola(Integer codigo, @NotEmpty(message = "Preencimento obrigatório") String nome,
			@NotEmpty(message = "Preencimento obrigatório") String cnpj, Endereco endereco,
			@NotEmpty(message = "Preencimento obrigatório") String telefone,
			@NotEmpty(message = "Preencimento obrigatório") String categoriaEscola, List<Professor> professores,
			List<Turma> turmas) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.cnpj = cnpj;
		this.endereco = endereco;
		this.telefone = telefone;
		this.categoriaEscola = categoriaEscola;
		Professores = professores;
		this.turmas = turmas;
	}

	public Escola() {

	}

}
