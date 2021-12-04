package br.ifpe.com.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifpe.com.Dao.AlunoDao;
import br.ifpe.com.Model.Aluno;

@Service
public class AlunoService {

	@Autowired
	private AlunoDao daoAluno;

	public void inserirAluno(Aluno aluno) {
		this.daoAluno.save(aluno);
	}
	
	public void removerAluno(Aluno aluno) {
		this.daoAluno.delete(aluno);
	}
}
