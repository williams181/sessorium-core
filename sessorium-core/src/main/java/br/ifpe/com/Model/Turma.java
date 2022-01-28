package br.ifpe.com.Model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Turma {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;

	@NotEmpty(message = "Preencimento obrigatório")
	private String titulo;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate ano;

	@NotEmpty(message = "Preencimento obrigatório")
	private String semestre;

	@NotEmpty(message = "Preencimento obrigatório")
	private String turno;

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

	public String getSemestre() {
		return semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
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


	public Turma(Integer codigo, @NotEmpty(message = "Preencimento obrigatório") String titulo, LocalDate ano,
			@NotEmpty(message = "Preencimento obrigatório") String semestre,
			@NotEmpty(message = "Preencimento obrigatório") String turno, List<Aluno> alunos, List<Materia> materias) {
		super();
		this.codigo = codigo;
		this.titulo = titulo;
		this.ano = ano;
		this.semestre = semestre;
		this.turno = turno;
		this.alunos = alunos;
		this.materias = materias;
	}

	public Turma() {

	}

}