package br.ifpe.com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifpe.com.Dao.ProfessorDao;
import br.ifpe.com.Model.Professor;

@Service
public class ProfessorService {

	@Autowired
	private ProfessorDao daoProfessor;

	public void inserirProfessor(Professor professor) {
		daoProfessor.save(professor);
	}
	
	public void removerProfessor(Integer id) {
		daoProfessor.deleteById(id);
	}
	
	public List<Professor> listarProfessores(){
		return daoProfessor.findAll();
	}
	public Professor buscarProfessor(Integer id) {
		return daoProfessor.findById(id).get();
	}
}
