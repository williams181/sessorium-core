package br.ifpe.com.Model;

import javax.persistence.Entity;

@Entity
public class Pais extends Pessoa {

	private double fatura;

	private String observacao;

//	@ManyToOne
//	private List<Aluno> alunos;

	public double getFatura() {
		return fatura;
	}

	public void setFatura(double fatura) {
		this.fatura = fatura;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

//	public List<Aluno> getAlunos() {
//		return alunos;
//	}
//
//	public void setAlunos(List<Aluno> alunos) {
//		this.alunos = alunos;
//	}
}
