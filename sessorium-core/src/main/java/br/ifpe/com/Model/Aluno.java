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

import br.ifpe.com.Enumerated.CategoriaPcd;

@Entity
public class Aluno {
	
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
	@AttributeOverrides({
	@AttributeOverride( name = "rua", column = @Column(name = "rua")),
	@AttributeOverride( name = "complemento", column = @Column(name = "complemento")),
	@AttributeOverride( name = "numero", column = @Column(name = "numero")),
	@AttributeOverride( name = "cidade", column = @Column(name = "cidade")),
	@AttributeOverride( name = "cep", column = @Column(name = "cep")),
	@AttributeOverride( name = "bairro", column = @Column(name = "bairro"))
	})
	private Endereco endereco;
	
	private String matricula;
	
	private boolean pcd;
	
	@Enumerated(EnumType.STRING)
	private CategoriaPcd categoriaPcd;

	public Aluno(Integer codigo, String nome, String email, String telefone, String cpf, LocalDate dataNascimento,
			Endereco endereco, String matricula, boolean pcd, CategoriaPcd categoriaPcd) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.endereco = endereco;
		this.matricula = matricula;
		this.pcd = pcd;
		this.categoriaPcd = categoriaPcd;
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



	public String getMatricula() {
		return matricula;
	}



	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}



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



	public Aluno() {

	}

}