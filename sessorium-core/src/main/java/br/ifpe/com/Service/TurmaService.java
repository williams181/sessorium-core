package br.ifpe.com.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifpe.com.Dao.TurmaDao;
import br.ifpe.com.Model.Turma;

@Service
public class TurmaService {
	
	@Autowired
	private TurmaDao daoTurma;
	
	public void insesirTurma(Turma turma) {
		this.daoTurma.save(turma);
	}
	
	public void removerTurma(Turma turma) {
		this.daoTurma.delete(turma);
	}
	
}
