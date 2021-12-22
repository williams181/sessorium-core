package br.ifpe.com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifpe.com.Dao.TurmaDao;
import br.ifpe.com.Model.Turma;

@Service
public class TurmaService {
	
	@Autowired
	private TurmaDao daoTurma;

	public void inserirTurma(Turma turma) {
		daoTurma.save(turma);
	}
	
	public void removerTurma(Integer id) {
		daoTurma.deleteById(id);
	}
	
	public List<Turma> listarTurmas(){
		return daoTurma.findAll();
	}
	public Turma buscarTurma(Integer id) {
		return daoTurma.findById(id).get();
	}
	
}
