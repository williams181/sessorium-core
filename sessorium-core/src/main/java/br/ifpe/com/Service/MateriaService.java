package br.ifpe.com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifpe.com.Dao.MateriaDao;
import br.ifpe.com.Model.Materia;

@Service
public class MateriaService {

	@Autowired
	private MateriaDao daoMateria;

	public void inserirMateria(Materia materia) {
		daoMateria.save(materia);
	}

	public void removerMateria(Integer codigo) {
		daoMateria.deleteById(codigo);
	}

	public List<Materia> listarMaterias() {
		return daoMateria.findAll();
	}

	public Materia buscarMateria(Integer codigo) {
		return daoMateria.findById(codigo).get();
	}

}
