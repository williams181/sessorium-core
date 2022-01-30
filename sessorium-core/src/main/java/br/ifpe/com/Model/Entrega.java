package br.ifpe.com.Model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Entrega {
	
	@Id
	private Integer codigo;
	
	private String titulo;

	@ManyToOne
	private Materia materia;
	
	private LocalDate dataEntrega;

	private String descricao;

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

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public LocalDate getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(LocalDate dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	

	public Entrega(Integer codigo, String titulo, Materia materia, LocalDate dataEntrega, String descricao) {
		super();
		this.codigo = codigo;
		this.titulo = titulo;
		this.materia = materia;
		this.dataEntrega = dataEntrega;
		this.descricao = descricao;
	}

	public Entrega() {

	}

}
