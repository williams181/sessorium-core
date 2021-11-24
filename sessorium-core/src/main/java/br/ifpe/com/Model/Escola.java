package br.ifpe.com.Model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Escola {
	
	@Id
	private String nome;
	private String cnpj;
	private String endereco;
	private String telefone;
	private String categoria;
	private int codigo;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	@Override
	public int hashCode() {
		return Objects.hash(categoria, cnpj, codigo, endereco, nome, telefone);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Escola other = (Escola) obj;
		return Objects.equals(categoria, other.categoria) && Objects.equals(cnpj, other.cnpj) && codigo == other.codigo
				&& Objects.equals(endereco, other.endereco) && Objects.equals(nome, other.nome)
				&& Objects.equals(telefone, other.telefone);
	}
	@Override
	public String toString() {
		return "Escola [nome=" + nome + ", cnpj=" + cnpj + ", endereco=" + endereco + ", telefone=" + telefone
				+ ", categoria=" + categoria + ", codigo=" + codigo + "]";
	}
	public Escola(String nome, String cnpj, String endereco, String telefone, String categoria, int codigo) {
		super();
		this.nome = nome;
		this.cnpj = cnpj;
		this.endereco = endereco;
		this.telefone = telefone;
		this.categoria = categoria;
		this.codigo = codigo;
	}
	public Escola() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
