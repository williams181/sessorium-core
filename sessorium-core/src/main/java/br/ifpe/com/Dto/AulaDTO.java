package br.ifpe.com.Dto;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

public class AulaDTO implements Serializable {

	private static final long serialVersionUID = 4459181847396892434L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;

	@NotEmpty(message = "Preencimento obrigatório")
	private String titulo;

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

	public AulaDTO(Integer codigo, @NotEmpty(message = "Preencimento obrigatório") String titulo) {
		super();
		this.codigo = codigo;
		this.titulo = titulo;
	}

	public AulaDTO() {

	}
	
}
