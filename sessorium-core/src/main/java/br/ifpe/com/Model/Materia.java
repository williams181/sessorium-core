package br.ifpe.com.Model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Materia {
	@Id
	private String nome;
	private String professor;
	private String conteudo;
	private int cargaHoraria;

	public Materia() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Materia(String nome, String professor, String conteudo, int cargaHoraria) {
		super();
		this.nome = nome;
		this.professor = professor;
		this.conteudo = conteudo;
		this.cargaHoraria = cargaHoraria;
	}

	@Override
	public String toString() {
		return "Materias [nome=" + nome + ", professor=" + professor + ", conteudo=" + conteudo + ", cargaHoraria="
				+ cargaHoraria + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cargaHoraria, conteudo, nome, professor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Materia other = (Materia) obj;
		return cargaHoraria == other.cargaHoraria && Objects.equals(conteudo, other.conteudo)
				&& Objects.equals(nome, other.nome) && Objects.equals(professor, other.professor);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getProfessor() {
		return professor;
	}

	public void setProfessor(String professor) {
		this.professor = professor;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public int getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

}
