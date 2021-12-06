package br.ifpe.com.Model;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Administrador extends Pessoa {

	@Id
	private String nome;
	private String email;
	private String telefone;
	private String cpf;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataNascimento;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(cpf, dataNascimento, email, nome, telefone);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Administrador other = (Administrador) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(dataNascimento, other.dataNascimento)
				&& Objects.equals(email, other.email) && Objects.equals(nome, other.nome)
				&& Objects.equals(telefone, other.telefone);
	}

	@Override
	public String toString() {
		return "Administrador [nome=" + nome + ", email=" + email + ", telefone=" + telefone + ", cpf=" + cpf
				+ ", dataNascimento=" + dataNascimento + "]";
	}

	public Administrador(String nome, String email, String telefone, String cpf, LocalDate dataNascimento, String nome2,
			String email2, String telefone2, String cpf2, LocalDate dataNascimento2) {
		super(nome, email, telefone, cpf, dataNascimento);
		nome = nome2;
		email = email2;
		telefone = telefone2;
		cpf = cpf2;
		dataNascimento = dataNascimento2;
	}

	public Administrador() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Administrador(String nome, String email, String telefone, String cpf, LocalDate dataNascimento) {
		super(nome, email, telefone, cpf, dataNascimento);
		// TODO Auto-generated constructor stub
	}

}
