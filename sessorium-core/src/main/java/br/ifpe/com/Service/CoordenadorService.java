package br.ifpe.com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifpe.com.Dao.CoordenadorDao;
import br.ifpe.com.Model.Coordenador;

@Service
public class CoordenadorService {

	@Autowired
	private CoordenadorDao daoCoordenador;

	public void inserirCoordenador(Coordenador coordenador) {
		daoCoordenador.save(coordenador);
	}
	
	public void removerCoordenador(Integer id) {
		daoCoordenador.deleteById(id);
	}
	
	public List<Coordenador> listarCoordenadores(){
		return daoCoordenador.findAll();
	}
	public Coordenador buscarCoordenador(Integer id) {
		return daoCoordenador.findById(id).get();
	}

}
