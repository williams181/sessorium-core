package br.ifpe.com.Model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Coordenador extends Pessoa {
	
	@Id
	private String nome;
	private String email;
	private String telefone;
	private String cpf;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dataNascimento;
	private String formacao;
	private String curso;
	private String instituto;

	public String getFormacao() {
		return formacao;
	}
	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public String getInstituto() {
		return instituto;
	}
	public void setInstituto(String instituto) {
		this.instituto = instituto;
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
	@Override
	public int hashCode() {
		return Objects.hash(cpf, curso, dataNascimento, email, formacao, instituto, nome, telefone);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordenador other = (Coordenador) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(curso, other.curso)
				&& Objects.equals(dataNascimento, other.dataNascimento) && Objects.equals(email, other.email)
				&& Objects.equals(formacao, other.formacao) && Objects.equals(instituto, other.instituto)
				&& Objects.equals(nome, other.nome) && Objects.equals(telefone, other.telefone);
	}
	@Override
	public String toString() {
		return "Coordenador [nome=" + nome + ", email=" + email + ", telefone=" + telefone + ", cpf=" + cpf
				+ ", dataNascimento=" + dataNascimento + ", formacao=" + formacao + ", curso=" + curso + ", instituto="
				+ instituto + "]";
	}
	public Coordenador(String nome, String email, String telefone, String cpf, Date dataNascimento, String formacao,
			String curso, String instituto) {
		super();
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.formacao = formacao;
		this.curso = curso;
		this.instituto = instituto;
	}
	public Coordenador() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
