package br.ifpe.com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifpe.com.Dao.PaisDao;
import br.ifpe.com.Model.Pais;

@Service
public class PaisService {

	@Autowired
	private PaisDao daoPais;

	public void inserirPais(Pais pais) {
		daoPais.save(pais);
	}

	public void removerPais(Integer codigo) {
		daoPais.deleteById(codigo);
	}

	public List<Pais> listarPais() {
		return daoPais.findAll();
	}

	public Pais buscarPais(Integer codigo) {
		return daoPais.findById(codigo).get();
	}
}
