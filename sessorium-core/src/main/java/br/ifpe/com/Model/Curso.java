package br.ifpe.com.Model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.springframework.format.annotation.DateTimeFormat;

@Embeddable
public class Curso {

	@Column(name = "curso")
	private String nome;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataInicio;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataConclusao;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public Curso(String nome, LocalDate dataInicio, LocalDate dataConclusao) {
		super();
		this.nome = nome;
		this.dataInicio = dataInicio;
		this.dataConclusao = dataConclusao;
	}

	public Curso() {

	}

}