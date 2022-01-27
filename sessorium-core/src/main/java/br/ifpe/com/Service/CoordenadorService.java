package br.ifpe.com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifpe.com.Model.Coordenador;
import br.ifpe.com.Repository.CoordenadorRepository;

@Service
public class CoordenadorService {

	@Autowired
	private CoordenadorRepository coordenadorRepository;

	public void inserirCoordenador(Coordenador coordenador) {
		coordenadorRepository.save(coordenador);
	}
	
	public void removerCoordenador(Integer codigo) {
		coordenadorRepository.deleteById(codigo);
	}
	
	public List<Coordenador> listarCoordenadores(){
		return coordenadorRepository.findAll();
	}
	public Coordenador buscarCoordenador(Integer codigo) {
		return coordenadorRepository.findById(codigo).get();
	}

}
