package br.ifpe.com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifpe.com.Model.Boletim;
import br.ifpe.com.Repository.BoletimRepository;

@Service
public class BoletimService {

	@Autowired
	private BoletimRepository boletimRepository;

	public void inserirBoletim(Boletim boletim) {
		boletimRepository.save(boletim);
	}

	public void removerBoletim(Integer codigo) {
		boletimRepository.deleteById(codigo);
	}

	public List<Boletim> listarBoletims() {
		return boletimRepository.findAll();
	}

	public Boletim buscarBoletim(Integer codigo) {
		return boletimRepository.findById(codigo).get();
	}

}
