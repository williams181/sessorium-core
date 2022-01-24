package br.ifpe.com.Dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.ifpe.com.Enumeration.CategoriaPcd;
import br.ifpe.com.Model.Aluno;
import br.ifpe.com.Model.Endereco;
import br.ifpe.com.Model.Pessoa;

@Entity
public class AlunoDto extends Pessoa implements Serializable {

	private static final long serialVersionUID = -5636083037254767651L;

	@NotEmpty(message = "Preencimento obrigatório")
	private String matricula;

	@NotNull
	private boolean pcd;

	@Enumerated(EnumType.STRING)
	private CategoriaPcd categoriaPcd;

	public boolean isPcd() {
		return pcd;
	}

	public void setPcd(boolean pcd) {
		this.pcd = pcd;
	}

	public CategoriaPcd getCategoriaPcd() {
		return categoriaPcd;
	}

	public void setCategoriaPcd(CategoriaPcd categoriaPcd) {
		this.categoriaPcd = categoriaPcd;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

//	public AlunoDto(Aluno aluno) {
//		this.codigo = aluno.getCodigo();
//	}

	public AlunoDto() {

	}

	@Override
	public String toString() {
		return "AlunoDto [matricula=" + matricula + ", pcd=" + pcd + ", categoriaPcd=" + categoriaPcd + "]";
	}

}