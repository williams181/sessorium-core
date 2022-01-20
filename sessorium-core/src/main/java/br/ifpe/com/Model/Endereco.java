package br.ifpe.com.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;

	@NotEmpty(message = "Preencimento obrigatório")
	private String rua;

	@NotEmpty(message = "Preencimento obrigatório")
	private String numero;

	@NotEmpty(message = "Preencimento obrigatório")
	private String bairro;

	@NotEmpty(message = "Preencimento obrigatório")
	private String complemento;

	private Cidade cidade;

	@NotEmpty(message = "Preencimento obrigatório")
	private String cep;

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public Endereco(Integer codigo, @NotEmpty(message = "Preencimento obrigatório") String rua,
			@NotEmpty(message = "Preencimento obrigatório") String numero,
			@NotEmpty(message = "Preencimento obrigatório") String bairro,
			@NotEmpty(message = "Preencimento obrigatório") String complemento, Cidade cidade,
			@NotEmpty(message = "Preencimento obrigatório") String cep) {
		super();
		this.codigo = codigo;
		this.rua = rua;
		this.numero = numero;
		this.bairro = bairro;
		this.complemento = complemento;
		this.cidade = cidade;
		this.cep = cep;
	}

	public Endereco() {

	}

}