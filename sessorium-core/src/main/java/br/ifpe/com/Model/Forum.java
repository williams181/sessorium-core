package br.ifpe.com.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Forum {

	@Id
	private Integer codigo;

	private String tema;
	
	@ManyToOne
	private Turma turma;
	
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	
	
	public Forum(Integer codigo, String tema, Turma turma) {
		super();
		this.codigo = codigo;
		this.tema = tema;
		this.turma = turma;
	}

	public Forum() {

	}

}
