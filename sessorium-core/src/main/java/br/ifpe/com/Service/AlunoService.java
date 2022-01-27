package br.ifpe.com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifpe.com.Model.Aluno;
import br.ifpe.com.Repository.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository alunoRepository;

	public void inserirAluno(Aluno aluno) {
		alunoRepository.save(aluno);
	}

	public void removerAluno(Integer codigo) {
		alunoRepository.deleteById(codigo);
	}

	public List<Aluno> listarAlunos() {
		return alunoRepository.findAll();
	}

	public Aluno buscarAluno(Integer codigo) {
		return alunoRepository.findById(codigo).get();
	}


}
