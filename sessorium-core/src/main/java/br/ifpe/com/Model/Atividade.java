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
public class Atividade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;

	@NotEmpty(message = "Preencimento obrigatório")
	private String titulo;

	@ManyToOne
	private Materia materia;
	
//	@DateTimeFormat(pattern = "yyyy-MM-dd")
//	private LocalDate dtInicio;

	// alterar para data de entrega
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dtFim;

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

//	public LocalDate getDtInicio() {
//		return dtInicio;
//	}
//
//	public void setDtInicio(LocalDate dtInicio) {
//		this.dtInicio = dtInicio;
//	}

	public LocalDate getDtFim() {
		return dtFim;
	}

	public void setDtFim(LocalDate dtFim) {
		this.dtFim = dtFim;
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

	public Atividade() {

	}

}
