package br.ifpe.com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifpe.com.Model.Pais;
import br.ifpe.com.Repository.PaisRepository;

@Service
public class PaisService {

	@Autowired
	private PaisRepository paisRepository;

	public void inserirPais(Pais pais) {
		paisRepository.save(pais);
	}

	public void removerPais(Integer codigo) {
		paisRepository.deleteById(codigo);
	}

	public List<Pais> listarPais() {
		return paisRepository.findAll();
	}

	public Pais buscarPais(Integer codigo) {
		return paisRepository.findById(codigo).get();
	}
}
