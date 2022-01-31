package br.ifpe.com.Model;

import java.time.LocalDate;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

import br.ifpe.com.Enumerated.Formacao;

@Entity
public class Professor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer codigo;

	private String nome;

	private String email;

	private String telefone;

	private String cpf;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataNascimento;

	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "municipio", column = @Column(name = "municipio")),
			@AttributeOverride(name = "uf", column = @Column(name = "uf")) })
	private Endereco endereco;

	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "cursoNome", column = @Column(name = "cursoNome")),
			@AttributeOverride(name = "dataInicio", column = @Column(name = "dataInicio")),
			@AttributeOverride(name = "dataConclusao", column = @Column(name = "dataConclusao")) })
	private Curso curso;

	private String instituto;

	@Enumerated(EnumType.STRING)
	private Formacao formacao;

	private int siape;

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

	public Formacao getFormacao() {
		return formacao;
	}

	public void setFormacao(Formacao formacao) {
		this.formacao = formacao;
	}

	public int getSiape() {
		return siape;
	}

	public void setSiape(int siape) {
		this.siape = siape;
	}

	public Professor(String nome, String email, String telefone, String cpf, LocalDate dataNascimento,
			Endereco endereco, Curso curso, String instituto, Formacao formacao, int siape) {
		super();
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.endereco = endereco;
		this.curso = curso;
		this.instituto = instituto;
		this.formacao = formacao;
		this.siape = siape;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Professor() {

	}

}