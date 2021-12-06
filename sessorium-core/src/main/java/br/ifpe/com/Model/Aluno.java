package br.ifpe.com.Model;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Aluno extends Pessoa {
	@Id
	private String nome;
	private String email;
	private String telefone;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataNascimento;
	private String pais;
	private String obs;
	private boolean pcd;
	private String descricao;

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
	
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(dataNascimento, descricao, email, nome, obs, pais, pcd, telefone);
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
		Aluno other = (Aluno) obj;
		return Objects.equals(dataNascimento, other.dataNascimento) && Objects.equals(descricao, other.descricao)
				&& Objects.equals(email, other.email) && Objects.equals(nome, other.nome)
				&& Objects.equals(obs, other.obs) && Objects.equals(pais, other.pais) && pcd == other.pcd
				&& Objects.equals(telefone, other.telefone);
	}

	@Override
	public String toString() {
		return "Aluno [nome=" + nome + ", email=" + email + ", telefone=" + telefone + ", dataNascimento="
				+ dataNascimento + ", pais=" + pais + ", obs=" + obs + ", pcd=" + pcd + ", descricao=" + descricao
				+ "]";
	}



	public Aluno(String nome, String email, String telefone, String cpf, LocalDate dataNascimento, String nome2,
			String email2, String telefone2, LocalDate dataNascimento2, String pais, String obs, boolean pcd,
			String descricao) {
		super(nome, email, telefone, cpf, dataNascimento);
		nome = nome2;
		email = email2;
		telefone = telefone2;
		dataNascimento = dataNascimento2;
		this.pais = pais;
		this.obs = obs;
		this.pcd = pcd;
		this.descricao = descricao;
	}

	public Aluno() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Aluno(String nome, String email, String telefone, String cpf, LocalDate dataNascimento) {
		super(nome, email, telefone, cpf, dataNascimento);
		// TODO Auto-generated constructor stub
	}

}
