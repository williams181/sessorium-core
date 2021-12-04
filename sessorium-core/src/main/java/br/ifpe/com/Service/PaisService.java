package br.ifpe.com.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifpe.com.Dao.PaisDao;
import br.ifpe.com.Model.Pais;

@Service
public class PaisService {

	@Autowired
	private PaisDao daoPais;

	public void inseirPais(Pais pais) {
		this.daoPais.save(pais);
	}
	
	public void removePais(Pais pais) {
		this.daoPais.delete(pais);
	}
}
