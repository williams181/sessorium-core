package br.ifpe.com.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Forum {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;

	public Forum(Integer codigo) {
		super();
		this.codigo = codigo;
	}

	public Forum() {

	}

}
