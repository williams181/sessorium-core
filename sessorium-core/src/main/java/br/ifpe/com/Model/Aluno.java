package br.ifpe.com.Model;

import java.util.List;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class Aluno extends Pessoa {
	
	@NotNull
	private String obs;
	
	@NotNull
	private boolean pcd;
	
	@NotNull
	private CategoriaPcd categoriaPcd;
	
	@NotNull
	private String descricao;
	
	@NotNull
	private List<Materia> materias;
	
	@NotNull
	private Pais pais;

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public boolean isPcd() {
		return pcd;
	}

	public void setPcd(boolean pcd) {
		this.pcd = pcd;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Materia> getMaterias() {
		return materias;
	}

	public void setMaterias(List<Materia> materias) {
		this.materias = materias;
	}

	public CategoriaPcd getCategoriaPcd() {
		return categoriaPcd;
	}

	public void setCategoriaPcd(CategoriaPcd categoriaPcd) {
		this.categoriaPcd = categoriaPcd;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}
	
}
