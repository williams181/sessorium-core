package br.ifpe.com.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifpe.com.Dao.MateriaDao;
import br.ifpe.com.Model.Materia;

@Service
public class MateriaService {

	@Autowired
	private MateriaDao daoMateria;

	public void inserirMateria(Materia materia) {
		this.daoMateria.save(materia);
	}
	
	public void removerMateria(Materia materia) {
		this.daoMateria.delete(materia);
	}
	
}
