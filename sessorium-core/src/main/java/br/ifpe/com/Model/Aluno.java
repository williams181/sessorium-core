package br.ifpe.com.Model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Aluno extends Pessoa  {
	@Id
	private String nome;
	private String email;
	private String telefone;
	private String cpf;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dataNascimento;
	private String pais;
	private String obs;
	private boolean pcd;
	private String descricao;
	
	@Override
	public String toString() {
		return "Aluno [nome=" + nome + ", email=" + email + ", telefone=" + telefone + ", cpf=" + cpf
				+ ", dataNascimento=" + dataNascimento + ", pais=" + pais + ", obs=" + obs + ", pcd=" + pcd
				+ ", descricao=" + descricao + "]";
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
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public Aluno(String nome, String email, String telefone, String cpf, Date dataNascimento, String pais, String obs,
			boolean pcd, String descricao) {
		super();
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.pais = pais;
		this.obs = obs;
		this.pcd = pcd;
		this.descricao = descricao;
	}
	@Override
	public int hashCode() {
		return Objects.hash(cpf, dataNascimento, descricao, email, nome, obs, pais, pcd, telefone);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(dataNascimento, other.dataNascimento)
				&& Objects.equals(descricao, other.descricao) && Objects.equals(email, other.email)
				&& Objects.equals(nome, other.nome) && Objects.equals(obs, other.obs)
				&& Objects.equals(pais, other.pais) && pcd == other.pcd && Objects.equals(telefone, other.telefone);
	}
	public Aluno() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
