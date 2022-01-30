package br.ifpe.com.Model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import br.ifpe.com.Enumerated.Semestre;
import br.ifpe.com.Enumerated.Turno;

@Entity
public class Turma {

	@Id
	private Integer codigo;

	private String titulo;

	private LocalDate ano;

	@Enumerated(EnumType.STRING)
	private Semestre semestre;
	
	@Enumerated(EnumType.STRING)
	private Turno turno;

	@OneToMany
	private List<Aluno> alunos;

	@OneToMany
	private List<Materia> materias;

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public LocalDate getAno() {
		return ano;
	}

	public void setAno(LocalDate ano) {
		this.ano = ano;
	}

	public List<Materia> getMaterias() {
		return materias;
	}

	public void setMaterias(List<Materia> materias) {
		this.materias = materias;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public Semestre getSemestre() {
		return semestre;
	}

	public void setSemestre(Semestre semestre) {
		this.semestre = semestre;
	}

	public Turno getTurno() {
		return turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}

	public Turma() {

	}

}