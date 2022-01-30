package br.ifpe.com.Model;

import java.time.LocalDate;

import javax.persistence.Embeddable;

import org.springframework.format.annotation.DateTimeFormat;

@Embeddable
public class Curso {

	private String cursoNome;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataInicio;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataConclusao;	
	
	public String getCursoNome() {
		return cursoNome;
	}

	public void setCursoNome(String cursoNome) {
		this.cursoNome = cursoNome;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataConclusao() {
		return dataConclusao;
	}

	public void setDataConclusao(LocalDate dataConclusao) {
		this.dataConclusao = dataConclusao;
	}



	public Curso(String cursoNome, LocalDate dataInicio, LocalDate dataConclusao) {
		super();
		this.cursoNome = cursoNome;
		this.dataInicio = dataInicio;
		this.dataConclusao = dataConclusao;
	}

	public Curso() {

	}

}