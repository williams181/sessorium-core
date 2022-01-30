package br.ifpe.com.Model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Boletim {

	@Id
	private Integer codigo;

	private String titulo;

	@OneToMany
	private List<Materia> materias;

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
	
	

	public Boletim(Integer codigo, String titulo, List<Materia> materias) {
		super();
		this.codigo = codigo;
		this.titulo = titulo;
		this.materias = materias;
	}

	public Boletim() {

	}

}