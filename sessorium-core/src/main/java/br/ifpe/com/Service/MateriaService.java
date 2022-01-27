package br.ifpe.com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifpe.com.Model.Materia;
import br.ifpe.com.Repository.MateriaRepository;

@Service
public class MateriaService {

	@Autowired
	private MateriaRepository materiaRepository;

	public void inserirMateria(Materia materia) {
		materiaRepository.save(materia);
	}

	public void removerMateria(Integer codigo) {
		materiaRepository.deleteById(codigo);
	}

	public List<Materia> listarMaterias() {
		return materiaRepository.findAll();
	}

	public Materia buscarMateria(Integer codigo) {
		return materiaRepository.findById(codigo).get();
	}

}
