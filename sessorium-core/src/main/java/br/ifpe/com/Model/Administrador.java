package br.ifpe.com.Model;

import javax.persistence.Entity;

@Entity
public class Administrador extends Pessoa {

	private boolean admin;

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

}
