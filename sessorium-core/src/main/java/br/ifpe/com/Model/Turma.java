package br.ifpe.com.Model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Turma {
	
	@Id
	private String nome;
	private Date ano;
	private String turno;
	
	public Turma() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Turma(String nome, Date ano, String turno) {
		super();
		this.nome = nome;
		this.ano = ano;
		this.turno = turno;
	}
	@Override
	public String toString() {
		return "Turma [nome=" + nome + ", ano=" + ano + ", turno=" + turno + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(ano, nome, turno);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Turma other = (Turma) obj;
		return Objects.equals(ano, other.ano) && Objects.equals(nome, other.nome) && Objects.equals(turno, other.turno);
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getAno() {
		return ano;
	}
	public void setAno(Date ano) {
		this.ano = ano;
	}
	public String getTurno() {
		return turno;
	}
	public void setTurno(String turno) {
		this.turno = turno;
	}
	
	
	

}
