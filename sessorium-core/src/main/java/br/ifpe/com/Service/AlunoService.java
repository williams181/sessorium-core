package br.ifpe.com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifpe.com.Dao.AlunoDao;
import br.ifpe.com.Dto.AlunoDto;
import br.ifpe.com.Model.Aluno;

@Service
public class AlunoService {

	@Autowired
	private AlunoDao daoAluno;

	public void inserirAluno(Aluno aluno) {
		daoAluno.save(aluno);
	}

	public void removerAluno(Integer codigo) {
		daoAluno.deleteById(codigo);
	}

	public List<Aluno> listarAlunos() {
		return daoAluno.findAll();
	}

	public Aluno buscarAluno(Integer codigo) {
		return daoAluno.findById(codigo).get();
	}

}
