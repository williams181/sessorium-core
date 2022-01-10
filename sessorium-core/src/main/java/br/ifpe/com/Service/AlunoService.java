package br.ifpe.com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifpe.com.Dao.AlunoDao;
import br.ifpe.com.Model.Aluno;
import br.ifpe.com.Repository.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	private AlunoDao daoAluno;
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	public List<Aluno> findAll() {
		return alunoRepository.findAll();
	}

	public void inserirAluno(Aluno aluno) {
		daoAluno.save(aluno);
	}
	
	public void removerAluno(Integer codigo) {
		daoAluno.deleteById(codigo);
	}
	
	public List<Aluno> listarAlunos(){
		return daoAluno.findAll();
	}
	
	public Aluno buscarAluno(Integer codigo) {
		return daoAluno.findById(codigo).get();
	}

}
