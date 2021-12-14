package br.ifpe.com.Model;

import java.time.LocalDate;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class Curso {

	@NotNull
	private String nome;
	
	@NotNull
	private LocalDate dataInicio;
	
	@NotNull
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
	
}
