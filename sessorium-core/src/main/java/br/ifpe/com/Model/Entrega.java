package br.ifpe.com.Model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Entrega {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	
	@NotEmpty(message = "Preencimento obrigatório")
	private String titulo;

	@ManyToOne
	private Materia materia;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataEntrega;

	@NotEmpty(message = "Preencimento obrigatório")
	private String descricao;

	@Lob
	private Byte[] arquivo;

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

	public Byte[] getArquivo() {
		return arquivo;
	}

	public void setArquivo(Byte[] arquivo) {
		this.arquivo = arquivo;
	}
	
	public Entrega(Integer codigo, @NotEmpty(message = "Preencimento obrigatório") String titulo, Materia materia,
			LocalDate dataEntrega, @NotEmpty(message = "Preencimento obrigatório") String descricao, Byte[] arquivo) {
		super();
		this.codigo = codigo;
		this.titulo = titulo;
		this.materia = materia;
		this.dataEntrega = dataEntrega;
		this.descricao = descricao;
		this.arquivo = arquivo;
	}

	public Entrega() {

	}

}
