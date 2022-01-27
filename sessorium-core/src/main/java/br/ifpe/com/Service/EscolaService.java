package br.ifpe.com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifpe.com.Model.Escola;
import br.ifpe.com.Repository.EscolaRepository;

@Service
public class EscolaService {

	@Autowired
	private EscolaRepository escolaRepository;

	public void inserirEscola(Escola escola) {
		escolaRepository.save(escola);
	}

	public void removerEscola(Integer codigo) {
		escolaRepository.deleteById(codigo);
	}

	public List<Escola> listarEscolas() {
		return escolaRepository.findAll();
	}

	public Escola buscarEscola(Integer codigo) {
		return escolaRepository.findById(codigo).get();
	}
}
