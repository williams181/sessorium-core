package br.ifpe.com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifpe.com.Model.Professor;
import br.ifpe.com.Repository.ProfessorRepository;

@Service
public class ProfessorService {

	@Autowired
	private ProfessorRepository professorRepository;

	public void inserirProfessor(Professor professor) {
		professorRepository.save(professor);
	}

	public void removerProfessor(Integer codigo) {
		professorRepository.deleteById(codigo);
	}

	public List<Professor> listarProfessores() {
		return professorRepository.findAll();
	}

	public Professor buscarProfessor(Integer codigo) {
		return professorRepository.findById(codigo).get();
	}
}
