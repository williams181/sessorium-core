package br.ifpe.com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifpe.com.Model.Aula;
import br.ifpe.com.Repository.AulaRepository;

@Service
public class AulaService {

	@Autowired
	private AulaRepository aulaRepository;

	public void inserirAula(Aula aula) {
		aulaRepository.save(aula);
	}

	public void removerAula(Integer codigo) {
		aulaRepository.deleteById(codigo);
	}

	public List<Aula> listarAulas() {
		return aulaRepository.findAll();
	}

	public Aula buscarAula(Integer codigo) {
		return aulaRepository.findById(codigo).get();
	}

}
