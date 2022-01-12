package br.ifpe.com.Model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import br.ifpe.com.Enumeration.Semestre;
import br.ifpe.com.Enumeration.Turno;

@Entity
public class Turma {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;

	@NotEmpty(message = "Preencimento obrigatório")
	private String nome;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate ano;

	@NotNull
	private int totalMeses;

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

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public List<Materia> getMaterias() {
		return materias;
	}

	public void setMaterias(List<Materia> materias) {
		this.materias = materias;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getAno() {
		return ano;
	}

	public void setAno(LocalDate ano) {
		this.ano = ano;
	}

	public Turno getTurno() {
		return turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public int getTotalMeses() {
		return totalMeses;
	}

	public void setTotalMeses(int totalMeses) {
		this.totalMeses = totalMeses;
	}

	public Semestre getSemestre() {
		return semestre;
	}

	public void setSemestre(Semestre semestre) {
		this.semestre = semestre;
	}

	public Turma(Integer codigo, @NotEmpty(message = "Preencimento obrigatório") String nome, LocalDate ano,
			@NotNull int totalMeses, Semestre semestre, Turno turno, List<Aluno> alunos, List<Materia> materias) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.ano = ano;
		this.totalMeses = totalMeses;
		this.semestre = semestre;
		this.turno = turno;
		this.alunos = alunos;
		this.materias = materias;
	}

	public Turma() {

	}

}