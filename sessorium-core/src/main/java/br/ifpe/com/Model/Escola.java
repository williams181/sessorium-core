package br.ifpe.com.Model;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import br.ifpe.com.Enumerated.CategoriaEscola;

@Entity
public class Escola {

	@Id
	private Integer codigo;

	private String nome;

	private String cnpj;

	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "rua", column = @Column(name = "rua")),
			@AttributeOverride(name = "complemento", column = @Column(name = "complemento")),
			@AttributeOverride(name = "numero", column = @Column(name = "numero")),
			@AttributeOverride(name = "cidade", column = @Column(name = "cidade")),
			@AttributeOverride(name = "cep", column = @Column(name = "cep")),
			@AttributeOverride(name = "bairro", column = @Column(name = "bairro")) })
	private Endereco endereco;

	private String telefone;

	@Enumerated(EnumType.STRING)
	private CategoriaEscola categoriaEscola;

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

	public CategoriaEscola getCategoriaEscola() {
		return categoriaEscola;
	}

	public void setCategoriaEscola(CategoriaEscola categoriaEscola) {
		this.categoriaEscola = categoriaEscola;
	}

	public Escola(Integer codigo, String nome, String cnpj, Endereco endereco, String telefone,
			CategoriaEscola categoriaEscola, List<Professor> professores, List<Turma> turmas) {
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
