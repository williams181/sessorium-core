package br.ifpe.com;

public class Aluno extends Pessoa {
	private String pais;
	private String obs;
	private boolean pcd;
	private String descricao;
	
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
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
	
	

}
