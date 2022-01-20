package br.ifpe.com.Model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;

import br.ifpe.com.Enumeration.CategoriaEscola;

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

	@Enumerated(EnumType.STRING)
	private CategoriaEscola categoriaEscola;

	@OneToMany
	private List<Professor> Professores;

	@OneToMany
	private List<Turma> turmas;

//	@OneToOne
//	@JoinColumn(name = "coordenador_id")
//	private Coordenador coordenador;
	
	private Integer totalUnidade;

	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}

//	public Coordenador getCoordenador() {
//		return coordenador;
//	}
//
//	public void setCoordenador(Coordenador coordenador) {
//		this.coordenador = coordenador;
//	}

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

	public CategoriaEscola getCategoriaEscola() {
		return categoriaEscola;
	}

	public void setCategoriaEscola(CategoriaEscola categoriaEscola) {
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

	public Integer getTotalUnidade() {
		return totalUnidade;
	}

	public void setTotalUnidade(Integer totalUnidade) {
		this.totalUnidade = totalUnidade;
	}

	public Escola() {

	}

	public Escola(Integer codigo, @NotEmpty(message = "Preencimento obrigatório") String nome,
			@NotEmpty(message = "Preencimento obrigatório") String cnpj, Endereco endereco,
			@NotEmpty(message = "Preencimento obrigatório") String telefone, CategoriaEscola categoriaEscola,
			List<Professor> professores, List<Turma> turmas, Integer totalUnidade) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.cnpj = cnpj;
		this.endereco = endereco;
		this.telefone = telefone;
		this.categoriaEscola = categoriaEscola;
		Professores = professores;
		this.turmas = turmas;
		this.totalUnidade = totalUnidade;
	}

}
