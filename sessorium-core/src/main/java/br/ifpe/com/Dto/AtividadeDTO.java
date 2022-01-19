package br.ifpe.com.Dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

public class AtividadeDTO implements Serializable {

	private static final long serialVersionUID = 5821032741235026013L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;

	@NotEmpty(message = "Preencimento obrigatório")
	private String titulo;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dtInicio;

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

	public LocalDate getDtInicio() {
		return dtInicio;
	}

	public void setDtInicio(LocalDate dtInicio) {
		this.dtInicio = dtInicio;
	}

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

	public AtividadeDTO(Integer codigo, @NotEmpty(message = "Preencimento obrigatório") String titulo,
			LocalDate dtInicio, LocalDate dtFim, @NotEmpty(message = "Preencimento obrigatório") String descricao,
			Byte[] arquivo) {
		super();
		this.codigo = codigo;
		this.titulo = titulo;
		this.dtInicio = dtInicio;
		this.dtFim = dtFim;
		this.descricao = descricao;
		this.arquivo = arquivo;
	}

	public AtividadeDTO() {

	}

}
