package br.ifpe.com.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifpe.com.Dao.ProfessorDao;
import br.ifpe.com.Model.Professor;

@Service
public class ProfessorService {

	@Autowired
	private ProfessorDao daoProfessor;

	public void inserirProfessor(Professor professor) {
		this.daoProfessor.save(professor);
	}
	
	public void removerProfessor(Professor professor) {
		this.daoProfessor.delete(professor);
	}
}
