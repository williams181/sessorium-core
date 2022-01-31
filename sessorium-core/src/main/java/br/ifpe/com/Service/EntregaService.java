package br.ifpe.com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifpe.com.Model.Entrega;
import br.ifpe.com.Repository.EntregaRepository;

@Service
public class EntregaService {

	@Autowired
	private EntregaRepository entregaRepository;

	public void inserirEntrega(Entrega entrega) {
		entregaRepository.save(entrega);
	}

	public void removerEntrega(Integer codigo) {
		entregaRepository.deleteById(codigo);
	}

	public List<Entrega> listarEntregas() {
		return entregaRepository.findAll();
	}

	public Entrega buscarEntrega(Integer codigo) {
		return entregaRepository.findById(codigo).get();
	}
}
